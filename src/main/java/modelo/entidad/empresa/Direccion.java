package modelo.entidad.empresa;

import javax.persistence.*;

/**
 * Clase que representa una dirección asociada a una empresa.
 */
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String ciudad;
    private String codigoPostal;

    @OneToOne(mappedBy = "direccion")
    private Empresa empresa;

    /**
     * Constructor de la clase Direccion.
     *
     * @param id           El ID de la dirección.
     * @param calle        La calle de la dirección.
     * @param ciudad       La ciudad de la dirección.
     * @param codigoPostal El código postal de la dirección.
     * @param empresa      La empresa asociada a la dirección.
     */
    public Direccion(Long id, String calle, String ciudad, String codigoPostal, Empresa empresa) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.empresa = empresa;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Direccion() {
    }

    // Getters y setters

    /**
     * Obtiene el ID de la dirección.
     *
     * @return El ID de la dirección.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la dirección.
     *
     * @param id El ID de la dirección.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la calle de la dirección.
     *
     * @return La calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección.
     *
     * @param calle La calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la ciudad de la dirección.
     *
     * @return La ciudad de la dirección.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de la dirección.
     *
     * @param ciudad La ciudad de la dirección.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el código postal de la dirección.
     *
     * @return El código postal de la dirección.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección.
     *
     * @param codigoPostal El código postal de la dirección.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene la empresa asociada a la dirección.
     *
     * @return La empresa asociada a la dirección.
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa asociada a la dirección.
     *
     * @param empresa La empresa asociada a la dirección.
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Sobrescritura del método toString para representar el objeto como una cadena de texto.
     *
     * @return Una cadena de texto que representa al objeto Direccion.
     */
    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
