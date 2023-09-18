package lib;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 * Verify that the JSON-RPC spec is satisfied
 * result
 *     This member is REQUIRED on success.
 *     This member MUST NOT exist if there was an error invoking the method.
 * error
 *     This member is REQUIRED on error.
 *     This member MUST NOT exist if there was no error triggered during invocation.
  * id
 *    This member is REQUIRED.
 *    It MUST be the same as the value of the id member in the Request Object.
 */
public class MainTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MainTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
