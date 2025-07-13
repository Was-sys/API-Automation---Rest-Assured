package API;//import static Config.BaseUrl.baseUrl;
import Config.BaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class GetInventory {
    private static final Logger log = LoggerFactory.getLogger(GetInventory.class);

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BaseUrl.baseUrl;
    }

    @Test
    public void getInventory() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("/v2/store/inventory");

        response.then().log().all().statusCode(HttpStatus.SC_OK);
    }
}

