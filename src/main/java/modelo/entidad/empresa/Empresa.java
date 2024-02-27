package modelo.entidad.empresa;
import javax.persistence.*;
import java.util.List;

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

    public Empresa(Long id, String nombre, List<Empleado> empleados, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = empleados;
        this.direccion = direccion;
    }

    public Empresa() {

    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

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
