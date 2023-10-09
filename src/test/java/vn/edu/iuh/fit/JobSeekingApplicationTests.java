package vn.edu.iuh.fit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.repositories.AddressRepositoryImpl;

import java.util.UUID;

@SpringBootTest
class JobSeekingApplicationTests {
    @Autowired
    private AddressRepositoryImpl addressRepository;

}
