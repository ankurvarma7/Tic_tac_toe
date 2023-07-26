package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameClient {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        List<Player> players=new ArrayList<>();
        System.out.println("Enter the dimension of the game:");
        int dimension=sc.nextInt();
        int numberOfPlayers=dimension-1;

        System.out.println("Will there be a bot in the game? y/n");
        String isBot=sc.next();

        if(isBot.equals("y")){
            numberOfPlayers-=1;
            System.out.println("Enter name of the bot:");
            String botName=sc.next();

            System.out.println("Enter the symbol for the bot:");
            String symbol=sc.next();

            //String difficultyLevel=sc.next();

            players.add(new Bot(botName,symbol.charAt(0),BotDifficultyLevel.EASY));
        }

        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Enter name of the player:");
            String name=sc.next();

            System.out.println("Enter symbol of the player:");
            String symbol=sc.next();

            players.add(new Player(name,symbol.charAt(0), PlayerType.HUMAN));
        }

        GameController gameController=new GameController();
        Game game=gameController.createGame(dimension,players);

        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){

            System.out.println("This is the current board:");
            gameController.displayBoard(game);

//            System.out.println("Do you want to undo?: y/n");
//            String isUndo=sc.next();

            gameController.makeNextMove(game);
        }

        System.out.println("The game has ended!!");
        if(game.getGameStatus().equals(GameStatus.FINISHED)){
            System.out.print("The  winner is: ");
            gameController.showWinner(game);
        }

    }
}
