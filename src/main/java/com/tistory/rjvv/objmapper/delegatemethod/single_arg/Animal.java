package com.tistory.rjvv.objmapper.delegatemethod.single_arg;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@ToString
@Getter
public class Animal {
    private final String name;
    private final int size;

    @JsonCreator
    public Animal(Map<String, String> delationMap) {
        this.name = delationMap.get("name");
        this.size = Integer.parseInt(delationMap.get("size"));
    }
}
