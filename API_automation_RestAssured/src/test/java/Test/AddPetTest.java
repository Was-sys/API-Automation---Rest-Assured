package Test;

import api.clients.AddPetClient;
import api.models.addPetInputDTO.AddPet;
import baseTest.BaseTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import api.utils.CsvUtils;

// Example test using BaseTest, PetClient and DTOs
public class AddPetTest extends BaseTest {

    @Test
    public void addPets() {
        // Path to CSV file
        String csvPath = "src/test/resources/testdata/petdata.csv";
        // Read CSV data
        List<String[]> petData = CsvUtils.readCsv(csvPath);
        AddPetClient petClient = new AddPetClient();
        for (String[] row : petData) {
            // Map CSV columns to DTOs
            Integer id = Integer.parseInt(row[0]);
            String name = row[1];
            int categoryId = Integer.parseInt(row[2]);
            String categoryName = row[3];
            String photoUrl = row[4];
            int tagId = Integer.parseInt(row[5]);
            String tagName = row[6];
            String status = row[7];
            AddPet.Category category = new AddPet.Category(categoryId, categoryName);

// Create Tags object
            AddPet.Tags tag = new AddPet.Tags(tagId, tagName);
            List<AddPet.Tags> tags = new ArrayList<>();
            tags.add(tag);

// Create photoUrls list
            List<String> photoUrls = new ArrayList<>();
            photoUrls.add(photoUrl);

// Finally build AddPet object
            AddPet requestBody = new AddPet(
                    id,
                    category,
                    name,
                    photoUrls,
                    tags,
                    status
            );

            // Call API
            Response response = petClient.addPet(requestBody);

            // Print and assert
            System.out.println("Created Pet: " + name + " Response: " + response.asString());
            Assert.assertEquals(response.statusCode(), 200);
        }
    }
}


