package com.psu.ist412.team2.projectplannerwebsite.business.service;

import com.psu.ist412.team2.projectplannerwebsite.business.dto.request.domain.CustomerUserDetails;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.Task;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.TasksList;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository.CustomerRepository;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository.TaskRepository;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository.TasksListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTasksListInformationService {
    private final CustomerRepository customerRepository;
    private final TasksListRepository tasksListRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public AccountTasksListInformationService(CustomerRepository customerRepository, TasksListRepository tasksListRepository, TaskRepository taskRepository) {
        this.customerRepository = customerRepository;
        this.tasksListRepository = tasksListRepository;
        this.taskRepository = taskRepository;
    }

    public List<TasksList> getTasksLists() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        short customerId = this.customerRepository.getIdByEmail(((CustomerUserDetails) auth.getPrincipal()).getUsername());

        return this.tasksListRepository.getTasksListsByCustomerId(customerId);
    }

    public void addNewTasksList(String tasksListName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        short customerId = this.customerRepository.getIdByEmail(((CustomerUserDetails) auth.getPrincipal()).getUsername());

        TasksList tasksList = new TasksList(tasksListName, customerId, false);

        this.tasksListRepository.save(tasksList);
    }

    public void addNewTask(String tasksListName, String taskName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        short customerId = this.customerRepository.getIdByEmail(((CustomerUserDetails) auth.getPrincipal()).getUsername());

        TasksList tasksList = this.tasksListRepository.getTasksListByCustomerIdAndName(customerId, tasksListName);
        Task task = new Task(taskName, customerId, false, tasksList);

        this.taskRepository.save(task);
    }
}
