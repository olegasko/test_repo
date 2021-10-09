package dataentities;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@JsonPropertyOrder({"name", "photoUrls"})
public class Pet {

    private String name;
    private List<String> photoUrls;

    public Pet() {
        name = "Шарик";
        photoUrls.add("https://google.com/search?q=%D0%A8%D0%B0%D1%80%D0%B8%D0%BA&tbm=isch");
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void addPhotoUrl(String newPhotoUrl) {
        this.photoUrls.add(newPhotoUrl);
    }
}
