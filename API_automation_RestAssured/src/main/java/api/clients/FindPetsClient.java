package api.clients;

import api.utils.ConfigManager;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FindPetsClient {
private final String petEndpoint = ConfigManager.get("findPets");
public Response findPet(){
    return given()
            .queryParam("status","available")
            .when()
            .get(petEndpoint)
            .then()
            .log().all()
            .extract().response();
}
}
