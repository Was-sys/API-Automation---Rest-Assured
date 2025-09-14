package api.clients;

import api.models.addPetInputDTO.AddPet;
import api.utils.ConfigManager;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AddPetClient {

    private final String petEndpoint = ConfigManager.get("addPets");

        public Response addPet(AddPet pet) {
            return given()
                    .body(pet)   // RestAssured will serialize DTO to JSON
                    .when()
                    .post(petEndpoint)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }
    }


