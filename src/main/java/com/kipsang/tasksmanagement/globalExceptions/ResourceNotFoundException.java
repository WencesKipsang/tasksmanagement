package com.kipsang.tasksmanagement.globalExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
//public class InvalidFieldException extends RuntimeException {
//    public InvalidFieldException(String message) {
//        super(message);
//    }
//}
//
//public class BadRequestException extends RuntimeException {
//    public BadRequestException(String message) {
//        super(message);
//    }
//}