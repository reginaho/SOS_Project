package sprint5_0.product;

import java.util.Vector;

public abstract class SOSGame {
    public static int BOARD_SIZE_MIN = 3;
    public static int BOARD_SIZE_MAX = 12;
    protected int rowNum = 6;
    protected int columnNum = 6;
    protected int totalPlaced;

    public enum Cell {
        EMPTY, S, O
    }

    protected Cell[][] grid;
    Vector<Combination> combinations;
    protected int turn = 1;

    public enum GameState {
        PLAYING, DRAW, BLUE_WON, RED_WON
    }

    protected GameState currentGameState;
    public enum GameType {
        SIMPLE_GAME, GENERAL_GAME
    }
    public enum PlayerType {
        HUMAN_PLAYER, COMPUTER_PLAYER
    }
    protected PlayerType leftPlayerType;
    protected PlayerType rightPlayerType;
    protected GameType gameType;
    protected Cell leftPlayerMoveType;
    protected Cell rightPlayerMoveType;
    protected Boolean startIndicator = true;

    public SOSGame() {
        initGame(6,6);
        startIndicator = false;
    }

    public Boolean initGame(int rowNum,int columnNum) {
        if(rowNum >= BOARD_SIZE_MIN && columnNum >= BOARD_SIZE_MIN && rowNum <= BOARD_SIZE_MAX && columnNum <= BOARD_SIZE_MAX) {
        this.rowNum = rowNum;
            this.columnNum = columnNum;
            grid = new Cell[rowNum][columnNum];
            combinations = new Vector<Combination>();
            for (int row = 0; row < rowNum; ++row) {
                for (int col = 0; col < columnNum; ++col) {
                    grid[row][col] = Cell.EMPTY;
                }
            }
            if(!startIndicator) {
                currentGameState = GameState.PLAYING;
            }
            turn = 1;
            totalPlaced = 0;
            return true;
        }
        return false;
    }

    public int getTotalRows() {
        return rowNum;
    }

