package modelo.entidad;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase que representa un artículo y facilita su serialización a XML utilizando JAXB.
 */
@XmlRootElement(name = "articulo")
@XmlType(propOrder = {"id", "nombre", "precio"})
public class Articulo {

    private int id;
    private String nombre;
    private double precio;

    /**
     * Constructor por defecto de la clase Articulo.
     * Inicializa los atributos de la clase con sus valores por defecto.
     */
    public Articulo() {
    }

    /**
     * Constructor que toma un ID, un nombre y un precio para inicializar un objeto Articulo.
     * @param id ID del artículo.
     * @param nombre Nombre del artículo.
     * @param precio Precio del artículo.
     */
    public Articulo(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Método getter para obtener el ID del artículo.
     * @return ID del artículo.
     */
    public int getId() {
        return id;
    }

    /**
     * Método setter para establecer el ID del artículo.
     * @param id ID del artículo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el nombre del artículo.
     * @return Nombre del artículo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del artículo.
     * @param nombre Nombre del artículo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el precio del artículo.
     * @return Precio del artículo.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método setter para establecer el precio del artículo.
     * @param precio Precio del artículo.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
