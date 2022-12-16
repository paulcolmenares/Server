package taller.BD.Server;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {
    @Id
    @Column(length=10)
    private String usr;
    @Column(length=150)
    private String clave;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    Set<Roles> roles;

    public Usuario() {
    }
    public String getUsr() {
        return usr;
    }
    public void setUsr(String usr) {
        this.usr = usr;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    //Eventos JPA para operaciones previas a persistir en la BD
    @PrePersist
    public void nuevo() {
        clave= new BCryptPasswordEncoder().encode(clave);
        System.out.println("nuevo  "+usr+" "+clave);
    }
    
    @PreUpdate
    public void actualizado() {
        clave= new BCryptPasswordEncoder().encode(clave);
        System.out.println("actualizado "+clave+" "+usr);
    }
    public Set<Roles> getRoles() {
        return roles;
    }
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
