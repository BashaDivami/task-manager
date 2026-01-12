package com.divami.task_manager.service;

import com.divami.task_manager.entity.Project;
import com.divami.task_manager.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    // to fetch all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    
    public Project getProjectById(UUID projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found with id: " + projectId)
                );
    }
    
    // create project
    public Project createProject(Project project) {
        
        return projectRepository.save(project);
    }
    
    
    // update project
    public Project updateProject(UUID id, Project updatedProject) {
        Project existing = getProjectById(id);
        existing.setName(updatedProject.getName());
        existing.setDescription(updatedProject.getDescription());
        existing.setUser(updatedProject.getUser()); 
        return projectRepository.save(existing);
    }
     
	// delete project
    public void deleteProject(UUID projectId) {
        projectRepository.deleteById(projectId);
    }
}
