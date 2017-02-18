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
    public String solveA() {
        String result = "";

        int sliceCounter = 0;
        int cellCounter = 0;
        int[][] currentSlice = getResetSlice(maxCellsIn1Slice, 1);

        for (int y = 0; y < lineCount; y++) {
            int indexSliceStart = 0;
            for (int x = 0; x < columnCount; x++) {

                if (sliceCounter == 17) {
                    int random = 4;
                }

                // create slice
                currentSlice[0][cellCounter] = pizzaMatrix[y][x];

                // continue to advance until the border
                if ((cellCounter < maxCellsIn1Slice - 1) && (x < columnCount - 1)) {
                    cellCounter++;
                }
                else {
                    if (isSliceValid(currentSlice)) {
                        result += y + " " + indexSliceStart + " " + y + " " + x + "\n";
                        sliceCounter++;
                        indexSliceStart = x + 1;
                    }
                    else {
                        indexSliceStart = x - cellCounter + 2;
                        x = indexSliceStart - 1;
                    }
                    currentSlice = getResetSlice(maxCellsIn1Slice, 1);
                    cellCounter = 0;
                }

            }
        }

        System.out.println(sliceCounter + "\n" + result);
        return sliceCounter + "\n" + result;
    }

    /*
    Reset slice
     */
    protected int[][] getResetSlice(int columnCount, int lineCount) {
        int[][] slice = new int[lineCount][columnCount];
        for (int y = 0; y < lineCount; y++) {
            for (int x = 0; x < columnCount; x++) {
                slice[y][x] = 0;
            }
        }
        return slice;
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
                if (slice[y][x] == 1) {
                    tomatoeCount++;
                }
                else if (slice[y][x] == 2) {
                    mushroomCount++;
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
                { 2, 2, 2, 1, 1, 1 },
                { 2, 2, 2, 2, 2, 2 },
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
