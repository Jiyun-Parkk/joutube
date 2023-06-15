package main.java.joutube.view;

public class JoutubeView {

    private static final JoutubeView JOUTUBE_VIEW = new JoutubeView();

    private JoutubeView(){}

    public static JoutubeView getJoutubeView() {
        return JOUTUBE_VIEW;
    }

    public void createAccountView() {
        System.out.println("");
    }
}
