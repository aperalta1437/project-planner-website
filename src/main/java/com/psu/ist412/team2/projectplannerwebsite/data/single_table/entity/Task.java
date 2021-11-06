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
    @Column(name = "BACKLOG_ID")
    private short backlogId;
    @Column(name = "IS_DELETED")
    private boolean isDeleted;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    @Column(name = "MODIFIED_AT")
    private Date modifiedAt;

    public Task() {
    }

    public Task(String name, short customerId, short backlogId, boolean isDeleted) {
        this.name = name;
        this.customerId = customerId;
        this.backlogId = backlogId;
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

    public short getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(short backlogId) {
        this.backlogId = backlogId;
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
}

