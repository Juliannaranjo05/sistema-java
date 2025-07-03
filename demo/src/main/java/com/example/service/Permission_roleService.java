package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import com.example.repository.Ipage;
import com.example.repository.Ipermission_role;
import com.example.repository.Irole;
import com.example.DTO.ResponsesDTO;
import com.example.model.permission_roles;
import com.example.DTO.Permission_RoleDTO;
import com.example.model.pages;
import com.example.model.role;
import java.util.List;
import java.util.Optional;


@Service
public class Permission_roleService {
    @Autowired
    private Ipermission_role data;

    @Autowired
    private Irole roleRepository;

    @Autowired
    private Ipage pageRepository;

    public List<permission_roles> findAll() {
        return data.findAll();
    }

    public Optional<permission_roles> findById(int id) {
        return data.findById(id);
    }

    public ResponsesDTO deletePermissionRole(int id) {
        Optional<permission_roles> permissionRole = findById(id);
        if (!permissionRole.isPresent()) {
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "El permiso de rol no existe");
        }

        data.deleteById(id);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Permiso de rol eliminado correctamente");
    }

    public ResponsesDTO save(Permission_RoleDTO permissionRoleDTO) {
        permission_roles permissionRole = convertToModel(permissionRoleDTO);
        data.save(permissionRole);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Permiso de rol guardado correctamente");
    }

    public ResponsesDTO updatePermissionRole(int id, Permission_RoleDTO permissionRoleDTO) {
        Optional<permission_roles> permissionRole = findById(id);
        if (!permissionRole.isPresent()) {
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "El permiso de rol no existe");
        }

        permission_roles updatedPermissionRole = permissionRole.get();
        updatedPermissionRole.setPage(permissionRoleDTO.getPage());
        updatedPermissionRole.setRole(permissionRoleDTO.getRole());
        updatedPermissionRole.setType(permissionRoleDTO.getType());

        data.save(updatedPermissionRole);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Permiso de rol actualizado correctamente");
    }

    public Permission_RoleDTO convertToDTO(permission_roles permissionRole) {
        Permission_RoleDTO dto = new Permission_RoleDTO();
        dto.setPermission_roleid(permissionRole.getPermission_roleid());
        dto.setPage(permissionRole.getPage());
        dto.setRole(permissionRole.getRole());
        dto.setType(permissionRole.getType());
        return dto;
    }

    public permission_roles convertToModel(Permission_RoleDTO permissionRoleDTO) {
        pages page = pageRepository.findById(permissionRoleDTO.getPage().getPageid())
                .orElseThrow(() -> new RuntimeException("Page not found"));
        role role = roleRepository.findById(permissionRoleDTO.getRole().getRoleid())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return new permission_roles(
            permissionRoleDTO.getPermission_roleid(),
            page,
            role,
            permissionRoleDTO.getType()
        );
       
    }

}
