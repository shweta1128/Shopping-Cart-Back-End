package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Running this test suite will print the setup and teardown messages five times each,
 *  because there are five tests in this class.
 */
public class MainTest {
    Main objectUnderTest = new Main("Initial Test Message");

    @Before
    public void setUp() throws Exception {
        System.out.println( "Hello from setup method." );
    }

    @After
    public void tearDown() throws Exception {
        System.out.println( "Hello from cleanup method." );
    }

    @Test
    public void main() {
    }

    /**
     * Test the side effect of a void method.
     * There is no return value from the setMessage() method; but we can still test the result of the method,
     *  because the message field is not private, and this test is in the same package as Main.
     */
    @Test
    public void setMessage() {
        objectUnderTest.setMessage("TEST MESSAGE");
        Assert.assertEquals("TEST MESSAGE", objectUnderTest.message);
    }

    @Test
    public void getMessage() {
        System.out.println( "Hello from the getMessage test method" );
        Assert.assertEquals("Hello World 2", objectUnderTest.getMessage());
        Assert.assertTrue("Hello World 2".equals(objectUnderTest.getMessage()));
    }

    @Test
    public void testSetMessageDoesNotAllowNull() {
        NullPointerException expectedNullPointerException = null;
        try {
            objectUnderTest.setMessage(null);
        } catch (NullPointerException caughtNullPointerException) {
            System.out.println(caughtNullPointerException.getMessage());
            expectedNullPointerException = caughtNullPointerException;
        }
        Assert.assertNotNull(expectedNullPointerException);
        Assert.assertEquals("Message cannot be null !!!!!!", expectedNullPointerException.getMessage());
    }

    /**
     * This is a simpler way to test for an Exception being thrown,
     *  but we don't have access to the message inside the Exception,
     *   like we did in the previous test.
     */
    @Test(expected = NullPointerException.class)
    public void expectNullPointerWhenSettingNullMessage() {
        objectUnderTest.setMessage(null);
    }
}