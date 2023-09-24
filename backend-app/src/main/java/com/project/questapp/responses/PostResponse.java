package com.project.questapp.responses;

import lombok.Data;

@Data
public class PostResponse {
    Long Id;
    Long UserId;
    String UserName;
    String Title;
    String Text;
}
