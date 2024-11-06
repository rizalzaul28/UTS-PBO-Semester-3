/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MysticWave
 */
public class Category {
    
    int category_id;
    String category_name;
    
    private Connection          conn;
    private PreparedStatement   ps;
    private Statement           st;
    private ResultSet           rs;
    private String              query;
    
    public Category() throws SQLException{
        Koneksi koneksi = new Koneksi();
        conn = koneksi.koneksiDB();
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
    
    public void TambahCategory(){
        query = "INSERT INTO category VALUES (?,?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, category_id);
            ps.setString(2, category_name);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Kategori Berhasil Ditambahkan!");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Kategori Gagal Ditambahkan!!!");
        } 
    }

    public void HapusCategory() {
    
        query = "DELETE FROM category WHERE category_id = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, category_id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Category Berhasil Di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Category Gagal Di Hapus!");
        }
        
    }
    
    public void UbahCategory(){
                query = "UPDATE category SET category_name = ?"
                    + " WHERE category_id = ?";
                
                try {
                ps = conn.prepareStatement(query);
                
                ps.setString(1, category_name);
                ps.setInt(2, category_id);
                
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Category Berhasil Di Ubah");
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(null, "Category Gagal Di Ubah");
            }
                
        }
    
    public ResultSet TampilCategory() {
        query = "SELECT * FROM category";
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan!");
        }
        
        return rs;
    }
    
    public int AutoId(){
        int newID =1;
        
        try {
            String query = "SELECT MAX(category_id) AS max_id FROM category";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()) {
                int lastID = rs.getInt("max_id");
                newID = lastID + 1;
            }
        } catch (SQLException sQLException) {
        }
        return newID;
    }
    
}
