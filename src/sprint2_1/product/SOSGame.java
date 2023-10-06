package sprint2_1.product;

public class SOSGame {
    private int rowNum = 6;
    private int columnNum = 6;

    public enum Cell {
        EMPTY, S, O
    }

    private Cell[][] grid;
    private int turn = 1;
    private Cell currentMoveType;

    public enum GameState {
        PLAYING, DRAW
    }

    private GameState currentGameState;
    public enum GameType {
        SIMPLE_GAME, GENERAL_GAME
    }
    GameType gameType;

//    public enum MoveType {
//        S, O
//    }
    Cell leftPlayerMoveType;
    Cell rightPlayerMoveType;


    public SOSGame() {
        initGame(6,6);
    }

    public void initGame(int rowNum,int columnNum) {
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        grid = new Cell[rowNum][columnNum];
        for (int row = 0; row < rowNum; ++row) {
            for (int col = 0; col < columnNum; ++col) {
                grid[row][col] = Cell.EMPTY;
            }
        }
        currentGameState = GameState.PLAYING;
    }

    public void resetGame() {
//        initGame();
    }

    public int getTotalRows() {
        return rowNum;
    }

    public int getTotalColumns() {
        return columnNum;
    }

    public Cell getCell(int row, int column) {
//        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS) {
//            return grid[row][column];
//        } else {
//            return null;
//        }
        return grid[row][column];
    }

    public int getTurn() {
        return turn;
    }

    public void updateGameType(GameType gameType){
        this.gameType = gameType;
    }

    public void makeMove(int row, int column) {
        if (grid[row][column] == Cell.EMPTY) {
            if (turn % 2 == 1) {
                System.out.println("p");
                grid[row][column] = leftPlayerMoveType;
            } else if (turn % 2 == 0) {
                System.out.println("k");
                grid[row][column] = rightPlayerMoveType;
            }
            turn++;
        }
        System.out.println(turn);
    }

    private void updateGameState(char turn, int row, int column) {
//        if (hasWon(turn, row, column)) { // check for win
//            currentGameState = (turn == 'X') ? GameState.CROSS_WON : GameState.NOUGHT_WON;
//        } else if (isDraw()) {
//            currentGameState = GameState.DRAW;
//        }
        // Otherwise, no change to current state (still GameState.PLAYING).
    }
    public void updateLeftPlayer(Cell leftPlayerMoveType){
        this.leftPlayerMoveType = leftPlayerMoveType;
    }

    public void updateRightPlayer(Cell rightPlayerMoveType){
        this.rightPlayerMoveType = rightPlayerMoveType;
    }
//
//    private boolean isDraw() {
//        for (int row = 0; row < TOTALROWS; ++row) {
//            for (int col = 0; col < TOTALCOLUMNS; ++col) {
//                if (grid[row][col] == Cell.EMPTY) {
//                    return false; // an empty cell found, not draw
//                }
//            }
//        }
//        return true;
//    }
//
//    private boolean hasWon(char turn, int row, int column) {
//        Cell token = (turn == 'X') ? Cell.CROSS : Cell.NOUGHT;
//        return (grid[row][0] == token // 3-in-the-row
//                && grid[row][1] == token && grid[row][2] == token
//                || grid[0][column] == token // 3-in-the-column
//                && grid[1][column] == token && grid[2][column] == token
//                || row == column // 3-in-the-diagonal
//                && grid[0][0] == token && grid[1][1] == token && grid[2][2] == token
//                || row + column == 2 // 3-in-the-opposite-diagonal
//                && grid[0][2] == token && grid[1][1] == token && grid[2][0] == token);
//    }
//
//    public GameState getGameState() {
//        return currentGameState;
//    }
//
}
