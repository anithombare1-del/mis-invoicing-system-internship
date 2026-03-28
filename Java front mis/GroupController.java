package com.example.mis.controller;

import com.example.mis.entity.Group;
import com.example.mis.repository.GroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    // Add Group
    @PostMapping("/add")
    public String addGroup(@RequestBody Group group) {

        if (group.getGroupName() == null || group.getGroupName().isEmpty()) {
            return "Group name cannot be empty";
        }

        if (groupRepository.existsByGroupName(group.getGroupName())) {
            return "Group already exists";
        }

        groupRepository.save(group);
        return "Group added successfully";
    }

    // View Active Groups
    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findByIsActiveTrue();
    }
}