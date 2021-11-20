package com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository;

import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksListRepository extends JpaRepository<TasksList, Short> {
    @Query(value = "SELECT TL1 FROM TasksList TL1 WHERE TL1.customerId = ?1")
    List<TasksList> getTasksListsByCustomerId(short customerId);

    @Query(value = "SELECT TL1 FROM TasksList TL1 WHERE TL1.customerId = ?1 AND TL1.name = ?2")
    TasksList getTasksListByCustomerIdAndName(short customerId, String tasksListName);
}
