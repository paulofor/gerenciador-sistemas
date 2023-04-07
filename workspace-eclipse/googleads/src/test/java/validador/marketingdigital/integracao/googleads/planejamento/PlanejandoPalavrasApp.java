package validador.marketingdigital.integracao.googleads.planejamento;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v13.enums.KeywordMatchTypeEnum.KeywordMatchType;
import com.google.ads.googleads.v13.enums.KeywordPlanForecastIntervalEnum.KeywordPlanForecastInterval;
import com.google.ads.googleads.v13.enums.KeywordPlanNetworkEnum.KeywordPlanNetwork;
import com.google.ads.googleads.v13.resources.KeywordPlan;
import com.google.ads.googleads.v13.resources.KeywordPlanAdGroup;
import com.google.ads.googleads.v13.resources.KeywordPlanAdGroupKeyword;
import com.google.ads.googleads.v13.resources.KeywordPlanCampaign;
import com.google.ads.googleads.v13.resources.KeywordPlanCampaignKeyword;
import com.google.ads.googleads.v13.resources.KeywordPlanForecastPeriod;
import com.google.ads.googleads.v13.resources.KeywordPlanGeoTarget;
import com.google.ads.googleads.v13.services.KeywordPlanAdGroupKeywordOperation;
import com.google.ads.googleads.v13.services.KeywordPlanAdGroupKeywordServiceClient;
import com.google.ads.googleads.v13.services.KeywordPlanAdGroupOperation;
import com.google.ads.googleads.v13.services.KeywordPlanAdGroupServiceClient;
import com.google.ads.googleads.v13.services.KeywordPlanCampaignKeywordOperation;
import com.google.ads.googleads.v13.services.KeywordPlanCampaignKeywordServiceClient;
import com.google.ads.googleads.v13.services.KeywordPlanCampaignOperation;
import com.google.ads.googleads.v13.services.KeywordPlanCampaignServiceClient;
import com.google.ads.googleads.v13.services.KeywordPlanOperation;
import com.google.ads.googleads.v13.services.KeywordPlanServiceClient;
import com.google.ads.googleads.v13.services.MutateKeywordPlanAdGroupKeywordResult;
import com.google.ads.googleads.v13.services.MutateKeywordPlanAdGroupKeywordsResponse;
import com.google.ads.googleads.v13.services.MutateKeywordPlanAdGroupsResponse;
import com.google.ads.googleads.v13.services.MutateKeywordPlanCampaignKeywordsResponse;
import com.google.ads.googleads.v13.services.MutateKeywordPlanCampaignsResponse;
import com.google.ads.googleads.v13.services.MutateKeywordPlansResponse;
import com.google.ads.googleads.v13.utils.ResourceNames;

public class PlanejandoPalavrasApp {

