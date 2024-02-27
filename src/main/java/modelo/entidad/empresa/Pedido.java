package modelo.entidad.empresa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un pedido realizado por un usuario.
 */
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallesPedidos = new ArrayList<>();

    /**
     * Constructor de la clase Pedido.
     * @param id Identificador del pedido.
     * @param usuario Usuario que realiza el pedido.
     * @param detallesPedidos Detalles asociados a este pedido.
     */
    public Pedido(Long id, Usuario usuario, List<DetallePedido> detallesPedidos) {
        this.id = id;
        this.usuario = usuario;
        this.detallesPedidos = detallesPedidos;
    }

    /**
     * Constructor vacío de la clase Pedido.
     */
    public Pedido() {}

    // Getters y setters

    /**
     * Obtiene el identificador del pedido.
     * @return Identificador del pedido.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del pedido.
     * @param id Identificador del pedido.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el usuario que realizó el pedido.
     * @return Usuario que realizó el pedido.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó el pedido.
     * @param usuario Usuario que realizó el pedido.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene los detalles asociados a este pedido.
     * @return Detalles asociados a este pedido.
     */
    public List<DetallePedido> getDetallesPedidos() {
        return detallesPedidos;
    }

    /**
     * Establece los detalles asociados a este pedido.
     * @param detallesPedidos Detalles asociados a este pedido.
     */
    public void setDetallesPedidos(List<DetallePedido> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }

    /**
     * Representación en forma de cadena del pedido.
     * @return Representación en forma de cadena del pedido.
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", detallesPedidos=" + detallesPedidos +
                '}';
    }
}
