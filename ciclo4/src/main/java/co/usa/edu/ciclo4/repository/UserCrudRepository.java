package co.usa.edu.ciclo4.repository;


import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import co.usa.edu.ciclo4.model.User;

public interface UserCrudRepository extends CrudRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    
    

}

