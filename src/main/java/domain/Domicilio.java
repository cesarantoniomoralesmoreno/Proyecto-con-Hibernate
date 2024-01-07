package domain;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Domicilio implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Con esto formalizamos la generacion de la llave primaria
    @Column(name="id_domicilio")
    private Integer idDomicilio;

    private String calle;

    @Column(name="no_calle")
    private String noCalle;

    private String pais;

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoCalle() {
        return noCalle;
    }

    public void setNoCalle(String noCalle) {
        this.noCalle = noCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Domicilio [idDomicilio=" + idDomicilio + ", calle=" + calle + ", noCalle=" + noCalle + ", pais=" + pais
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idDomicilio == null) ? 0 : idDomicilio.hashCode());
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
        Domicilio other = (Domicilio) obj;
        if (idDomicilio == null) {
            if (other.idDomicilio != null)
                return false;
        } else if (!idDomicilio.equals(other.idDomicilio))
            return false;
        return true;
    }

    //Como en este caso se pueden agregar estas clases en colecciones 
    

    

}
