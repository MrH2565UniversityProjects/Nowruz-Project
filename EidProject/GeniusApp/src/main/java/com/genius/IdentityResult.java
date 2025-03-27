package com.genius;

public class IdentityResult {
    private final boolean success;
    private final String message;

    public IdentityResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public static IdentityResult CreateSuccessResult(){
        return new IdentityResult(true,"");
    }
    public static IdentityResult CreateSuccessResult(String message){
        return new IdentityResult(true,message);
    }
    public static IdentityResult CreateFailedResult(String message){
        return new IdentityResult(false,message);
    }
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public static IdentityResult success(String message) {
        return new IdentityResult(true, message);
    }

    public static IdentityResult failure(String message) {
        return new IdentityResult(false, message);
    }
}
