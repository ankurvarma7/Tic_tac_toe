package tictactoe.factories;

import tictactoe.models.Board;
import tictactoe.models.BotDifficultyLevel;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.strategies.BotStrategy.BotPLayingStrategy;
import tictactoe.strategies.BotStrategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPLayingStrategy getInstance(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY))return new EasyBotPlayingStrategy();
        return null;
    }
}
