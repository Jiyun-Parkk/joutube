package main.java.joutube.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Comment {
    private int id;
    private int video_id;
    private int account_id;
    private String comment;
    private LocalDate created_at;

}
