package com.icefek.models.entity;

import com.icefek.models.notentity.ElementIsntExistException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegularUser extends User {
    private final BufferedReader br;
    private final UserMenu userMenu;

    public RegularUser(String name){
        super(name);
        userMenu = new UserMenu();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void openUserMenu() throws InterruptedException {
       while(true){
           String userOption = userMenu.showGeneralMenu(br);
           switch(userOption){
               case "1":
                   userOption = userMenu.getToDoMenu(br);
                   try{
                       Todo todo = RESTProvider.get(Integer.parseInt(userOption));
                       todo.show();
                   }
                   catch (ElementIsntExistException e){
                       e.printStackTrace();
                       Thread.sleep(5000);
                       openUserMenu();
                       return;
                   }
                   Thread.sleep(5000);
                   break;

               case "2":

                   break;

               default:
                   try{
                       br.close();
                       return;
                   }
                   catch(IOException e){
                       e.printStackTrace();
                   }
           }
       }
    }
}
