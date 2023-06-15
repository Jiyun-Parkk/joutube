package main.java.joutube.domain;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Channel {
    private int id;
    private int account_id;
    private long subscriber;
    private long video_count;
}
