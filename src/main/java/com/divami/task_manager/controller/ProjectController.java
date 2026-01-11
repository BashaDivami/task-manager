package com.divami.task_manager.controller;

import com.divami.task_manager.entity.Project;
import com.divami.task_manager.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

 
    @GetMapping
    public Object getProjects(
            @RequestParam(value = "id", required = false) UUID projectId
    ) {
        if (projectId != null) {
            return projectService.getProjectById(projectId);
        }
        return projectService.getAllProjects();
    }


    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable UUID id,
            @RequestBody Project project
    ) {
        return projectService.updateProject(id, project);
    }

    
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
    }
}
