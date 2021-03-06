import React from "react";
import { Link } from "react-router-dom";

const ProjectItem = () => {
  return (
    <div className="container">
      <div className="card card-body mb-3">
        <div className="row">
          <div className="col-2">
            <span className="mx-auto">REACT</span>
          </div>
          <div className="col-lg-6 col-md-4 col-8">
            <h3>Spring / React Project</h3>
            <p>Project to create a Kanban Board with Spring Boot and React</p>
          </div>
          <div className="col-md-4 d-none d-lg-block">
            <ul className="list-group">
              <Link to="#">
                <li className="list-group-item board">
                  <i className="fas fa-clipboard-list px-3 fa-1x"></i>
                  Project Board
                </li>
              </Link>
              <Link to="#">
                <li className="list-group-item update">
                  <i className="fa fa-edit px-3 fa-1x"></i>
                  Update Project Info
                </li>
              </Link>
              <Link to="">
                <li className="list-group-item delete">
                  <i className="fa fa-minus-circle px-3 fa-1x"></i>
                  Delete Project
                </li>
              </Link>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProjectItem;
