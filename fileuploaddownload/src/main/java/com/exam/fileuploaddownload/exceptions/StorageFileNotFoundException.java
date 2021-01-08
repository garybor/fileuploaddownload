package com.exam.fileuploaddownload.exceptions;

import java.net.MalformedURLException;

public class StorageFileNotFoundException extends RuntimeException {

    public StorageFileNotFoundException() {
        super();
    }

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, MalformedURLException e) {
        super(message, e);
    }
}
