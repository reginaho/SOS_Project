package sprint4_0.product;

import java.util.Random;

public class SimpleComputerGame extends SimpleGame{
    public SimpleComputerGame(){
        super();
        leftPlayerType = PlayerType.HUMAN_PLAYER;
        rightPlayerType = PlayerType.HUMAN_PLAYER;
    }
    public SimpleComputerGame(Cell leftPlayerMoveType, Cell rightPlayerMoveType, PlayerType leftType, PlayerType rightType){
        super(leftPlayerMoveType,rightPlayerMoveType);
        leftPlayerType = leftType;
        rightPlayerType = rightType;
    }
    @Override
    public Boolean makeMove() {
        if(!SOSMove()){
            randomMove();
        }
        return true;
    }

    public Boolean randomMove(){
        Random ran = new Random();
        int boardSize = rowNum * rowNum;
        int nxt = ran.nextInt(1,3);
        int startLocation = ran.nextInt(boardSize);
        Cell ranCell = Cell.values()[nxt];

        for(int i = 0; i < boardSize; i++){
            int row = startLocation / rowNum;
            int col = startLocation % columnNum;
            if(grid[row][col] == Cell.EMPTY){
                if (getTurn() % 2 == 0) {
                    rightPlayerMoveType = ranCell;
                } else if (getTurn() % 2 == 1) {
                    leftPlayerMoveType = ranCell;
                }
                return makeMove(row, col);
            }

            startLocation++;
            if(startLocation == boardSize){
                startLocation = 0;
            }
        }
        return false;
    }
    public boolean SOSMove(){
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < columnNum; j++){
                if(grid[i][j] == Cell.EMPTY){
                    if(CheckO(i,j)){
                        if (getTurn() % 2 == 0) {
                            rightPlayerMoveType = Cell.O;
                        } else if (getTurn() % 2 == 1) {
                            leftPlayerMoveType = Cell.O;
                        }
                        return makeMove(i,j);
                    }
                    else if(CheckS(i,j)){
                        if (getTurn() % 2 == 0) {
                            rightPlayerMoveType = Cell.S;
                        } else if (getTurn() % 2 == 1) {
                            leftPlayerMoveType = Cell.S;
                        }
                        return makeMove(i,j);
                    }
                }
            }
        }
        return false;
    }
    public boolean CheckO(int row, int column){
        try {
            if (checkMove(row - 1, column) && checkMove(row + 1, column)) {
                if (grid[row - 1][column] == Cell.S && grid[row + 1][column] == Cell.S) {
                    return true;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
        try {
            if (checkMove(row - 1, column - 1) && checkMove(row + 1, column + 1)) {
                if (grid[row - 1][column - 1] == Cell.S && grid[row + 1][column + 1] == Cell.S) {
                    return true;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
        try{
            if(checkMove(row, column-1) && checkMove(row, column+1)){
                if(grid[row][column-1] == Cell.S && grid[row][column+1] == Cell.S){
                    return true;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
        try {
            if (checkMove(row + 1, column - 1) && checkMove(row - 1, column + 1)) {
                if (grid[row + 1][column - 1] == Cell.S && grid[row - 1][column + 1] == Cell.S) {
                    return true;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
        return false;
    }
    public boolean CheckS(int row, int column){
        if(checkMove(row, column+1) && checkMove(row, column+2)){
            if(grid[row][column+1] == Cell.O && grid[row][column+2] == Cell.S){
                return true;
            }
        }//2
        if(checkMove(row+1, column+1) && checkMove(row+2, column+2)){
            if(grid[row+1][column+1] == Cell.O && grid[row+2][column+2] == Cell.S){
                return true;
            }
        }//3
        if(checkMove(row+1, column) && checkMove(row+2, column)){
            if(grid[row+1][column] == Cell.O && grid[row+2][column] == Cell.S){
                return true;
            }
        }//4
        if(checkMove(row+1, column-1) && checkMove(row+2, column-2)){
            if(grid[row+1][column-1] == Cell.O && grid[row+2][column-2] == Cell.S){
                return true;
            }
        }//5
        if(checkMove(row, column-1) && checkMove(row, column-2)){
            if(grid[row][column-1] == Cell.O && grid[row][column-2] == Cell.S){
                return true;
            }
        }//6
        if(checkMove(row-1, column-1) && checkMove(row-2, column-2)){
            if(grid[row-1][column-1] == Cell.O && grid[row-2][column-2] == Cell.S){
                return true;
            }
        }//7
        if(checkMove(row-1, column) && checkMove(row-2, column)){
            if(grid[row-1][column] == Cell.O && grid[row-2][column] == Cell.S){
                return true;
            }
        }//8
        if(checkMove(row-1, column+1) && checkMove(row-2, column+2)){
            if(grid[row-1][column+1] == Cell.O && grid[row-2][column+2] == Cell.S){
                return true;
            }
        }
        return false;
    }
}
