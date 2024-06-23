package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() throws IOException {
        CommonMethods.setUp();
    }

    @After
    public void tearDown() {
        CommonMethods.tearDown();
    }
}