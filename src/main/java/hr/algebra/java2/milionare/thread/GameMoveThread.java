package hr.algebra.java2.milionare.thread;

import hr.algebra.java2.milionare.model.OnePlayerMove;
import hr.algebra.java2.milionare.repository.GameMoveRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GameMoveThread implements GameMoveRepository {

    private static Boolean isFileAccessInProgress = false;

    private static final String GAME_MOVES_FILE = "C:\\Users\\Karla\\IdeaProjects\\Milionare\\PlayerMoves.xml";

    protected synchronized Optional<OnePlayerMove> getLastGameMove() {

        if(isFileAccessInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        isFileAccessInProgress = true;

        List<OnePlayerMove> allGameMoves = getAllGameMoves();
        //AllPlayerMoves allGameMoves = new AllPlayerMoves();

        Optional<OnePlayerMove> lastGameMoveOptional = Optional.empty();

        if(!allGameMoves.isEmpty()){
            lastGameMoveOptional = Optional.of(allGameMoves.get(allGameMoves.size() - 1));
        }

        isFileAccessInProgress = false;

        notifyAll();

        return lastGameMoveOptional;
    }

    @Override
    public synchronized void saveNewGameMove(OnePlayerMove onePlayerMove) {

        if(isFileAccessInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        isFileAccessInProgress = true;

        List<OnePlayerMove> allGameMoves = getAllGameMoves();
        allGameMoves.add(onePlayerMove);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GAME_MOVES_FILE))) {
            oos.writeObject(allGameMoves);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        isFileAccessInProgress = false;

        notifyAll();
    }

    @Override
    public synchronized List<OnePlayerMove> getAllGameMoves() {
        List<OnePlayerMove> gameMoveList = new ArrayList<>();

        if(Files.exists(Path.of(GAME_MOVES_FILE))) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GAME_MOVES_FILE))) {
                gameMoveList.addAll((List<OnePlayerMove>) ois.readObject());
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        return gameMoveList;
    }



}
