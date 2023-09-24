package com.project.questapp.requests;

import lombok.Data;

@Data

public class CreateLikeRequest {
    Long UserId;
    Long PostId;
    String Text;

    public Long getUserId() {
        return UserId;
    }
    public Long getPostId() {
        return PostId;
    }
}
