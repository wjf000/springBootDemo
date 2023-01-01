package com.wjf.demo.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class HttpResponse implements Serializable {
    private Integer code;
    private String message;
    private Object data;
}
