package cicloVida;

import domain.Contacto;
import jakarta.persistence.*;

public class Estado4EliminarObjetoPersistente {
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

        
        //Iniciamos la trasaccion
        em.getTransaction().begin();

        //2. Remove ----Eliminamos el objeto 
        
        em.remove(em.merge(contacto));//sincronizamos la informacion en la BD 
        
        em.getTransaction().commit();//Si modificaramos el objeto con esta forma se guardaria el objeto modificado en la BD

        //3. Transitivo
                //En la consola se hace un select hacia la BD, pero ha sido eliminado
        System.out.println("contacto ="+contacto);

        }

        /*
Hibernate: select c1_0.id_contacto,c1_0.Email,c1_0.telefono from Contacto c1_0 where c1_0.id_contacto=?
Hibernate: delete from Contacto where id_contacto=?
contacto =Contacto [idContacto=3, telefono=2132145454, Email=Clara@gmail.com]

Se hace el delete y la informacion se queda en memoria pero ya se elimino de la base de datos
         */
}
