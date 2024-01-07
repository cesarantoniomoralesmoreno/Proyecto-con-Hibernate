package cicloVida;

import domain.Contacto;
import jakarta.persistence.*;

public class Estado2RecuperarObjetoPersistente {
    public static void main(String[] args) {

        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");

        EntityManager em = emf.createEntityManager();//Esto es para crear la conexion con la base de datos.


        //Para Recuperar un objeto no es necesario iniciar una nueva trasaccion pero tambien se puede hacer
                    

        //Recuperar un objeto de la base de datos.
        //Definimos la variable que recibira el objeto de la BD
        Contacto contacto = null;
        
        //Ejemplo de otra forma
                    //em.getTransaction().begin();  //Esto estaria en estado persistente

        //Recuperamos el objeto
        contacto = em.find(Contacto.class, 3);//La clase y la llave primaria que deseamos recuperar
                    //em.getTrasaction.commit();//Si modificaramos el objeto con esta forma se guardaria el objeto modificado en la BD

        //Detached o separado de la BD
        //En la consola se hace un select hacia la BD
        System.out.println("contacto ="+contacto);

    }
}
