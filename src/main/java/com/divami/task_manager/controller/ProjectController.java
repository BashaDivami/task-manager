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

    /**
     * 1️⃣ GET projects
     * - /api/projects           → fetch all projects
     * - /api/projects?id=UUID   → fetch project by id
     */
    @GetMapping
    public Object getProjects(
            @RequestParam(value = "id", required = false) UUID projectId
    ) {
        if (projectId != null) {
            return projectService.getProjectById(projectId);
        }
        return projectService.getAllProjects();
    }

    /**
     * 2️⃣ UPDATE project
     * - PUT /api/projects/{id}
     */
    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable UUID id,
            @RequestBody Project project
    ) {
        return projectService.updateProject(id, project);
    }

    /**
     * 3️⃣ DELETE project
     * - DELETE /api/projects/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
    }
}
