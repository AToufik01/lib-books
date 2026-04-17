package com.libbooks.library.service.implementation;

import com.libbooks.library.model.entity.Role;
import com.libbooks.library.repository.RoleRepo;
import com.libbooks.library.service.interfaceService.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }
    @Override
    public Optional<Role> getRoleById(Integer roleId){
        return this.roleRepo.findById(roleId);
    }

    @Override
    public List<Role> getRoles(){
        return this.roleRepo.findAll();
    }

    @Override
    public void addRole(Role role){
        this.roleRepo.save(role);
    }

    @Override
    public void updateRole(Integer roleId,Role role){
        Role roleToUpdate = this.roleRepo.findById(roleId).orElseThrow(()-> new RuntimeException("role not Found"));
        roleToUpdate.setName(role.getName());
        this.roleRepo.save(roleToUpdate);
    }

    @Override
    public  void deleteRole(Integer roleId){
        this.roleRepo.deleteById(roleId);
    }
}
