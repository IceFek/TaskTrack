package com.icefek;

import com.icefek.models.entity.RegularUser;
import com.icefek.models.entity.RestClientHanlder;
import com.icefek.models.entity.Todo;
import com.icefek.models.entity.User;
import com.icefek.models.notentity.Status;

public class Main {
    public static void main(String[] args){
       RegularUser user = new RegularUser("Bohdan");
       user.menuHanlde();
    }
}
