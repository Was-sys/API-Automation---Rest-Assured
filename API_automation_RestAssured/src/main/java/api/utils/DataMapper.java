package api.utils;

import api.models.addPetInputDTO.AddPet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataMapper {
    public static AddPet mapToAddPet(String[] csvRow){
        Integer id = Integer.parseInt(csvRow[0]);
        Integer categoryId = Integer.parseInt(csvRow[1]);
        String categoryName = csvRow[2];
        String name = csvRow[3];
        List<String> photoUrls = Arrays.asList(csvRow[4].split(";"));
        List<AddPet.Tags> tags = Arrays.stream(csvRow[5].split(";"))
                .map(tag -> {
                    String[] parts = tag.split(":");
                    return new AddPet.Tags(Integer.parseInt(parts[0]), parts[1]);
                })
                .collect(Collectors.toList());

        String status = csvRow[6];
        return new AddPet(id, new AddPet.Category(categoryId, categoryName), name, photoUrls, tags, status);
    }
}
