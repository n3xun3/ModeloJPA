package modelo.entidad;

import modelo.entidad.Articulo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una lista de artículos y facilita su serialización a XML utilizando JAXB.
 */
@XmlRootElement(name = "articulos")
@XmlType(propOrder = {"listaArticulos"})
public class Articulos {

    private List<Articulo> listaArticulos;

    /**
     * Constructor por defecto de la clase Articulos.
     * Inicializa la lista de artículos como una lista vacía.
     */
    public Articulos() {
        listaArticulos = new ArrayList<>();
    }

    /**
     * Constructor que toma una lista de artículos y la asigna a la lista de artículos de esta instancia.
     * @param listaArticulos Lista de artículos.
     */
    public Articulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    /**
     * Método getter para obtener la lista de artículos.
     * @return Lista de artículos.
     */
    @XmlElement(name = "articulo")
    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    /**
     * Método setter para establecer la lista de artículos.
     * @param listaArticulos Lista de artículos.
     */
    public void setListaArticulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }
}
