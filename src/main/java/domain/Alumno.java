package domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity

public class Alumno implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Con esto formalizamos la generacion de la llave primaria
    @Column(name="id_alumno")

    private Integer idAlumno;

    private String nombre;

    private String apellido;

    //Definimos las relaciones de muchos a uno, de alumno a domicilio y contacto
    //Si los nombres entre la llave primaria y secundaria son iguales no hay necesidad de agregar esta anotacion mas sin
    //embargo es de la siguiente manera:
    @JoinColumn(name="id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne(cascade = CascadeType.ALL)

    private Domicilio domicilio;
    
    @JoinColumn(name="id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne(cascade = CascadeType.ALL)//Para todas las acciones (insert,update,delete) se va a ejecutar la cascada
    
    private Contacto contacto;
    

    @OneToMany(mappedBy = "alumno") //Este mapeo al ser en dos direcciones se le llama mapeo bidireccional 


    private List<Asignacion> asignaciones;//En los metodos toString no se deben agregar la lista
    
    

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }


    @Override
    public String toString() {
        return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio="
                + domicilio + ", contacto=" + contacto + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAlumno == null) ? 0 : idAlumno.hashCode());
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
        Alumno other = (Alumno) obj;
        if (idAlumno == null) {
            if (other.idAlumno != null)
                return false;
        } else if (!idAlumno.equals(other.idAlumno))
            return false;
        return true;
    }

    

}
