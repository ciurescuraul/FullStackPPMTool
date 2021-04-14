import React from "react";
import CreateProjectButton from "./Project/CreateProjectButton";
import ProjectItem from "./Project/ProjectItem";

const Dashboard = () => {
  return (
    <div className="projects">
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <h4 className="display-4 text-center">List of Projects</h4>
            <br />
            <CreateProjectButton/>
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
