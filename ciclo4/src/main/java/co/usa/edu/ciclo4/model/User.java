package co.usa.edu.ciclo4.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class User {
	@Id
	private Integer id;
	private String identification;
	private String name;
    private Date birthtDay;
    private String monthBirthtDay;
	private String address;
	private String cellPhone;
	private String email;
	private String password; 
	private String zone;
	private String type;
	
    
}
