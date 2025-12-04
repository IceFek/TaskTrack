package com.icefek.models.entity;

import java.io.BufferedReader;
import java.io.IOException;

public class UserMenu extends Menu {

   public String showGeneralMenu(BufferedReader br){
        String[] options = {"Get to do by id","Create to do","Close menu"};
        showParagraph("Regular user menu",options);
        String answer = "";
        try{
           answer = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return answer;
   }
   public String getToDoMenu(BufferedReader br){
       showParagraph("Write todo's id",null);
       String answer = "";
       try{
           answer = br.readLine();
       }
       catch (IOException e){
           e.printStackTrace();
       }
       return answer;
   }

    public String createToDoMenu(BufferedReader br){
        String[] options = {"Set id","Create to do","Close menu"};
        showParagraph("Create todo",options);
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
