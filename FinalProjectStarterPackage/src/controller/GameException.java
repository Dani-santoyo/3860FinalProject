package controller;

import java.io.IOException;

public class GameException extends IOException {
    public GameException() {
    }

    public GameException(String message) {
        super(message);
    }
}
