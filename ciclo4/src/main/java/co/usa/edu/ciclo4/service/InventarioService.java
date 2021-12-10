package co.usa.edu.ciclo4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import co.usa.edu.ciclo4.model.Vegetarian;
import co.usa.edu.ciclo4.repository.InventariorRepository;

@Service
public class InventarioService {

    @Autowired
    private InventariorRepository inventariorRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Vegetarian> getAll() {
        return inventariorRepository.getAll();
    }

    public Optional<Vegetarian> getInverario(String reference) {
        return inventariorRepository.getInventario(reference);
    }

    public Vegetarian create(Vegetarian inventario) {
        if (inventario.getReference() == null) {
            return inventario;
        } else {
            return inventariorRepository.create(inventario);
        }
    }

    public Vegetarian update(Vegetarian inventario) {

        if (inventario.getReference() != null) {
            Optional<Vegetarian> inventarioDb = inventariorRepository.getInventario(inventario.getReference());
            if (!inventarioDb.isEmpty()) {
                if (inventario.getBrand() != null) {
                    inventarioDb.get().setBrand(inventario.getBrand());
                }

                if (inventario.getCategory() != null) {
                    inventarioDb.get().setCategory(inventario.getCategory());
                }

                if (inventario.getDescription() != null) {
                    inventarioDb.get().setDescription(inventario.getDescription());
                }
                if (inventario.getPrice() != 0.0) {
                    inventarioDb.get().setPrice(inventario.getPrice());
                }
                if (inventario.getQuantity() != 0) {
                    inventarioDb.get().setQuantity(inventario.getQuantity());
                }
                if (inventario.getPhotography() != null) {
                    inventarioDb.get().setPhotography(inventario.getPhotography());
                }
                inventarioDb.get().setAvailability(inventario.isAvailability());
                inventariorRepository.update(inventarioDb.get());
                return inventarioDb.get();
            } else {
                return inventario;
            }
        } else {
            return inventario;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getInverario(reference).map(inventario -> {
            inventariorRepository.delete(inventario);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
