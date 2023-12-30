package com.xma.task1;

public class GenericImplementation<T> implements SomeInterface<T>{
    protected T data;

    @Override
    public T getData() {
        return data;
    }

    @Override
    public boolean validate(T data) {
        return true;
    }
}
