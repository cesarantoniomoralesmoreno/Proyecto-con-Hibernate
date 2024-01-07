package cicloVida;

import domain.Contacto;
import jakarta.persistence.*;

public class Estado3ModificarObjetoPersistente {
    public static void main(String[] args) {

        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");

        EntityManager em = emf.createEntityManager();//Esto es para crear la conexion con la base de datos.

        
       

        //Recuperar un objeto de la base de datos.

        //Definimos la variable que recibira el objeto de la BD
        Contacto contacto = null;

        //Recuperamos el objeto  (si estamos fuera de la transaccion el objeto estaria en Estado detached)
        //1. Transitivo
        contacto = em.find(Contacto.class, 3);
        //La clase y la llave primaria que deseamos recuperar, este objeto puede estar dentro
        //o fuera de la transaccion

        

        //Modificamos el objeto:

        contacto.setEmail("Clara@gmail.com");//Objeto fuera de la transaccion
        
        em.getTransaction().begin();//Iniciamos la trasaccion

        //2. Estado de persistente porque el objeto esta dentro de la transaccion
        
        //em.persist(contacto);//Se puede usar este metodo pero esto es mas para guardar informacion la primera vez
        em.merge(contacto);//Pero de preferencia se usa este metodo para hacer modificaciones en la BD
        
        em.getTransaction().commit();//Si modificaramos el objeto con esta forma se guardaria el objeto modificado en la BD

        //3Detached o separado de la BD
        //En la consola se hace un select hacia la BD
        System.out.println("contacto ="+contacto);


        /*
Hibernate: select c1_0.id_contacto,c1_0.Email,c1_0.telefono from Contacto c1_0 where c1_0.id_contacto=?
Hibernate: update Contacto set Email=?,telefono=? where id_contacto=?
contacto =Contacto [idContacto=3, telefono=2132145454, Email=Clara@gmail.com] */


    }
}
