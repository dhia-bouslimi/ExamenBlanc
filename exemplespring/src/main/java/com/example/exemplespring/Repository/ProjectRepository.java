package com.example.exemplespring.Repository;

import com.example.exemplespring.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByProjectsIdAndUserFNameIName(int projectId, String firstName,String lastName);
}
