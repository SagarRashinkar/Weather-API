package com.weatherapitask.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    String value;

    public ResourceNotFoundException(String resourceName, String fieldName, String value) {
        super(resourceName+" not found with "+fieldName+" : "+ value);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
