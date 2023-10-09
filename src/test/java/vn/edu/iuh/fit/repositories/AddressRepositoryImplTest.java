package vn.edu.iuh.fit.repositories;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Address;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressRepositoryImplTest {

    @Autowired
    private AddressRepositoryImpl addressRepository;
    @Test
    void save() {
        boolean actualResult  = addressRepository.save(new Address(UUID.randomUUID(), "HCM City", (short) 84, "51", "Yen The", "40111"));
        boolean expectedResult = true;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void update() {
    }

    @Test
    void detele() {
    }

    @Test
    void getByID() {
    }

    @Test
    void getAll() {
    }
}