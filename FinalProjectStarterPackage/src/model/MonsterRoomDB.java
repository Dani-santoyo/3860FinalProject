package model;

import controller.GameException;
import controller.MonsterRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class : MonsterRoomDB.java
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: June 22, 2021
 * Purpose: Manage database interactions for the MonsterRoom association table
 */
public class MonsterRoomDB {
    /**
     * Method: getMonster
     * Purpose: get the monster from a specific room
     * @param roomID
     * @return MonsterRoom
     * @throws SQLException
     */
    public MonsterRoom getMonster(int roomID) throws GameException {
        MonsterRoom mr = new MonsterRoom();
        String sql = "SELECT DISTINCT m.monsterNumber, m.monsterName, m.monsterDescription, m.hitPoints, "
                + " m.maxDamage, m.minDamage, r.roomNumber, r.roomName, r.roomDescription FROM Monster m, room r" +
                " INNER JOIN MonsterRoom mr on mr.monsterNumber = m.monsterNumber where r.roomNumber = " + roomID + " ORDER BY mr.monsterNumber";
        try {
            SQLiteDB sdb = new SQLiteDB();
            ResultSet rs = sdb.queryDB(sql);
            if (rs.next()) {
                mr = parseDBData(rs);
            }
            else {
                throw new GameException("No monster was found in room " + roomID);
            }
            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new GameException("There was a problem reading the DB. Cannot display this monster.");
        }
        return mr;
    }

    private MonsterRoom parseDBData(ResultSet rs) throws SQLException {
        MonsterRoom mr = new MonsterRoom();
        mr.setMonsterNumber(rs.getInt("monsterNumber"));
        mr.setMonsterName(rs.getString("monsterName"));
        mr.setMonsterDescription(rs.getString("monsterDescription"));
        mr.setHitPoints(rs.getInt("hitPoints"));
        mr.setMaxDamage(rs.getInt("maxDamage"));
        mr.setMinDamage(rs.getInt("minDamage"));
        mr.setRoomNumber(rs.getInt("roomNumber"));
        mr.setRoomName(rs.getString("roomName"));
        mr.setRoomDescription(rs.getString("roomDescription"));
        return mr;
    }

    /**
     * Method: getAllMonsters
     * Purpose: get the list of all monsters and their rooms
     * @return ArrayList<Monster>
     * @throws GameException
     */
    public ArrayList<MonsterRoom> getAllMonsters() throws GameException {
        ArrayList<MonsterRoom> monsterRooms = new ArrayList<MonsterRoom>();
        String sql = "SELECT DISTINCT Monster.monsterNumber, Monster.monsterName, Monster.monsterDescription, Monster.hitPoints, "
                + " Monster.maxDamage, Monster.minDamage, Room.roomNumber, Room.roomName, Room.roomDescription FROM MonsterRoom " +
                "INNER JOIN Room ON MonsterRoom.roomNumber = Room.roomNumber " +
                " INNER JOIN Monster on MonsterRoom.monsterNumber = Monster.monsterNumber";
        try {
            SQLiteDB sdb = new SQLiteDB();
            ResultSet rs = sdb.queryDB(sql);
            if (rs == null) {
                throw new GameException("No monsters found");
            }
            while (rs.next()) {
                MonsterRoom mr = parseDBData(rs);
                monsterRooms.add(mr);
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new GameException("An error occurred while addressing the DB.");
        }
        return monsterRooms;
    }
}
