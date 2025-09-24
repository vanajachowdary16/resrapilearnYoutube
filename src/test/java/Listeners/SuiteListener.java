package Listeners;

import io.restassured.RestAssured;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import filters.LoggingFilter;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        RestAssured.filters(new LoggingFilter());
    }

    @Override
    public void onFinish(ISuite suite) {
        // optional clean-up
    }
}
