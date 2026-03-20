package main;

import manager.UserManager;
import auth.PasswordHasher;

public class LegacyLockApp {

    public static void main(String[] args){

        System.out.println("Legacy Lock Application Started");

        UserManager userManager=new UserManager();

        try{

            userManager.registerUser(
                "Alice",
                "alice@email.com",
                PasswordHasher.hash("123")
            );

            System.out.println("User registered");

        }catch(Exception e){

            System.out.println(e.getMessage());

        }

    }
}