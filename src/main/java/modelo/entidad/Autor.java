package modelo.entidad;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un autor.
 */
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    /**
     * Constructor de la clase Autor.
     *
     * @param nombre          El nombre del autor.
     * @param apellidos       Los apellidos del autor.
     * @param fechaNacimiento La fecha de nacimiento del autor.
     */
    public Autor(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = new ArrayList<>();
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Autor() {

    }

    // Getters y setters

    /**
     * Obtiene el ID del autor.
     *
     * @return El ID del autor.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del autor.
     *
     * @param id El ID del autor.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del autor.
     *
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del autor.
     *
     * @param nombre El nombre del autor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del autor.
     *
     * @return Los apellidos del autor.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del autor.
     *
     * @param apellidos Los apellidos del autor.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la fecha de nacimiento del autor.
     *
     * @return La fecha de nacimiento del autor.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del autor.
     *
     * @param fechaNacimiento La fecha de nacimiento del autor.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la lista de libros asociados al autor.
     *
     * @return La lista de libros asociados al autor.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Establece la lista de libros asociados al autor.
     *
     * @param libros La lista de libros asociados al autor.
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
