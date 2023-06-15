package main.java.joutube.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class Video {
    private int id;
    private Video video;
    private String title;
    private String thumbnail_image;
    private String video_length;
    private LocalDate created_at;
    private long view_count;
}
