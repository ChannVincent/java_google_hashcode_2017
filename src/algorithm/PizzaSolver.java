package algorithm;

import manager.InputManager;

/**
 * Created by vchann on 17/02/2017.
 */
public class PizzaSolver {

    protected InputManager inputManager;
    protected String input;
    protected int lineCount;
    protected int columnCount;
    protected int minIngredientsIn1Slice;
    protected int maxCellsIn1Slice;

    protected int[][] pizzaMatrix;

    public PizzaSolver(String input) {
        this.input = input;
        this.inputManager = new InputManager(this.input);
        initInputs();
    }

    protected void initInputs() {
        int[] initInputs = inputManager.getFirstLineInput();
        lineCount = initInputs[0];
        columnCount = initInputs[1];
        minIngredientsIn1Slice = initInputs[2];
        maxCellsIn1Slice = initInputs[3];
        pizzaMatrix = inputManager.getMatrixInput(lineCount, columnCount, true);
        System.out.println("initInput : " + lineCount + " " + columnCount + " " + minIngredientsIn1Slice + " " + maxCellsIn1Slice);
    }

    /*
    Solutions
     */
    public void solveA() {
        String result = "";

        int[][] currentSlice = new int[1][maxCellsIn1Slice];
        int cellCounter = 0;

        for (int y = 0; y < lineCount; y++) {
            for (int x = 0; x < columnCount; x++) {

                // create slice
                currentSlice[0][cellCounter] = pizzaMatrix[y][x];

                // continue to advance until the border
                if (cellCounter < maxCellsIn1Slice && (maxCellsIn1Slice - cellCounter + x) < columnCount) {
                    cellCounter++;
                }
                else {
                    if (isSliceValid(currentSlice)) {
                        result += (x - maxCellsIn1Slice) + " " + y + " " + x + " " + y + "\n";
                    }
                    cellCounter = 0;
                }
            }
        }

        System.out.println(result);
    }



    /*
    Slice validator
     */
    protected boolean isSliceValid(int[][] slice) {
        int tomatoeCount = 0;
        int mushroomCount = 0;

        int height = slice.length;
        int width = slice[0].length;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (slice[y][x] == 0) {
                    tomatoeCount++;
                }
                else if (slice[y][x] == 1) {
                    mushroomCount++;
                }
                else {
                    System.out.println("error slice");
                }
            }
        }

        if (tomatoeCount >= minIngredientsIn1Slice && mushroomCount >= minIngredientsIn1Slice) {
            return true;
        }
        else {
            return false;
        }
    }

    protected boolean testIsSliceValid() {
        int[][] slice = new int[][] {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        if (isSliceValid(slice)) {
            System.out.println("Slice is Valid");
            return true;
        }
        else {
            System.out.println("Slice is NOT Valid");
            return false;
        }
    }


}
