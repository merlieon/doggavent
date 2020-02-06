package com.example.doggamore.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event<U> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "event_title")
    String eventTitle;

    @Column(name = "event_content")
    String eventContent;

    @Column(name = "created_date")
            @CreatedDate
    Date createdDate;

    @Column(name = "created_by")
            @CreatedBy
    U createdBy;

    @Column(name = "updated_date")
            @LastModifiedDate
    Date updatedDate;

    @Column(name = "updated_by")
            @LastModifiedBy
    U updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public U getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(U updatedBy) {
        this.updatedBy = updatedBy;
    }
}
