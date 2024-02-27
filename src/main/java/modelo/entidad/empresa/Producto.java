package modelo.entidad.empresa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un producto en el sistema.
 */
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallesPedidos = new ArrayList<>();

    /**
     * Constructor de la clase Producto.
     * @param id Identificador del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param detallesPedidos Detalles asociados a este producto.
     */
    public Producto(Long id, String nombre, double precio, List<DetallePedido> detallesPedidos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.detallesPedidos = detallesPedidos;
    }

    /**
     * Constructor vacío de la clase Producto.
     */
    public Producto() {}

    // Getters y setters

    /**
     * Obtiene el identificador del producto.
     * @return Identificador del producto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del producto.
     * @param id Identificador del producto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * @param precio Precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene los detalles asociados a este producto.
     * @return Detalles asociados a este producto.
     */
    public List<DetallePedido> getDetallesPedidos() {
        return detallesPedidos;
    }

    /**
     * Establece los detalles asociados a este producto.
     * @param detallesPedidos Detalles asociados a este producto.
     */
    public void setDetallesPedidos(List<DetallePedido> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }

    /**
     * Representación en forma de cadena del producto.
     * @return Representación en forma de cadena del producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", detallesPedidos=" + detallesPedidos +
                '}';
    }
}
