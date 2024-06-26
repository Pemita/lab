package ru.edu.penzgtu.lab.exeption;


import jakarta.persistence.AssociationOverride;

public class PenzGtuException extends Exception {
    private final ErrorType type;

    public PenzGtuException(ErrorType type, String message) {
        super(message);
        this.type = type;
    }

    public PenzGtuException(ErrorType type,String message, Throwable throwable) {
        super(message, throwable);
        this.type = type;
    }

    public PenzGtuException(ErrorType type, Throwable throwable) {
        super(throwable);
        this.type = type;
    }

    public ErrorType getType() {
        return type;
    }

}
