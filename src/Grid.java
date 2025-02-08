import java.lang.reflect.Array;
import java.util.Arrays;

public class Grid {

  public int height;
  public int width;

  public Grid (int height, int width) {
    this.height = height;
    this.width = width;
  }

  public Array createGridArray() {
    int[] gameGrid = new int[ height ];
    Arrays.fill(gameGrid, height);
    int i = 1;
    System.out.println("   1  2  3  4  5  6  7  8  9  10 ");
    System.out.println("__________________________________");
    while (gameGrid.length + 1 > i) {
      System.out.println( i + "| [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]");
      i++;
    }

    return null;
  }
}
