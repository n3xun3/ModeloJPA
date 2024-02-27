import modelo.entidad.*;

import javax.persistence.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.time.LocalDate;
import java.util.*;

/**
 * Esta clase representa el punto de entrada principal del programa.
 * Contiene la lógica principal para interactuar con la base de datos mediante JPA
 * y para serializar una lista de artículos a XML utilizando JAXB.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModeloJPA");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Dar de alta 3 autores
            Autor autor1 = new Autor("Miguel", "de Cervantes", LocalDate.of(1547, 9, 29));
            em.persist(autor1);

            Autor autor2 = new Autor("Federico", "García Lorca", LocalDate.of(1898, 6, 5));
            em.persist(autor2);

            Autor autor3 = new Autor("Isabel", "Allende", LocalDate.of(1942, 8, 2));
            em.persist(autor3);

            // Dar de alta 2 editoriales
            Editorial editorial1 = new Editorial("Editorial Planeta", "Barcelona");
            em.persist(editorial1);

            Editorial editorial2 = new Editorial("Editorial Alfaguara", "Madrid");
            em.persist(editorial2);

            // Dar de alta 2 librerías
            Libreria libreria1 = new Libreria("Librería La Central", "Juan Pérez", "Calle del Postigo de San Martín, 8, 28013 Madrid");
            em.persist(libreria1);

            Libreria libreria2 = new Libreria("Librería Bertrand", "María García", "Calle de Fuencarral, 119, 28010 Madrid");
            em.persist(libreria2);

            // Dar de alta 8 libros
            Libro libro1 = new Libro("Don Quijote de la Mancha", 20.0, editorial1, autor1);
            libro1.setLibreria(libreria1);
            autor1.getLibros().add(libro1);
            em.persist(libro1);

            Libro libro2 = new Libro("Bodas de Sangre", 25.0, editorial2, autor2);
            libro2.setLibreria(libreria1);
            autor2.getLibros().add(libro2);
            em.persist(libro2);

            Libro libro3 = new Libro("La casa de los espíritus", 30.0, editorial1, autor3);
            libro3.setLibreria(libreria1);
            autor3.getLibros().add(libro3);
            em.persist(libro3);

            Libro libro4 = new Libro("La Celestina", 20.0, editorial2, autor1);
            libro4.setLibreria(libreria2);
            autor1.getLibros().add(libro4);
            em.persist(libro4);

            Libro libro5 = new Libro("Yerma", 25.0, editorial2, autor2);
            libro5.setLibreria(libreria2);
            autor2.getLibros().add(libro5);
            em.persist(libro5);

            Libro libro6 = new Libro("Eva Luna", 30.0, editorial1, autor3);
            libro6.setLibreria(libreria1);
            autor3.getLibros().add(libro6);
            em.persist(libro6);

            // Dos libros adicionales
            Libro libro7 = new Libro("Cien años de soledad", 35.0, editorial1, autor3);
            libro7.setLibreria(libreria2);
            autor3.getLibros().add(libro7);
            em.persist(libro7);

            Libro libro8 = new Libro("Crónica de una muerte anunciada", 22.0, editorial2, autor1);
            libro8.setLibreria(libreria1);
            autor1.getLibros().add(libro8);
            em.persist(libro8);

            // Establecer libros en librerías
            libreria1.setLibros(Arrays.asList(libro1, libro2, libro3, libro6));
            libreria2.setLibros(Arrays.asList(libro4, libro5, libro7, libro8));

            // Commit transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        // Consultas
        try {
            // Mostrar todos los libros dados de alta, con su editorial y su autor
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Mostrar todos los libros dados de alta, con su editorial y su autor");
            System.out.println("-------------------------------------------------------------------");
            TypedQuery<Libro> query1 = em.createQuery("SELECT l FROM Libro l JOIN FETCH l.editorial JOIN FETCH l.autor", Libro.class);
            List<Libro> libros = query1.getResultList();
            for (Libro libro : libros) {
                System.out.println("Libro: " + libro.getTitulo());
                System.out.println("Editorial: " + libro.getEditorial().getNombre());
                System.out.println("Autor: " + libro.getAutor().getNombre());
                System.out.println();
            }

            // Mostrar todos los autores dados de alta, con sus libros asociados
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Mostrar todos los autores dados de alta, con sus libros asociados");
            System.out.println("-----------------------------------------------------------------");
            TypedQuery<Autor> query2 = em.createQuery("SELECT DISTINCT a FROM Autor a JOIN FETCH a.libros", Autor.class);
            List<Autor> autores = query2.getResultList();

            // Usar un conjunto para almacenar autores únicos
            Set<Autor> autoresUnicos = new HashSet<>(autores);

            // Recorrer el conjunto de autores únicos
            for (Autor autor : autoresUnicos) {
                System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellidos());
                System.out.println("Libros: ");
                for (Libro libro : autor.getLibros()) {
                    System.out.println("- " + libro.getTitulo());
                }
                System.out.println();
            }

            // Mostrar todas las librerías, con solamente sus libros asociados
            System.out.println("---------------------------------------------------------------");
            System.out.println("Mostrar todas las librerías, con solamente sus libros asociados");
            System.out.println("---------------------------------------------------------------");
            TypedQuery<Libreria> query3 = em.createQuery("SELECT DISTINCT l FROM Libreria l JOIN FETCH l.libros", Libreria.class);
            List<Libreria> librerias = query3.getResultList();
            for (Libreria libreria : librerias) {
                System.out.println("Librería: " + libreria.getNombre());
                System.out.println("Libros: ");
                for (Libro libro : libreria.getLibros()) {
                    System.out.println("- " + libro.getTitulo());
                }
                System.out.println();
            }

            // Mostrar todos los libros dados de alta, y en la librería en la que están
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Mostrar todos los libros dados de alta, y en la librería en la que están");
            System.out.println("------------------------------------------------------------------------");
            TypedQuery<Libro> query4 = em.createQuery("SELECT l FROM Libro l JOIN FETCH l.libreria", Libro.class);
            List<Libro> librosEnLibreria = query4.getResultList();
            for (Libro libro : librosEnLibreria) {
                System.out.println("Libro: " + libro.getTitulo());
                System.out.println("Librería: " + libro.getLibreria().getNombre());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        em.close();
        emf.close();

        // Código para serializar una lista de artículos a XML usando JAXB
        System.out.println("---------------");
        System.out.println("Mostrar XMLJAXB");
        System.out.println("---------------");
        List<Articulo> listaArticulos = new ArrayList<>();
        listaArticulos.add(new Articulo(1, "Camiseta de algodón", 15.99));
        listaArticulos.add(new Articulo(2, "Pantalones vaqueros", 29.95));
        listaArticulos.add(new Articulo(3, "Zapatillas deportivas", 49.99));

        Articulos articulos = new Articulos(listaArticulos);

        try {
            JAXBContext context = JAXBContext.newInstance(Articulos.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(articulos, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
