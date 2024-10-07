package week2;

public class Task9 {
    public static void main(String[] args){
        drawPyramid(5);
    }
    public static void drawPyramid(int rows){
        for(int i=0;i<=rows;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
