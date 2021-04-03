package com.example.demo.controller.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorDescription  implements Serializable {
    private static final long serialVersionUID = -5340902716834570084L;

    private String timestamp;
    private String code;
    private String path;
    private String detail;

    public ErrorDescription() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

