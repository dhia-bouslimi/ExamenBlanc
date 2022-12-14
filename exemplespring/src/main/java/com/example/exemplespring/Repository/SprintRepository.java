package com.example.exemplespring.Repository;

import com.example.exemplespring.Entity.Project;
import com.example.exemplespring.Entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {


    List<Project> countByProjectId();


}
