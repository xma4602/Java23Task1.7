package com.xma.task1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateImplementation implements SomeInterface<LocalDate> {
    private LocalDate currentDate;

    public LocalDate getData() {
        return currentDate;
    }

    public boolean validate(LocalDate data) {
        return true;
    }

    public boolean validate(String data) {
        try {
            LocalDate.parse(data);
            return true;
        }
        catch (DateTimeParseException e){
            return false;
        }

    }
}
