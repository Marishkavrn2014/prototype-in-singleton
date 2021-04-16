package com.epam.prototypeInSingleton;

import com.epam.prototypeInSingleton.config.ApplicationConfig;
import com.epam.prototypeInSingleton.dogfood.Dog;
import com.epam.prototypeInSingleton.dogfood.Food;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.IntStream;

@ShellComponent
public class Command {

final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Dog.class, Food.class);

    @ShellMethod("get food")
    public void get_food() {
        IntStream.range(0,5)
                .mapToObj(i -> applicationContext.getBean(Food.class))
                .forEach(food -> System.out.println(food.getTitle()));
    }

    @ShellMethod("get dog")
    public void get_dog() {
        IntStream.range(0,5)
                .mapToObj(i -> applicationContext.getBean(Dog.class))
                .forEach(dog -> System.out.println(dog.getFood().getTitle()));
    }

    @ShellMethod("get dif food")
    public void get_dif_food() {
        IntStream.range(0,5)
                .mapToObj(i -> applicationContext.getBean(Dog.class).happyEat())
                .forEach(System.out::println);
    }
}