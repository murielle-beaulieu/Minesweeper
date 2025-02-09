import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Welcome to Minesweeper!");
        Scanner scan = new Scanner(System.in);

        // // System.out.println("Enter a set of coordinates for the tile you want to display: ");
        // // String coordinatesPlayed = scan.next();

        /* generate grid coordinates */

        Integer a = 10; // rows
        Integer b = 10; // columns
        // int n = (Integer)null; // having a third array empty to display?

        String[][] gridCoord = new String[a][b];

        for (int i = 0; i < b; i++) {
          for (int j = 0; j < b; j++) {
            gridCoord[i][j] = Integer.toString(j + 1);
            // this gives us a large array of 10 arrays, each smaller array listing 1 throught 10
          }
        }

        // print array of arrays
        // System.out.println(Arrays.deepToString(gridCoord));

        // // access value at position within the array of arrays
        // System.out.println(gridCoord[2][9]);


        // /* generate an empty display array where we show clicked tiles */

        int x = 10; // rows
        int y = 10; // columns
        // int n = (Integer)null; // having a third array empty to display?

        String [][] gridString = new String[x][y];

        for (int i = 0; i < x; i++) {
          for (int j = 0; j < x; j++) {
            gridString[i][j] = "[  ]";
            // this gives us a large array of 10 arrays, each smaller array listing 1 throught 10
          }
        }

        // // print array of arrays
        System.out.println(Arrays.deepToString(gridString));


        /* generate random mine coordinates */

         System.out.println("Here are the mines coordinates: ");

          ArrayList<String> coordinatesArr = new ArrayList<>();

          int i = 0;
          while (i < 10) {
          Integer randomColumn = (int)(Math.random() * 10);
          Integer randomRow = (int)(Math.random() * 10);

          Integer[] coord = {randomColumn, randomRow};
          coordinatesArr.add(coord[0] + "," + coord[1]);
        /* loops through the nested coordinates and replace the coords where theres a mine */
          gridCoord[coord[0]][coord[1]] = "*";
          i++;
        }

        System.out.println(coordinatesArr);
        System.out.println(Arrays.deepToString(gridCoord));

        // /* check user input and mine coordinates */

        System.out.println("Enter a set of coordinates row,column : ");

        String userInput = scan.next();
        Integer inputRow = Character.getNumericValue(userInput.charAt(0));
        Integer inputColumn = Character.getNumericValue(userInput.charAt(2));

        Boolean gameOver = false;
        System.out.println(gameOver);

        while(gameOver.equals(false)) {
          System.out.println(Arrays.deepToString(gridCoord));
          gridString[inputRow.intValue()][inputColumn.intValue()] = "[no]";
          System.out.println(Arrays.deepToString(gridString));

          System.out.println("Enter next set of coordinates: ");
          // reassign the values of the scanner and of the selected row/col

          userInput = scan.next();
          inputRow = Character.getNumericValue(userInput.charAt(0));
          inputColumn = Character.getNumericValue(userInput.charAt(2));

          if (coordinatesArr.contains(userInput)) {
              System.out.println("Boom!! a mine exploded");
              gameOver = true;
            }
          }

        scan.close();
      }
    }

    /* if the coordinates are not matching with a bomb, we should reveal that tile */

    // we need to find a way to keep track of all the array withing the array list
    // i think how the grid is currently generated doesn't work

    // generate a large array of 10 small arrays - containing numbers 1 to 10
    // each small array represent a row
    // each number 1 through 10 represent a column
      // that way accessing [1][8] is looking at the first row at column 8th
      // this returns 7 (colums start from 0)

    // and then we compare the nested array to the userInput
    // if there's mines in the surroundings, we change the value of the tile to the amount of mines

    // to check how many mines: we could loop over the coordinates[a,b] by 1 for a and by 1 for b
    // when they no surrounding arrays (like on the edges?)
