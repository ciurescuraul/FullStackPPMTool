package com.rsystems.ppmtool.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsystems.ppmtool.domain.Project;
import com.rsystems.ppmtool.services.MapValidationErrorService;
import com.rsystems.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController
{

  private final ProjectService            projectService;
  private final MapValidationErrorService errorService;

  public ProjectController(ProjectService projectService,
                           MapValidationErrorService errorService)
  {
    this.projectService = projectService;
    this.errorService = errorService;
  }

  @PostMapping("")
  public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,
                                            BindingResult result)
  {
    ResponseEntity<?> errorMap = errorService.mapValidationErrorService(result);

    if (errorMap != null)
    {
      return errorMap;
    }

    Project project1 = projectService.saveOrUpdateProject(project);

    return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
  }

  @GetMapping("/{projectId}")
  public ResponseEntity<?> getProjectById(@PathVariable String projectId)
  {
    Project project = projectService.findProjectByIdentifier(projectId);

    return new ResponseEntity<Project>(project, HttpStatus.OK);
  }

  @GetMapping("/all")
  public Iterable<Project> getAllProjects()
  {
    return projectService.findAllProjects();
  }

  @DeleteMapping("{projectId}")
  public ResponseEntity<?> deleteProject(@PathVariable String projectId)
  {
    projectService.deleteProjectByIdentifier(projectId);

    return new ResponseEntity<String>("Project with ID: '" + projectId + "' was deleted.", HttpStatus.OK);
  }
}
