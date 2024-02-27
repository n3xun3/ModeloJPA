package modelo.entidad;
import javax.persistence.*;
import java.util.List;

@Entity
public class Libreria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nombreDueno;
    private String direccion;

    @ManyToMany
    private List<Libro> libros;

    // Getters y setters
}

