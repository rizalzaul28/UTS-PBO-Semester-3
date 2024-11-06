/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Kelas.Products;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MysticWave
 */
public class FrameProducts extends javax.swing.JFrame {

    /**
     * Creates new form FrameProducts
     */
    public FrameProducts() throws SQLException {
        initComponents();
        loadTabel();
        reset();
        cbCategory();
        autoId();
    }
    
    void loadTabel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Produk ID");
        model.addColumn("Produk Name");
        model.addColumn("Produk DESC");
        model.addColumn("Produk Harga");
        model.addColumn("Produk Kategori");

        try {
            Products pro = new Products();
            ResultSet data = pro.TampilProduk();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getInt("produk_id"),
                    data.getString("produk_name"),
                    data.getString("produk_desc"),
                    data.getInt("produk_price"),
                    data.getString("category_name")
                });
            }
        } catch (SQLException sQLException) {
        }

        tb_Produk.setModel(model);
        }
    
    void reset(){
            tf_Id.setText("");
            tf_Nama.setText("");
            tf_Desc.setText("");
            tf_Harga.setText("");
            cb_Id.setSelectedItem("");
            
            tf_Id.setEditable(true);
        }
    
    void cbCategory() {
        
            try {
            Products cb = new Products();
            ResultSet data = cb.Tampil_CbCategory();

            while (data.next()) {
                cb_Id.addItem(data.getString("category_name"));
            }
            cb_Id.setSelectedItem(null);

        } catch (Exception e) {
            e.printStackTrace();
        }            
        }

    private void autoId() throws SQLException {
            Products produc = new Products();
            int newID = produc.autoID();
            tf_Id.setText(String.valueOf(newID));
            tf_Id.setEditable(false);
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_Id = new javax.swing.JTextField();
        tf_Nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_Desc = new javax.swing.JTextArea();
        tf_Harga = new javax.swing.JTextField();
        cb_Id = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Produk = new javax.swing.JTable();
        bt_Tambah = new javax.swing.JButton();
        bt_Ubah = new javax.swing.JButton();
        bt_Hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM PRODUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setText("Id Produk");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setText("Nama Produk");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setText("Deskripsi Produk");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setText("Harga Produk");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setText("Kartu Id Produk");

        tf_Id.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        tf_Nama.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        tf_Desc.setColumns(20);
        tf_Desc.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tf_Desc.setRows(5);
        jScrollPane1.setViewportView(tf_Desc);

        tf_Harga.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tf_Harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_HargaKeyTyped(evt);
            }
        });

        cb_Id.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        tb_Produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_Produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ProdukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Produk);

        bt_Tambah.setBackground(new java.awt.Color(0, 0, 153));
        bt_Tambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Tambah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Tambah.setText("Tambah");
        bt_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TambahActionPerformed(evt);
            }
        });

        bt_Ubah.setBackground(new java.awt.Color(0, 204, 0));
        bt_Ubah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Ubah.setForeground(new java.awt.Color(255, 255, 255));
        bt_Ubah.setText("Ubah");
        bt_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UbahActionPerformed(evt);
            }
        });

        bt_Hapus.setBackground(new java.awt.Color(204, 0, 0));
        bt_Hapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Hapus.setForeground(new java.awt.Color(255, 255, 255));
        bt_Hapus.setText("Hapus");
        bt_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_Hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Tambah)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cb_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Tambah)
                            .addComponent(bt_Ubah)
                            .addComponent(bt_Hapus)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(869, 554));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_TambahActionPerformed
       try {
            Products products = new Products();
            products.setProduk_id(Integer.parseInt(tf_Id.getText()));
            products.setProduk_name(tf_Nama.getText());
            products.setProduk_desc(tf_Desc.getText());
            products.setProduk_price(Integer.parseInt(tf_Harga.getText()));
            
            String selectedCategoryName = cb_Id.getSelectedItem().toString();
            int categoryId = products.konversi(selectedCategoryName);
            products.setProduk_card_id(categoryId);
            
            products.TambahProducts();
        } catch (SQLException sQLException) {
        }
        loadTabel();
        reset();
        try {
            autoId();
        } catch (SQLException ex) {
            Logger.getLogger(FrameProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_TambahActionPerformed

    private void bt_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UbahActionPerformed
        try {
            Products prod = new Products();
            prod.setProduk_id(Integer.parseInt(tf_Id.getText()));
            prod.setProduk_name(tf_Nama.getText());
            prod.setProduk_id(Integer.parseInt(tf_Id.getText()));
            prod.setProduk_name(tf_Nama.getText());
            prod.setProduk_desc(tf_Desc.getText());
            prod.setProduk_price(Integer.parseInt(tf_Harga.getText()));
            String selectedCategoryName = cb_Id.getSelectedItem().toString();
            int categoryId = prod.konversi(selectedCategoryName);
            prod.setProduk_card_id(categoryId);
            
            prod.UbahProduk();
        } catch (SQLException sQLException) {
        }
        loadTabel();
        reset();
        try {
            autoId();
        } catch (SQLException ex) {
            Logger.getLogger(FrameProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_UbahActionPerformed

    private void bt_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HapusActionPerformed
        try {
            Products prd = new Products();
            prd.setProduk_id(Integer.parseInt(tf_Id.getText()));
            prd.HapusProducts();
        } catch (SQLException sQLException) {
        }
        loadTabel();
        reset();
        try {
            autoId();
        } catch (SQLException ex) {
            Logger.getLogger(FrameProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_HapusActionPerformed

    private void tb_ProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdukMouseClicked
        int baris = tb_Produk.rowAtPoint(evt.getPoint());
        String Id = tb_Produk.getValueAt(baris, 0).toString();
        String Nama = tb_Produk.getValueAt(baris, 1).toString();
        String Desc = tb_Produk.getValueAt(baris, 2).toString();
        String Harga = tb_Produk.getValueAt(baris, 3).toString();
        String CardId = tb_Produk.getValueAt(baris, 4).toString();
        
        tf_Id.setText(Id);
        tf_Nama.setText(Nama);
        tf_Desc.setText(Desc);
        tf_Harga.setText(Harga);
        cb_Id.setSelectedItem(CardId);
        
        tf_Id.setEditable(false);
    }//GEN-LAST:event_tb_ProdukMouseClicked

    private void tf_HargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_HargaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())){
        evt.consume();
    }
    }//GEN-LAST:event_tf_HargaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 20);
            UIManager.put("Component.focusWidth", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameProducts().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrameProducts.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Hapus;
    private javax.swing.JButton bt_Tambah;
    private javax.swing.JButton bt_Ubah;
    private javax.swing.JComboBox<String> cb_Id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_Produk;
    private javax.swing.JTextArea tf_Desc;
    private javax.swing.JTextField tf_Harga;
    private javax.swing.JTextField tf_Id;
    private javax.swing.JTextField tf_Nama;
    // End of variables declaration//GEN-END:variables
}
