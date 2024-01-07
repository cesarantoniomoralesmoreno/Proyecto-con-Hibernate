package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;

import domain.Alumno;
import domain.Contacto;
import domain.Domicilio;
import servicio.ServicioAlumno;

@WebServlet("/ServletAgregar")

public class ServletAgregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String noCalle = request.getParameter("noCalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        Domicilio domicilio = new Domicilio();

        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setPais(pais);


        Contacto contacto = new Contacto();

        contacto.setEmail(email);
        contacto.setTelefono(telefono);


        Alumno alumno = new Alumno();
        
        alumno.setNombre(nombre);
        alumno.setApellido(nombre);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);



        ServicioAlumno servicioAlumno = new ServicioAlumno();
        //Guardando o actualizando la informacion de la BD.
        servicioAlumno.guardarAlumno(alumno);//Esta capa se va a comunicar con la capa de datos utilizando los objetos de tipo DAO

        request.getRequestDispatcher("/index.jsp").forward(request, response);//redirigimos al index para redesplegar la app.
        


    }
}
