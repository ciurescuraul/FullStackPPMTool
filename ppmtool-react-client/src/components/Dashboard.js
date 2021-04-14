import React from "react";
import ProjectItem from "./Project/ProjectItem";

const Dashboard = () => {
  return (
    <div>
      <h1 className="alert alert-warning">Welcome to the Dashboar</h1>
      <ProjectItem />
      <ProjectItem />
      <ProjectItem />
    </div>
  );
};

export default Dashboard;
