package modelo.entidad.empresa;
import javax.persistence.*;
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cargo;

    @ManyToOne
    private Empresa empresa;

    public Empleado(Long id, String nombre, String cargo, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    public Empleado() {

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

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
