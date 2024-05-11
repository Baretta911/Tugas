/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOImple.datamovieimplement;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dhimas
 */
public class datamovieDAO implements datamovieimplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, akting, penokohan,nilai) VALUES (?, ?, ?, ?,?)";
    final String update = "UPDATE movie set  alur=?, akting=?, penokohan=?, nilai=? where judul=?";
    final String delete = "DELETE from movie where judul=?";
    public datamovieDAO(){
        connection = connector.connection();
        
    }

    @Override
    public void insert(datamovie m) {
     PreparedStatement statement = null;
        try {
            double nilai = (m.getAlur() + m.getAkting() + m.getPenokohan())/3.0;    
            statement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getAkting());
            statement.setDouble(4, m.getPenokohan());
            statement.setDouble(5, nilai);
            statement.executeUpdate();
            ResultSet re = statement.getGeneratedKeys();
            while(re.next()){
                m.setJudul(re.getString(1));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datamovie m) {
         PreparedStatement statement = null;
        try {
            double nilai = (m.getAlur() + m.getAkting() + m.getPenokohan())/3.0;    
            statement = connection.prepareStatement(update, statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, m.getAlur());
            statement.setDouble(2, m.getAkting());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, nilai);
            statement.setString(5, m.getJudul());
            statement.executeUpdate();
            ResultSet re = statement.getGeneratedKeys();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
    }
@Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try { 
            statement = connection.prepareStatement(delete, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, judul);
            statement.executeUpdate();
            ResultSet re = statement.getGeneratedKeys();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datamovie> getALL() {
        List<datamovie> dm = null;
        try{
            dm = new ArrayList<datamovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                datamovie movie = new datamovie ();
                movie.setJudul(rs.getString("judul"));
                movie.setAlur(rs.getDouble("alur"));
                movie.setAkting(rs.getDouble("akting"));
                movie.setPenokohan(rs.getDouble("penokohan"));
                movie.setNilai(rs.getDouble("nilai"));
                dm.add(movie);
            }
        }catch(SQLException ex){
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dm;
    }

    
    
}
