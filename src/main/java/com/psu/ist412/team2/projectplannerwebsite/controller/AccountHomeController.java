package com.psu.ist412.team2.projectplannerwebsite.controller;

import com.psu.ist412.team2.projectplannerwebsite.business.service.AccountTasksListInformationService;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.TasksList;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountHomeController {

    private final AccountTasksListInformationService accountTasksListInformationService;

    @Autowired
    public AccountHomeController(AccountTasksListInformationService accountTasksListInformationService) {
        this.accountTasksListInformationService = accountTasksListInformationService;
    }

    @GetMapping
    public String getAccountMainPage(Model model) {
        List<TasksList> tasksLists = this.accountTasksListInformationService.getTasksLists();

        model.addAttribute("tasksLists", tasksLists);
        return "account-home";
    }

    @PostMapping(value = "/add-new-tasks-list/{tasks-list-name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> addNewTasksList(@PathVariable(value = "tasks-list-name") String tasksListName) throws JSONException {
        JSONObject jsonResponse = new JSONObject();
        try {
            this.accountTasksListInformationService.addNewTasksList(tasksListName);
        } catch (Exception exception) {
            jsonResponse.put("Message", "An issue happened at the server. Please try again later. If the issue persist, please contact your system administrator");

            exception.printStackTrace();

            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
    }

    @PostMapping(value = "/add-new-task/tasks-list/{tasks-list-name}/task/{task-name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> addNewTask(@PathVariable(value = "tasks-list-name") String tasksListName, @PathVariable(value = "task-name") String taskName) throws JSONException {
        JSONObject jsonResponse = new JSONObject();
        try {
            this.accountTasksListInformationService.addNewTask(tasksListName, taskName);
        } catch (Exception exception) {
            jsonResponse.put("Message", "An issue happened at the server. Please try again later. If the issue persist, please contact your system administrator");

            exception.printStackTrace();

            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
    }
}
