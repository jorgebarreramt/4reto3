package co.usa.edu.ciclo4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.usa.edu.ciclo4.model.Vegetarian;

public interface InventarioRepository extends MongoRepository<Vegetarian, String>{
    
}
