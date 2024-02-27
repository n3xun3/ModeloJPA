package modelo.entidad.empresa;

import javax.persistence.*;

/**
 * Clase que representa la dirección de un usuario.
 */
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String ciudad;
    private String codigoPostal;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /**
     * Constructor de la clase Direccion.
     * @param id Identificador de la dirección.
     * @param calle Nombre de la calle.
     * @param ciudad Nombre de la ciudad.
     * @param codigoPostal Código postal de la dirección.
     * @param usuario Usuario asociado a esta dirección.
     */
    public Direccion(Long id, String calle, String ciudad, String codigoPostal, Usuario usuario) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.usuario = usuario;
    }

    /**
     * Constructor vacío de la clase Direccion.
     */
    public Direccion() {}

    // Getters y setters

    /**
     * Obtiene el identificador de la dirección.
     * @return Identificador de la dirección.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la dirección.
     * @param id Identificador de la dirección.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la calle.
     * @return Nombre de la calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle.
     * @param calle Nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el nombre de la ciudad.
     * @return Nombre de la ciudad.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece el nombre de la ciudad.
     * @param ciudad Nombre de la ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el código postal de la dirección.
     * @return Código postal de la dirección.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección.
     * @param codigoPostal Código postal de la dirección.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene el usuario asociado a esta dirección.
     * @return Usuario asociado a esta dirección.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a esta dirección.
     * @param usuario Usuario asociado a esta dirección.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Representación en forma de cadena de la dirección.
     * @return Representación en forma de cadena de la dirección.
     */
    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
