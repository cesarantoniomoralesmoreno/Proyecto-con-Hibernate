package web.cascade;
import domain.Alumno;
import domain.Contacto;
import domain.Domicilio;
import jakarta.persistence.*;

public class PersistenciaCascadaTest {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");

        EntityManager em = emf.createEntityManager();//Esto es para crear la conexion con la base de datos.

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Nogales");
        domicilio.setNoCalle("10");
        domicilio.setPais("Colombia");

        Contacto contacto = new Contacto();
        contacto.setEmail("Clara@mail.com");
        contacto.setTelefono("23345234");

        Alumno alumno = new Alumno();

        alumno.setNombre("Carlos");
        alumno.setApellido("Apellido");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

        //En este caso solo con guardar el objeto alumno todos los valores se guardaran en cascada

        em.getTransaction().begin();//Iniciamos la transaccion
        em.persist(alumno);//Persistimos el objeto alumno que contiene todos los datos de los demas objetos
        em.getTransaction().commit();//Cerramos la transaccion y hacemos commit


        System.out.println("alumno = "+alumno);

        /*
         Hibernate: insert into Contacto (Email,telefono) values (?,?)
Hibernate: insert into Domicilio (calle,no_calle,pais) values (?,?,?)
Hibernate: insert into Alumno (apellido,id_contacto,id_domicilio,nombre) values (?,?,?,?)
alumno = Alumno [idAlumno=3, nombre=Carlos, apellido=Apellido, domicilio=Domicilio [idDomicilio=3, 
calle=Nogales, noCalle=10, pais=Colombia], contacto=Contacto [idContacto=4, telefono=23345234, Email=Clara@mail.com]]
         */
    }
}
