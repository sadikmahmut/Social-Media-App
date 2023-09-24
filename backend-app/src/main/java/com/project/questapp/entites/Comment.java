package com.project.questapp.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="comments")
@Data
public class Comment {
    @Id
    Long Id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PostId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;
    @Lob
    @Column(columnDefinition = "text")
    String Text;

    public Comment(Post post, User user, String text) {
        this.post = post;
        this.user = user;
        Text = text;
    }

    public void setText(String text) {
        Text = text;
    }
}
