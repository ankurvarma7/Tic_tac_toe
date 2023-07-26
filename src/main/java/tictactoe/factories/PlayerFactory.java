package tictactoe.factories;

import tictactoe.models.Bot;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;

public class PlayerFactory {
    public static Player getInstance(PlayerType playerType){
        if(playerType.equals(PlayerType.HUMAN))return new Player();
        else if(playerType.equals(PlayerType.BOT))return new Bot();
        return null;
    }
}
