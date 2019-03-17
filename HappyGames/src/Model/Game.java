/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
public class Game extends BaseModel{
    
    private String name;
    private GameType type;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }
}
