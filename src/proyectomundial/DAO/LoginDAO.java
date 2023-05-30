/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomundial.DAO;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proyectomundial.model.Seleccion;
import proyectomundial.util.BasedeDatos;

/**
 *
 * @author usuario
 */
public class LoginDAO {

    public LoginDAO() {
        BasedeDatos.conectar();
    }

    public boolean consultarLogin(String usuario, String contraseña) {
        System.out.println("1");
            String sql = "select * from poo.users u where username = '" + usuario + "' and \"password\" =  '"+contraseña+"';";
            System.out.println("2");
        try {
            ResultSet comprobar = BasedeDatos.ejecutarSQL(sql);
            System.out.println("3");
            if (comprobar != null) {
                while(comprobar.next()) {
                    return true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Fallo en conexion login");
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
