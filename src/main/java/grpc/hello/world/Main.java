package grpc.hello.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
            System.out.println("Application started with gRPC port: " + event.getApplicationContext().getEnvironment().getProperty("grpc.server.port"));
        });
        app.run(args);
    }

}
