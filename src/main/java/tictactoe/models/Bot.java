package tictactoe.models;

import tictactoe.factories.BotPlayingStrategyFactory;
import tictactoe.strategies.BotStrategy.BotPLayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPLayingStrategy botPLayingStrategy;

    public Bot(){}
    public Bot(String name,char symbol,BotDifficultyLevel botDifficultyLevel){
        super(name,symbol,PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
        botPLayingStrategy= BotPlayingStrategyFactory.getInstance(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board){
        return botPLayingStrategy.decideMove(board,this);
    }
}
