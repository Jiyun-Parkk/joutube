package main.java.joutube.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Account {
    private int id;
    private String name;
    private  String profile_image;
    private String email;
    private String password;

}
