package com.tistory.rjvv.objmapper.delegatemethod.factorymethod;

import lombok.Getter;

@Getter
public class HumanCreator {
    private final String name;
    private final String height;

    public HumanCreator(String name, String height) {
        this.name = name;
        this.height = height;
    }
}
