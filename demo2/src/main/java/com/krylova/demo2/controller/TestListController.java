package com.krylova.demo2.controller;

import com.krylova.demo2.exception.ResourceNotFoundException;
import com.krylova.demo2.model.TestList;
import com.krylova.demo2.repository.SubjectRepository;
import com.krylova.demo2.repository.UserRepository;
import com.krylova.demo2.repository.TestListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class TestListController {
    @Autowired
    private TestListRepository testListRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/users/{userId}/testLists")
    public List<TestList> getTestListsByUserId(@PathVariable Long userId) {
        return testListRepository.findByUserId(userId);
    }
    @GetMapping("/subjects/{subjectId}/testLists")
    public List<TestList> getTestListsBySubjectId(@PathVariable Long subjectId) {
        return testListRepository.findBySubjectId(subjectId);
    }

    @PostMapping("/users/{userId}/testLists")
    public TestList addTestListByUserId(@PathVariable Long userId, @Valid @RequestBody TestList testList) {
        return userRepository.findById(userId)
                .map(user -> {
                    testList.setUser(user);
                    return testListRepository.save(testList);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with Id " + userId));
    }

    @PostMapping("/subjects/{subjectId}/testLists")
    public TestList addTestListBySubjectId(@PathVariable Long subjectId, @Valid @RequestBody TestList testList) {
        return subjectRepository.findById(subjectId)
                .map(subject -> {
                    testList.setSubject(subject);
                    return testListRepository.save(testList);
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with Id " + subjectId));
    }

    @PutMapping("/users/{userId}/testLists/{testListId}")
    public TestList updateTestListByUserId(@PathVariable Long userId,
                                   @PathVariable Long testListId,
                                   @Valid @RequestBody TestList testListRequest) {
        if(!userRepository.existsById(userId)){
            throw new ResourceNotFoundException("User not found with Id " + userId);
        }
        return testListRepository.findById(testListId)
                .map(testList -> {
                    testList.setFirst_name(testListRequest.getFirst_name());
                    testList.setLast_name(testListRequest.getLast_name());
                    testList.setMiddle_name(testListRequest.getMiddle_name());
                    testList.setLogin(testListRequest.getLogin());
                    testList.setPassword_hash(testListRequest.getPassword_hash());
                    testList.setUser(testListRequest.getUser());
                    testList.setSubject(testListRequest.getSubject());
                    return testListRepository.save(testList);
                }).orElseThrow(() -> new ResourceNotFoundException("TestList not found with Id " + testListId));
    }

    @PutMapping("/subjects/{subjectId}/testLists/{testListId}")
    public TestList updateTestListBySubjectId(@PathVariable Long subjectId,
                                    @PathVariable Long testListId,
                                    @Valid @RequestBody TestList testListRequest) {
        if(!subjectRepository.existsById(subjectId)){
            throw new ResourceNotFoundException("Subject not found with Id " + subjectId);
        }
        return testListRepository.findById(testListId)
                .map(testList -> {
                    testList.setFirst_name(testListRequest.getFirst_name());
                    testList.setLast_name(testListRequest.getLast_name());
                    testList.setMiddle_name(testListRequest.getMiddle_name());
                    testList.setLogin(testListRequest.getLogin());
                    testList.setPassword_hash(testListRequest.getPassword_hash());
                    testList.setUser(testListRequest.getUser());
                    testList.setSubject(testListRequest.getSubject());
                    return testListRepository.save(testList);
                }).orElseThrow(() -> new ResourceNotFoundException("TestList not found with Id " + testListId));
    }

    @DeleteMapping("/users/{userId}/testLists/{testListId}")
    public ResponseEntity<?> deleteTestListByUserId(@PathVariable Long userId,
                                                @PathVariable Long testListId) {
        if(!userRepository.existsById(userId)){
            throw new ResourceNotFoundException("User not found with Id " + userId);
        }
        return testListRepository.findById(testListId)
                .map(testList -> {
                    testListRepository.delete(testList);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("TestList not found with Id " + testListId));
    }

    @DeleteMapping("/subjects/{subjectId}/testLists/{testListId}")
    public ResponseEntity<?> deleteTestListSubjectId(@PathVariable Long subjectId,
                                               @PathVariable Long testListId) {
        if(!subjectRepository.existsById(subjectId)){
            throw new ResourceNotFoundException("Subject not found with Id " + subjectId);
        }
        return testListRepository.findById(testListId)
                .map(testList -> {
                    testListRepository.delete(testList);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("TestList not found with Id " + testListId));
    }
}
