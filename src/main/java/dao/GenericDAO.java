package dao;

import jakarta.persistence.*;

public abstract class GenericDAO {

    //Se hace abstracta para que no podamos crear objetos de este tipo de clases
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "HibernateJpaPU";

    //Este constructor se encargara de instanciar la fabrica si en dado caso es igual a null
    public GenericDAO(){
        if(emf==null){
            emf = Persistence.createEntityManagerFactory(PU);
        }

    }

    public EntityManager getEntityManager(){
        if(em==null){
            em = emf.createEntityManager();
        }

        return em;
    }



    
}
