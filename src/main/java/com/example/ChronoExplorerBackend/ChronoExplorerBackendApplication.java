package com.example.ChronoExplorerBackend;

import com.example.ChronoExplorerBackend.Entity.Role;
import com.example.ChronoExplorerBackend.Repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ChronoExplorerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChronoExplorerBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner initRoles(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.count() == 0) {
				roleRepository.save(new Role( "ROLE_USER"));
				roleRepository.save(new Role( "ROLE_ADMIN"));
				System.out.println("Rôles initiaux créés.");
			}
		};
	}

}
