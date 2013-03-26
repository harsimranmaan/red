/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

/**
 *
 * @author Witt
 */
public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    private String userSelect = null;

    public String getUserSelect() {
        return userSelect;
    }

    public void setUserSelect(String userSelect) {
        this.userSelect = userSelect;
    }
    
}
