package com.rsystems.ppmtool.services;

import org.springframework.stereotype.Service;

import com.rsystems.ppmtool.domain.Project;
import com.rsystems.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService
{

  private final ProjectRepository projectRepository;

  public ProjectService(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  public Project saveOrUpdateProject(Project project)
  {
    // Logic

    return projectRepository.save(project);
  }
}
