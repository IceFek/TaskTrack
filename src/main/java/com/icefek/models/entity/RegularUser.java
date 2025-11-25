package com.icefek.models.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegularUser extends User {
    private final BufferedReader br;
    public RegularUser(String name){
        super(name);
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void openUserMenu() throws InterruptedException {
       while(true){
           String userOption = UserMenu.showGeneralMenu(br);
           switch(userOption){
               case "1":
                   userOption = UserMenu.getToDoMenu(br);
                   Todo todo = RESTProvider.get(Integer.parseInt(userOption));
                   todo.show();
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
