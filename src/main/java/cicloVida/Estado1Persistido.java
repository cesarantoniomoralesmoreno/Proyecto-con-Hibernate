package cicloVida;

import domain.Contacto;
import jakarta.persistence.*;

public class Estado1Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");

        EntityManager em = emf.createEntityManager();//Esto es para crear la conexion con la base de datos.

        //1. Estado Transitivo

        //Creamos un objeto

        Contacto contacto = new Contacto();//Estado transitivo

        contacto.setEmail("clara");
        contacto.setTelefono("2132145454");

        //2.persistimos el objeto
        em.getTransaction().begin();

        em.persist(contacto);
        //em.flush();//con esto se sincroniza lo que este pendiente en la BD sin hacer commit 
        //Luego de esto podemos llamar a la informacion sincronizada por ejemplo con... contacto.getEmail();
        em.getTransaction().commit();//Con esto es que se guarda la informacion en la BD.

        //3. detached(separado)


        System.out.println("contacto = "+ contacto);
    }
}
