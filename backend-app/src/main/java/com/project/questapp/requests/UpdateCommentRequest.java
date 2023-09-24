package com.project.questapp.requests;

import lombok.Data;

@Data
public class UpdateCommentRequest {
    Long Id;
    String Text;

    public Long getId() {
        return Id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
