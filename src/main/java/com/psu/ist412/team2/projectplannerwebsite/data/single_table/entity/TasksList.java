package com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "TASKS_LIST")
public class TasksList {
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

    @OneToMany(mappedBy = "tasksList", fetch = FetchType.EAGER)
    private List<Task> tasks;

    public TasksList() {
    }

    public TasksList(String name, short customerId, boolean isDeleted) {
        this.name = name;
        this.customerId = customerId;
        this.isDeleted = isDeleted;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

