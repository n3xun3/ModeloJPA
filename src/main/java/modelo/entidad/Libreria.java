package modelo.entidad;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que representa una librería.
 */
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

    /**
     * Constructor de la clase Libreria.
     *
     * @param nombre       El nombre de la librería.
     * @param nombreDueno  El nombre del dueño de la librería.
     * @param direccion    La dirección de la librería.
     */
    public Libreria(String nombre, String nombreDueno, String direccion) {
        this.nombre = nombre;
        this.nombreDueno = nombreDueno;
        this.direccion = direccion;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Libreria() {

    }

    // Getters y setters

    /**
     * Obtiene el ID de la librería.
     *
     * @return El ID de la librería.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la librería.
     *
     * @param id El ID de la librería.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la librería.
     *
     * @return El nombre de la librería.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la librería.
     *
     * @param nombre El nombre de la librería.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del dueño de la librería.
     *
     * @return El nombre del dueño de la librería.
     */
    public String getNombreDueno() {
        return nombreDueno;
    }

    /**
     * Establece el nombre del dueño de la librería.
     *
     * @param nombreDueno El nombre del dueño de la librería.
     */
    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    /**
     * Obtiene la dirección de la librería.
     *
     * @return La dirección de la librería.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la librería.
     *
     * @param direccion La dirección de la librería.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la lista de libros asociados a la librería.
     *
     * @return La lista de libros asociados a la librería.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Establece la lista de libros asociados a la librería.
     *
     * @param libros La lista de libros asociados a la librería.
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombreDueno='" + nombreDueno + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
