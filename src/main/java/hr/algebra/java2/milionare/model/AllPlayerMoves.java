package hr.algebra.java2.milionare.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllPlayerMoves implements Serializable {

    private static List<OnePlayerMove> playerMoves = new ArrayList<>();

    public AllPlayerMoves() {
    }
    public static List<OnePlayerMove> getPlayerMoves() {
        return playerMoves;
    }
    public void addPlayerMove(OnePlayerMove playerMove) {
        playerMoves.add(playerMove);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("All Player Moves:\n");

        for (OnePlayerMove move : playerMoves) {
            result.append(move.toString()).append("\n");
        }

        return result.toString();
    }

}
