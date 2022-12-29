package database;

import config.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Publicacion;

public class PublicacionDAO {
    
    private Connection connection;
    
    public PublicacionDAO(){
        DBConn conn = new DBConn();
        String DB = "motos";
        String userDB = "root";
        String passDB = "admin123";
        connection = conn.getConnection(DB, userDB, passDB);
    }
    
    public int createPub(Publicacion p) throws SQLException {
                        
        PreparedStatement ps;
        int lineasAfectadas;
        
        String pQuery = "INSERT INTO publicaciones (username, descripcion, cilindrada, modelo, urlfoto, signup_date)"
                + " VALUES(?, ?, ?, ?, ?, sysdate());";
        
        ps = connection.prepareStatement(pQuery);        
        ps.setString(1, p.getUserName());
        ps.setString(2,p.getDescripcion());
        ps.setString(3, p.getCilindrada());
        ps.setString(4, p.getModelo());
        ps.setString(5, p.getUrlfoto());                         
        
        lineasAfectadas = ps.executeUpdate();
        
        return lineasAfectadas;
    }
    
     public Publicacion getPubByUsernameModeloCilindrada(String username, String modelo, String cilindrada) throws SQLException {
        
        PreparedStatement ps;
        ResultSet rs;
        Publicacion p = null;

        ps = connection.prepareStatement("SELECT * FROM publicaciones WHERE username = ? AND modelo = ? AND cilindrada = ?");
        ps.setString(1, username);
        ps.setString(2,modelo);
        ps.setString(3, cilindrada);

        rs = ps.executeQuery();

        if(rs.next()) {
            String userEncontrado = rs.getString("username");
            String modEncontrado = rs.getString("modelo");
            String desEncontrado = rs.getString("descripcion");
            String cilEncontrado = rs.getString("cilindrada");
            String urlEncontrado = rs.getString("urlfoto");

            p = new Publicacion(userEncontrado, modEncontrado, desEncontrado, cilEncontrado, urlEncontrado);
            
        }
        
        return p;
    }
    
    public ArrayList<Publicacion> getPubs() throws SQLException {
               
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        ps = connection.prepareStatement("SELECT * FROM publicaciones;");                 
        rs = ps.executeQuery();

        while(rs.next()){
            String username = rs.getString("username");
            String modelo = rs.getString("modelo");
            String descripcion = rs.getString("descripcion");
            String cilindrada = rs.getString("cilindrada");
            String urlfoto = rs.getString("urlfoto");                   
            publicaciones.add(new Publicacion(username, descripcion, cilindrada, modelo, urlfoto));
            System.out.println("publicaciones");
        }
        return publicaciones;
    }
    
    public ArrayList<Publicacion> getPubsByUsername(String user) throws SQLException {
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Publicacion p;

        ps = connection.prepareStatement("SELECT * FROM publicaciones WHERE username = ?");
        ps.setString(1, user);

        rs = ps.executeQuery();

        while(rs.next()) {
            String username = rs.getString("username");
            String modelo = rs.getString("modelo");
            String descripcion = rs.getString("descripcion");
            String cilindrada = rs.getString("cilindrada");
            String urlfoto = rs.getString("urlfoto");

            p = new Publicacion(username, descripcion, cilindrada, modelo, urlfoto);
            publicaciones.add(p);
        }
        return publicaciones;
    }
//    
//       
//    public int updatePub(Publicacion p) throws SQLException {
//        PreparedStatement ps;
//        int lineasAfectadas;
//        
//        String pQuery = "UPDATE publicaciones SET modelo = ?, descripcion = ?, cilindrada = ?, urlfoto = ?"
//                + " WHERE username = ?;";
//        ps = connection.prepareStatement(pQuery);
//        
//        ps.setString(1, p.getModelo());
//        ps.setString(2, p.getDescripcion());
//        ps.setString(3, p.getCilindrada());
//        ps.setString(4, p.getUrlfoto());
//                 
//        lineasAfectadas = ps.executeUpdate();
//        return lineasAfectadas;
//    }
//    
//    public int deletePub(String username,String modelo) throws SQLException {
//        PreparedStatement ps;
//        int lineasAfectadas;
//        
//        String pQuery = "DELETE FROM publicaciones WHERE username = ? AND modelo =?;";
//        ps = connection.prepareStatement(pQuery);
//        
//        ps.setString(1, username);
//        ps.setString(2,modelo);
//        lineasAfectadas = ps.executeUpdate();
//        return lineasAfectadas;
//    }   
}
