package modelo.entidad.empresa;

import javax.persistence.*;

/**
 * Clase que representa un detalle de un pedido.
 */
@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    /**
     * Constructor de la clase DetallePedido.
     * @param id Identificador del detalle de pedido.
     * @param cantidad Cantidad del producto en el detalle.
     * @param pedido Pedido al que pertenece este detalle.
     * @param producto Producto asociado a este detalle.
     */
    public DetallePedido(Long id, int cantidad, Pedido pedido, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.producto = producto;
    }

    /**
     * Constructor vacío de la clase DetallePedido.
     */
    public DetallePedido() {}

    // Getters y setters

    /**
     * Obtiene el identificador del detalle de pedido.
     * @return Identificador del detalle de pedido.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del detalle de pedido.
     * @param id Identificador del detalle de pedido.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad del producto en el detalle.
     * @return Cantidad del producto en el detalle.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto en el detalle.
     * @param cantidad Cantidad del producto en el detalle.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el pedido al que pertenece este detalle.
     * @return Pedido al que pertenece este detalle.
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * Establece el pedido al que pertenece este detalle.
     * @param pedido Pedido al que pertenece este detalle.
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Obtiene el producto asociado a este detalle.
     * @return Producto asociado a este detalle.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado a este detalle.
     * @param producto Producto asociado a este detalle.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Representación en forma de cadena del detalle de pedido.
     * @return Representación en forma de cadena del detalle de pedido.
     */
    @Override
    public String toString() {
        return "DetallePedido{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", pedido=" + pedido +
                ", producto=" + producto +
                '}';
    }
}
