import java.util.ArrayList;
import java.util.Scanner;


public class App {
  public static void main(String[] args) throws Exception {
    System.out.println();
    System.out.println("*******************************");
    System.out.println("     Welcome to Minesweeper!   ");
    System.out.println("*******************************");
    System.out.println();
    System.out.println("Enter a set of comma separated coordinates (0-9)");
    System.out.println();

    Scanner scan = new Scanner(System.in);

    /* generate grid coordinates */
    Grid.createGridArray();

    /* generate random mine coordinates */
    Grid.insertMines();

    /* initialize grid coordinates and mine coordinates variables */
    String[][] gridDisplay = Grid.getEmptyGrid();
    ArrayList<String> mineCoordinatesArr = Grid.getMineCoordinates();

    /* check user input and mine coordinates */
    System.out.println();
    System.out.println("Enter a set of coordinates: ");
    String userInput = scan.next();

    Boolean gameOver = false;
    Integer inputRow = Character.getNumericValue(userInput.charAt(0));
    Integer inputColumn = Character.getNumericValue(userInput.charAt(2));

    if (mineCoordinatesArr.contains(userInput)) {
      System.out.println("Boom!! a mine exploded");
      System.out.println("GAME OVER!");
      gameOver = true;
    }

        while(gameOver.equals(false)) {

          Integer minesAround = 0;
          Mines.countSurroundingMines(userInput, mineCoordinatesArr);
          minesAround = Mines.getSurroundingMines();

          gridDisplay[inputRow.intValue()][inputColumn.intValue()] = "["+ minesAround +"]";

          System.out.println();
          /* reprint the  grid, but showing the array with the mine*/
          for (int i = 0; i < gridDisplay.length; i++) {
            for (int j = 0; j < gridDisplay[i].length; j++) {
                System.out.print(gridDisplay[i][j]);
            }
          System.out.println();
          }

          Mines.resetMinesCount();

          System.out.println();
          System.out.println("Enter next set of coordinates: ");
          userInput = scan.next();

          inputRow = Character.getNumericValue(userInput.charAt(0));
          inputColumn = Character.getNumericValue(userInput.charAt(2));

          if (mineCoordinatesArr.contains(userInput)) {
            System.out.println();
            System.out.println("Boom!! a mine exploded");
            gameOver = true;
          }
        }
      scan.close();
    }
  }
