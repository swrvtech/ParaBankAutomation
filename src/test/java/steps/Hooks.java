package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;
import utils.PageInitializer;

import java.io.IOException;

public class Hooks {

    @Before
    public void start() throws IOException {
        CommonMethods.setUp();
        PageInitializer.initializePageObjects(CommonMethods.driver);
    }

    @After
    public void end() {
        CommonMethods.tearDown();
    }
}