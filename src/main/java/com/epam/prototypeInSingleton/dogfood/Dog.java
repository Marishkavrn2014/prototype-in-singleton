package com.epam.prototypeInSingleton.dogfood;

import lombok.Data;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dog {
    private final String dogName = "Sharik";
    private final Food food;

    @Lookup
    public Food createFood() {
        System.out.println("!!!!!!!!!!!!!!!");
        return null;
    }

    public String eat() {
        return "Bark! I am " + dogName + " I ate " + food.getTitle();
    }

    public String happyEat() {
        return "Bark! I am " + dogName + " I ate " + createFood().getTitle();
    }
}
