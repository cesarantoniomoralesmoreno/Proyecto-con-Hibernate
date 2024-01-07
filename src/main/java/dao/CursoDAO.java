package dao;
import java.util.List;

import domain.Curso;
import jakarta.persistence.Query;

public class CursoDAO extends GenericDAO {
    public List<Curso> listar(){
        
        String consulta = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        return query.getResultList();

    }

    public void insertar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
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

    public void Actualizar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso);//Con esto actualizamos y sincronizamos el estado de este objeto con la BD
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


    public void Eliminar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(curso));
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

    public Curso buscarPorId(Curso curso){
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());//con el objeto Curso proporcionamos la llave primaria que deseamos
        //mostrar.
    }
    
}
