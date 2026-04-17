package com.libbooks.library.controller;

import com.libbooks.library.model.entity.Role;
import com.libbooks.library.service.interfaceService.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {
    private final RoleService roleService;
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/role/{roleId}")
    public Optional<Role> getRoleById(@PathVariable Integer roleId){
        return this.roleService.getRoleById(roleId);
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return this.roleService.getRoles();
    }
    @PostMapping("/role")
    public void addRole(@RequestBody Role role){
        this.roleService.addRole(role);
    }

    @PutMapping("/role/{roleId}")
    public void updateRole(@PathVariable Integer roleId,@RequestBody Role role){
        this.roleService.updateRole(roleId,role);
    }

    @DeleteMapping("/role/{roleId}")
    public void deleteRole(@PathVariable Integer roleId){
        this.roleService.deleteRole(roleId);
    }
}