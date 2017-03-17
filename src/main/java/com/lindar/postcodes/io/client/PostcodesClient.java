package com.lindar.postcodes.io.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.ResponseVO;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.lindar.postcodes.io.client.util.PostcodesAPI;
import com.lindar.postcodes.io.client.vo.Geolocation;
import com.lindar.postcodes.io.client.vo.Geolocations;
import com.lindar.postcodes.io.client.vo.MultiResponse;
import com.lindar.postcodes.io.client.vo.PostcodeVO;
import com.lindar.postcodes.io.client.vo.Response;

/**
 *
 * @author iulian
 */
public class PostcodesClient {

    public static final String START = "?";
    public static final String AND = "&";
    public static final String LIMIT_QUERY = "limit=%s";
    public static final String RADIUS_QUERY = "radius=%s";
    public static final String WIDE_SEARCH_QUERY = "wideSearch=%s";
    public static final String OUTCODE_QUERY = "outcode=%s";

    private final PostcodesAPI API;

    /**
     * Creates a Postcodes.io client with the default API root path: http://api.postcodes.io/
     */
    public PostcodesClient() {
        this.API = new PostcodesAPI();
    }

    /**
     * Creates a Postcodes.io client with a custom Postcodes.io API root path -
     * useful for when you host your own instance of Postcodes.io or the default
     * API changes and the library hasn't been updated yet
     *
     * @param postCodesApiRoot the custom Postcodes.io API root path
     * @throws IllegalArgumentException when the argument provided is blank -
     * please use the empty constructor if you want to use the default API path
     */
    public PostcodesClient(String postCodesApiRoot) {
        if (StringUtils.isBlank(postCodesApiRoot)) {
            throw new IllegalArgumentException("You provided a blank Postcodes API root path. If you want to use the default Postcodes.io API root path then use the default constructor");
        }
        this.API = new PostcodesAPI(postCodesApiRoot);
    }

    /**
     * Lookup a postcode. Returns all available data if found. Returns 404 if
     * postcode does not exist.
     *
     * @param postcode
     * @return
     */
    public Response<PostcodeVO> lookupPostcode(String postcode) {
        return processGetRequestAndReturnResponse(String.format(API.LOOKUP_POSTCODE, postcode));
    }

    /**
     * Receives a list of postcodes to search for. 
     * Returns a list of matching postcodes and respective available data in the form of a List of MultiResponse objects that contains the query and the list of results for each query
     *
     * <b>Accepts up to 100 codes</b>
     *
     * @param postcodes
     * @return
     */
    public Response<List<MultiResponse<String, PostcodeVO>>> bulkPostcodeLookup(List<String> postcodes) {
        String bulkPostcodesJson = "{\"postcodes\" : [%s]}";
        String formattedPostcodes = StringUtils.EMPTY;
        for (int i = 0; i < postcodes.size(); i++) {
            if (i == postcodes.size() - 1) {
                formattedPostcodes += "\"" + postcodes.get(i) + "\"";
            } else {
                formattedPostcodes += "\"" + postcodes.get(i) + "\",";
            }
        }
        return processPostRequestAndReturnResponse(API.BULK_LOOKUP_POSTCODES, String.format(bulkPostcodesJson, formattedPostcodes));
    }
    
    /**
     * Receives a list of geolocations to search for. 
     * Returns a list of matching postcodes and respective available data in the form of a List of MultiResponse objects that contains the query and the list of results for each query
     *
     * <b>Accepts up to 100 codes</b>
     *
     * @param geolocations
     * @return
     */
    public Response<List<MultiResponse<Geolocation, PostcodeVO>>> bulkReverseGeocoding(List<Geolocation> geolocations) {
        Geolocations geolocationsObj = new Geolocations();
        geolocationsObj.setGeolocations(geolocations);

        ResponseVO serverResponse = WellRestedRequest.build(API.BULK_REVERSE_GEOCODING).post(geolocationsObj);

        return getResponseFromServerResponse(serverResponse);
    }

