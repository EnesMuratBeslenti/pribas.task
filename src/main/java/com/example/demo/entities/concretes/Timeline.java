package com.example.demo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeLineId;
    @NotNull
    @Size(min = 5, max = 50, message = "Lütfen en az 5 en fazla 50 karakter giriniz")
    private String title;
    @NotNull
    @Size(min = 5, max = 150, message = "Lütfen en az 5 en fazla 150 karakter giriniz")
    private String description;
    private LocalDate localDate;

    private String tags;
    public Timeline() {
    }


    public Timeline(Long timeLineId, String title, String description, LocalDate localDate, String tags, User user) {
        this.timeLineId = timeLineId;
        this.title = title;
        this.description = description;
        this.localDate = localDate;
        this.tags = tags;
        this.user = user;
    }

    public Timeline(String title, String description, LocalDate localDate, String tags, User user) {
        this.title = title;
        this.description = description;
        this.localDate = localDate;
        this.tags = tags;
        this.user = user;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getTimeLineId() {
        return timeLineId;
    }

    public void setTimeLineId(Long timeLineId) {
        this.timeLineId = timeLineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
