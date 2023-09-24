package com.project.questapp.requests;

import lombok.Data;

@Data
public class UpdatePostRequest {
    Long Id;
    String Text;
    String Title;


    public Long getId() {
        return Id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
