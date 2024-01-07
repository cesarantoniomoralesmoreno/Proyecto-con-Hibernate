package domain;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity

public class Contacto implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Con esto formalizamos la generacion de la llave primaria
    @Column(name="id_contacto")


    private Integer idContacto;
    private String telefono;
    private String Email;


    public Contacto() {
    }


    public Contacto(Integer idContacto) {
        this.idContacto = idContacto;
    }


    public Integer getIdContacto() {
        return idContacto;
    }


    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }


    @Override
    public String toString() {
        return "Contacto [idContacto=" + idContacto + ", telefono=" + telefono + ", Email=" + Email + "]";
    }

    //Con esto sabemos si 2 objetos son iguales o diferentes
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idContacto == null) ? 0 : idContacto.hashCode());
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
        Contacto other = (Contacto) obj;
        if (idContacto == null) {
            if (other.idContacto != null)
                return false;
        } else if (!idContacto.equals(other.idContacto))
            return false;
        return true;
    }

    

    
}
