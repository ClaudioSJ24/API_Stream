package com.juarez.stream_API.lambdas.interfaces.engine.inventory.repository;

import com.juarez.stream_API.lambdas.interfaces.engine.inventory.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements  Repository<Customer, Long>{

    private  final InMemoryRepository storage = new InMemoryRepository();


    @Override
    public void save(Customer entity, Long aLong) {

        this.storage.save(aLong, entity);
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.of((Customer) storage.findById(aLong));
    }

    @Override
    public List<Customer> findAll() {

        List<Customer> result = new ArrayList<>();

        for (Object obj : this.storage.findAll()){
            result.add((Customer) obj);
        }
        return result;
    }

    @Override
    public void delete(Long aLong) {

        this.storage.delete(aLong);

    }
}
