package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import domain.Alumno;
import servicio.ServicioAlumno;

@WebServlet("/ServletControlador")

public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ServicioAlumno servicioAlumno = new ServicioAlumno();
    //Recuperamos la lista servicioAlumno:

    List<Alumno> alumnos = servicioAlumno.listarAlumnos();

    System.out.println("Listado de alumnos: "+alumnos);

    request.setAttribute("alumnos",alumnos);
    
    try {
        request.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(request, response);
    } catch (ServletException ex) {
        ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    }

    }
    
}
