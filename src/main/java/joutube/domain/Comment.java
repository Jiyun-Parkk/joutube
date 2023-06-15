package main.java.joutube.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Comment {
    private int id;
    private Video video;
    private Account account;
    private String comment;
    private LocalDate created_at;

}
