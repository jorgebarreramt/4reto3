package co.usa.edu.ciclo4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.edu.ciclo4.model.Vegetarian;
import co.usa.edu.ciclo4.repository.InventarioRepository;
import co.usa.edu.ciclo4.service.InventarioService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/vegetarian")

public class InventarioController {
	
	@Autowired
	private InventarioRepository inventariorepo;

	@Autowired
    private InventarioService inventarioService;
	
	@GetMapping("/all")
	List<Vegetarian> productos() {
		return inventariorepo.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/new")
	Vegetarian crearProducto(@RequestBody Vegetarian inventario) {
		return inventariorepo.save(inventario);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/update")
	Vegetarian actualizarProducto(@RequestBody Vegetarian inventario) {
		return inventariorepo.save(inventario);
	}
	


	@GetMapping("/{reference}")
    public Optional<Vegetarian> getInventario(@PathVariable("reference") String reference) {
        return inventarioService.getInverario(reference);
	}
}

