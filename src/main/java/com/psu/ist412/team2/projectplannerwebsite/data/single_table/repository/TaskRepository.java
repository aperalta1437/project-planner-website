package com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository;

import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Short> {
}
