package com.example.mis.repository;

import com.example.mis.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    boolean existsByGroupName(String groupName);

    List<Group> findByIsActiveTrue();
}