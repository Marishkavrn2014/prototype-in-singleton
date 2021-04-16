package com.epam.prototypeInSingleton.dogfood;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Data
@Component
@Scope("prototype")
public class Food {
    private String title;

    public Food() {
        List<String> foodNames = List.of("sausage", "Royal Canin", "Pedigree", "Abba", "Canning");
        title = foodNames.get(ThreadLocalRandom.current().nextInt(foodNames.size()));
    }
}
