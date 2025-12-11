package com.icefek.models.entity;

import com.icefek.models.notentity.MenuType;

import java.io.BufferedReader;
import java.io.IOException;

public class UserMenu extends Menu {

   public void showMenu(MenuType menuType) {
       switch(menuType) {
           // MAIN BLOCK
           case USER_MAIN :{
               String[] options = {"Get to do by id","Create to do","Delete todo","Update todo","Close menu"};;
               showParagraph("Regular user menu",options);
               break;
               }


           // GET BLOCK
           case  USER_GET:{
               showParagraph("Write todo's id",null);
               break;
           }


           //DELETE BLOCK
           case USER_DELETE:{
                showParagraph("Write id to delete",null);
                break;
           }
           case USER_DELETE_SUCCESS:{
               showParagraph("TODO WAS DELETED SUCCESSFUL",null);
               break;
           }
           case USER_DELETE_UNSUCCESS:{
               showParagraph("TODO WAS DELETED UNSUCCESSFUL",null);
               break;
           }


           //UPDATE BLOCK
           case USER_UPDATE_SUCCESS:{
               showParagraph("TODO WAS UPDATED SUCCESSFUL",null);
               break;
           }
           case USER_UPDATE_UNSUCCESS:{
               showParagraph("TODO WAS UPDATED UNSUCCESSFUL",null);
               break;
           }
           case  USER_UPDATE:{
               String[] options = {"Description","Status","Update","Go back"};
               showParagraph("Update todo",options);
               break;
           }
           case  USER_UPDATE_DESCRIPTION:{
               showParagraph("Enter description",null);
               break;
           }
           case  USER_UPDATE_STATUS:{
               String[] options = {"Done","Undone","In progress","Go back"};
               showParagraph("Choose status",options);
               break;
           }


           //CREATE BLOCK
           case USER_CREATE_SUCCESS:{
               showParagraph("TODO WAS CREATED SUCCESSFUL",null);
               break;
           }
           case USER_CREATE_UNSUCCESS:{
               showParagraph("TODO WAS CREATED UNSUCCESSFUL",null);
               break;
           }
           case  USER_CREATE:{
               String[] options = {"Description","Status","Create","Go back"};
               showParagraph("Create todo",options);
               break;
           }
           case  USER_CREATE_DESCRIPTION:{
               showParagraph("Enter description",null);
               break;
           }
           case  USER_CREATE_STATUS:{
               String[] options = {"Done","Undone","In progress","Go back"};
               showParagraph("Choose status",options);
               break;
           }
       }
   }
}
