import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Welcome to Minesweeper!");
        Scanner scan = new Scanner(System.in);

        /* generate grid coordinates */

        Integer a = 10; // rows
        Integer b = 10; // columns

        String[][] gridCoord = new String[a][b];

        for (int i = 0; i < b; i++) {
          for (int j = 0; j < b; j++) {
            gridCoord[i][j] = Integer.toString(j + 1);
          }
        }

        // /* generate an empty display array where we show clicked tiles */

        int x = 10; // rows
        int y = 10; // columns

        String [][] gridString = new String[x][y];

        for (int i = 0; i < x; i++) {
          for (int j = 0; j < x; j++) {
            gridString[i][j] = "[  ]";
          }
        }

        // // print array of arrays
        System.out.println(Arrays.deepToString(gridString));

        /* generate random mine coordinates */

         System.out.println("Here are the mines coordinates: ");

          ArrayList<String> mineCoordinatesArr = new ArrayList<>();

          int i = 0;
          while (i < 10) {
          Integer randomColumn = (int)(Math.random() * 10);
          Integer randomRow = (int)(Math.random() * 10);

          Integer[] coord = {randomColumn, randomRow};
          mineCoordinatesArr.add(coord[0] + "," + coord[1]);
        /* loops through the nested coordinates and replace the coords where theres a mine [*]  */
          gridCoord[coord[0]][coord[1]] = "*";
          i++;
        }

        System.out.println(mineCoordinatesArr);
        System.out.println(Arrays.deepToString(gridCoord));

        // /* check user input and mine coordinates */

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

          System.out.println(Arrays.deepToString(gridCoord));

        // keep track of the tiles by adding one each time there's a match
        Integer surroudingMines = 0;

        // position to give to check, we start at the one before (-1), then at the same position (0), then at the one after (+1)
        // c for check
        Integer c = -1;
        Integer d = -1;
        Integer e = -1;

        Integer checkAboveRow = Character.getNumericValue(userInput.charAt(0));
        Integer checkAboveColumn = Character.getNumericValue(userInput.charAt(2));
        while (c < 2) {
          checkAboveRow = Character.getNumericValue(userInput.charAt(0))-1;
          checkAboveColumn = Character.getNumericValue(userInput.charAt(2))+c;
        // check row below
          if (mineCoordinatesArr.contains(checkAboveRow + "," + checkAboveColumn)) {
            surroudingMines++;
            c++;
            System.out.println("Surrounding mines" + surroudingMines);
            System.out.println("Surrounding mines " + checkAboveRow + "," + checkAboveColumn);
          }
          c++;
          System.out.println("Surrounding mines" + surroudingMines);
          System.out.println("Surrounding mines " + checkAboveRow + "," + checkAboveColumn);
        }

        // //The same row, add 0 to row, cycle through columns
        Integer checkSameRow = Character.getNumericValue(userInput.charAt(0));
        Integer checkSameColumn = Character.getNumericValue(userInput.charAt(2));

        while (d < 2) {
          checkSameRow = Character.getNumericValue(userInput.charAt(0));
          checkSameColumn = Character.getNumericValue(userInput.charAt(2)+d);
          if (mineCoordinatesArr.contains(checkSameRow + "," + checkSameColumn)) {
            surroudingMines++;
            d++;
          }
          d++;
          System.out.println("Surrounding mines" + surroudingMines);
          System.out.println("Surrounding mines " + checkSameRow+","+checkSameColumn);

        }

        // //The row below, add 1 to row, cycle through columns
        Integer checkBelowRow = Character.getNumericValue(userInput.charAt(0));
        Integer checkBelowColumn = Character.getNumericValue(userInput.charAt(2));

        while (e < 2) {
          checkBelowRow = Character.getNumericValue(userInput.charAt(0))+1;
          checkBelowColumn = Character.getNumericValue(userInput.charAt(2)+ e);
        // check row below
          if (mineCoordinatesArr.contains(checkBelowRow + "," + checkBelowColumn)) {
            surroudingMines++;
            e++;
          }
          e++;
          System.out.println("Surrounding mines" + surroudingMines);
          System.out.println("Surrounding mines " + checkBelowRow+","+checkBelowColumn);
        }


          gridString[inputRow.intValue()][inputColumn.intValue()] = "["+ surroudingMines +"]";
          System.out.println(Arrays.deepToString(gridString));

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

    /* if the coordinates are not matching with a bomb, we should reveal that tile */

    // we need to find a way to keep track of all the array withing the array list

    // generate a large array of 10 small arrays - containing numbers 1 to 10
    // each small array represent a row
    // each number 1 through 10 represent a column
      // that way accessing [1][8] is looking at the first row at column 8th
      // this returns 7 (colums start from 0)

    // and then we compare the nested array to the userInput
    // if there's mines in the surroundings, we change the value of the tile to the amount of mines

    // to check how many mines: we could loop over the coordinates[a,b] by 1 for a and by 1 for b
    // when they no surrounding arrays (like on the edges?)
