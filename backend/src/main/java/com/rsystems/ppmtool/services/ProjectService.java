package com.rsystems.ppmtool.services;

import org.springframework.stereotype.Service;

import com.rsystems.ppmtool.domain.Project;
import com.rsystems.ppmtool.exceptions.ProjectIdException;
import com.rsystems.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService
{

  private final ProjectRepository projectRepository;

  public ProjectService(ProjectRepository projectRepository)
  {
    this.projectRepository = projectRepository;
  }

  public Project saveOrUpdateProject(Project project)
  {
    try
    {
      project
          .setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
      return projectRepository.save(project);
    }
    catch (Exception e)
    {
      throw new ProjectIdException("Project ID '" + project
          .getProjectIdentifier().toUpperCase() + "' already exists");
    }
  }

  public Project findProjectByIdentifier(String projectId)
  {
    Project project = projectRepository
        .findByProjectIdentifier(projectId.toUpperCase());

    if (project == null)
    {
      throw new ProjectIdException("Project ID '" + projectId +
                                   "' does not exist");
    }

    return project;
  }

  public Iterable<Project> findAllProjects()
  {
    return projectRepository.findAll();
  }

  public void deleteProjectByIdentifier(String projectId)
  {
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

    if (project == null)
    {
      throw new ProjectIdException("Cannot delete project with ID '" +
                                   projectId +
                                   "'. This project does not exist.");
    }

    projectRepository.delete(project);
  }
}