    public int getTotalColumns() {
        return columnNum;
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public int getTurn() {
        return turn;
    }

    public void updateGameType(GameType gameType){
        this.gameType = gameType;
    }

    public GameType getGameType(){
        return gameType;
    }
    public PlayerType getLeftPlayerType(){
        return leftPlayerType;
    }
    public PlayerType getRightPlayerType(){
        return rightPlayerType;
    }
    public void setLeftPlayerType(PlayerType leftPlayerType){
        this.leftPlayerType = leftPlayerType;
    }
    public void setRightPlayerType(PlayerType rightPlayerType){
        this.rightPlayerType = rightPlayerType;
    }
    public abstract Boolean makeMove(int row, int column);
    public abstract Boolean makeMove();
    //    public abstract Boolean makeMove(int row, int column);
    public int findCombination(int row, int column){
        boolean redTurn;
        boolean blueTurn;
        if(turn % 2 == 0){
            blueTurn = true;
            redTurn = false;
        }
        else{
            blueTurn = false;
            redTurn = true;
        }
        Cell move = grid[row][column];
        //I need to verify each statement
        int totalCombinations = 0;
        if(move == Cell.O){
            try {
                if (checkMove(row - 1, column) && checkMove(row + 1, column)) {
                    if (grid[row - 1][column] == Cell.S && grid[row + 1][column] == Cell.S) {
                        System.out.println("Vertical O");
                        combinations.add(new Combination(row - 1, column, row + 1, column, redTurn, blueTurn));
                        totalCombinations++;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try {
                if (checkMove(row - 1, column - 1) && checkMove(row + 1, column + 1)) {
                    if (grid[row - 1][column - 1] == Cell.S && grid[row + 1][column + 1] == Cell.S) {
                        System.out.println("Diagonal Up O");
                        combinations.add(new Combination(row - 1, column - 1, row + 1, column + 1, redTurn, blueTurn));
                        totalCombinations++;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
            if(checkMove(row, column-1) && checkMove(row, column+1)){
                if(grid[row][column-1] == Cell.S && grid[row][column+1] == Cell.S){
                    System.out.println("Horizontal O");
                    combinations.add(new Combination(row, column-1, row, column+1, redTurn, blueTurn));
                    totalCombinations++;
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try {
                if (checkMove(row + 1, column - 1) && checkMove(row - 1, column + 1)) {
                    if (grid[row + 1][column - 1] == Cell.S && grid[row - 1][column + 1] == Cell.S) {
                        System.out.println("Diagonal Down O");
                        combinations.add(new Combination(row + 1, column - 1, row - 1, column + 1, redTurn, blueTurn));
                        totalCombinations++;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
        }
        else if(move == Cell.S){//1
            if(checkMove(row, column+1) && checkMove(row, column+2)){
                if(grid[row][column+1] == Cell.O && grid[row][column+2] == Cell.S){
                    System.out.println("right S");
                    combinations.add(new Combination(row, column, row, column+2, redTurn, blueTurn));
                    totalCombinations++;
                }
            }//2
            if(checkMove(row+1, column+1) && checkMove(row+2, column+2)){
                if(grid[row+1][column+1] == Cell.O && grid[row+2][column+2] == Cell.S){
                    System.out.println("top right S");
                    combinations.add(new Combination(row, column, row+2, column+2, redTurn, blueTurn));
                    totalCombinations++;
                }
            }//3
            if(checkMove(row+1, column) && checkMove(row+2, column)){
                if(grid[row+1][column] == Cell.O && grid[row+2][column] == Cell.S){
                    System.out.println("vertical up S");
                    combinations.add(new Combination(row, column, row+2, column, redTurn, blueTurn));
                    totalCombinations++;
                }
            }//4
            if(checkMove(row+1, column-1) && checkMove(row+2, column-2)){
                if(grid[row+1][column-1] == Cell.O && grid[row+2][column-2] == Cell.S){
                    System.out.println("top left S");
                    combinations.add(new Combination(row, column, row+2, column-2, redTurn, blueTurn));
                    totalCombinations++;
                }
            }//5
            if(checkMove(row, column-1) && checkMove(row, column-2)){
                if(grid[row][column-1] == Cell.O && grid[row][column-2] == Cell.S){
                    System.out.println("left S");
                    combinations.add(new Combination(row, column, row, column-2, redTurn, blueTurn));
                    totalCombinations++;
                }
            }//6
            if(checkMove(row-1, column-1) && checkMove(row-2, column-2)){
                if(grid[row-1][column-1] == Cell.O && grid[row-2][column-2] == Cell.S){
                    System.out.println("bottom left S");
                    combinations.add(new Combination(row, column, row-2, column-2, redTurn, blueTurn));
                    totalCombinations++;
                }
            }//7
            if(checkMove(row-1, column) && checkMove(row-2, column)){
                if(grid[row-1][column] == Cell.O && grid[row-2][column] == Cell.S){
                    System.out.println("vertical down S");
                    combinations.add(new Combination(row, column, row-2, column, redTurn, blueTurn));
                    totalCombinations++;
                }
            }//8
            if(checkMove(row-1, column+1) && checkMove(row-2, column+2)){
                if(grid[row-1][column+1] == Cell.O && grid[row-2][column+2] == Cell.S){
                    System.out.println("right down S");
                    combinations.add(new Combination(row, column, row-2, column+2, redTurn, blueTurn));
                    totalCombinations++;
                }
            }
        }
        return totalCombinations;
    }
    public boolean checkMove(int row, int column){
        if(row >= 0 && column >= 0 && row < rowNum && column < columnNum){
            return true;
        }
        return false;
    }
    private void updateGameState(char turn, int row, int column) {
    }
    public GameState getGameState() {
        return currentGameState;
    }
    public void updateLeftPlayer(Cell leftPlayerMoveType){
        this.leftPlayerMoveType = leftPlayerMoveType;
    }

    public void updateRightPlayer(Cell rightPlayerMoveType){
        this.rightPlayerMoveType = rightPlayerMoveType;
    }
    public Cell getLeftPlayer(){
        return leftPlayerMoveType;
    }

    public Cell getRightPlayer(){
        return rightPlayerMoveType;
    }
    public Vector<Combination> getCombinations(){
        return combinations;
    }
    class Combination{
        int row1;
        int col1;
        int row2;
        int col2;
        boolean redTurn;
        boolean blueTurn;
        //true =left right = false

        Combination(int row1, int col1, int row2, int col2, boolean redTurn, boolean blueTurn){
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.redTurn = redTurn;
            this.blueTurn = blueTurn;
        }
        public int getRow1(){
            return row1;
        }
        public int getCol1(){
            return col1;
        }
        public int getRow2(){
            return row2;
        }
        public int getCol2(){
            return col2;
        }
        public boolean getPlayerTurn(){
            return blueTurn;
        }
    }
}
