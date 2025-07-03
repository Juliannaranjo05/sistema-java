package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.DTO.ResponsesDTO;
import com.example.DTO.RoleDTO;
import com.example.model.role;
import com.example.repository.Irole;

@Service
public class RoleService {

     @Autowired
    private Irole data;

    public List<role> findAll() {
        return data.findAll();
    }

    public Optional<role> findById(int id) {
        return data.findById(id);
    }

    public ResponsesDTO deleteRole(int id) {
        Optional<role> roleOpt = findById(id);
        if (!roleOpt.isPresent()) {
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "El rol no existe");
        }
        data.deleteById(id);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Rol eliminado correctamente");
    }

    public ResponsesDTO save(RoleDTO roleDTO) {
        role rol = convertToModel(roleDTO);
        data.save(rol);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Rol guardado correctamente");
    }

    public ResponsesDTO updateRole(int id, RoleDTO roleDTO) {
        Optional<role> roleOpt = findById(id);
        if (!roleOpt.isPresent()) {
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "El rol no existe");
        }
        role updatedRole = roleOpt.get();
        updatedRole.setName(roleDTO.getName());
        updatedRole.setDescription(roleDTO.getDescription());

        data.save(updatedRole);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Rol actualizado correctamente");
    }

    public RoleDTO convertToDTO(role rol) {
        return new RoleDTO(
            rol.getRoleid(),
            rol.getName(),
            rol.getDescription()
        );
    }

    public role convertToModel(RoleDTO roleDTO) {
        return new role(
            0, // Nuevo rol, id generado por BD
            roleDTO.getName(),
            roleDTO.getDescription(), 
            null
        );
    }
}
