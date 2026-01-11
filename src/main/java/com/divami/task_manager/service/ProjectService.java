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

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(UUID projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found with id: " + projectId)
                );
    }

    public Project updateProject(UUID projectId, ProjectUpdateRequest request) {
        Project project = getProjectById(projectId);

        if (request.name() != null)
            project.setName(request.name());

        if (request.description() != null)
            project.setDescription(request.description());

//        if (request.userId() != null) {
//            User user = userRepository.findById(request.userId())
//                    .orElseThrow(() -> new RuntimeException("User not found"));
//            project.setUser(user);
//        }

        return projectRepository.save(project);
    }


    public void deleteProject(UUID projectId) {
        projectRepository.deleteById(projectId);
    }
}