	public static void main(String[] args) {
		GoogleAdsClient googleAdsClient;
		try {
			googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
			runExample(googleAdsClient,5328916093L);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void runExample(GoogleAdsClient googleAdsClient, Long customerId) {
		String keywordPlanResource = createKeywordPlan(googleAdsClient, customerId);
		String planCampaignResource = createKeywordPlanCampaign(googleAdsClient, customerId, keywordPlanResource);
		String planAdGroupResource = createKeywordPlanAdGroup(googleAdsClient, customerId, planCampaignResource);
		createKeywordPlanAdGroupKeywords(googleAdsClient, customerId, planAdGroupResource);
		createKeywordPlanCampaignKeywords(googleAdsClient, customerId, planCampaignResource);
	}

	/**
	 * Creates a keyword plan.
	 *
	 * @param googleAdsClient the Google Ads API client.
	 * @param customerId      the client customer ID.
	 */
	private static String createKeywordPlan(GoogleAdsClient googleAdsClient, Long customerId) {
		KeywordPlan plan = KeywordPlan.newBuilder()
				.setName("Keyword plan for traffic estimate #" + getPrintableDateTime())
				.setForecastPeriod(KeywordPlanForecastPeriod.newBuilder()
						.setDateInterval(KeywordPlanForecastInterval.NEXT_QUARTER).build())
				.build();

		KeywordPlanOperation op = KeywordPlanOperation.newBuilder().setCreate(plan).build();

		try (KeywordPlanServiceClient client = googleAdsClient.getLatestVersion().createKeywordPlanServiceClient()) {
			// Adds the keyword plan.
			MutateKeywordPlansResponse response = client.mutateKeywordPlans(String.valueOf(customerId),
					Arrays.asList(op));

			// Displays the results.
			String resourceName = response.getResults(0).getResourceName();
			System.out.printf("Created keyword plan: %s%n", resourceName);
			return resourceName;
		}
	}

	/**
	 * Creates a campaign for the keyword plan.
	 *
	 * @param googleAdsClient     the Google Ads API client.
	 * @param customerId          the client customer ID.
	 * @param keywordPlanResource the keyword plan resource name.
	 */
	private static String createKeywordPlanCampaign(GoogleAdsClient googleAdsClient, Long customerId,
			String keywordPlanResource) {
		// Creates a keyword plan campaign.
		KeywordPlanCampaign.Builder campaign = KeywordPlanCampaign.newBuilder()
				.setName("Keyword plan campaign #" + getPrintableDateTime()).setCpcBidMicros(1_000_000L)
				.setKeywordPlanNetwork(KeywordPlanNetwork.GOOGLE_SEARCH).setKeywordPlan(keywordPlanResource);

		// See https://developers.google.com/google-ads/api/reference/data/geotargets
		// for the list of geo target IDs.
		campaign.addGeoTargets(KeywordPlanGeoTarget.newBuilder()
				// Geo-target constant 2840 is for USA.
				.setGeoTargetConstant(ResourceNames.geoTargetConstant(2840)).build());

		// See
		// https://developers.google.com/google-ads/api/reference/data/codes-formats#languages
		// for the list of language criteria IDs.
		//
		// Language criteria 1000 is for English.
		campaign.addLanguageConstants(ResourceNames.languageConstant(1000));

		KeywordPlanCampaignOperation op = KeywordPlanCampaignOperation.newBuilder().setCreate(campaign).build();

		try (KeywordPlanCampaignServiceClient client = googleAdsClient.getLatestVersion()
				.createKeywordPlanCampaignServiceClient()) {
			// Adds the campaign.
			MutateKeywordPlanCampaignsResponse response = client.mutateKeywordPlanCampaigns(String.valueOf(customerId),
					Arrays.asList(op));

			// Displays the result.
			String resourceName = response.getResults(0).getResourceName();
			System.out.printf("Created campaign for keyword plan: %s%n", resourceName);
			return resourceName;
		}
	}

	/**
	 * Creates the ad group for the keyword plan.
	 *
	 * @param googleAdsClient      the Google Ads API client.
	 * @param customerId           the client customer ID.
	 * @param planCampaignResource plan campaign resource name.
	 */
	private static String createKeywordPlanAdGroup(GoogleAdsClient googleAdsClient, Long customerId,
			String planCampaignResource) {
		// Creates the keyword plan ad group.
		KeywordPlanAdGroup.Builder adGroup = KeywordPlanAdGroup.newBuilder()
				.setKeywordPlanCampaign(planCampaignResource)
				.setName("Keyword plan ad group #" + getPrintableDateTime()).setCpcBidMicros(2_500_000L);

		KeywordPlanAdGroupOperation op = KeywordPlanAdGroupOperation.newBuilder().setCreate(adGroup).build();
		try (KeywordPlanAdGroupServiceClient client = googleAdsClient.getLatestVersion()
				.createKeywordPlanAdGroupServiceClient()) {
			// Adds the ad group.
			MutateKeywordPlanAdGroupsResponse response = client.mutateKeywordPlanAdGroups(String.valueOf(customerId),
					Arrays.asList(op));

			// Displays the result.
			String resourceName = response.getResults(0).getResourceName();
			System.out.println("Created ad group for keyword plan: " + resourceName);
			return resourceName;
		}
	}

	

	/**
	 * Creates keywords for the keyword plan.
	 *
	 * @param googleAdsClient     the Google Ads API client.
	 * @param customerId          the client customer ID.
	 * @param planAdGroupResource plan ad group resource name.
	 */
	private static void createKeywordPlanAdGroupKeywords(GoogleAdsClient googleAdsClient, Long customerId,
			String planAdGroupResource) {
		// Creates the keywords for keyword plan.
		KeywordPlanAdGroupKeyword keyword1 = KeywordPlanAdGroupKeyword.newBuilder()
				.setKeywordPlanAdGroup(planAdGroupResource).setCpcBidMicros(2_000_000L)
				.setMatchType(KeywordMatchType.BROAD).setText("mars cruise").build();
		KeywordPlanAdGroupKeyword keyword2 = KeywordPlanAdGroupKeyword.newBuilder()
				.setKeywordPlanAdGroup(planAdGroupResource).setCpcBidMicros(1_500_000L)
				.setMatchType(KeywordMatchType.PHRASE).setText("cheap cruise").build();
		KeywordPlanAdGroupKeyword keyword3 = KeywordPlanAdGroupKeyword.newBuilder()
				.setKeywordPlanAdGroup(planAdGroupResource).setCpcBidMicros(1_990_000L)
				.setMatchType(KeywordMatchType.EXACT).setText("jupiter cruise").build();

		// Creates an operation for each plan keyword.
		List<KeywordPlanAdGroupKeywordOperation> operations = Stream.of(keyword1, keyword2, keyword3)
				.map(kw -> KeywordPlanAdGroupKeywordOperation.newBuilder().setCreate(kw).build())
				.collect(Collectors.toList());

		try (KeywordPlanAdGroupKeywordServiceClient client = googleAdsClient.getLatestVersion()
				.createKeywordPlanAdGroupKeywordServiceClient()) {
			// Adds the keywords.
			MutateKeywordPlanAdGroupKeywordsResponse response = client
					.mutateKeywordPlanAdGroupKeywords(String.valueOf(customerId), operations);
			// Displays the results.
			for (MutateKeywordPlanAdGroupKeywordResult result : response.getResultsList()) {
				System.out.printf("Created keyword for keyword plan: %s%n", result.getResourceName());
			}
		}
	}

	/**
	 * Creates negative keywords for the keyword plan.
	 *
	 * @param googleAdsClient      the Google Ads API client.
	 * @param customerId           the client customer ID.
	 * @param planCampaignResource plan campaign resource name.
	 */
	private static void createKeywordPlanCampaignKeywords(GoogleAdsClient googleAdsClient, Long customerId,
			String planCampaignResource) {
		KeywordPlanCampaignKeyword negativeKeyword = KeywordPlanCampaignKeyword.newBuilder()
				.setKeywordPlanCampaign(planCampaignResource).setMatchType(KeywordMatchType.BROAD).setNegative(true)
				.setText("moon walk").build();
		KeywordPlanCampaignKeywordOperation op = KeywordPlanCampaignKeywordOperation.newBuilder()
				.setCreate(negativeKeyword).build();

		try (KeywordPlanCampaignKeywordServiceClient client = googleAdsClient.getLatestVersion()
				.createKeywordPlanCampaignKeywordServiceClient()) {
			// Adds the negative keyword.
			MutateKeywordPlanCampaignKeywordsResponse response = client
					.mutateKeywordPlanCampaignKeywords(String.valueOf(customerId), Arrays.asList(op));

			// Displays the result.
			String resourceName = response.getResults(0).getResourceName();
			System.out.printf("Created negative keyword for keyword plan: %s%n", resourceName);
		}
	}
	
	
	private static String getPrintableDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date); 
	}

}
