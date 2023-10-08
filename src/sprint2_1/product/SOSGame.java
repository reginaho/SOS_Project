package sprint2_1.product;

public class SOSGame {
    public static int BOARD_SIZE_MIN = 3;
    public static int BOARD_SIZE_MAX = 12;
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
    Cell leftPlayerMoveType;
    Cell rightPlayerMoveType;
    Boolean startIndicator = true;


    public SOSGame() {
        initGame(6,6);
        startIndicator = false;
    }

    public Boolean initGame(int rowNum,int columnNum) {
        if(rowNum >= BOARD_SIZE_MIN && columnNum >= BOARD_SIZE_MIN && rowNum <= BOARD_SIZE_MAX && columnNum <= BOARD_SIZE_MAX) {
            this.rowNum = rowNum;
            this.columnNum = columnNum;
            grid = new Cell[rowNum][columnNum];
            for (int row = 0; row < rowNum; ++row) {
                for (int col = 0; col < columnNum; ++col) {
                    grid[row][col] = Cell.EMPTY;
                }
            }
            if(!startIndicator) {
                currentGameState = GameState.PLAYING;
            }
            turn = 1;
            return true;
        }
        System.out.println("test9");
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

    public Boolean makeMove(int row, int column) {
        if(currentGameState == GameState.PLAYING && rowNum >= BOARD_SIZE_MIN && columnNum >= BOARD_SIZE_MIN && rowNum <= BOARD_SIZE_MAX && columnNum <= BOARD_SIZE_MAX) {
            if (grid[row][column] == Cell.EMPTY) {
                if (turn % 2 == 1) {
                    System.out.println("p");
                    grid[row][column] = leftPlayerMoveType;
                } else if (turn % 2 == 0) {
                    System.out.println("k");
                    grid[row][column] = rightPlayerMoveType;
                }
                turn++;
                return true;
            }
            return false;
        }
        return false;
    }

    private void updateGameState(char turn, int row, int column) {
    }
    public void updateLeftPlayer(Cell leftPlayerMoveType){
        this.leftPlayerMoveType = leftPlayerMoveType;
    }

    public void updateRightPlayer(Cell rightPlayerMoveType){
        this.rightPlayerMoveType = rightPlayerMoveType;
    }
}
