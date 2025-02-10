import java.util.ArrayList;

public class Mines {

  private static Integer surroudingMines = 0;

      public static void countSurroundingMines (String userInput, ArrayList<String> mineCoordinatesArr) {
        Integer c = -1;
        Integer d = -1;
        Integer e = -1;

        // check row above, minus 1 to row cycle through columns
        Integer checkAboveRow = Character.getNumericValue(userInput.charAt(0));
        Integer checkAboveColumn = Character.getNumericValue(userInput.charAt(2));

        while (c < 2) {
          checkAboveRow = Character.getNumericValue(userInput.charAt(0))-1;
          checkAboveColumn = Character.getNumericValue(userInput.charAt(2))+c;
            if (mineCoordinatesArr.contains(checkAboveRow + "," + checkAboveColumn)) {
              surroudingMines++;
              c++;
            }
          c++;
        }

        // check same row, add 0 to row, cycle through columns
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
        }

        // check row below, add 1 to row, cycle through columns
        Integer checkBelowRow = Character.getNumericValue(userInput.charAt(0));
        Integer checkBelowColumn = Character.getNumericValue(userInput.charAt(2));

        while (e < 2) {
          checkBelowRow = Character.getNumericValue(userInput.charAt(0))+1;
          checkBelowColumn = Character.getNumericValue(userInput.charAt(2)+ e);
            if (mineCoordinatesArr.contains(checkBelowRow + "," + checkBelowColumn)) {
              surroudingMines++;
              e++;
            }
          e++;
        }
  }

  public static Integer getSurroundingMines() {
    return surroudingMines;
  }

  public static void resetMinesCount() {
    surroudingMines = 0;
  }

}
