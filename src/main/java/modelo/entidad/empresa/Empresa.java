package modelo.entidad.empresa;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que representa una empresa.
 */
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Empleado> empleados;

    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;

    /**
     * Constructor de la clase Empresa.
     *
     * @param id         El ID de la empresa.
     * @param nombre     El nombre de la empresa.
     * @param empleados  La lista de empleados de la empresa.
     * @param direccion  La dirección de la empresa.
     */
    public Empresa(Long id, String nombre, List<Empleado> empleados, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = empleados;
        this.direccion = direccion;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Empresa() {
    }

    // Getters y setters

    /**
     * Obtiene el ID de la empresa.
     *
     * @return El ID de la empresa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la empresa.
     *
     * @param id El ID de la empresa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la empresa.
     *
     * @return El nombre de la empresa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la empresa.
     *
     * @param nombre El nombre de la empresa.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de empleados de la empresa.
     *
     * @return La lista de empleados de la empresa.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece la lista de empleados de la empresa.
     *
     * @param empleados La lista de empleados de la empresa.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Obtiene la dirección de la empresa.
     *
     * @return La dirección de la empresa.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la empresa.
     *
     * @param direccion La dirección de la empresa.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Sobrescritura del método toString para representar el objeto como una cadena de texto.
     *
     * @return Una cadena de texto que representa al objeto Empresa.
     */
    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                ", direccion=" + direccion +
                '}';
    }
}
