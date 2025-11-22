package com.icefek.models.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegularUser extends User {
    private BufferedReader br;
    public RegularUser(String name){
        br = new BufferedReader(new InputStreamReader(System.in));
        super(name);
    }

    public void menuHanlde(){
        try{
            openUserMenu();
        }
       catch(IOException e){
            e.printStackTrace();
       }


    }

    private void openUserMenu() throws IOException {
        System.out.println("==================================");
        System.out.println("=Welcome to the Regular User menu=");
        System.out.println("==================================");
        System.out.println("=1.Get to do by id               =");
        System.out.println("=2.Create to do                  =");
        String userOption;
        userOption = br.readLine();
        switch(userOption){
            case "1":
                System.out.println(userOption);
                break;
            case "2":
                System.out.println(userOption + "sdsd");
                break;
        }

    }
}
