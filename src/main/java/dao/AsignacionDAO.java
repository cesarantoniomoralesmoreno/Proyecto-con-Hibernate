package dao;
import java.util.List;
import domain.Asignacion;
import jakarta.persistence.Query;


public class AsignacionDAO extends GenericDAO {
    public List<Asignacion> listar(){
        
        String consulta = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        return query.getResultList();

    }

    public void insertar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
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

    public void Actualizar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);//Con esto actualizamos y sincronizamos el estado de este objeto con la BD
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


    public void Eliminar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
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

    public Asignacion buscarPorId(Asignacion asignacion){//Aqui cambiamos el tipo de retorno por el de la clase
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getIdAsignacion());//con el objeto Asignacion proporcionamos la llave primaria que deseamos
        //mostrar.
    }
    
}

