package api.clients;

import api.models.addPetInputDTO.AddPet;
import api.models.updatePet.UpdatePetInputDTO;
import api.utils.ConfigManager;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdatePetClient {
    private final String petEndpoint = ConfigManager.get("updatePet");

    public Response updatePet(UpdatePetInputDTO pet) {
        return given()
                .body(pet)   // RestAssured will serialize DTO to JSON
                .when()
                .put(petEndpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}

