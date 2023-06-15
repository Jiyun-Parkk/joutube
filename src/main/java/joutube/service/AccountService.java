package main.java.joutube.service;

import main.java.joutube.dao.AccountDao;
import main.java.joutube.domain.Account;
import main.java.joutube.io.Console;

public class AccountService {
    private final AccountDao accountDao = new AccountDao();
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
    }

    //TODO: 계정 삭제
    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
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
        accountDao.updateAccount(name, profile, email, password, id);
    }


}




