package com.project.cc.ccbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class User implements Serializable {

    private String uuid;
    private String username;
    private String avatarUrl;
    private int gender;
    private int age;
    private String city;
    private String state;
    private String country;
    private String language;
    private boolean deleted; //default false
}
