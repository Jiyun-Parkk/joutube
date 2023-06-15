package main.java.joutube.service;

import main.java.joutube.dao.VideoDao;
import main.java.joutube.io.Console;

public class VideoService {

    private final VideoDao videoDao = new VideoDao();

    public void uploadVideo(){

        Console.println("비디오 소유자를 알려주세요.");
        int owner = Console.readInt();
        Console.println("비디오 제목을 입력하세요.");
        String title = Console.read();
        Console.println("썸네일 설정하실?");
        String thumbnailImage = Console.read();
        Console.println("비디오의 길이는??");
        int videoLength = Console.readInt();

        videoDao.uploadVideo(owner, title, thumbnailImage, videoLength);
    }
}
