package ma.fstt.microservice2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("ma.fstt.microservice2client.controlleur")
@ComponentScan("ma.fstt.microservice2client.service")
@ComponentScan("ma.fstt.microservice2client.repository")


public class Microservice2ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2ClientApplication.class, args);
	}

}
