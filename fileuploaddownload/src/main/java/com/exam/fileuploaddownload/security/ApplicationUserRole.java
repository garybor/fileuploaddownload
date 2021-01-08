package com.exam.fileuploaddownload.security;

import java.util.Set;

import static com.exam.fileuploaddownload.security.ApplicationUserPermission.FILE_DOWNLOAD;
import static com.exam.fileuploaddownload.security.ApplicationUserPermission.FILE_UPLOAD;
import static com.exam.fileuploaddownload.security.ApplicationUserPermission.USER_LOGIN;
import com.google.common.collect.Sets;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(USER_LOGIN)),
    ADMIN(Sets.newHashSet(FILE_UPLOAD, FILE_DOWNLOAD));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}