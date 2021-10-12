package dataentities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pet {
    String name;
    List<String> photoUrls;
}
