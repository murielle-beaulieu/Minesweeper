// import java.util.Arrays;

import java.util.ArrayList;

public class Mine {

// the game should be able to randomly generate 10 mines in a 10x10 grid
// generate random set of coordinates of column/row

  public Mine() {
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
  }

}
