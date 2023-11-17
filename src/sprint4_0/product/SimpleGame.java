package sprint4_0.product;

public abstract class SimpleGame extends SOSGame {
    public SimpleGame(){
        super();
        gameType = GameType.SIMPLE_GAME;
    }
    public SimpleGame(Cell leftPlayerMoveType, Cell rightPlayerMoveType){
        super();
        gameType = GameType.SIMPLE_GAME;
        this.leftPlayerMoveType = leftPlayerMoveType;
        this.rightPlayerMoveType = rightPlayerMoveType;
    }
    public Boolean makeMove(int row, int column){
        if(currentGameState == GameState.PLAYING && rowNum >= BOARD_SIZE_MIN && columnNum >= BOARD_SIZE_MIN && rowNum <= BOARD_SIZE_MAX && columnNum <= BOARD_SIZE_MAX) {
            if (grid[row][column] == Cell.EMPTY) {
                if (turn % 2 == 1) {
                    grid[row][column] = leftPlayerMoveType;
                    if(findCombination(row, column) != 0) {
                        currentGameState = GameState.RED_WON;
                    }
                }
                else if (turn % 2 == 0) {
                    grid[row][column] = rightPlayerMoveType;
                    if(findCombination(row, column) != 0) {
                        currentGameState = GameState.BLUE_WON;
                    }
                }
                totalPlaced++;
                if(totalPlaced >= rowNum * rowNum){
                    currentGameState = GameState.DRAW;
                }
                turn++;
                return true;
            }
            return false;
        }
        return false;
    }
}