package taller.BD.Server;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movimientos {
    @Id
    @GeneratedValue
    private Integer identif;
    private Instant fecha;
    private Boolean Tipo;
    private BigDecimal monto;
    @ManyToMany
    private List<Cuentas> cuenta;
    
    public void setCuenta(List<Cuentas> cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cuentas> getCuenta() {
        return cuenta;
    }

    public Movimientos() {
    }

    public Integer getIdentif() {
        return identif;
    }

    public void setIdentif(Integer identif) {
        this.identif = identif;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Boolean getTipo() {
        return Tipo;
    }

    public void setTipo(Boolean tipo) {
        Tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    
    
}
