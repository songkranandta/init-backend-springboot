package com.example.demo.project.feature.datauser.model;

import lombok.*;

import java.math.BigDecimal;

public class UserModel {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
//    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Response {

        private int id;
        private String name;
        private String tel;
        private String emailAddress;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Request {

        private String name;
        private String tel;
        private String emailAddress;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Student{
        private int id;
        private String name;
        private String age;
        private BigDecimal score;
        private String gpa;

    }

}
