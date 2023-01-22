package com.tistory.rjvv.objmapper.custom;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.tistory.rjvv.objmapper.exception.ErrorEnum;
import com.tistory.rjvv.objmapper.exception.ErrorResponse;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomErrorResponseDeserializer extends StdDeserializer<ErrorResponse> {

    public CustomErrorResponseDeserializer() {
        this(null);
    }

    public CustomErrorResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ErrorResponse deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String localDateTime = node.get("timestamp").asText();
        String code = node.get("code").asText();

        if (ErrorEnum.hasName(code)) {
            return new ErrorResponse(LocalDateTime.parse(localDateTime), ErrorEnum.from(code));
        }

        return null;
    }
}
