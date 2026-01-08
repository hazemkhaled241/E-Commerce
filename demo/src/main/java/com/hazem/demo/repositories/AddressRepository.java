package com.hazem.demo.repositories;
import com.hazem.demo.entities.Address;
import org.springframework.data.repository.CrudRepository;
public interface AddressRepository extends CrudRepository<Address,Long>{
}
