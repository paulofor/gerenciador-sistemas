// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package validador.marketingdigital.integracao.googleads.pesquisas;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v13.resources.CarrierConstant;
import com.google.ads.googleads.v13.resources.LanguageConstant;
import com.google.ads.googleads.v13.services.GoogleAdsRow;
import com.google.ads.googleads.v13.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v13.services.SearchGoogleAdsStreamRequest;
import com.google.ads.googleads.v13.services.SearchGoogleAdsStreamResponse;
import com.google.api.gax.rpc.ServerStream;

/**
 * Illustrates how to:
 *
 * <ul>
 *   <li>Search for language constants where the name includes a given string.
 *   <li>Search for all the available mobile carrier constants with a given country code.
 * </ul>
 */
public class SearchForLanguageAndCarrierConstants {

  

  public static void main(String[] args) {
 

    GoogleAdsClient googleAdsClient = null;
    try {
      googleAdsClient = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
      searchForLanguageConstants(googleAdsClient, 5328916093L, "portugues");
      //searchForCarrierConstants(googleAdsClient, customerId, countryCode);
    } catch (FileNotFoundException fnfe) {
      System.err.printf(
          "Failed to load GoogleAdsClient configuration from file. Exception: %s%n", fnfe);
      System.exit(1);
    } catch (IOException ioe) {
      System.err.printf("Failed to create GoogleAdsClient. Exception: %s%n", ioe);
      System.exit(1);
    }

   
  }

  

  /**
   * Searches for language constants where the name includes the specified language name.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID.
   * @param languageName the string to use for searching for language constants.
   */
  private static void searchForLanguageConstants(
      GoogleAdsClient googleAdsClient, long customerId, String languageName) {
    try (GoogleAdsServiceClient googleAdsServiceClient =
        googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {

      // Creates a query that retrieves each language constant with the language name parameter in
      // the name.
      String searchQuery =
          "SELECT language_constant.id, "
              + "language_constant.code, "
              + "language_constant.name, "
              + "language_constant.targetable "
              + "FROM language_constant "
              + "WHERE language_constant.name LIKE '%"
              + languageName
              + "%'";

      // Constructs the SearchGoogleAdsStreamRequest.
      SearchGoogleAdsStreamRequest request =
          SearchGoogleAdsStreamRequest.newBuilder()
              .setCustomerId(Long.toString(customerId))
              .setQuery(searchQuery)
              .build();

      // Creates and issues a search Google Ads stream request that will retrieve all of the
      // requested field values for the matching language constants.
      ServerStream<SearchGoogleAdsStreamResponse> stream =
          googleAdsServiceClient.searchStreamCallable().call(request);

      for (SearchGoogleAdsStreamResponse response : stream) {
        for (GoogleAdsRow googleAdsRow : response.getResultsList()) {
          LanguageConstant languageConstant = googleAdsRow.getLanguageConstant();
          System.out.printf(
              "Language with ID %d, code '%s', name '%s', and targetable '%s' was found.%n",
              languageConstant.getId(),
              languageConstant.getCode(),
              languageConstant.getName(),
              languageConstant.getTargetable());
        }
      }
    }
  }

  /**
   * Searches for all the available mobile carrier constants with a given country code.
   *
   * @param googleAdsClient the Google Ads API client.
   * @param customerId the client customer ID.
   * @param countryCode the country code to use for filtering.
   */
  private static void searchForCarrierConstants(
      GoogleAdsClient googleAdsClient, long customerId, String countryCode) {
    try (GoogleAdsServiceClient googleAdsServiceClient =
        googleAdsClient.getLatestVersion().createGoogleAdsServiceClient()) {

      // Creates a query that retrieves each language constant with the language name parameter in
      // the name.
      String searchQuery =
          String.format(
              "SELECT carrier_constant.id, "
                  + "carrier_constant.name, "
                  + "carrier_constant.country_code "
                  + "FROM carrier_constant "
                  + "WHERE carrier_constant.country_code = '%s'",
              countryCode);

      // Constructs the SearchGoogleAdsStreamRequest.
      SearchGoogleAdsStreamRequest request =
          SearchGoogleAdsStreamRequest.newBuilder()
              .setCustomerId(Long.toString(customerId))
              .setQuery(searchQuery)
              .build();

      // Creates and issues a search Google Ads stream request that will retrieve all of the
      // requested field values for the matching carrier constants.
      ServerStream<SearchGoogleAdsStreamResponse> stream =
          googleAdsServiceClient.searchStreamCallable().call(request);

      for (SearchGoogleAdsStreamResponse response : stream) {
        for (GoogleAdsRow googleAdsRow : response.getResultsList()) {
          CarrierConstant carrierConstant = googleAdsRow.getCarrierConstant();
          System.out.printf(
              "Carrier with ID %d, name '%s', and country code '%s' was found.%n",
              carrierConstant.getId(), carrierConstant.getName(), carrierConstant.getCountryCode());
        }
      }
    }
  }
}

      