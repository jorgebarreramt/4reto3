package co.usa.edu.ciclo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.edu.ciclo4.model.User;
import co.usa.edu.ciclo4.repository.UseRepo;
import co.usa.edu.ciclo4.service.UserService;


@RestController

/**
 * el mapping define el contexto
 */

@RequestMapping("/api/user")

/**
 * permite procesamiento de cualquier tipo de peticion
 */

@CrossOrigin("*")

/**
 * creamos la nuestra clase 
 */
public class UserController {
    /**
    * creamos el  Autowired para inyectar
    */
     @Autowired
     /**
    * creamos la nuestra metodo userService
    */
    private UserService userService;
    
    /**
    * creamos el GetMapping
    */
    @GetMapping("/all")

    /**
    * creamos la lista User
    */
    public List<User> getAll() {
        return userService.getAll();
    }
    
    
    

    @GetMapping("/{email}/{password}")
    /**
    * creamos el metodo autenticarUsuario
    */
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    
    @GetMapping("/emailexist/{email}")
    /**
    * creamos el metodo existeEmail
    */
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }
    
    @Autowired
	private UseRepo userrepo1;

    @ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void Delete(@PathVariable Integer id) {
		User user = userrepo1.findById(id).orElseThrow(RuntimeException::new);
		userrepo1.delete(user);
	}
    
    @ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/new")
	User crearUsuario(@RequestBody User user) {
		return userrepo1.save(user);
	}

    @ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/update")
	User actualizarProducto(@RequestBody User inventario) {
		return userrepo1.save(inventario);
	}


}
   

