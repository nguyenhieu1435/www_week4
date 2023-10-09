package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.repositories.AddressRepositoryImpl;
import vn.edu.iuh.fit.repositories.CompanyRepositoryImpl;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class JobSeekingApplication {
	//scanBasePackages = {"vn.edu.iuh.fit.repositories"}
	@Autowired
	private AddressRepositoryImpl addressRepository;
	@Autowired
	private CompanyRepositoryImpl companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(JobSeekingApplication.class, args);
	}


	@Bean
	CommandLineRunner test_1(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				addressRepository.save(new Address(UUID.randomUUID(), "HCM City", (short) 84, "51", "Yen The", "40111"));
			}
		};
	}
	@Bean
	CommandLineRunner test_2(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Company> companyList = companyRepository.getAll();
				System.out.println(companyList);

			}
		};
	}
}
