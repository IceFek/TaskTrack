package com.icefek.models.entity;

import com.icefek.models.notentity.ElementIsntExistException;
import com.icefek.models.notentity.MenuType;

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
           String userOption;
           MenuType menuType = MenuType.USER_MAIN;
           userMenu.showMenu(menuType);
           userOption = userInput();
           switch(userOption){
               case "1":
                   menuType = MenuType.USER_GET;
                   userMenu.showMenu(menuType);
                   userOption = userInput();
                   try{
                       Todo todo = RESTProvider.get(Integer.parseInt(userOption)-1);
                       todo.show();
                   }
                   catch (ElementIsntExistException e){
                       e.printStackTrace();
                       continue;
                   }
                   Thread.sleep(3000);
                   continue;

               case "2":
                   Todo todo;
                   String[] todoProp = new String[2];
                   while (true) {
                       menuType = MenuType.USER_CREATE;
                       userMenu.showMenu(menuType);
                       userOption = userInput();
                       String tempProperty = "";
                       menuType = switch (userOption) {
                           case "1" -> MenuType.USER_CREATE_DESCRIPTION;
                           case "2" -> MenuType.USER_CREATE_STATUS;
                           default -> MenuType.USER_MAIN;
                       };
                       if(userOption.equals("4")){
                           break;
                       }
                       else if(userOption.equals("3")){
                           String status = todoProp[1];
                           switch (status) {
                               case "1" -> todoProp[1] = "Done";
                               case "2" -> todoProp[1] = "Un done";
                               case "3" -> todoProp[1] = "In progress";
                           }
                           todo = new Todo(1,todoProp[0],todoProp[1]);
                           if(RESTProvider.post(todo)){
                               menuType = MenuType.USER_CREATE_SUCCESS;
                           }
                           else{
                               menuType = MenuType.USER_CREATE_UNSUCCESS;
                           }
                           userMenu.showMenu(menuType);
                           break;
                       }
                       userMenu.showMenu(menuType);
                       tempProperty = userInput();
                       todoProp[Integer.parseInt(userOption)-1] = tempProperty;
                   }
               break;
               case "3":
                   menuType = MenuType.USER_DELETE;
                   userMenu.showMenu(menuType);
                   userOption = userInput();
                   if(RESTProvider.delete(userOption)){
                       menuType = MenuType.USER_DELETE_SUCCESS;
                       userMenu.showMenu(menuType);
                   }
                   else {
                       menuType = MenuType.USER_DELETE_UNSUCCESS;
                       userMenu.showMenu(menuType);
                   }
               case "4":
                   int idToUpdate;
                   Todo todoUpdate;
                   String[] todoPropUpdate = new String[2];
                   menuType = MenuType.USER_GET;
                   userMenu.showMenu(menuType);
                   idToUpdate = Integer.parseInt(userInput());
                   todo = RESTProvider.get(idToUpdate-1);
                   todoPropUpdate[0] = todo.getDescription();
                   todoPropUpdate[1] = todo.getStatus().get();
                   while (true) {
                       menuType = MenuType.USER_UPDATE;
                       userMenu.showMenu(menuType);
                       userOption = userInput();
                       String tempProperty = "";
                       menuType = switch (userOption) {
                           case "1" -> MenuType.USER_UPDATE_DESCRIPTION;
                           case "2" -> MenuType.USER_UPDATE_STATUS;
                           default -> MenuType.USER_MAIN;
                       };
                       if(userOption.equals("4")){
                           break;
                       }
                       else if(userOption.equals("3")){
                           String status = todoPropUpdate[1];
                           switch (status) {
                               case "1" -> todoPropUpdate[1] = "Done";
                               case "2" -> todoPropUpdate[1] = "Un done";
                               case "3" -> todoPropUpdate[1] = "In progress";
                           }
                           todo.setDescription(todoPropUpdate[0]);
                           todo.setStatus(todoPropUpdate[1]);
                           todo.setUpdatedAt();
                           todo.show();


                           if(RESTProvider.update(todo)){
                               menuType = MenuType.USER_UPDATE_SUCCESS;
                           }
                           else{
                               menuType = MenuType.USER_UPDATE_UNSUCCESS;
                           }
                           userMenu.showMenu(menuType);
                           break;
                       }
                       userMenu.showMenu(menuType);
                       tempProperty = userInput();
                       todoPropUpdate[Integer.parseInt(userOption)-1] = tempProperty;
                   }
                   break;
               case "5":
                   try{
                       br.close();
                   }
                   catch(IOException e){
                       e.printStackTrace();
                   }
                   return;
           }
       }
    }
    private String userInput(){
        String userOption = "";
        try{
            userOption = br.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return userOption;
    }
}
