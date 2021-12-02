package be.dennisvn.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExercisesConfig {
    @Bean
    CommandLineRunner commandLineRunner(ExercisesRepository repository) {
        return args -> {
            Exercises tetris = new Exercises(
                "Tetris Session, Cis won bigtime.", "Tetris", 3
            );
            Exercises minecraft = new Exercises(
                " Minecraft Session, Kenneth got rekt.", "Minecraft", 1
            );

            repository.saveAll(
                List.of(tetris, minecraft)
            );
        };
    }
}
