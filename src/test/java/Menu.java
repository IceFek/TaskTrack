
public abstract class Menu {
    private static int borderLenght = 10;
    private static String border;
    public static void showHead(String string){

    }

    public static void calculateBorder(){
        for(int i=0;i<borderLenght;i++){
            border = border.concat("=");
            System.out.println(border);
        }
    }
}
