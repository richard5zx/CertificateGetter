package richard5zx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Helper functions.
 */
public class HelperFunctionTest {
    /**
     * Test to add and delete certificates
     */
    @Test
    public void isNumericTest() {
        // Add Certificate
        String test1 = "123";
        String test2 = "2131";
        String test3 = "11231";
        String test4 = "hello";
        String test5 = "wasup";
        String test6 = "yolo";

        assertTrue(HelperFunction.isNumeric(test1));
        assertTrue(HelperFunction.isNumeric(test2));
        assertTrue(HelperFunction.isNumeric(test3));
        assertFalse(HelperFunction.isNumeric(test4));
        assertFalse(HelperFunction.isNumeric(test5));
        assertFalse(HelperFunction.isNumeric(test6));
    }
}
