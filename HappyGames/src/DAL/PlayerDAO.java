/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Player;
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
public class PlayerDAO extends BaseDAO<Player>{

    @Override
    // Allow user to change password only
    public void update(Player model) {
        String sql = "UPDATE Player SET password = ? WHERE ID =?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,model.getPassword());
            statement.setInt(2, model.getID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 //delete user from database
    @Override
    public void delete(Player model) {
        String sql = "DELETE FROM Player WHERE ID =?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    //when user register to web, set point to 0
    public void insert(Player model) {
        String sql = "INSERT INTO Player VALUES (?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, model.getUsername());
            statement.setString(1, model.getPassword());
            statement.setInt(1, 0);
            statement.setInt(1, model.getAge());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

 ///when user log in
    public Player get(String xName) {
        String sql = "SELECT * FROM [Player] WHERE username = ?" ;
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, xName);
            ResultSet rs = statement.executeQuery();
            Player m = new Player();
            while(rs.next()) {
                m.setID(rs.getInt("ID"));
                m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password"));
                m.setPoint(rs.getInt("point"));
                m.setAge(rs.getInt("age"));
            }
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Player> all() {
        ArrayList<Player> players = new ArrayList<>();
        String sql="SELECT * FROM Player";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Player m = new Player();
                m.setID(rs.getInt("ID"));
                m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password"));
                m.setPoint(rs.getInt("point"));
                m.setAge(rs.getInt("age"));
                players.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return players;
    }

    @Override
    public Player get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
