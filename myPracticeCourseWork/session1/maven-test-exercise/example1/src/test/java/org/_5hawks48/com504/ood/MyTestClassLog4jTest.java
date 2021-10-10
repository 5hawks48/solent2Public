package org._5hawks48.com504.ood;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MyTestClassLog4jTest 
{
    @Test
    public void writeAboutMeTest()
    {
        MyTestClassLog4j logger = new MyTestClassLog4j();
        logger.writeAboutMe();
        assertTrue(true);
    }
}
