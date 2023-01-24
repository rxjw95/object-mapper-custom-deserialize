package com.tistory.rjvv.objmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tistory.rjvv.objmapper.delegatemethod.factorymethod.Human;
import com.tistory.rjvv.objmapper.delegatemethod.single_arg.Animal;
import com.tistory.rjvv.objmapper.exception.ErrorEnum;
import com.tistory.rjvv.objmapper.exception.ErrorResponse;
import com.tistory.rjvv.objmapper.propertymethod.Book;
import org.junit.jupiter.api.*;
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
    @Disabled
    void test_ErrorResponse_Deserialize() throws JsonProcessingException {
        String json = """
            {
                "timestamp":"2023-01-23T01:33:33.974493",
                "status":404,
                "error":"NOT_FOUND",
                "message":"Cannot found member id.",
                "code":"NOT_FOUND_MEMBER"
             }""".stripIndent();

        ErrorResponse errorResponse = objectMapper.readValue(json, ErrorResponse.class);

        assertThat(errorResponse.getTimestamp()).isEqualTo("2023-01-23T01:33:33.974493");
        assertThat(errorResponse.getCode()).isEqualTo(ErrorEnum.NOT_FOUND_MEMBER.name());
    }

    @Test
    void test_Animal_DelegateBasedCreator_Single_Arg() throws JsonProcessingException {
        String json = """
            {
                "name":"frog",
                "size":40
             }""".stripIndent();

        Animal animal = objectMapper.readValue(json, Animal.class);
        assertThat(animal.getName()).isEqualTo("frog");
        assertThat(animal.getSize()).isEqualTo(40);
    }

    @Test
    void test_Human_DelegateBasedCreator_FactoryMethod() throws JsonProcessingException {
        String json = """
            {
                "name":"woogie",
                "height":"180cm"
             }""".stripIndent();

        Human human = objectMapper.readValue(json, Human.class);
        assertThat(human.getName()).isEqualTo("woogie");
        assertThat(human.getHeight()).isEqualTo("180cm");
    }

    @Test
    void test_Book_PropertyBasedCreator() throws JsonProcessingException {
        String json = """
            {
                "isbn":"BS-1234",
                "name":"kingkong"
             }""".stripIndent();

        Book book = objectMapper.readValue(json, Book.class);
        assertThat(book.getIsbn()).isEqualTo("BS-1234");
        assertThat(book.getName()).isEqualTo("kingkong");
    }
}
