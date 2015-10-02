package org.spauny.joy.postcodes.io.util;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author iulian
 */
public final class PostcodesAPI {

    private static final String POSTCODES_IO_API_ROOT_PATH = "http://api.postcodes.io/";

    public final String API_ROOT_PATH;

    public String POSTCODES_IO_POSTCODES_API_ROOT_PATH;

    public String LOOKUP_POSTCODE;
    public String BULK_LOOKUP_POSTCODES;

    public String NEAREST_POSTCODES_FOR_POSTCODE;
    public String NEAREST_POSTCODES;

    public String BULK_REVERSE_GEOCODING;

    public String RANDOM_POSTCODE;
    public String VALIDATE_POSTCODE;

    public String AUTOCOMPLETE_POSTCODE;
    public String QUERY_POSTCODE;

    /**
     *
     * Creates a Postcodes.io client with the default API root path:
     * {@value #POSTCODES_IO_API_ROOT_PATH}
     */
    public PostcodesAPI() {
        this.API_ROOT_PATH = POSTCODES_IO_API_ROOT_PATH;
        initAPI();
    }

    /**
     * Creates a Postcodes.io client with a custom Postcodes.io API root path -
     * useful for when you host your own instance of Postcodes.io or the default
     * API changes and the library hasn't been updated yet
     *
     * @param postcodesAPIRootpath the custom Postcodes.io API root path
     * @throws IllegalArgumentException when the argument provided is blank -
     * please use the empty constructor if you want to use the default API path
     */
    public PostcodesAPI(String postcodesAPIRootpath) {
        if (StringUtils.isBlank(postcodesAPIRootpath)) {
            throw new IllegalArgumentException("You provided a blank Postcodes API root path. If you want to use the default Postcodes.io API root path then use the default constructor");
        }
        this.API_ROOT_PATH = postcodesAPIRootpath;
        initAPI();
    }
    
    private void initAPI() {
        POSTCODES_IO_POSTCODES_API_ROOT_PATH = API_ROOT_PATH + "postcodes/";

        LOOKUP_POSTCODE = POSTCODES_IO_POSTCODES_API_ROOT_PATH + "%s";
        BULK_LOOKUP_POSTCODES = POSTCODES_IO_POSTCODES_API_ROOT_PATH;

        NEAREST_POSTCODES_FOR_POSTCODE = POSTCODES_IO_POSTCODES_API_ROOT_PATH + "%s/nearest";
        NEAREST_POSTCODES = POSTCODES_IO_POSTCODES_API_ROOT_PATH + "?lon=%s&lat=%s";

        BULK_REVERSE_GEOCODING = POSTCODES_IO_POSTCODES_API_ROOT_PATH;

        RANDOM_POSTCODE = API_ROOT_PATH + "random/postcodes";
        VALIDATE_POSTCODE = POSTCODES_IO_POSTCODES_API_ROOT_PATH + "%s/validate";

        AUTOCOMPLETE_POSTCODE = POSTCODES_IO_POSTCODES_API_ROOT_PATH + "%s/autocomplete";
        QUERY_POSTCODE = POSTCODES_IO_POSTCODES_API_ROOT_PATH + "?q=%s";
    }
}
