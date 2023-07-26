package tictactoe.models;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {

    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player(){}
    public Player(String name,char symbol,PlayerType playerType){
        this.name=name;
        this.symbol=symbol;
        this.playerType=playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move decideMove(Board board){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please punch in the row number:");
        int row=sc.nextInt();

        System.out.println("Please punch in the column number");
        int col=sc.nextInt();

        Cell cell=board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellStatus(CellStatus.FILLED);

        return new Move(this,cell);
    }


}
