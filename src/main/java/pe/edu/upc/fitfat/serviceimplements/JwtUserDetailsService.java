package pe.edu.upc.fitfat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.fitfat.entities.Usuarios;
import pe.edu.upc.fitfat.repositories.IUsuariosRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuariosRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = repo.findOneByUsuario(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists with username: %s", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        // Si la lista de roles no es nula, asigna los roles a la lista de GrantedAuthority
        if (user.getRoles() != null) {
            user.getRoles().forEach(rol -> {
                roles.add(new SimpleGrantedAuthority(rol.getDescripcion()));
            });
        }

        UserDetails ud = new org.springframework.security.core.userdetails.User(
                user.getUsuario(),
                user.getContrasena(),
                user.getEnabled(),
                true,
                true,
                true,
                roles
        );

        return ud;
    }
}
