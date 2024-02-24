package hr.algebra.java2.milionare.thread;

import hr.algebra.java2.milionare.model.AllPlayerMoves;
import hr.algebra.java2.milionare.model.OnePlayerMove;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaveNewGameMoveThread extends GameMoveThread implements Runnable {

    private OnePlayerMove gameMove;

    public SaveNewGameMoveThread(OnePlayerMove gameMove) {
        this.gameMove = gameMove;
    }

    @Override
    public void run() {
        saveNewGameMove(gameMove);
    }
}
