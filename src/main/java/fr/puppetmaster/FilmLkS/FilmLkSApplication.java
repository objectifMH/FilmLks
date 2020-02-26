package fr.puppetmaster.FilmLkS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class FilmLkSApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FilmLkSApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
