package main.java.joutube;

import main.java.joutube.service.AccountService;
import main.java.joutube.service.VideoService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        VideoService videoService = new VideoService();
//        accountService.createAccount(); // 계정생성
//        accountService.deleteAccount(15); // 계정삭제
//        accountService.updateAccount(3); // 계정수정
//        videoService.uploadVideo();

    }
}
