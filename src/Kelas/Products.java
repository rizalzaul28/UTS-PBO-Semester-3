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
public class Products {
    
    int produk_id, produk_price, produk_card_id;
    String produk_name, produk_desc;
    
    private Connection          conn;
    private PreparedStatement   ps;
    private Statement           st;
    private ResultSet           rs;
    private String              query;
    
    public Products() throws SQLException{
        Koneksi koneksi = new Koneksi();
        conn = koneksi.koneksiDB();
    }

    public int getProduk_id() {
        return produk_id;
    }

    public void setProduk_id(int produk_id) {
        this.produk_id = produk_id;
    }

    public int getProduk_price() {
        return produk_price;
    }

    public void setProduk_price(int produk_price) {
        this.produk_price = produk_price;
    }

    public int getProduk_card_id() {
        return produk_card_id;
    }

    public void setProduk_card_id(int produk_card_id) {
        this.produk_card_id = produk_card_id;
    }

    public String getProduk_name() {
        return produk_name;
    }

    public void setProduk_name(String produk_name) {
        this.produk_name = produk_name;
    }

    public String getProduk_desc() {
        return produk_desc;
    }

    public void setProduk_desc(String produk_desc) {
        this.produk_desc = produk_desc;
    }
    
    public void TambahProducts(){
        query = "INSERT INTO products VALUES (?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, produk_id);
            ps.setString(2, produk_name);
            ps.setString(3, produk_desc);
            ps.setInt(4, produk_price);
            ps.setInt(5, produk_card_id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Produk Berhasil Ditambahkan!");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Produk Gagal Ditambahkan!!!");
        } 
    }
    
    public void HapusProducts() {
    
        query = "DELETE FROM products WHERE produk_id = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, produk_id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Produk Berhasil Di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produk Gagal Di Hapus!");
        }
        
    }
    
    public void UbahProduk(){
                query = "UPDATE products SET produk_name = ?,"
                    + " produk_desc = ?,"
                    + " produk_price = ?,"
                    + " produk_card_id = ?"
                    + " WHERE produk_id = ?";
                
                try {
                ps = conn.prepareStatement(query);
                
                ps.setString(1, produk_name);
                ps.setString(2, produk_desc);
                ps.setInt(3, produk_price);
                ps.setInt(4, produk_card_id);
                ps.setInt(5, produk_id);
                
                
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Produk Berhasil Di Ubah");
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(null, "Produk Gagal Di Ubah");
            }
                
        }
    
    public ResultSet TampilProduk() {
    query = "SELECT " +
            " p.produk_id," +
            " p.produk_name," +
            " p.produk_desc," +
            " p.produk_price," +
            " c.category_name" +
            " FROM" +
            " products p" +
            " JOIN" +
            " category c ON p.produk_card_id = c.category_id;";
    
    try {
        st = conn.createStatement();
        rs = st.executeQuery(query);
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data gagal ditampilkan!");
    }
    
    return rs;
    }
    
    public int autoID() {
    int newID = 1;
    
    try {
       
        String query = "SELECT MAX(produk_id) AS max_id FROM products";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        if (rs.next()) {
            int lastID = rs.getInt("max_id");
            newID = lastID + 1;
        }
        
        rs.close();
        st.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menghasilkan ID baru!");
    }

    return newID;
    }
    
    public ResultSet Tampil_CbCategory() {
        
        try {
            query = "SELECT category_name FROM category";
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }
    
        return rs;
    
    }
    
    public int konversi(String categoryName) throws SQLException {
        
        int category_id = -1;
        query = "SELECT category_id FROM category WHERE category_name = ?";
    
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, categoryName);
        ResultSet rs = ps.executeQuery();
    
        if (rs.next()) {
        category_id = rs.getInt("category_id");
        }
    
        rs.close();
        ps.close();
        return category_id;
    }
    
}
