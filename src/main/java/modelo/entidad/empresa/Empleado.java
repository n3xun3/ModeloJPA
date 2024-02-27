package modelo.entidad.empresa;

import javax.persistence.*;

/**
 * Clase que representa a un empleado de una empresa.
 */
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cargo;

    @ManyToOne
    private Empresa empresa;

    /**
     * Constructor de la clase Empleado.
     *
     * @param id      El ID del empleado.
     * @param nombre  El nombre del empleado.
     * @param cargo   El cargo del empleado.
     * @param empresa La empresa a la que pertenece el empleado.
     */
    public Empleado(Long id, String nombre, String cargo, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Empleado() {
    }

    // Getters y setters

    /**
     * Obtiene el ID del empleado.
     *
     * @return El ID del empleado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id El ID del empleado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el cargo del empleado.
     *
     * @return El cargo del empleado.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     *
     * @param cargo El cargo del empleado.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene la empresa a la que pertenece el empleado.
     *
     * @return La empresa a la que pertenece el empleado.
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa a la que pertenece el empleado.
     *
     * @param empresa La empresa a la que pertenece el empleado.
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Sobrescritura del método toString para representar el objeto como una cadena de texto.
     *
     * @return Una cadena de texto que representa al objeto Empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
