package dao;

import java.util.List;

import domain.Alumno;
import jakarta.persistence.Query;

public class AlumnoDAO extends GenericDAO {

    public List<Alumno> listar(){
        
        String consulta = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        return query.getResultList();

    }

    public void insertar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
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

    public void Actualizar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);//Con esto actualizamos y sincronizamos el estado de este objeto con la BD
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


    public void Eliminar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
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

    public Alumno buscarPorId(Alumno alumno){//Aqui cambiamos el tipo de retorno por el de la clase
        em = getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());//con el objeto Alumno proporcionamos la llave primaria que deseamos
        //mostrar.
    }
    
}
