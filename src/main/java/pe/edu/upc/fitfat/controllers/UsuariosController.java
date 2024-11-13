package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.ContarUsuariosActivosInactivosDTO;
import pe.edu.upc.fitfat.dtos.Tipo_comidaDTO;
import pe.edu.upc.fitfat.dtos.UsuariosDTO;
import pe.edu.upc.fitfat.dtos.UsuariosPorRolDTO;
import pe.edu.upc.fitfat.entities.Tipo_comida;
import pe.edu.upc.fitfat.entities.Usuarios;
import pe.edu.upc.fitfat.serviceinterfaces.IUsuariosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@PreAuthorize("hasAuthority('ADMIN')")
public class UsuariosController {

    @Autowired
    private IUsuariosService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<UsuariosDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuariosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuarios usuario = m.map(dto, Usuarios.class);
        String encodedPassword = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(encodedPassword);
        uS.insert(usuario);
    }

    @GetMapping("/{id}")
    public UsuariosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(uS.listId(id), UsuariosDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody UsuariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuarios usuario = m.map(dto, Usuarios.class);
        uS.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }

    @GetMapping("/buscarxcorreo")
    public List<UsuariosDTO> buscarxcorreo(@RequestParam String email) {
        return uS.buscarxcorreo(email).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuariosDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarxusuario")
    public UsuariosDTO buscarxusuario(@RequestParam String usuario) {
        ModelMapper m = new ModelMapper();
        Usuarios usuarioEntity = uS.findOneByUsuario(usuario);
        return m.map(usuarioEntity, UsuariosDTO.class);
    }
    @GetMapping("/contar-usuarios")
    public List<ContarUsuariosActivosInactivosDTO> contarUsuariosActivosInactivos() {
        return uS.contarUsuariosActivosInactivos().stream().map(arr -> {
            return new ContarUsuariosActivosInactivosDTO(arr[0], Long.valueOf(arr[1]));
        }).collect(Collectors.toList());
    }
    @GetMapping("/usuarios-por-rol")
    public List<UsuariosPorRolDTO> obtenerUsuariosPorRol() {
        return uS.obtenerUsuariosPorRol();
    }
}
