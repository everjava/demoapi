package io.tempo.demoapi.infrastructure.configuration;

import feign.FeignException;
import io.tempo.demoapi.core.role.exception.RoleNotFoundException;
import io.tempo.demoapi.core.teams.exception.TeamNotFoundException;
import io.tempo.demoapi.core.user.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class APIExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                500,
                "An unexpected error occurred " +e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handleFeignStatusException(FeignException e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                e.status(),"An error occurred calling the endpoint: " +e.getMessage()),
                HttpStatus.valueOf(response.getStatus()));
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<?> handleFeignNotFoundException(FeignException.NotFound e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                e.status(),
                e.getMessage()),
                HttpStatus.valueOf(response.getStatus()));
    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<?> handleFeignBadRequestException(FeignException.BadRequest e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                e.status(),
                e.getMessage()),
                HttpStatus.valueOf(response.getStatus()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid parameter value: "+e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<?> handleException(RoleNotFoundException e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleException(UserNotFoundException e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<?> handleException(TeamNotFoundException e, HttpServletResponse response) {
        log.error("Exception handler",e);
        return new ResponseEntity<>(exceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> exceptionMessage(Integer status, String message){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", message);
        body.put("status", status);
        return body;
    }

}
