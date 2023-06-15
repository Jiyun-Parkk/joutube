package main.java.joutube;

import main.java.joutube.io.Console;
import main.java.joutube.service.AccountService;
import main.java.joutube.service.VideoService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        VideoService videoService = new VideoService();

//        accountService.createAccount();
        videoService.uploadVideo();
    }
}
