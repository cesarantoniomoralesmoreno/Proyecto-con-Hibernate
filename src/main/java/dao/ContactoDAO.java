package dao;

import java.util.List;

import domain.Contacto;
import jakarta.persistence.Query;

public class ContactoDAO extends GenericDAO {
    public List<Contacto> listar(){
        
        String consulta = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        return query.getResultList();

    }

    public void insertar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        // finally{
        //     if(em!=null){
        //         em.close(); //cerramos nuestro objeto entityManager
        //     }
        // }
    }

    public void Actualizar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto);//Con esto actualizamos y sincronizamos el estado de este objeto con la BD
            em.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        // finally{
        //     if(em!=null){
        //         em.close(); //cerramos nuestro objeto entityManager
        //     }
        // }
    }


    public void Eliminar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        // finally{
        //     if(em!=null){
        //         em.close(); //cerramos nuestro objeto entityManager
        //     }
        // }
    }

    public Contacto buscarPorId(Contacto contacto){//Aqui cambiamos el tipo de retorno por el de la clase
        em = getEntityManager();
        return em.find(Contacto.class, contacto.getIdContacto());//con el objeto Contacto proporcionamos la llave primaria que deseamos
        //mostrar.
    }
    
}
