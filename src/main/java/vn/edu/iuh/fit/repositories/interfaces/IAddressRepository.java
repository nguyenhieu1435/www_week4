package vn.edu.iuh.fit.repositories.interfaces;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface IAddressRepository {
    public boolean save(Address address);

    public boolean update(Address address);
    public boolean detele(UUID uuid);

    public Optional<Address> getByID(UUID uuid);

    public List<Address> getAll();
}
