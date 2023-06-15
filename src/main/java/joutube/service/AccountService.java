package main.java.joutube.service;

import main.java.joutube.dao.AccountDao;
import main.java.joutube.io.Console;

public class AccountService {
    private final AccountDao accountDao = new AccountDao();

    // 계정을 만들기
    public void createAccount() {
        Console.println("계정 이름을 작성해주세요.");
        String name = Console.read();
        Console.println("프로필 이미지 링크를 입력해주세요.");
        String profile_image = Console.read();
        Console.println("이메일을 입력해주세요.");
        String email = Console.read();
        Console.println("비밀번호를 입력주세요.");
        String password = Console.read();
        accountDao.createAccount(name, profile_image, email, password);
    }

}




