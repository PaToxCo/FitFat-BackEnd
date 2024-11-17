package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.DuracionTotalDietasDTO;
import pe.edu.upc.fitfat.dtos.RolDTO;
import pe.edu.upc.fitfat.dtos.RolesActivosDTO;
import pe.edu.upc.fitfat.entities.Rol;
import pe.edu.upc.fitfat.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")

public class RolController {

    @Autowired
    private IRolService rS;

    @GetMapping
    public List<RolDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rS.insert(rol);
    }

    @GetMapping("/{id}")

    public RolDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(rS.listId(id), RolDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rS.update(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }

    @GetMapping("/activerol")
    public List<RolesActivosDTO> rolesactivos() {
        List<String[]> listarolesactivos = rS.listarolesactivos();
        return listarolesactivos.stream().map(y -> {
            RolesActivosDTO dto = new RolesActivosDTO();
            dto.setDescripcion(y[0]);
            dto.setIdRol(Integer.parseInt(y[1]));
            return dto;
        }).collect(Collectors.toList());
    }
}
