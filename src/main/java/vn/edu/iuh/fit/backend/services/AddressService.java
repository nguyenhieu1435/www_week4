package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.repositories.AddressRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {
    private AddressRepositoryImpl addressRepository;
    @Autowired
    public AddressService(AddressRepositoryImpl addressRepository) {
        this.addressRepository = addressRepository;
    }
    public boolean save(Address address) {
        return addressRepository.save(address);
    }
    public boolean update(Address address) {
        return addressRepository.update(address);
    }
    public boolean detele(UUID uuid) {
        return addressRepository.detele(uuid);
    }
    public Optional<Address> getByID(UUID uuid) {
        return addressRepository.getByID(uuid);
    }
    public List<Address> getAll() {
        return addressRepository.getAll();
    }
}
