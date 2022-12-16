package taller.BD.Server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(RepoUsuarios repository)
	 {
  	  return (args) -> {
		System.out.println("Estoy añadiendo un usuario");
		Usuario t = new Usuario();
		t.setUsr("Octavio");t.setClave("1234");
		repository.save(t);
	  };
	}	
}
