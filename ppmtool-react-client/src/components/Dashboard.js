import React from "react";
import ProjectItem from "./Project/ProjectItem";

const Dashboard = () => {
  return (
    <div className="projects">
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <h4 className="display-4 text-center">List of Projects</h4>
            <br />
            <a href="ProjectForm.html" className="btn btn-lg btn-info">
              Create a Project
            </a>
            <br />
            <hr />
            <ProjectItem />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
