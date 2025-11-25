package com.icefek.models.entity;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class UserMenu extends Menu {

   public static String showGeneralMenu(BufferedReader br){
        System.out.printf("\n%s\n",BORDER);
        System.out.print("=Welcome to the Regular User menu=");
        System.out.printf("\n%s",BORDER);
        System.out.print("\n=1.Get to do by id               =\n=2.Create to do                  =\n=3.Close menu                    =\n");
        System.out.printf("%s\n",BORDER);
        String answer = "";
        try{
           answer = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return answer;
   }
   public static String getToDoMenu(BufferedReader br){
       System.out.printf("\n%s\n",BORDER);
       System.out.print("=   Write id here   =");
       System.out.printf("\n%s",BORDER);
       String answer = "";
       try{
           answer = br.readLine();
       }
       catch (IOException e){
           e.printStackTrace();
       }
       return answer;
   }
}
