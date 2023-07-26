package tictactoe.strategies.BotStrategy;

import tictactoe.models.*;

public class EasyBotPlayingStrategy implements BotPLayingStrategy {
    @Override
    public Move decideMove(Board board, Player player) {
        int dimension=board.getBoard().size();
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)){
                    board.getBoard().get(i).get(j).setCellStatus(CellStatus.FILLED);
                    return new Move(player,board.getBoard().get(i).get(j));
                }
            }
        }
        return null;
    }
}
