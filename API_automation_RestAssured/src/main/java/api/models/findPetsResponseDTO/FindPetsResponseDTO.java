package api.models.findPetsResponseDTO;

import api.models.addPetInputDTO.AddPet;

import java.util.List;

public class FindPetsResponseDTO {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private Tags tags;

    public static class Category{
        private Integer id;
        private String name;
    }
    public static class Tags{
        
    }
}
