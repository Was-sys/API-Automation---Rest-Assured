package api.models.addPetInputDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class AddPet {
    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;

    public AddPet(
            @JsonProperty("id") Integer id,
            @JsonProperty("category") Category category,
            @JsonProperty("name") String name,
            @JsonProperty("photoUrls") List<String> photoUrls,
            @JsonProperty("tags") List<Tags> tags,
            @JsonProperty("status") String status
    ) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    @Getter
    public static class Category {
        private Integer id;
        private String name;

        public Category(@JsonProperty("id") Integer id,
                        @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Getter
    public static class Tags {
        private Integer id;
        private String name;

        public Tags(@JsonProperty("id") Integer id,
                    @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }
    }
}