    /**
     * Returns nearest postcodes for a given longitude and latitude. Uses
     * default limit of 10, default radius of 100m and defaults the wide search
     * to false 
     * <b>Want more options? Use reverse geocoding methods</b>
     *
     * @param longitude
     * @param latitude
     * @return
     */
    public Response<List<PostcodeVO>> nearestPostcodesFor(double longitude, double latitude) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES, longitude, latitude));
    }

    /**
     * Returns nearest postcodes for a given longitude and latitude. Uses
     * default limit of 10, default radius of 100m and defaults the wide search
     * to false 
     *
     * @param longitude
     * @param latitude
     * @return
     */
    public Response<PostcodeVO> reverseGeocoding(double longitude, double latitude) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES, longitude, latitude));
    }

    /**
     * Returns nearest postcodes for a given longitude and latitude. The limit
     * needs to be less than 100 Uses a default radius of 100m
     *
     * @param longitude
     * @param latitude
     * @param limit
     * @return
     */
    public Response<PostcodeVO> reverseGeocoding(double longitude, double latitude, int limit) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES + AND + LIMIT_QUERY, longitude, latitude, limit));
    }

    /**
     * Returns nearest postcodes for a given longitude and latitude. The limit
     * needs to be less than 100 The radius needs to be less than 2000m
     *
     * @param longitude
     * @param latitude
     * @param limit
     * @param radius
     * @return
     */
    public Response<PostcodeVO> reverseGeocoding(double longitude, double latitude, int limit, int radius) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES + AND + LIMIT_QUERY + AND + RADIUS_QUERY, longitude, latitude, limit, radius));
    }

    /**
     * Returns nearest postcodes for a given longitude and latitude. Uses
     * default limit of 10, default radius of 10. Wide Search - Search up to
     * 20km radius, but subject to a maximum of 10 results. Since lookups over a
     * wide area can be very expensive, we've created this method to allow you
     * choose to make the trade off between search radius and number of results.
     * When enabled, radius and limits over 10 are ignored.
     *
     * @param longitude
     * @param latitude
     * @param wideSearch
     * @return
     */
    public Response<PostcodeVO> reverseGeocoding(double longitude, double latitude, boolean wideSearch) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES + AND + WIDE_SEARCH_QUERY, longitude, latitude, wideSearch));
    }

    /**
     * Do you need a postcode badly? One postcode, any postcode? You're in the
     * right place
     *
     * @return
     */
    public Response<PostcodeVO> randomPostcode() {
        return processGetRequestAndReturnResponse(API.RANDOM_POSTCODE);
    }

    /**
     * Do you need a postcode badly? One postcode, any postcode? You're in the
     * right place Filters random postcodes by outcode.
     * <b>Doesn't return anything if invalid outcode</b>
     *
     * @param outcode
     * @return
     */
    public Response<PostcodeVO> randomPostcode(String outcode) {
        return processGetRequestAndReturnResponse(String.format(API.RANDOM_POSTCODE + START + OUTCODE_QUERY, outcode));
    }

    /**
     * Convenience method to validate a postcode. Returns true or false (meaning
     * valid or invalid respectively)
     *
     * @param postcode
     * @return
     */
    public Response<PostcodeVO> validatePostcode(String postcode) {
        return processGetRequestAndReturnResponse(String.format(API.VALIDATE_POSTCODE, postcode));
    }

    /**
     * Returns nearest postcodes for a given postcode. Uses a default limit of
     * 10 results and a default radius of 100m
     *
     * @param postcode
     * @return
     */
    public Response<PostcodeVO> nearestPostcodesForPostcode(String postcode) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES_FOR_POSTCODE, postcode));
    }

    /**
     * Returns nearest postcodes for a given postcode. Limit needs to be less
     * than 100 Uses a default radius of 100m
     *
     * @param postcode
     * @param limit
     * @return
     */
    public Response<PostcodeVO> nearestPostcodesForPostcode(String postcode, int limit) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES_FOR_POSTCODE + START + LIMIT_QUERY, postcode, limit));
    }

    /**
     * Returns nearest postcodes for a given postcode. Limit needs to be less
     * than 100 Radius needs to be less than 2000m
     *
     * @param postcode
     * @param limit
     * @param radius
     * @return
     */
    public Response<PostcodeVO> nearestPostcodesForPostcode(String postcode, int limit, int radius) {
        return processGetRequestAndReturnResponse(String.format(API.NEAREST_POSTCODES_FOR_POSTCODE + START + LIMIT_QUERY + AND + RADIUS_QUERY, postcode, limit));
    }

    /**
     * Convenience method to return a list of matching postcodes starting from
     * the partial post code Uses a default limit of 10 results
     *
     * @param partialPostcode
     * @return
     */
    public Response<PostcodeVO> autocompletePartialPostcode(String partialPostcode) {
        return processGetRequestAndReturnResponse(String.format(API.AUTOCOMPLETE_POSTCODE, partialPostcode));
    }

    /**
     * Convenience method to return a list of matching postcodes starting from
     * the partial post code Limit needs to be less than 100
     *
     * @param partialPostcode
     * @param limit
     * @return
     */
    public Response<PostcodeVO> autocompletePartialPostcode(String partialPostcode, int limit) {
        return processGetRequestAndReturnResponse(String.format(API.AUTOCOMPLETE_POSTCODE + START + LIMIT_QUERY, partialPostcode, limit));
    }

    /**
     * Submit a postcode query and receive a complete list of postcode matches
     * and all associated postcode data Uses a default limit of 10 results
     *
     * @param postcode
     * @return
     */
    public Response<PostcodeVO> queryForPostcode(String postcode) {
        return processGetRequestAndReturnResponse(String.format(API.QUERY_POSTCODE, postcode));
    }

    /**
     * Submit a postcode query and receive a complete list of postcode matches
     * and all associated postcode data. Limit needs to be less than 100
     *
     * @param postcode
     * @param limit
     * @return
     */
    public Response<PostcodeVO> queryForPostcode(String postcode, int limit) {
        return processGetRequestAndReturnResponse(String.format(API.QUERY_POSTCODE + AND + LIMIT_QUERY, postcode, limit));
    }

    private <T> Response<T> processGetRequestAndReturnResponse(String url) {
        ResponseVO serverResponse = WellRestedRequest.build(url).get();

        return getResponseFromServerResponse(serverResponse);
    }

    private <T> Response<T> processPostRequestAndReturnResponse(String url, String json) {
        ResponseVO serverResponse = WellRestedRequest.build(url).post(json);

        return getResponseFromServerResponse(serverResponse);
    }

    private <T> Response<T> getResponseFromServerResponse(ResponseVO serverResponse) {
        Response<T> response;
        if (StringUtils.isNotBlank(serverResponse.getServerResponse())) {
            Gson gson = new Gson();
            response = gson.fromJson(serverResponse.getServerResponse(), new TypeToken<Response<T>>() {
            }.getType());
        } else {
            response = new Response<>();
            response.setStatus(serverResponse.getStatusCode());
        }
        return response;
    }

}
