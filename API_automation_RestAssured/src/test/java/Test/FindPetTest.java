package Test;

import api.clients.FindPetsClient;
import baseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindPetTest extends BaseTest {
    @Test
    public void findPets(){
        FindPetsClient findPetsClient = new FindPetsClient();
        Response response = findPetsClient.findPet();
        System.out.println("Response: " + response.asString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("status").contains("available"));
    }
}
