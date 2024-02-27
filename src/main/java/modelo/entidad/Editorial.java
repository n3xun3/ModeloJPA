package modelo.entidad;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que representa una editorial.
 */
@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    /**
     * Constructor de la clase Editorial.
     *
     * @param nombre    El nombre de la editorial.
     * @param direccion La dirección de la editorial.
     */
    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Editorial() {

    }

    // Getters y setters

    /**
     * Obtiene el ID de la editorial.
     *
     * @return El ID de la editorial.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la editorial.
     *
     * @param id El ID de la editorial.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la editorial.
     *
     * @return El nombre de la editorial.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la editorial.
     *
     * @param nombre El nombre de la editorial.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección de la editorial.
     *
     * @return La dirección de la editorial.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la editorial.
     *
     * @param direccion La dirección de la editorial.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la lista de libros asociados a la editorial.
     *
     * @return La lista de libros asociados a la editorial.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Establece la lista de libros asociados a la editorial.
     *
     * @param libros La lista de libros asociados a la editorial.
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
