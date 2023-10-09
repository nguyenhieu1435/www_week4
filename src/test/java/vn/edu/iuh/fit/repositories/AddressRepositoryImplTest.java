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
        boolean actualResult  = addressRepository.save(new Address(UUID.randomUUID(), "HCM City"
                , (short) 84, "51", "Yen The", "40111"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void update() {
        boolean actualResult = addressRepository.update(
                new Address(UUID.fromString("71063e14-6e57-4f95-b51a-0122bab98a54"), "Pho Quang", (short) 55
                        , "100", "n van ba", "abc")
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void detele() {
        boolean actualResult = addressRepository.detele(UUID.fromString("e75fc0dd-40b8-460c-a087-073850922aac"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getByID() {
        assertNotNull(addressRepository.getByID(UUID.fromString("71063e14-6e57-4f95-b51a-0122bab98a54")).orElse(null));
    }

    @Test
    void getAll() {
        assertNotNull(addressRepository.getAll());

    }
}