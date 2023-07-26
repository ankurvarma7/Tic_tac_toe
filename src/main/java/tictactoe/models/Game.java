package tictactoe.models;
import tictactoe.exceptions.InvalidGameAttributes;
import tictactoe.strategies.WinningStrategies.OrderOneGameWinningStrategy;
import tictactoe.strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
public class Game {

    private Board board;
    private int boardDimension;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;
    private WinningStrategy winningStrategy;

    private Game(){}

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getBoardDimension() {
        return boardDimension;
    }

    public void setBoardDimension(int boardDimension) {
        this.boardDimension = boardDimension;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void makeNextMove(){

        Player playerToMove=players.get(nextPlayerIndex);

        System.out.println("This is "+playerToMove.getName()+"'s turn");

        Move move=playerToMove.decideMove(board);

        moves.add(move);

        if(winningStrategy.checkWinner(board,playerToMove,move.getCell())){
            this.setGameStatus(GameStatus.FINISHED);
            winner=playerToMove;
        }

        if(moves.size()==boardDimension*boardDimension){
            this.setGameStatus(GameStatus.DRAW);
        }

        nextPlayerIndex++;
        nextPlayerIndex%=players.size();
    }

    public static Builder GameBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        List<Player> players;

        public Builder withPlayers(List<Player> players){
            this.players=players;
            return this;
        }

        public Builder withBoardDimension(int dimension){
            this.dimension=dimension;
            return this;
        }

        public Game build(){
            try{
                isValid();
            }
            catch (InvalidGameAttributes iga){
                System.out.println(iga.getMessage());
            }
            Game game=new Game();
            game.setBoard(new Board(dimension));
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setWinningStrategy(new OrderOneGameWinningStrategy(dimension));
            return game;
        }

        public boolean isValid(){
            if(dimension<3)
                throw new InvalidGameAttributes("The dimension should atleast three!!");
            else if(players.size()!=dimension-1)
                throw new InvalidGameAttributes("Number of players should be one less than dimension.");
            return true;
        }
    }
}
