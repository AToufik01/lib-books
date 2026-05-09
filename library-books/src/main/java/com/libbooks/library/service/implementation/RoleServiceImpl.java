package com.libbooks.library.service.implementation;

import com.libbooks.library.model.dto.RoleDTO;
import com.libbooks.library.model.entity.Role;
import com.libbooks.library.repository.RoleRepo;
import com.libbooks.library.service.interfaceService.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepo roleRepo, ModelMapper modelMapper){
        this.roleRepo = roleRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public RoleDTO getRoleById(Integer roleId){
        try {
            Role role = this.roleRepo.findById(roleId).orElseThrow(()-> new RuntimeException("role not Found"));
            return this.modelMapper.map(role,RoleDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<RoleDTO> getRoles(){
        try{
            return this.roleRepo.findAll().stream().map(role -> this.modelMapper.map(role,RoleDTO.class)).collect(Collectors.toList());
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public RoleDTO addRole(RoleDTO role){
        try {
            Role roleToAdd = this.modelMapper.map(role, Role.class);
            Role savedRole = this.roleRepo.save(roleToAdd);
            return this.modelMapper.map(savedRole, RoleDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public RoleDTO updateRole(Integer roleId,RoleDTO role){
        try {
            Role roleToUpdate = this.roleRepo.findById(roleId).orElseThrow(()-> new RuntimeException("role not Found"));
            this.modelMapper.map(role,roleToUpdate);
            roleToUpdate.setId(roleId);
            Role updatedRole = this.roleRepo.save(roleToUpdate);
            return this.modelMapper.map(updatedRole, RoleDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public  void deleteRole(Integer roleId){
        try{
            this.roleRepo.findById(roleId).orElseThrow(() -> new RuntimeException("role not Found"));
            this.roleRepo.deleteById(roleId);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
