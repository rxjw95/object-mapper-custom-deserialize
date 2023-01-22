package com.tistory.rjvv.objmapper.exception;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tistory.rjvv.objmapper.custom.CustomErrorResponseDeserializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = CustomErrorResponseDeserializer.class)
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String code;

    public ErrorResponse(LocalDateTime timestamp, ErrorEnum error) {
        this.timestamp = timestamp;
        this.status = error.getStatus().value();
        this.error = error.getStatus().name();
        this.message = error.getMessage();
        this.code = error.name();
    }
}
