package dao;

import java.util.List;

import domain.Domicilio;
import jakarta.persistence.Query;

public class DomicilioDAO extends GenericDAO {
    public List<Domicilio> listar(){
        
        String consulta = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        return query.getResultList();

    }

    public void insertar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
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

    public void Actualizar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);//Con esto actualizamos y sincronizamos el estado de este objeto con la BD
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


    public void Eliminar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
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

    public Domicilio buscarPorId(Domicilio domicilio){//Aqui cambiamos el tipo de retorno por el de la clase
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());//con el objeto domicilio proporcionamos la llave primaria que deseamos
        //mostrar
    }
    
}
