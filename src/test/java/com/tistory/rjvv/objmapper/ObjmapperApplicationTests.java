package com.tistory.rjvv.objmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tistory.rjvv.objmapper.exception.ErrorEnum;
import com.tistory.rjvv.objmapper.exception.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ObjmapperApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test_ErrorResponse_Deserialize() throws JsonProcessingException {
        String json = """
            {
                \"timestamp\":\"2023-01-23T01:33:33.974493\",
                \"status\":404,
                \"error\":\"NOT_FOUND\",
                \"message\":\"Cannot found member id.\",
                \"code\":\"NOT_FOUND_MEMBER\"
             }""".stripIndent();

        ErrorResponse errorResponse = objectMapper.readValue(json, ErrorResponse.class);

        assertThat(errorResponse.getTimestamp()).isEqualTo("2023-01-23T01:33:33.974493");
        assertThat(errorResponse.getCode()).isEqualTo(ErrorEnum.NOT_FOUND_MEMBER.name());
    }
}
