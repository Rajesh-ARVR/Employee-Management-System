package com.example.employee.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Method to handle unique constraint violation exception
    @ExceptionHandler(UniqueConstraintViolationException.class)
    public ModelAndView handleUniqueConstraintViolationException(UniqueConstraintViolationException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    // Method to handle runtime exception
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(RuntimeException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", "An unexpected error occurred: " + ex.getMessage());
        return modelAndView;
    }
}
