package domain;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity

public class Asignacion implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Con esto formalizamos la generacion de la llave primaria
    @Column(name="id_asignacion")
    private Integer idAsignacion;

    private String turno;



    //Definimos las relaciones de muchos a uno, de alumno a domicilio y contacto
    //Si los nombres entre la llave primaria y secundaria son iguales no hay necesidad de agregar esta anotacion mas sin
    //embargo es de la siguiente manera:

    @JoinColumn(name="id_alumno", referencedColumnName = "id_alumno")
    @ManyToOne
    private Alumno alumno;

     @JoinColumn(name="id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso curso;

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Asignacion [idAsignacion=" + idAsignacion + ", turno=" + turno + ", alumno=" + alumno + ", curso="
                + curso + "]";
    }
    //Seleccionamos solo la llave primaria
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAsignacion == null) ? 0 : idAsignacion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Asignacion other = (Asignacion) obj;
        if (idAsignacion == null) {
            if (other.idAsignacion != null)
                return false;
        } else if (!idAsignacion.equals(other.idAsignacion))
            return false;
        return true;
    }

    


}
