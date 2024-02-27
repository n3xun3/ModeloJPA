package modelo.entidad;

import modelo.entidad.Articulo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "articulos")
@XmlType(propOrder = {"listaArticulos"})
public class Articulos {

    private List<Articulo> listaArticulos;

    public Articulos() {
        listaArticulos = new ArrayList<>();
    }

    public Articulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    @XmlElement(name = "articulo")
    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }
}

