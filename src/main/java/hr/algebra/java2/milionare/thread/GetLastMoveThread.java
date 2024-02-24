package hr.algebra.java2.milionare.thread;

import hr.algebra.java2.milionare.model.OnePlayerMove;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Optional;

public class GetLastMoveThread extends GameMoveThread implements Runnable {

    private Label lastGameMoveLabel;

    public GetLastMoveThread(Label lastGameMoveLabel) {
        this.lastGameMoveLabel = lastGameMoveLabel;
    }

    @Override
    public void run() {

        while(true) {
            Optional<OnePlayerMove> lastGameMoveOptional = getLastGameMove();

            if(lastGameMoveOptional.isPresent()) {
                Platform.runLater(() -> {
                    lastGameMoveLabel.setText("The last game move: "
                            + lastGameMoveOptional.get().toString());
                });
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
