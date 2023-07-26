package tictactoe.strategies.BotStrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public interface BotPLayingStrategy {

    Move decideMove(Board board, Player player);
}
