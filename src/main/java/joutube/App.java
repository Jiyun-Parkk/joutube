package main.java.joutube;

import main.java.joutube.io.Console;
import main.java.joutube.service.AccountService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();

        accountService.createAccount();
    }
}
