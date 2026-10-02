package com.libbooks.library;

import com.libbooks.library.model.entity.Role;
import com.libbooks.library.repository.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class LibraryBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryBooksApplication.class, args);


	}


		@Bean
		public CommandLineRunner commandLineRunner(RoleRepo roleRepo) {
			return args -> {
				if(roleRepo.findByName("USER").isEmpty()) {
					roleRepo.save(Role.builder().name("USER").build());
				}
			};
		}

}
