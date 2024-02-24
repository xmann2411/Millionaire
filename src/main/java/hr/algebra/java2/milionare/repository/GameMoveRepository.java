package hr.algebra.java2.milionare.repository;

import hr.algebra.java2.milionare.model.OnePlayerMove;

import java.util.List;

public interface GameMoveRepository {
    void saveNewGameMove(OnePlayerMove gameMove);
    List<OnePlayerMove> getAllGameMoves();
}
