package Dao;

import entity.Project;

import java.util.List;

public interface ProjectDAO {

    void add(Project project);

    List<Project> getAll();

    Project getById(Long id);

    void update(Project project);

    void remove (Project project);
}
