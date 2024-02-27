package modelo.entidad.empresa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un usuario en el sistema.
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Direccion direccion;

    /**
     * Constructor de la clase Usuario.
     * @param id Identificador del usuario.
     * @param nombre Nombre del usuario.
     * @param email Correo electrónico del usuario.
     * @param pedidos Lista de pedidos asociados al usuario.
     * @param direccion Dirección asociada al usuario.
     */
    public Usuario(Long id, String nombre, String email, List<Pedido> pedidos, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.pedidos = pedidos;
        this.direccion = direccion;
    }

    /**
     * Constructor vacío de la clase Usuario.
     */
    public Usuario() {}

    // Getters y setters

    /**
     * Obtiene el identificador del usuario.
     * @return Identificador del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     * @param id Identificador del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return Correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email Correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la lista de pedidos asociados al usuario.
     * @return Lista de pedidos asociados al usuario.
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Establece la lista de pedidos asociados al usuario.
     * @param pedidos Lista de pedidos asociados al usuario.
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * Obtiene la dirección asociada al usuario.
     * @return Dirección asociada al usuario.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección asociada al usuario.
     * @param direccion Dirección asociada al usuario.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Representación en forma de cadena del usuario.
     * @return Representación en forma de cadena del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", pedidos=" + pedidos +
                ", direccion=" + direccion +
                '}';
    }
}
