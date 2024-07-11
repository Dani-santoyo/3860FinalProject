package controller;

import model.GameDBCreate;

import java.sql.SQLException;

/**
 * Class : CreateFilesController.java
 * @author: Rick Price
 * @version: 2.0
 * Course: ITEC 3860
 * Written: September 12, 2022
 * This class calls into the model to build the database if it doesn't exist.
 */


public class CreateFilesController {

    /**
     * Method: createFile
     * Purpose: Create the database for GameDB
     * @return void
     */
    public void createFile() throws GameException, SQLException, ClassNotFoundException {
        GameDBCreate sdb = new GameDBCreate();
        sdb.buildTables();
    }
    /**
     * Method: createFile
     * Purpose: Create the database for GameDB
     * @return void
     */
    public void createFile(String dbName) throws GameException, SQLException, ClassNotFoundException {
        GameDBCreate sdb = new GameDBCreate(dbName);
        sdb.buildTables();
    }
}


