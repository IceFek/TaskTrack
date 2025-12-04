package com.icefek;

import com.icefek.models.entity.*;
import com.icefek.models.notentity.Status;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RegularUser user = new RegularUser("Bohdan");
        user.openUserMenu();
    }
}
