package com.nsk.musiclib.controller.model.response;

public class MessageResponse extends BaseResponse{
    private String message;

    public MessageResponse() {
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(int statuscode, String message) {
        super(statuscode,statuscode);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageResponse message(String message) {
        setMessage(message);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            "}";
    }

    
}
