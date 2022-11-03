package com.example.demo.project.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "for_test")
public class ForTestEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "tel",length = 15)
    private String tel;

    @Column(name = "email_address",length = 200)
    private String emailAddress;
}
