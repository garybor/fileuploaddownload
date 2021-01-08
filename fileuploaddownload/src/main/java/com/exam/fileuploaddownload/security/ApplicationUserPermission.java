package com.exam.fileuploaddownload.security;

public enum ApplicationUserPermission {
    FILE_UPLOAD("file:upload"),
    FILE_DOWNLOAD("file:download"),
    USER_LOGIN("user:login");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}