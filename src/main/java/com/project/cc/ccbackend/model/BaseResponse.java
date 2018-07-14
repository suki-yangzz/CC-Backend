package com.project.cc.ccbackend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter @Setter
public class BaseResponse implements Serializable {

    private String message;
    private Integer code;
    private Object result;
}
