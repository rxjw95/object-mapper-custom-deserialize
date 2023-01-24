package com.tistory.rjvv.objmapper.delegatemethod.factorymethod;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Human {
    private final String name;
    private final String height;

    @JsonCreator
    public static Human create(HumanCreator humanCreator) {
        return new Human(humanCreator.getName(), humanCreator.getHeight());
    }

    public Human(String name, String height) {
        this.name = name;
        this.height = height;
    }
}
