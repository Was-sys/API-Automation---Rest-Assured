package Test;

import api.clients.UpdatePetClient;
import api.models.updatePet.UpdatePetInputDTO;
import api.models.updatePet.UpdateResponseDTO;
import api.utils.CsvUtils;
import baseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UpdatePetTest extends BaseTest {

    // Example test using BaseTest, PetClient and DTOs
    @Test
    public void updatePet() {
        // Path to CSV file
        String csvPath = "src/test/resources/testdata/updatePetData.csv";
        // Read CSV data
        List<String[]> petData = CsvUtils.readCsv(csvPath);
        UpdatePetClient petClient = new UpdatePetClient();
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
            UpdatePetInputDTO.Category category = new UpdatePetInputDTO.Category(categoryId, categoryName);

// Create Tags object
            UpdatePetInputDTO.Tags tag = new UpdatePetInputDTO.Tags(tagId, tagName);
            List<UpdatePetInputDTO.Tags> tags = new ArrayList<>();
            tags.add(tag);

// Create photoUrls list
            List<String> photoUrls = new ArrayList<>();
            photoUrls.add(photoUrl);

// Finally build AddPet object
            UpdatePetInputDTO requestBody = new UpdatePetInputDTO(
                    id,
                    category,
                    name,
                    photoUrls,
                    tags,
                    status
            );

            // Call API
            Response response = petClient.updatePet(requestBody);

            // Print and assert
            // System.out.println("Created Pet: " + name + " Response: " + response.asString());
            Assert.assertEquals(response.statusCode(), 200);
            UpdateResponseDTO responseDTO = response.as(UpdateResponseDTO.class);

            Assert.assertTrue(responseDTO.getId() > 0);
            Assert.assertEquals(responseDTO.getName(), name);
            Assert.assertEquals(responseDTO.getStatus(), status);

            Assert.assertEquals(responseDTO.getCategory().getId(), categoryId);
            Assert.assertEquals(responseDTO.getCategory().getName(), categoryName);

            Assert.assertEquals(responseDTO.getPhotoUrls().get(0), photoUrl);
            Assert.assertEquals(responseDTO.getTags().get(0).getId(), tagId);
            Assert.assertEquals(responseDTO.getTags().get(0).getName(), tagName);
        }
    }
}
