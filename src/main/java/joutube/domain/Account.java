package main.java.joutube.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class Account {
    private int id;
    private String name;
    private String profileImage;
    private String email;
    private String password;
    private LocalDate date;

}
