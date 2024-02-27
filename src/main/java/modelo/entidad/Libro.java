package modelo.entidad;
import javax.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private double precio;

    @ManyToOne
    private Editorial editorial;

    @ManyToOne
    private Autor autor;

    // Getters y setters
}

