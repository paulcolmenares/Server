package taller.BD.Server;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Socios")
public class Socios {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "C1", length = 10)
    private String cedula;
    @Column(name = "N1", length = 15)
    private String nombres;
    @Column(name = "A1", length = 20)
    private String apellidos;
    private byte[] Foto;

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }

    @OneToOne(cascade = CascadeType.REMOVE,optional = true)
    private Usuario usr;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "titular")
    private Set<Cuentas> cuentas;

    public Set<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Set<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String ced) {
        cedula = ced;
    }

    public Socios() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
        result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
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
        Socios other = (Socios) obj;
        if (apellidos == null) {
            if (other.apellidos != null)
                return false;
        } else if (!apellidos.equals(other.apellidos))
            return false;
        if (nombres == null) {
            if (other.nombres != null)
                return false;
        } else if (!nombres.equals(other.nombres))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Persona [apellidos=" + apellidos + ", nombres=" + nombres + "]";
    }
}
