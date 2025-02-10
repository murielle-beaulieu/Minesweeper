import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class App {
  public static void main(String[] args) throws Exception {
    // System.out.println("Welcome to Minesweeper!");
    Scanner scan = new Scanner(System.in);

    /* generate grid coordinates */

    Grid.createGridArray();

    /* generate random mine coordinates */

    Grid.insertMines();

    /* initialize grid coordinates and mine coordinates variables */

    // String[][] gridString = Grid.getGridCoordinates();
    String[][] gridDisplay = Grid.getEmptyGrid();

    ArrayList<String> mineCoordinatesArr = Grid.getMineCoordinates();

    /* check user input and mine coordinates */

    System.out.println("Enter a set of coordinates row,column : ");
    String userInput = scan.next();

    Boolean gameOver = false;
    Integer inputRow = Character.getNumericValue(userInput.charAt(0));
    Integer inputColumn = Character.getNumericValue(userInput.charAt(2));


    if (mineCoordinatesArr.contains(userInput)) {
      System.out.println("Boom!! a mine exploded");
      gameOver = true;
    }

        while(gameOver.equals(false)) {

          Integer minesAround = 0;
          Mines.countSurroundingMines(userInput, mineCoordinatesArr);
          minesAround = Mines.getSurroundingMines();

          System.out.println(minesAround);

          gridDisplay[inputRow.intValue()][inputColumn.intValue()] = "["+ minesAround +"]";

          Grid.printGrid();
          System.out.println("Enter next set of coordinates: ");

          userInput = scan.next();
          inputRow = Character.getNumericValue(userInput.charAt(0));
          inputColumn = Character.getNumericValue(userInput.charAt(2));

          if (mineCoordinatesArr.contains(userInput)) {
            System.out.println("Boom!! a mine exploded");
            gameOver = true;
          }
        }

        scan.close();
      }
    }

    // to check how many mines: we could loop over the coordinates[a,b] by 1 for a and by 1 for b
    // when they no surrounding arrays (like on the edges?)
