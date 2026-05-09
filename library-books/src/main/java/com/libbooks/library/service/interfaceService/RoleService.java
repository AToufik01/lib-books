package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.dto.RoleDTO;
import com.libbooks.library.model.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    RoleDTO getRoleById(Integer roleId);
    List<RoleDTO> getRoles();
    RoleDTO addRole(RoleDTO role);
    RoleDTO updateRole(Integer roleId,RoleDTO role);
    void deleteRole(Integer roleId);
}
