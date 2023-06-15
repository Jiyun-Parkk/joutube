package main.java.joutube.view;

import main.java.joutube.io.Console;

public class JoutubeView {

    private static final JoutubeView JOUTUBE_VIEW = new JoutubeView();

    private JoutubeView(){}

    public static JoutubeView getJoutubeView() {
        return JOUTUBE_VIEW;
    }

    public void createAccountView(String name) {
        Console.println(name + "님의 계정 등록이 완료 되었습니다.");
    }
    public void deleteAccountView() {
        Console.println("계정 삭제가 완료 되었습니다.");
    }

    public void updateAccountView() {
        Console.println("계정 업데이트가 완료 되었습니다.");
    }

    public void uploadVideoView() {
        Console.println("비디오가 업로드 되었습니다.");
    }


    public void errorView(String errorMessage) {
        System.out.println(errorMessage);
    }

}
