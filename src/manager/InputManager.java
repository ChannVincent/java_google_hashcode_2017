package manager;

/**
 * Created by vchann on 17/02/2017.
 */
public class InputManager {

    protected String input;

    public InputManager(String input) {
        this.input = input;
    }

    public int[] getLineInput(int line) {
        String firstLine = input.split("\n")[line];
        String[] splitLine = firstLine.split(" ");
        int[] result = new int[splitLine.length];
        for (int i = 0; i < splitLine.length; i++) {
            result[i] = Integer.parseInt(splitLine[i]);
        }
        return result;
    }

    public int[][] getPizzaMatrixInput(int lineCount, int columnCount) {
        int[][] result = new int[lineCount][columnCount];
        String[] lines = input.split("\n");
        for (int y = 1; y < lineCount + 1; y++) {

            String line = lines[y];
            for (int x = 0; x < columnCount; x++) {

                if (String.valueOf(line.charAt(x)).equals("M")) {
                    result[y - 1][x] = 1;
                }
                else if (String.valueOf(line.charAt(x)).equals("T")) {
                    result[y - 1][x] = 2;
                }
                else {
                    System.out.println("error parsing matrice input at x = " + x + " / y = " + (y - 1));
                    result[y - 1][x] = -1;
                }
            }
        }
        return result;
    }

    public int[][] getPizzaMatrixInput(int lineCount, int columnCount, boolean debug) {
        int[][] result = getPizzaMatrixInput(lineCount, columnCount);
        if (debug) {
            for (int y = 0; y < lineCount; y++) {

                for (int x = 0; x < columnCount; x++) {
                    System.out.print(result[y][x]);
                }

                System.out.print("\n");
            }
        }
        return result;
    }
}
