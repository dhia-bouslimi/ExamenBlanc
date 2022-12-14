package com.example.exemplespring.Controller;

import com.example.exemplespring.Entity.Project;
import com.example.exemplespring.Entity.Sprint;
import com.example.exemplespring.Entity.User;
import com.example.exemplespring.Repository.ProjectRepository;
import com.example.exemplespring.Repository.SprintRepository;
import com.example.exemplespring.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Slf4j

@RestController
@RequestMapping("/exam")
//@AllArgsConstructor
public class ExamenRestController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    SprintRepository sprintRepository;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);

    }


    @PostMapping("/addProject")
    public Project addProject(@RequestBody Project project){
        return projectRepository.save(project);

    }


    @GetMapping("/affecterUtilisateurClasse/{projectId}/{userId}")
    public void assignProjectToUser(@PathVariable int projectId, @PathVariable Integer userId ) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

     user.getProjects().add(project);
     projectRepository.save(project);

    }





    @GetMapping("/assignProjectToClient/{projectId}/{firstName}/{lastName}")
    public void assignProjectToClient(@PathVariable int projectId, @PathVariable String firstName, @PathVariable String lastName ){
        Project p = projectRepository.findById(projectId).orElse(null);
        User u= userRepository.findByFNameAndLName(firstName,lastName);
        if(u!=null && p!=null){
            u.getProjects().add(p);
            userRepository.save(u);
        }
    }



    public List<Project> getAllCurrentProject(){
        List<Sprint> sprints = sprintRepository.findAll();

       // List<Project> projects = projectRepository.findAll();
        for (Sprint sprint : sprints) {
            if(sprint.getStartDate().after(new Date())){
              log.info("la date" + sprint.getStartDate() + "> date daujourdh'ui"  );
            }
        }
        return projectRepository.findAll();
    }






    @Scheduled(cron = "*/30 * * * * * ")
    public List<Project> getNbrSprintByCurrentProject(){
        List<Sprint> sprints = sprintRepository.findAll();
        for (Sprint sprint : sprints) {
            if(sprint.getStartDate().after(new Date())){

            }
        }
        return sprintRepository.countByProjectId();
    }




    @PostMapping("/addSprintAndAssignToProject/{idProject}")
    public void addSprintAndAssignToProject (@RequestBody Sprint sprint, @PathVariable int idProject){
        Project project = projectRepository.findById(idProject).orElse(null);
        sprint.setProject(project);
        sprintRepository.save(sprint);
    }













}
