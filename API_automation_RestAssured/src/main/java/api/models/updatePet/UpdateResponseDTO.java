package api.models.updatePet;

import java.util.List;

public class UpdateResponseDTO {
        private long id;
        private Category category;
        private String name;
        private List<String> photoUrls;
        private List<Tag> tags;
        private String status;

        public static class Category {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public static class Tag {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public long getId() {
            return id;
        }

        public Category getCategory() {
            return category;
        }

        public String getName() {
            return name;
        }

        public List<String> getPhotoUrls() {
            return photoUrls;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public String getStatus() {
            return status;
        }
    }

