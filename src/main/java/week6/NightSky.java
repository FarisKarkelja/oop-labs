//Task7

package week6;

import java.util.Random;

public class NightSky {
    private double density;
    private int width;
    private int height;
    Random random;
    private int starsInLastPrint;

    public NightSky(double density) {
        this.density = density;
        this.width = 20;
        this.height = 10;
        this.random = new Random();
    }

    public NightSky(int width, int height) {
        this.width = width;
        this.height = height;
        this.density = 0.1;
        this.random = new Random();
    }

    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
        this.random = new Random();
    }

    public void printLine() {
        for (int i = 0; i < width; i++) {
            if (random.nextDouble() < density) {
                System.out.print("*");
                starsInLastPrint++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void print() {
        starsInLastPrint = 0;
        for (int i = 0; i < height; i++) {
            printLine();
        }
    }

    public int starsInLastPrint() {
        return starsInLastPrint;
    }

    public static void main(String[] args) {
        NightSky NightSky = new NightSky(0.1, 40, 10);
        NightSky.printLine();

        NightSky nightSky = new NightSky(8, 4);
        nightSky.print();

        System.out.println("Number of stars: " + NightSky.starsInLastPrint());
        System.out.println("");

        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
    }
}
