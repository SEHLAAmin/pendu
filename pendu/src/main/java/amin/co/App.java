package amin.co;

/**
 * Hello world!
 */
public final class App {
    private App() {

    }

    
    public static void main(String[] args) {
        System.out.println("Hello World!");

Player player1 = new Player();

Game jeux1 = new Game();

jeux1.genererMots();
jeux1.genererMotNormal();

jeux1.genererMotsCacher();

jeux1.checkerLetter();


    

    }
}
