package web;

import dao.AlumnoDAO;
import dao.AsignacionDAO;
import dao.ContactoDAO;
import dao.CursoDAO;
import dao.DomicilioDAO;


import java.util.List;

public class testDAOs {
    public static void main(String[] args) {
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("Alumnos: ");
        imprimir(alumnoDao.listar());

        System.out.println("Domicilios");
        DomicilioDAO domicilioDao = new DomicilioDAO();
        imprimir(domicilioDao.listar());

         System.out.println("Contactos");
        ContactoDAO contactoDao = new ContactoDAO();
        imprimir(contactoDao.listar());

        System.out.println("Curso");
        CursoDAO cursoDao = new CursoDAO();
        imprimir(cursoDao.listar());

        System.out.println("Asignaciones");
        AsignacionDAO asignacionDao = new AsignacionDAO();
        imprimir(asignacionDao.listar());


    }

    private static void imprimir(List coleccion){

        for(Object o: coleccion){
            System.out.println("valor = "+ o);
            
        }

    }
}
