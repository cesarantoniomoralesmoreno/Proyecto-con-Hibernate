package servicio;

import dao.AlumnoDAO;
import domain.Alumno;

import java.util.List;


public class ServicioAlumno {
    private AlumnoDAO alumnoDao = new AlumnoDAO();

    public List<Alumno> listarAlumnos(){
        return alumnoDao.listar();
    }

    public void guardarAlumno(Alumno alumno){
        if(alumno != null && alumno.getIdAlumno()==null){//Si no hay datos de este alumno guardados en la BD
            alumnoDao.insertar(alumno);
        }
        else{
            alumnoDao.Actualizar(alumno);//Si hay se actualizan
        }
    }

    public void eliminarAlumno(Alumno alumno){
        alumnoDao.Eliminar(alumno);;
    }

    public Alumno encontrarAlumno(Alumno alumno){
        
        return alumnoDao.buscarPorId(alumno);
        
    }

}
