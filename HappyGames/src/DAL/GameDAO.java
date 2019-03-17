/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Game;
import Model.GameType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class GameDAO extends BaseDAO<Game>{

    @Override
    public void update(Game model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Game model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Game model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Game get(int id) {
        String sql ="SELECT g.ID, g.Name as GameName, gt.ID as TypeID .gt.Name as TypeName"
                + " FROM GAME as g, GameType as gt "
                + "WHERE ID=? AND Game.TypeID = GaneType.ID";
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Game x = new Game();
                x.setID(id);
                x.setName(rs.getString("Name"));
                GameType gt = new GameType();
                gt.setID(rs.getInt("TypeID"));
                gt.setName(rs.getString("TypeName"));
                x.setType(gt);
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Game> all() {
        ArrayList<Game> games = new ArrayList<>();
        String sql = "SELECT g.ID, g.Name as GameName, gt.ID as TypeID .gt.Name as TypeName"
                + " FROM GAME as g, GameType as gt "
                + "WHERE Game.TypeID = GaneType.ID";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Game x = new Game();
                x.setID(rs.getInt("ID"));
                x.setName(rs.getString("GameName"));
                GameType gt = new GameType();
                gt.setID(rs.getInt("TypeID"));
                gt.setName(rs.getString("TypeName"));
                x.setType(gt);
                games.add(x);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return games;
    }
    
}
