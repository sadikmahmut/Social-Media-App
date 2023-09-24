package com.project.questapp.requests;

import lombok.Data;

@Data
public class CreateCommentRequest {
    Long UserId;
    Long PostId;
    String Text;

    public Long getUserId() {
        return UserId;
    }
    public Long getPostId() {
        return PostId;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
