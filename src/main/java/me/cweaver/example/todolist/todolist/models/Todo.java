package me.cweaver.example.todolist.todolist.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String todo;

    @Column(nullable = false)
    private String assignee;
    private boolean isDone;

    @CreationTimestamp
    private LocalDateTime createDts;

    @UpdateTimestamp
    private LocalDateTime updateDts;

    private LocalDateTime dueDts;

    public Todo() {
    }

    public Todo(int id, String todo, String assignee, boolean isDone, LocalDateTime createDts, LocalDateTime updateDts,
            LocalDateTime dueDts) {
        this.id = id;
        this.todo = todo;
        this.assignee = assignee;
        this.isDone = isDone;
        this.createDts = createDts;
        this.updateDts = updateDts;
        this.dueDts = dueDts;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return this.todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public boolean isIsDone() {
        return this.isDone;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public LocalDateTime getCreateDts() {
        return this.createDts;
    }

    public void setCreateDts(LocalDateTime createDts) {
        this.createDts = createDts;
    }

    public LocalDateTime getUpdateDts() {
        return this.updateDts;
    }

    public void setUpdateDts(LocalDateTime updateDts) {
        this.updateDts = updateDts;
    }

    public LocalDateTime getDueDts() {
        return this.dueDts;
    }

    public void setDueDts(LocalDateTime dueDts) {
        this.dueDts = dueDts;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", todo='" + getTodo() + "'" +
                ", assignee='" + getAssignee() + "'" +
                ", isDone='" + isIsDone() + "'" +
                ", createDts='" + getCreateDts() + "'" +
                ", updateDts='" + getUpdateDts() + "'" +
                ", dueDts='" + getDueDts() + "'" +
                "}";
    }
}
