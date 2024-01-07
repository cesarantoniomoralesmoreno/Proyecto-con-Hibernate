package web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import domain.Alumno;
import domain.Contacto;
import domain.Domicilio;
import servicio.ServicioAlumno;

@WebServlet("/ServletModificar")

public class ServletModificar extends HttpServlet{


    //Este metodo se usara para cargar la informacion  del alumno que se ha seleccionado
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            String idAlumnoS = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);

            Alumno alumno = new Alumno();
            alumno.setIdAlumno(idAlumno);
            //Para mandar a llamar el metodo de busqueda:

            ServicioAlumno  servicioAlumno = new ServicioAlumno();

            alumno = servicioAlumno.encontrarAlumno(alumno);//Se le pasa el alumno que se recupero 

            //compartimos la variable con la informacion de cada alumno por id.

            //request.setAttribute("alumno", alumno); para evitar que al recargar la informacion se pierda hay que cambiar el alcance

            HttpSession sesion = request.getSession();
            sesion.setAttribute("alumno", alumno);

            request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);

    }

    //Este metodo se usara para guardar la informacion  del alumno que se ha seleccionado

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServicioAlumno servicioAlumno = new ServicioAlumno();

        String modificar = request.getParameter("Modificar");

        if(modificar !=null){

        

//Recuperamos toda la informacion
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String noCalle = request.getParameter("noCalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        HttpSession sesion = request.getSession();
        Alumno alumno = (Alumno) sesion.getAttribute("alumno");
        
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);

        //Aqui recuperamos el valor del domicilio y lo setteamos en el valor deseado
        alumno.getDomicilio().setCalle(calle);
        alumno.getDomicilio().setNoCalle(noCalle);
        alumno.getDomicilio().setPais(pais);
        alumno.getContacto().setEmail(email);
        alumno.getContacto().setTelefono(telefono);

        
        
        //Guardando o actualizando la informacion de la BD.
        servicioAlumno.guardarAlumno(alumno);//Esta capa se va a comunicar con la capa de datos utilizando los objetos de tipo DAO

        
        //Aqui eliminamos los datos que fueron compartidos en esta sesion para evitar que sigan disponibles luego de terminar esta
        sesion.removeAttribute("alumno");

        }
        else{
            //Caso de eliminar:
            String idAlumnoS = request.getParameter("idAlumno"); //Recibiendo el idAlumno
            Integer idAlumno = Integer.parseInt(idAlumnoS);
            Alumno alumno = new Alumno(idAlumno);
            servicioAlumno.eliminarAlumno(alumno);//Con esto ya se elimina el objeto que con id que le estamos pasando
            
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);//redirigimos al index para redesplegar la app.
        


    }
    


    
}
