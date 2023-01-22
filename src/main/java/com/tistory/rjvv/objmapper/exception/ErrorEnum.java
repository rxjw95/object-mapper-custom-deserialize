package com.tistory.rjvv.objmapper.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum ErrorEnum {

    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, "Cannot found member id.");

    private static final Map<String, ErrorEnum> map = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(ErrorEnum::name, Function.identity()));

    private final HttpStatus status;
    private final String message;

    public static ErrorEnum from(String name) {
        return map.getOrDefault(name, null);
    }

    public static boolean hasName(String name) {
        return map.containsKey(name);
    }
}