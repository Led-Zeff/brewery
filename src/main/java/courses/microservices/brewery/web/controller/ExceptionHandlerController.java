package courses.microservices.brewery.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public List<String> validationErrorHandler(ConstraintViolationException e) {
    log.error(e.getMessage(), e);
    return e.getConstraintViolations().stream().map(cv -> cv.getPropertyPath() + " " + cv.getMessage())
        .collect(Collectors.toList());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public List<String> argumentNotValid(MethodArgumentNotValidException e) {
    log.error(e.getMessage(), e);
    return e.getBindingResult().getFieldErrors().stream().map(fe -> fe.getField() + " -> " + fe.getDefaultMessage())
        .collect(Collectors.toList());
  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public List<ObjectError> handleBindException(BindException e) {
    log.error(e.getMessage(), e);
    return e.getAllErrors();
  }
}
