package com.krylova.demo2.controller;

import com.krylova.demo2.exception.ResourceNotFoundException;
import com.krylova.demo2.model.Question;
import com.krylova.demo2.model.User;
import com.krylova.demo2.repository.GroupRepository;
import com.krylova.demo2.repository.RoleRepository;
import com.krylova.demo2.repository.UserRepository;
import com.krylova.demo2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("users")
    public List<User> getUsersByRoleId(@PathVariable Long roleId) {
        return userRepository.findByRoleId(roleId);
    }
    @GetMapping
    public List<User> getUsersByGroupId(@PathVariable Long groupId) {
        return userRepository.findByGroupId(groupId);
    }

    @PostMapping("/roles/{roleId}/users")
    @PostMapping("/groups/{groupId}/users")
    public User addUserByRoleId(@PathVariable Long roleId, @Valid @RequestBody User user) {
        return roleRepository.findById(roleId)
                .map(role -> {
                    user.setRole(role);
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("Role not found with Id " + roleId));
    }

    @PostMapping("/groups/{groupId}/users")
    public User addUserByGroupId(@PathVariable Long groupId, @Valid @RequestBody User user) {
        return groupRepository.findById(groupId)
                .map(group -> {
                    user.setGroup(group);
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("Group not found with Id " + groupId));
    }

    @PutMapping("/roles/{roleId}/users/{userId}")
    public User updateUserByRoleId(@PathVariable Long roleId,
                               @PathVariable Long userId,
                               @Valid @RequestBody User userRequest) {
        if(!roleRepository.existsById(roleId)){
            throw new ResourceNotFoundException("Role not found with Id " + roleId);
        }
        return userRepository.findById(userId)
                .map(user -> {
                    user.setFirst_name(userRequest.getFirst_name());
                    user.setLast_name(userRequest.getLast_name());
                    user.setMiddle_name(userRequest.getMiddle_name());
                    user.setLogin(userRequest.getLogin());
                    user.setPassword_hash(userRequest.getPassword_hash());
                    user.setRole(userRequest.getRole());
                    user.setGroup(userRequest.getGroup());
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with Id " + userId));
    }

    @PutMapping("/groups/{groupId}/users/{userId}")
    public User updateUserByGroupId(@PathVariable Long groupId,
                           @PathVariable Long userId,
                           @Valid @RequestBody User userRequest) {
        if(!groupRepository.existsById(groupId)){
            throw new ResourceNotFoundException("Group not found with Id " + groupId);
        }
        return userRepository.findById(userId)
                .map(user -> {
                    user.setFirst_name(userRequest.getFirst_name());
                    user.setLast_name(userRequest.getLast_name());
                    user.setMiddle_name(userRequest.getMiddle_name());
                    user.setLogin(userRequest.getLogin());
                    user.setPassword_hash(userRequest.getPassword_hash());
                    user.setRole(userRequest.getRole());
                    user.setGroup(userRequest.getGroup());
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with Id " + userId));
    }

    @DeleteMapping("/roles/{roleId}/users/{userId}")
    public ResponseEntity<?> deleteUserByRoleId(@PathVariable Long roleId,
                                          @PathVariable Long userId) {
        if(!roleRepository.existsById(roleId)){
            throw new ResourceNotFoundException("Role not found with Id " + roleId);
        }
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with Id " + userId));
    }

    @DeleteMapping("/groups/{groupId}/users/{userId}")
    public ResponseEntity<?> deleteUserGroupId(@PathVariable Long groupId,
                                        @PathVariable Long userId) {
        if(!groupRepository.existsById(groupId)){
            throw new ResourceNotFoundException("Group not found with Id " + groupId);
        }
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with Id " + userId));
    }
}
