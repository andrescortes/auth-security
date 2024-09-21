package com.app.auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class ApiError implements Serializable {

    private String internalMessage;
    private String message;
    private int httpCode;
    private LocalDateTime time;

}
