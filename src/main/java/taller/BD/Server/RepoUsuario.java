package taller.BD.Server;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RestResource(path = "Users")
public interface RepoUsuario extends CrudRepository<Usuario,String> {

}