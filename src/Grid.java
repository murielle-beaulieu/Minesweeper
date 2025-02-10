import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

  private static Integer a = 10; // rows
  private static Integer b = 10; // columns
  private static String[][] gridString = new String[a][b];
  private static String[][] gridCoord = new String[a][b];
  static ArrayList<String> mineCoordinatesArr = new ArrayList<>();

      public static void createGridArray() {

        for (int i = 0; i < a; i++) {
          for (int j = 0; j < a; j++) {
            gridCoord[i][j] = Integer.toString(j + 1);
              }
            }

              // /* generate an empty display array where we show clicked tiles */

          for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
              gridString[i][j] = "[  ]";
              }
            }
          System.out.println("Here's your empty array:");
          System.out.println(Arrays.deepToString(gridString));
        }


            public static void insertMines() {
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

            System.out.println("Here are the mines coordinates: ");
            System.out.println(Arrays.deepToString(gridCoord));

          }

        public static String[][] getGridCoordinates() {
            return gridCoord;
        }

        public static String[][] getEmptyGrid() {
          return gridString;
      }

        public static void printGrid() {
          System.out.println(Arrays.deepToString(gridString));
        }

        public static ArrayList<String> getMineCoordinates () {
          System.out.println(mineCoordinatesArr);
          return mineCoordinatesArr;
        }

}
