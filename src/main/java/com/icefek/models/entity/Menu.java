package com.icefek.models.entity;

import com.icefek.models.notentity.HeaderType;

public abstract class Menu {
    private static int borderLength = 1;
    private static String border = "";
    public static void showParagraph(String string,String[] options){
        border = "";
        borderLength = 1;
        calculateBorder(string,options);
        //Show head
        System.out.println("\n"+border);
        System.out.printf("=%s%s%s=\n",calculateSpaces(string,HeaderType.HEADER),string,calculateSpaces(string,HeaderType.HEADER));
        System.out.println(border);

        if (options != null) {
            for (int i = 0; i <= options.length - 1; i++) {
                System.out.printf("=%d.%s%s=\n", i + 1, options[i], calculateSpaces(options[i], HeaderType.OPTION));
            }
            System.out.print(border + "\n");
        }
    }

    public static String getBorder(){
        return border;
    }
    private static String calculateSpaces(String string, HeaderType headerType){
        int space = 0;
        String spaces = "";
        space = borderLength - string.length() - 3;
        if (headerType.equals(HeaderType.HEADER)) {
            space = (borderLength - string.length() - 2) / 2;
        }
        for(int j=0;j<space;j++){
            spaces = spaces.concat(" ");
        }
        return spaces;
    }

    private static void calculateBorder(String string,String[] options){
        if(options == null){
            borderLength = string.length() + 6;
            for(int i = 0; i< borderLength; i++){
                border = border.concat("=");
            }
            return;
        }
        for(int i = 0; i < options.length+1; i++){
            if(i <= options.length-1&& options[i].length() + 6 > borderLength){
                borderLength = options[i].length() + 6;
            }
            else if(i > options.length-1&& string.length() + 6 > borderLength){
                borderLength = string.length() + 6;
            }
        }

        for(int i = 0; i< borderLength; i++){
            border = border.concat("=");
        }
    }
}
