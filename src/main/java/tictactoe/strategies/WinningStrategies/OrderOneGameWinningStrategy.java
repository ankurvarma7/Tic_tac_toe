package tictactoe.strategies.WinningStrategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Move;
import tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements WinningStrategy{

    private List<HashMap<Character,Integer>> rowSymbolCount;
    private List<HashMap<Character,Integer>> colSymbolCount;
    private HashMap<Character,Integer> majorDiagSymbolCount;
    private HashMap<Character,Integer> minorDiagSymbolCount;

    public OrderOneGameWinningStrategy(int dimension){
        rowSymbolCount=new ArrayList<>();
        colSymbolCount=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
        majorDiagSymbolCount=new HashMap<>();
        minorDiagSymbolCount=new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Player player,Cell cell) {
        int row=cell.getRow();
        int col=cell.getCol();
        char symbol= player.getSymbol();
        int dimension=board.getBoard().size();

        if(!rowSymbolCount.get(row).containsKey(symbol)){
            rowSymbolCount.get(row).put(symbol,0);
        }
        rowSymbolCount.get(row).computeIfPresent(symbol,(key,val)->val+1);

        if(!rowSymbolCount.get(row).containsKey(symbol)){
            rowSymbolCount.get(row).put(symbol,0);
        }
        rowSymbolCount.get(row).computeIfPresent(symbol,(key,val)->val+1);

        if(!colSymbolCount.get(col).containsKey(symbol)){
            colSymbolCount.get(col).put(symbol,0);
        }
        colSymbolCount.get(col).computeIfPresent(symbol,(key,val)->val+1);

        if(isOnMajorDiag(row,col,dimension)){
            if(!majorDiagSymbolCount.containsKey(symbol)){
                majorDiagSymbolCount.put(symbol,0);
            }
            majorDiagSymbolCount.computeIfPresent(symbol,(key,val)->val+1);
        }

        if(isOnMinorDiag(row,col,dimension)){
            if(!minorDiagSymbolCount.containsKey(symbol)){
                minorDiagSymbolCount.put(symbol,0);
            }
            minorDiagSymbolCount.computeIfPresent(symbol,(key,val)->val+1);
        }

        if(rowSymbolCount.get(row).get(symbol)==dimension)return true;
        if(colSymbolCount.get(col).get(symbol)==dimension)return true;
        if(isOnMajorDiag(row,col,dimension)&&majorDiagSymbolCount.get(symbol)==dimension) {
            return true;
        }
        if(isOnMinorDiag(row,col,dimension)&&minorDiagSymbolCount.get(symbol)==dimension){
            return true;
        }

        return false;

    }

    public boolean isOnMajorDiag(int row,int col,int dimension){
        return row==col;
    }

    public boolean isOnMinorDiag(int row,int col,int dimension){
        return (row+col==dimension-1);
    }
}
