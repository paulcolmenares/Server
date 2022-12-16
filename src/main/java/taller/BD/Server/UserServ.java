package taller.BD.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServ implements UserDetailsService {
    @Autowired
    private RepoUsuarios users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usr = users.findById(username);
        System.out.println(usr.get().getRoles().toString());
        List<GrantedAuthority> roles = new ArrayList<>();
        Object[] lista = usr.get().getRoles().toArray();
        for(int i=0;i<lista.length;i++) {
              // Agregar los Roles de la BD
            String temp_r = ((Roles) lista[i]).getCodigo();
            System.out.println(temp_r);
            roles.add(new SimpleGrantedAuthority("ROLE_"+temp_r));
        }
         
        UserDetails userDet = new User (usr.get().getUsr(), usr.get().getClave(),roles);
        return userDet;  
    }
}
