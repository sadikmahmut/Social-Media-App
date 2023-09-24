package com.project.questapp.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="posts")
@Data
public class Post {
    @Id
    Long Id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;
    String Title;
    @Lob
    @Column(columnDefinition = "text")
    String Text;

    public Post(Long id, User user, String title, String text) {
        Id = id;
        this.user = user;
        Title = title;
        Text = text;
    }

    public Post(User user, String title, String text) {
        this.user = user;
        Title = title;
        Text = text;
    }

    public Post() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
