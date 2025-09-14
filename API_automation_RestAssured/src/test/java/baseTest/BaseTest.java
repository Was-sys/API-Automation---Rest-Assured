package baseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import api.utils.ConfigManager;

import java.util.HashMap;
import java.util.Map;


public class BaseTest {

        protected RequestSpecification requestSpec;

        @BeforeClass
        public void setUp() {
            // Load from config.properties
            String baseUrl = ConfigManager.get("baseUrl");

            // Default headers
            Map<String, String> headers = new HashMap<>();
            headers.put("Accept", "application/json");
            headers.put("Content-Type", "application/json");

            // Build RequestSpecification
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(baseUrl)
                    .addHeaders(headers)
                    .build();

            // Assign it globally (optional)
            RestAssured.requestSpecification = requestSpec;
        }

        @AfterClass
        public void tearDown() {
            // RestAssured doesn't need explicit teardown like Playwright
            System.out.println("Test execution finished!");
        }
    }

