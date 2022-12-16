package taller.BD.Server;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Cuentas {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "nro",length = 10)
    private String numeracion;
    @ManyToOne
    private Persona titular;
    @ManyToMany(mappedBy = "cuenta")
    private List<Movimientos> movimientos;
    
    public Cuentas() {
    }
    public List<Movimientos> getMovis() {
        return movimientos;
    }
    public void setMovis(List<Movimientos> movis) {
        this.movimientos = movis;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeracion() {
        return numeracion;
    }
    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }
    public Persona getTitular() {
        return titular;
    }
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    


}
