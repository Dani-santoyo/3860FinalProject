import controller.GameController;
import controller.GameException;
import view.ConsoleUI;

import java.sql.SQLException;

public class GameStart {

    public static void main(String[] args) {
        boolean valid = true;
        GameController gc = new GameController();
        try {
            gc.start();
        } catch (GameException ge) {
            valid = false;
            System.out.println(ge.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (valid) {

            ConsoleUI cui = new ConsoleUI();
            cui.startGame();
            System.exit(0);
        }
    }
}
