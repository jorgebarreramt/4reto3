package co.usa.edu.ciclo4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.edu.ciclo4.model.Vegetarian;

@Repository
public class InventariorRepository {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Vegetarian> getAll() {
        return inventarioRepository.findAll();
    }

    public Optional<Vegetarian> getInventario(String reference) {
        return inventarioRepository.findById(reference);
    }
    
    public Vegetarian create(Vegetarian inverario) {
        return inventarioRepository.save(inverario);
    }

    public void update(Vegetarian inverario) {
        inventarioRepository.save(inverario);
    }
    
    public void delete(Vegetarian inverario) {
        inventarioRepository.delete(inverario);
    }
}
