package tictactoe.strategies.WinningStrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Move;
import tictactoe.models.Player;

public interface WinningStrategy {

    boolean checkWinner(Board board, Player player, Cell cell);

}
