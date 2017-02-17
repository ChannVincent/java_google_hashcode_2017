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

    protected int[][] pizzaMatrice;

    public PizzaSolver(String input) {
        this.input = input;
        this.inputManager = new InputManager(this.input);
        initInputs();
    }

    public void solve() {

    }

    protected void initInputs() {
        int[] initInputs = inputManager.getFirstLineInput();
        lineCount = initInputs[0];
        columnCount = initInputs[1];
        minIngredientsIn1Slice = initInputs[2];
        maxCellsIn1Slice = initInputs[3];
        pizzaMatrice = inputManager.getMatriceInput(lineCount, columnCount, true);
        System.out.println("initInput : " + lineCount + " " + columnCount + " " + minIngredientsIn1Slice + " " + maxCellsIn1Slice);
    }
}
