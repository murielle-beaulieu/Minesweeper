import java.util.ArrayList;

public class Mines {

  private static Integer surroudingMines = 0;

        // position to give to check, we start at the one before (-1), then at the same position (0), then at the one after (+1)
        // c for check
        public static void countSurroundingMines (String userInput, ArrayList<String> mineCoordinatesArr) {
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
          }
          c++;
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
      }
  }

  public static Integer getSurroundingMines() {
    return surroudingMines;
  }

}
