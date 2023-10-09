package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.repositories.interfaces.IAddressRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Component
public class AddressRepositoryImpl implements IAddressRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Address address) {
        String sqlQuery = "insert into address(id, street, city, country, number, zipcode) " +
                "values(?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sqlQuery, address.getId(), address.getStreet()
                , address.getCity(), address.getCountry(), address.getNumber(), address.getZipcode());
        return result > 0;
    }

    @Override
    public boolean update(Address address) {
        String sqlQuery = "update address set street = ?, city = ?, country = ?, number = ?, zipcode = ? where id = ?";
        int result = jdbcTemplate.update(sqlQuery, address.getStreet()
                , address.getCity(), address.getCountry(), address.getNumber(), address.getZipcode(), address.getId());
        return result > 0;
    }

    @Override
    public boolean detele(UUID uuid) {
        String sqlQuery = "delete from address where id = ?";
        int result = jdbcTemplate.update(sqlQuery, uuid);
        return result > 0;
    }

    @Override
    public Address getByID(UUID uuid) {
        String sqlQuery = "select * from address where id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new BeanPropertyRowMapper<>(Address.class), uuid);

    }

    @Override
    public List<Address> getAll() {
        String sqlQuery = "select * from address";
        return jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(Address.class));
    }
}
