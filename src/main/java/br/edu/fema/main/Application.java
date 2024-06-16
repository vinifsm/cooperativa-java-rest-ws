package br.edu.fema.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
@ComponentScan({"br.edu.fema"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void started() {
        System.out.println("Application started at " + LocalDateTime.now());
    }
}
