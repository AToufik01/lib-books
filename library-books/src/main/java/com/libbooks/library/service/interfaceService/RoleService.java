package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public Optional<Role> getRoleById(Integer roleId);
    public List<Role> getRoles();
    public void addRole(Role role);
    public void updateRole(Integer roleId,Role role);
    public void deleteRole(Integer roleId);
}
