package modelo.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    // Getters y setters
}

