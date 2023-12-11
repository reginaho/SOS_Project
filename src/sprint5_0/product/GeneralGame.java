package sprint5_0.product;

public abstract class GeneralGame extends SOSGame {
    int redPlayerCombinations;
    int bluePlayerCombinations;
    public GeneralGame(){
        super();
        redPlayerCombinations = 0;
        bluePlayerCombinations = 0;
        gameType = GameType.GENERAL_GAME;
    }
    public GeneralGame(Cell leftPlayerMoveType, Cell rightPlayerMoveType){
        super();
        redPlayerCombinations = 0;
        bluePlayerCombinations = 0;
        this.leftPlayerMoveType = leftPlayerMoveType;
        this.rightPlayerMoveType = rightPlayerMoveType;
        gameType = GameType.GENERAL_GAME;
    }
    public Boolean makeMove(int row, int column){
        if(currentGameState == GameState.PLAYING && rowNum >= BOARD_SIZE_MIN && columnNum >= BOARD_SIZE_MIN && rowNum <= BOARD_SIZE_MAX && columnNum <= BOARD_SIZE_MAX) {
            RecordMoveToFile(row, column);
            if (grid[row][column] == Cell.EMPTY) {
                int combinationNum;
                if (turn % 2 == 1) {
                    grid[row][column] = leftPlayerMoveType;
                    combinationNum = findCombination(row, column);
                    if(combinationNum != 0) {
                        redPlayerCombinations += combinationNum;
                    }
                    else{
                        turn++;
                    }
                }
                else if (turn % 2 == 0) {
                    grid[row][column] = rightPlayerMoveType;
                    combinationNum = findCombination(row, column);
                    if(combinationNum != 0) {
                        bluePlayerCombinations += combinationNum;
                    }
                    else{
                        turn++;
                    }
                }
                totalPlaced++;
                if(totalPlaced >= rowNum * rowNum){
                    if(redPlayerCombinations == bluePlayerCombinations) {
                        currentGameState = GameState.DRAW;
                    }
                    else if(redPlayerCombinations > bluePlayerCombinations){
                        currentGameState = GameState.RED_WON;
                    }
                    else{
                        currentGameState = GameState.BLUE_WON;
                    }
                    closeGameFile();
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
