package com.lindar.postcodes.io.client;

import com.lindar.postcodes.io.client.PostcodesClient;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.lindar.postcodes.io.client.vo.Geolocation;
import com.lindar.postcodes.io.client.vo.MultiResponse;
import com.lindar.postcodes.io.client.vo.PostcodeVO;
import com.lindar.postcodes.io.client.vo.Response;

/**
 *
 * @author iulian
 */
@Ignore
public class PostcodesClientTest {
    
    public PostcodesClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lookupPostcode method, of class PostcodesClient.
     */
    @Test
    public void testLookupPostcode() {
        System.out.println("lookupPostcode");
        String postcode = "";
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.lookupPostcode(postcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bulkPostcodeLookup method, of class PostcodesClient.
     */
    @Test
    public void testBulkPostcodeLookup() {
        System.out.println("bulkPostcodeLookup");
        List<String> postcodes = null;
        PostcodesClient instance = new PostcodesClient();
        Response<List<MultiResponse<String, PostcodeVO>>> expResult = null;
        Response<List<MultiResponse<String, PostcodeVO>>> result = instance.bulkPostcodeLookup(postcodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bulkReverseGeocoding method, of class PostcodesClient.
     */
    @Test
    public void testBulkReverseGeocoding() {
        System.out.println("bulkReverseGeocoding");
        List<Geolocation> geolocations = null;
        PostcodesClient instance = new PostcodesClient();
        Response<List<MultiResponse<Geolocation, PostcodeVO>>> expResult = null;
        Response<List<MultiResponse<Geolocation, PostcodeVO>>> result = instance.bulkReverseGeocoding(geolocations);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nearestPostcodesFor method, of class PostcodesClient.
     */
    @Test
    public void testNearestPostcodesFor() {
        System.out.println("nearestPostcodesFor");
        double longitude = 0.0;
        double latitude = 0.0;
        PostcodesClient instance = new PostcodesClient();
        Response<List<PostcodeVO>> expResult = null;
        Response<List<PostcodeVO>> result = instance.nearestPostcodesFor(longitude, latitude);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseGeocoding method, of class PostcodesClient.
     */
    @Test
    public void testReverseGeocoding_double_double() {
        System.out.println("reverseGeocoding");
        double longitude = 0.0;
        double latitude = 0.0;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.reverseGeocoding(longitude, latitude);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseGeocoding method, of class PostcodesClient.
     */
    @Test
    public void testReverseGeocoding_3args_1() {
        System.out.println("reverseGeocoding");
        double longitude = 0.0;
        double latitude = 0.0;
        int limit = 0;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.reverseGeocoding(longitude, latitude, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseGeocoding method, of class PostcodesClient.
     */
    @Test
    public void testReverseGeocoding_4args() {
        System.out.println("reverseGeocoding");
        double longitude = 0.0;
        double latitude = 0.0;
        int limit = 0;
        int radius = 0;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.reverseGeocoding(longitude, latitude, limit, radius);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseGeocoding method, of class PostcodesClient.
     */
    @Test
    public void testReverseGeocoding_3args_2() {
        System.out.println("reverseGeocoding");
        double longitude = 0.0;
        double latitude = 0.0;
        boolean wideSearch = false;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.reverseGeocoding(longitude, latitude, wideSearch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomPostcode method, of class PostcodesClient.
     */
    @Test
    public void testRandomPostcode_0args() {
        System.out.println("randomPostcode");
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.randomPostcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomPostcode method, of class PostcodesClient.
     */
    @Test
    public void testRandomPostcode_String() {
        System.out.println("randomPostcode");
        String outcode = "";
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.randomPostcode(outcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePostcode method, of class PostcodesClient.
     */
    @Test
    public void testValidatePostcode() {
        System.out.println("validatePostcode");
        String postcode = "";
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.validatePostcode(postcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nearestPostcodesForPostcode method, of class PostcodesClient.
     */
    @Test
    public void testNearestPostcodesForPostcode_String() {
        System.out.println("nearestPostcodesForPostcode");
        String postcode = "";
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.nearestPostcodesForPostcode(postcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nearestPostcodesForPostcode method, of class PostcodesClient.
     */
    @Test
    public void testNearestPostcodesForPostcode_String_int() {
        System.out.println("nearestPostcodesForPostcode");
        String postcode = "";
        int limit = 0;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.nearestPostcodesForPostcode(postcode, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nearestPostcodesForPostcode method, of class PostcodesClient.
     */
    @Test
    public void testNearestPostcodesForPostcode_3args() {
        System.out.println("nearestPostcodesForPostcode");
        String postcode = "";
        int limit = 0;
        int radius = 0;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.nearestPostcodesForPostcode(postcode, limit, radius);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autocompletePartialPostcode method, of class PostcodesClient.
     */
    @Test
    public void testAutocompletePartialPostcode_String() {
        System.out.println("autocompletePartialPostcode");
        String partialPostcode = "";
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.autocompletePartialPostcode(partialPostcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autocompletePartialPostcode method, of class PostcodesClient.
     */
    @Test
    public void testAutocompletePartialPostcode_String_int() {
        System.out.println("autocompletePartialPostcode");
        String partialPostcode = "";
        int limit = 0;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.autocompletePartialPostcode(partialPostcode, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of queryForPostcode method, of class PostcodesClient.
     */
    @Test
    public void testQueryForPostcode_String() {
        System.out.println("queryForPostcode");
        String postcode = "";
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.queryForPostcode(postcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of queryForPostcode method, of class PostcodesClient.
     */
    @Test
    public void testQueryForPostcode_String_int() {
        System.out.println("queryForPostcode");
        String postcode = "";
        int limit = 0;
        PostcodesClient instance = new PostcodesClient();
        Response<PostcodeVO> expResult = null;
        Response<PostcodeVO> result = instance.queryForPostcode(postcode, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
