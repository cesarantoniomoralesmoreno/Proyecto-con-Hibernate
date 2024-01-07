package domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Curso implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Con esto formalizamos la generacion de la llave primaria
    @Column(name="id_curso")
    private Integer idCurso;

    private String nombre;

    private Double precio;


    
    @OneToMany(mappedBy = "curso") //Este mapeo al ser en dos direcciones se le llama mapeo bidireccional 


    private List<Asignacion> asignaciones;//En los metodos toString no se deben agregar la lista



    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    
   
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

     

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String toString() {
        return "Curso [idCurso=" + idCurso + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
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
        Curso other = (Curso) obj;
        if (idCurso == null) {
            if (other.idCurso != null)
                return false;
        } else if (!idCurso.equals(other.idCurso))
            return false;
        return true;
    }

    
    
}
