package main.java.joutube.service;

import main.java.joutube.dao.AccountDao;
import main.java.joutube.domain.Account;
import main.java.joutube.io.Console;
import main.java.joutube.view.JoutubeView;

public class AccountService {
    private final AccountDao accountDao = new AccountDao();
    private final JoutubeView joutubeView = JoutubeView.getJoutubeView();
    //TODO: 계정을 만들기
    public void createAccount() {
        Console.println("계정 이름을 입력해주세요");
        String name = Console.read();
        Console.println("프로필 이미지 링크를 입력해주세요.");
        String profileImage = Console.read();
        Console.println("이메일을 입력해주세요.");
        String email = Console.read();
        Console.println("비밀번호를 입력주세요.");
        String password = Console.read();
        Account account = Account.builder()
                .name(name)
                .profileImage(profileImage)
                .email(email)
                .password(password).build();
        accountDao.createAccount(account);
        joutubeView.createAccountView(name);
    }

    //TODO: 계정 삭제
    public void deleteAccount(int id) {
        int delete = accountDao.deleteAccount(id);
        if (delete != 0) {
            joutubeView.deleteAccountView();
        } else {
            Exception exception = new Exception("삭제 하는 과정에서 오류가 생겼습니다.");
            joutubeView.errorView(exception.getMessage());
        }
    }

    //TODO: 계정 수정
    public void updateAccount(int id) {
        Console.println("수정할 계정 이름을 입력해주세요.");
        String name = Console.read();
        Console.println("수정할 프로필 이미지 링크를 입력해주세요.");
        String profile = Console.read();
        Console.println("수정할 이메일을 입력해주세요.");
        String email = Console.read();
        Console.println("수정할 비밀번호를 입력해주세요.");
        String password = Console.read();
        int update = accountDao.updateAccount(name, profile, email, password, id);
        if (update != 0) {
            joutubeView.updateAccountView();
        } else {
            Exception exception = new Exception("업데이트를 하는 과정에서 오류가 생겼습니다.");
            joutubeView.errorView(exception.getMessage());
        }
    }


}




