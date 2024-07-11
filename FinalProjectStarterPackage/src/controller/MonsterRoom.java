package controller;

import model.MonsterRoomDB;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class : MonsterRoom.java
 * @author: Rick Price
 * @version: 1.1
 * Course: ITEC 3860
 * Written: October 9, 2021
 * Purpose: Provide the logic for the association table mapping monsters to rooms.
 */
public class MonsterRoom {
    private Monster monster;
    private Room room;

    public MonsterRoom() {
        monster = new Monster();
        room = new Room();
    }

    /**
     * Method: getMonster
     * Purpose: Get the monster in a specific room
     * @param roomID
     * @return MonsterRoom
     * @throws SQLException
     */
    public MonsterRoom getMonster(int roomID) throws GameException {
        MonsterRoomDB mdb = new MonsterRoomDB();
        return mdb.getMonster(roomID);
    }

    /**
     * Method: getAllMonsters
     * Purpose: gets all mosters and their associated rooms
     * @return ArrayList<MonsterRoom>
     * @throws SQLException
     */
    public ArrayList<MonsterRoom> getAllMonsters() throws GameException {
        MonsterRoomDB mdb = new MonsterRoomDB();
        return mdb.getAllMonsters();
    }

    /**
     * Method: getMonsterNumber
     * @return the monsterNumber
     */
    public int getMonsterNumber() {
        return monster.getMonsterID();
    }

    /**
     * Method: setMonsterNumber
     * @param monsterNumber the monsterNumber to set
     */
    public void setMonsterNumber(int monsterNumber) {
        this.monster.setMonsterID(monsterNumber);
    }

    /**
     * Method: getMonsterName
     * @return the monsterName
     */
    public String getMonsterName() {
        return monster.getMonsterName();
    }

    /**
     * Method: setMonsterName
     * @param monsterName the monsterName to set
     */
    public void setMonsterName(String monsterName) {
        this.monster.setMonsterName(monsterName);
    }

    /**
     * Method: getMonsterDescription
     * @return the monsterDescription
     */
    public String getMonsterDescription() {
        return monster.getMonsterDescription();
    }

    /**
     * Method: setMonsterDescription
     * @param monsterDescription the monsterDescription to set
     */
    public void setMonsterDescription(String monsterDescription) {
        this.monster.setMonsterDescription(monsterDescription);
    }

    /**
     * Method: getHitPoints
     * @return the hitPoints
     */
    public int getHitPoints() {
        return monster.getHitPoints();
    }

    /**
     * Method: setHitPoints
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        this.monster.setHitPoints(hitPoints);
    }

    /**
     * Method: getMaxDamage
     * @return the maxDamage
     */
    public int getMaxDamage() {
        return monster.getMaxDamage();
    }

    /**
     * Method: setMaxDamage
     * @param maxDamage the maxDamage to set
     */
    public void setMaxDamage(int maxDamage) {
        this.monster.setMaxDamage(maxDamage);
    }

    /**
     * Method: getMinDamage
     * @return the minDamage
     */
    public int getMinDamage() {
        return monster.getMinDamage();
    }

    /**
     * Method: setMinDamage
     * @param minDamage the minDamage to set
     */
    public void setMinDamage(int minDamage) {
        this.monster.setMinDamage(minDamage);
    }

    /**
     * Method: getRoomNumber
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return room.getRoomID();
    }

    /**
     * Method: setRoomNumber
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {room.setRoomID(roomNumber);
    }

    /**
     * Method: getRoomName
     * @return the roomName
     */
    public String getRoomName() {
        return room.getRoomName();
    }

    /**
     * Method: setRoomName
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        room.setRoomName(roomName);
    }

    /**
     * Method: getRoomDescription
     * @return the roomDescription
     */
    public String getRoomDescription() {
        return room.getRoomDescription();
    }

    /**
     * Method: setRoomDescription
     * @param roomDescription the roomDescription to set
     */
    public void setRoomDescription(String roomDescription) {
        this.room.setRoomDescription(roomDescription);
    }

    /**
     * Method: toString
     * Purpose: Returns a String representation of the MonsterRoom data.
     * @return String
     */
    @Override
    public String toString() {
        return "MonsterRoom,  monster ID = " + monster.getMonsterID() + ", monsterName = " + monster.getMonsterName() + "\n monster description = "
                + monster.getMonsterDescription() + "\nwith hit points = " + monster.getHitPoints()+ " causing max damage = " + monster.getMaxDamage() +
                " and min damage = " + monster.getMinDamage() + ".\nIs in room number = " + room.getRoomID() + ", room name = " + room.getRoomName() +
                ", room description = " + room.getRoomDescription();
    }
}
