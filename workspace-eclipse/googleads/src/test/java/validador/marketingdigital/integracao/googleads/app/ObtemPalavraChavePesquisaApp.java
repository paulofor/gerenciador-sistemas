package validador.marketingdigital.integracao.googleads.app;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Nullable;

import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v13.enums.KeywordPlanNetworkEnum.KeywordPlanNetwork;
import com.google.ads.googleads.v13.errors.GoogleAdsError;
import com.google.ads.googleads.v13.errors.GoogleAdsException;
import com.google.ads.googleads.v13.services.GenerateKeywordIdeaResult;
import com.google.ads.googleads.v13.services.GenerateKeywordIdeasRequest;
import com.google.ads.googleads.v13.services.KeywordPlanIdeaServiceClient;
import com.google.ads.googleads.v13.services.KeywordPlanIdeaServiceClient.GenerateKeywordIdeasPagedResponse;
import com.google.ads.googleads.v13.utils.ResourceNames;

public class ObtemPalavraChavePesquisaApp {

	/*
	public static void main(String[] args) {
		AccessToken accessToken = new AccessToken("CENTRALLY_GENERATED_ACCESS_TOKEN", DateUtils.addMinutes(new Date(), 60));
		Credentials credentials = UserCredentials.newBuilder().setAccessToken(accessToken).setClientId("").setClientSecret("").build();
		GoogleAdsClient googleAdsClient = GoogleAdsClient.newBuilder().setCredentials(credentials).setDeveloperToken("XXXX").setLoginCustomerId(5328916093L).build();
		try {
			runExample(googleAdsClient, 5328916093L);
		} catch (GoogleAdsException gae) {
			System.err.printf("Request ID %s failed due to GoogleAdsException. Underlying errors:%n", gae.getRequestId());
			int i = 0;
			for (GoogleAdsError googleAdsError : gae.getGoogleAdsFailure().getErrorsList()) {
				System.err.printf("  Error %d: %s%n", i++, googleAdsError);
			}
		}
	}
	*/
	
	public static void main(String[] args) {
		AddCampaignsParams params = new AddCampaignsParams();
		params.customerId = Long.parseLong("5328916093");
		//setProxy();
		
		GoogleAdsClient googleAdsClient;
		try {
			googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
		} catch (FileNotFoundException fnfe) {
			System.out.printf("Failed to load GoogleAdsClient configuration from file. Exception: %s%n", fnfe);
			return;
		} catch (IOException ioe) {
			System.out.printf("Failed to create GoogleAdsClient. Exception: %s%n", ioe);
			return;
		}

		try {
			runExample(googleAdsClient, params.customerId);
		} catch (GoogleAdsException gae) {
			// GoogleAdsException is the base class for most exceptions thrown by an API
			// request.
			// Instances of this exception have a message and a GoogleAdsFailure that
			// contains a
			// collection of GoogleAdsErrors that indicate the underlying causes of the
			// GoogleAdsException.
			System.err.printf("Request ID %s failed due to GoogleAdsException. Underlying errors:%n",
					gae.getRequestId());
			int i = 0;
			for (GoogleAdsError googleAdsError : gae.getGoogleAdsFailure().getErrorsList()) {
				System.out.printf("  Error %d: %s%n", i++, googleAdsError);
			}
		}

	}

	
	
	private static void runExample(
		    GoogleAdsClient googleAdsClient,
		    long customerId,
		    long languageId,
		    List<Long> locationIds,
		    List<String> keywords,
		    @Nullable String pageUrl) {
		  try (KeywordPlanIdeaServiceClient keywordPlanServiceClient =
		      googleAdsClient.getLatestVersion().createKeywordPlanIdeaServiceClient()) {
		    GenerateKeywordIdeasRequest.Builder requestBuilder =
		        GenerateKeywordIdeasRequest.newBuilder()
		            .setCustomerId(Long.toString(customerId))
		            // Sets the language resource using the provided language ID.
		            .setLanguage(ResourceNames.languageConstant(languageId))
		            // Sets the network. To restrict to only Google Search, change the parameter below to
		            // KeywordPlanNetwork.GOOGLE_SEARCH.
		            .setKeywordPlanNetwork(KeywordPlanNetwork.GOOGLE_SEARCH_AND_PARTNERS);

		    // Adds the resource name of each location ID to the request.
		    for (Long locationId : locationIds) {
		      requestBuilder.addGeoTargetConstants(ResourceNames.geoTargetConstant(locationId));
		    }

		    // Makes sure that keywords and/or page URL were specified. The request must have exactly one
		    // of urlSeed, keywordSeed, or keywordAndUrlSeed set.
		    if (keywords.isEmpty() && pageUrl == null) {
		      throw new IllegalArgumentException(
		          "At least one of keywords or page URL is required, but neither was specified.");
		    }

		    if (keywords.isEmpty()) {
		      // Only page URL was specified, so use a UrlSeed.
		      requestBuilder.getUrlSeedBuilder().setUrl(pageUrl);
		    } else if (pageUrl == null) {
		      // Only keywords were specified, so use a KeywordSeed.
		      requestBuilder.getKeywordSeedBuilder().addAllKeywords(keywords);
		    } else {
		      // Both page URL and keywords were specified, so use a KeywordAndUrlSeed.
		      requestBuilder.getKeywordAndUrlSeedBuilder().setUrl(pageUrl).addAllKeywords(keywords);
		    }

		    // Sends the keyword ideas request.
		    GenerateKeywordIdeasPagedResponse response =
		        keywordPlanServiceClient.generateKeywordIdeas(requestBuilder.build());
		    // Prints each result in the response.
		    for (GenerateKeywordIdeaResult result : response.iterateAll()) {
		      System.out.printf(
		          "Keyword idea text '%s' has %d average monthly searches and '%s' competition.%n",
		          result.getText(),
		          result.getKeywordIdeaMetrics().getAvgMonthlySearches(),
		          result.getKeywordIdeaMetrics().getCompetition());
		    }
		  }
		}
		      

}
