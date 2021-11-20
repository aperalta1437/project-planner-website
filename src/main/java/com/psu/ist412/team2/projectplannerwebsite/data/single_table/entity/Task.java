package com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CUSTOMER_ID")
    private short customerId;
    @Column(name = "IS_DELETED")
    private boolean isDeleted;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    @Column(name = "MODIFIED_AT")
    private Date modifiedAt;

    @ManyToOne
    @JoinColumn(name = "TASKS_LIST_ID", nullable = false)
    private TasksList tasksList;

    public Task() {
    }

    public Task(String name, short customerId, boolean isDeleted, TasksList tasksList) {
        this.name = name;
        this.customerId = customerId;
        this.isDeleted = isDeleted;
        this.tasksList = tasksList;
    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public TasksList getTasksList() {
        return tasksList;
    }

    public void setTasksList(TasksList tasksList) {
        this.tasksList = tasksList;
    }
}

