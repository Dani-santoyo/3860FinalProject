package controller;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class : GameController.java
 * @author: Rick Price
 * @version: 1.3
 * Course: ITEC 3860
 * Written: September 12, 2022
 * This class is the main controller for the DB Demo program.
 * Will hold utility functions as well as central functionality
 */
public class GameController {

    public void start() throws GameException, SQLException, ClassNotFoundException {
        File dbFile = new File("Game.db");
        if (!dbFile.exists()) {
            CreateFilesController cfc = new CreateFilesController();
            cfc.createFile("Game.db");
        }
     }

    /**
     * Method: getRoomData
     * Purpose: gets room data and returns a String containing it
     * @return String
     * @throws SQLException
     */
    public String getRoomData(int roomNumber) throws SQLException, ClassNotFoundException {
        Room rm = new Room();
        rm = rm.getRoom(roomNumber);
        return rm.toString();
    }

    /**
     * Method: getAllRoomsData
     * Purpose: Gets all rooms and returns an ArrayList<String> of all of the rooms
     * @return ArrayList<String>
     * @throws SQLException
     */
    public ArrayList<String> getAllRoomsData() throws SQLException, ClassNotFoundException {
        ArrayList<Room> rooms = null;
        Room rm = new Room();
        rooms = rm.getAllRooms();
        ArrayList<String> roomStrs = new ArrayList<String>();
        for (Room room : rooms) {
            roomStrs.add(room.toString());
        }
        return roomStrs;
    }

    /**
     * Method: getMonsterData
     * Purpose: gets Monster data and returns a String containing it
     * @return String
     * @throws SQLException
     */
    public String getMonsterData(int monsterNumber) throws SQLException, ClassNotFoundException {
        Monster mon = new Monster();
        mon = mon.getMonster(monsterNumber);
        return mon.toString();
    }

    /**
     * Method: getAllMonstersData
     * Purpose: Get all of the monster data from the DB
     * @return ArrayList<String>
     * @throws SQLException
     */
    public ArrayList<String> getAllMonstersData() throws SQLException, ClassNotFoundException {
        Monster mon = new Monster();
        ArrayList<Monster> monsters = null;
        monsters = mon.getAllMonsters();
        ArrayList<String> monstersStr = new ArrayList<String>();
        for (Monster monster : monsters) {
            monstersStr.add(monster.toString());
        }
        return monstersStr;
    }

    /**
     * Method: getMonsterRoomData
     * Purpose: Gets the monster and room for the specified room and displays list of monsters in specified rooms
     * @return void
     *
     * @throws SQLException
     */
    public String getMonsterRoomData(int monsterRoomNumber) throws GameException {
        MonsterRoom mr = new MonsterRoom();
        mr = mr.getMonster(monsterRoomNumber);
        return mr.toString();
    }

    /**
     * Method: getAllMonsterRoomData
     * Purpose: Get all of the monster and room data.  Joins these two tables.
     * @return ArrayList<String>
     * @throws SQLException
     */
    public ArrayList<String> getAllMonsterRoomData() throws GameException {
        MonsterRoom mr = new MonsterRoom();
        ArrayList<MonsterRoom> monsterRooms = null;
        monsterRooms = mr.getAllMonsters();
        ArrayList<String> mrStrs = new ArrayList<String>();
        for (MonsterRoom monsterRoom : monsterRooms) {
            mrStrs.add(monsterRoom.toString());
        }
        return mrStrs;
    }
}
