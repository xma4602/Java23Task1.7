package com.xma.task1;

public class InterfaceUser {
    private SomeInterface<String> inUse;

    SomeInterface<String> getUsed() {
        return inUse;
    }

    void useInterface(SomeInterface<String> i){
        inUse = i;
    }
}
