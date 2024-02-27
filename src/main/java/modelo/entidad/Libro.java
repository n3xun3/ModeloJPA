package modelo.entidad;

import javax.persistence.*;

/**
 * Clase que representa un libro.
 */
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

    @ManyToOne
    @JoinColumn(name = "libreria_id") // Nombre de la columna en la tabla de la base de datos
    private Libreria libreria;

    /**
     * Constructor de la clase Libro.
     *
     * @param titulo    El título del libro.
     * @param precio    El precio del libro.
     * @param editorial La editorial del libro.
     * @param autor     El autor del libro.
     */
    public Libro(String titulo, double precio, Editorial editorial, Autor autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Libro() {

    }

    // Getters y setters

    /**
     * Obtiene el ID del libro.
     *
     * @return El ID del libro.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del libro.
     *
     * @param id El ID del libro.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el precio del libro.
     *
     * @return El precio del libro.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del libro.
     *
     * @param precio El precio del libro.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return La editorial del libro.
     */
    public Editorial getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del libro.
     *
     * @param editorial La editorial del libro.
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor El autor del libro.
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la librería del libro.
     *
     * @return La librería del libro.
     */
    public Libreria getLibreria() {
        return libreria;
    }

    /**
     * Establece la librería del libro.
     *
     * @param libreria La librería del libro.
     */
    public void setLibreria(Libreria libreria) {
        this.libreria = libreria;
    }
}
