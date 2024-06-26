package dio.me.desafio_santander_api_deploy_2024;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class DesafioSantanderApiDeploy2024Application {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSantanderApiDeploy2024Application.class, args);
	}
}
