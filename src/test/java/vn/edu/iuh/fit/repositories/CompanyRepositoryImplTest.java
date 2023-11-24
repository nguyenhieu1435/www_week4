package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.repositories.CompanyRepositoryImpl;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Company;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CompanyRepositoryImplTest {
    @Autowired
    private CompanyRepositoryImpl companyRepository;
    @Test
    void save() {
        boolean actualResult = companyRepository.save(
                new Company(UUID.randomUUID(), "Unknown"
                        , new Address(UUID.fromString("73c0dda3-cffe-41b6-b28a-f04d1fd31193")), "ABC Corp"
                        , "hieuabac1@gmail.com", "0966323292", "wwww.vovanhai.wp.com")
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void update() {
        boolean actualResult = companyRepository.update(
                new Company(UUID.fromString("a86f885f-1057-48d1-93c5-633e81398f07"), "Known"
                        , new Address(UUID.fromString("86e818f6-f3bb-4c87-bd48-f4f691d51eea"))
                        , "HieuCorp", "hieuhieua@gmail.com"
                , "010101011", "hieunguyen@web.com")
        );
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void delete() {
        boolean actualResult = companyRepository.delete(UUID.fromString("2411924b-3671-4760-8a6d-b935bc4465f9"));
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getByID() {
        Company company = companyRepository.getByID(UUID.fromString("a86f885f-1057-48d1-93c5-633e81398f07")).orElse(null);
        System.out.println(company);
        assertNotNull(company);
    }

    @Test
    void getAll() {
        List<Company> companyList = companyRepository.getAll();
        System.out.println(companyList);
        assertNotNull(companyList);
    }
}