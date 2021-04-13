package com.rsystems.ppmtool.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsystems.ppmtool.domain.Project;
import com.rsystems.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController
{

  private ProjectService projectService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @PostMapping("")
  public ResponseEntity<Project> createNewProject(@RequestBody Project project)
  {
    return new ResponseEntity<Project>(projectService
        .saveOrUpdateProject(project), HttpStatus.CREATED);
  }
}
