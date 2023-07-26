package tictactoe.controller;

import tictactoe.exceptions.InvalidGameAttributes;
import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        try{
            Game game=Game.GameBuilder()
                    .withBoardDimension(dimension)
                    .withPlayers(players)
                    .build();
            return game;
        }
        catch (InvalidGameAttributes iga){
            System.out.println(iga.getMessage());
        }
        return null;
    }

    public void displayBoard(Game game){
        game.getBoard().display();
    }

    public void showWinner(Game game){
        System.out.println(game.getWinner().getName());
    }

    public void makeNextMove(Game game){
        game.makeNextMove();
    }

}
