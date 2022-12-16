package taller.BD.Server;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface RepoCuentas extends CrudRepository<Cuentas, Integer>{
    
}
