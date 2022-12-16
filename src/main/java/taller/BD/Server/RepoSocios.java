package taller.BD.Server;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@CrossOrigin("*")
@RestResource
public interface RepoSocios extends CrudRepository<Roles,Integer> {
    
}
