import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Welcome to Minesweeper!");

        Scanner scan = new Scanner(System.in);

        // /* get coordinates */
        // // System.out.println("Enter a set of coordinates for the tile you want to display: ");
        // // String coordinatesPlayed = scan.next();
        // // System.out.println("You've selected " + coordinatesPlayed);

        /* generate random coordinates */

         System.out.println("Here are the mines coordinates: ");

          ArrayList<String> coordinatesArr = new ArrayList<>();

          int i = 0;

          while (i < 10) {
          Integer randomColumn = (int)(Math.random() * 10);
          Integer randomRow = (int)(Math.random() * 10);

          Integer[] coord = {randomColumn, randomRow};

          coordinatesArr.add(coord[0] + "," + coord[1]);
          i++;
        }

        System.out.println(coordinatesArr);

        /* check user input and mine coordinates */

        System.out.println("Enter something: ");

        String userInput = scan.next();

        Boolean gameOver = false;
        System.out.println(gameOver);

        while(gameOver.equals(false)) {
          /* if the coordinates are not matching with a bomb, we should reveal that tile */

          System.out.println("Enter something: ");
          userInput = scan.next();

            if (coordinatesArr.contains(userInput)) {
              System.out.println("Boom!! a mine exploded");
              gameOver = true;
            }
          }

        scan.close();
    }
}
