package com.example.oops;

public class Requirement {
    private Integer id;
    private String description;
    private User createdBy;
    private User assignedTo;
    private Integer planTime;
    private Float budget;
    private Boolean requiementStatus;

    public Requirement(Integer id, String description, User createdBy, User assignedTo, Integer planTime, Float budget, Boolean requiementStatus) {
        this.id = id;
        this.description = description;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.planTime = planTime;
        this.budget = budget;
        this.requiementStatus = requiementStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Integer getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Integer planTime) {
        this.planTime = planTime;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public Boolean isRequiementStatus() {
        return requiementStatus;
    }

    public void setRequiementStatus(Boolean requiementStatus) {
        this.requiementStatus = requiementStatus;
    }

}


