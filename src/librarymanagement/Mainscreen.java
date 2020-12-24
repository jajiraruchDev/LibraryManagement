/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static librarymanagement.library.getConnection;

/**
 *
 * @author Phanasorn's PC
 */
public class Mainscreen extends javax.swing.JFrame {

    /**
     * Creates new form Mainscreen
     */
    public Mainscreen() {
        initComponents();
        getConnection();
        getBookList();
    }
    
    
    
  
    
    public final void getBookList()
   {
       String query = "SELECT * FROM  `book` ";
       Statement st;
       ResultSet rs;
       DefaultTableModel table = (DefaultTableModel)jtable.getModel();

       try {
           st = getConnection().createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next())
           {
               String ISBN = rs.getString("ISBN");
               String Book = rs.getString("Book");
               String Author = rs.getString("Author");
               String Edition = rs.getString("Edition");
               String Publication = rs.getString("Publication");
               
               
               String BookData[] = {ISBN, Book, Author, Edition, Publication};
                  //DefaultTableModel table = (DefaultTableModel)jtable.getModel();
                  
                  table.addRow(BookData);
           }
       } catch (SQLException e) {
           
       }
       
   }
    
   public void searchQuery(){
       
       Statement st;
       ResultSet rs;
       String searchKey = txtSearch.getText();
       DefaultTableModel table = (DefaultTableModel)jtable.getModel();
       if(radISBN.isSelected()){
           try {
           st = getConnection().createStatement();
           rs = st.executeQuery("SELECT * FROM `book` WHERE `ISBN` LIKE '"+ searchKey +"'");
           
           while(rs.next())
           {
               String ISBN = rs.getString("ISBN");
               String Book = rs.getString("Book");
               String Author = rs.getString("Author");
               String Edition = rs.getString("Edition");
               String Publication = rs.getString("Publication");
               
               table.setRowCount(0);
               String BookData[] = {ISBN, Book, Author, Edition, Publication};
                  //DefaultTableModel table = (DefaultTableModel)jtable.getModel();
                  
                  table.addRow(BookData);
           }
       } catch (SQLException e) {
           
       }
       }
       else if(radBookName.isSelected() && !txtSearch.equals("")){
           try {
           st = getConnection().createStatement();
           rs = st.executeQuery("SELECT * FROM `book` WHERE `book` LIKE '"+ searchKey +"'");
           
           while(rs.next())
           {
               String ISBN = rs.getString("ISBN");
               String Book = rs.getString("Book");
               String Author = rs.getString("Author");
               String Edition = rs.getString("Edition");
               String Publication = rs.getString("Publication");
               
               table.setRowCount(0);
               String BookData[] = {ISBN, Book, Author, Edition, Publication};
                  //DefaultTableModel table = (DefaultTableModel)jtable.getModel();
                  
                  table.addRow(BookData);
           }
       } catch (SQLException e) {
           
       }
       }
       else if(radAuthor.isSelected()){
           try {
           st = getConnection().createStatement();
           rs = st.executeQuery("SELECT * FROM `book` WHERE `Author` LIKE '"+ searchKey +"'");
           
           while(rs.next())
           {
               String ISBN = rs.getString("ISBN");
               String Book = rs.getString("Book");
               String Author = rs.getString("Author");
               String Edition = rs.getString("Edition");
               String Publication = rs.getString("Publication");
               
               table.setRowCount(0);
               String BookData[] = {ISBN, Book, Author, Edition, Publication};
                  //DefaultTableModel table = (DefaultTableModel)jtable.getModel();
                  
                  table.addRow(BookData);
           }
       } catch (SQLException e) {
           
       }
       }
       else if(radEdition.isSelected()){
           try {
           st = getConnection().createStatement();
           rs = st.executeQuery("SELECT * FROM `book` WHERE `Edition` LIKE '"+ searchKey +"'");
           
           while(rs.next())
           {
               String ISBN = rs.getString("ISBN");
               String Book = rs.getString("Book");
               String Author = rs.getString("Author");
               String Edition = rs.getString("Edition");
               String Publication = rs.getString("Publication");
               
               table.setRowCount(0);
               String BookData[] = {ISBN, Book, Author, Edition, Publication};
                  //DefaultTableModel table = (DefaultTableModel)jtable.getModel();
                  
                  table.addRow(BookData);
           }
       } catch (SQLException e) {
           
       }
       }
       else if(radPublication.isSelected()){
           try {
           st = getConnection().createStatement();
           rs = st.executeQuery("SELECT * FROM `book` WHERE `Publication` LIKE '"+ searchKey +"'");
           
           while(rs.next())
           {
               String ISBN = rs.getString("ISBN");
               String Book = rs.getString("Book");
               String Author = rs.getString("Author");
               String Edition = rs.getString("Edition");
               String Publication = rs.getString("Publication");
               
               table.setRowCount(0);
               String BookData[] = {ISBN, Book, Author, Edition, Publication};
                  //DefaultTableModel table = (DefaultTableModel)jtable.getModel();
                  
                  table.addRow(BookData);
           }
       } catch (SQLException e) {
           
       }
       }
        
   } 
   
   public void refreshBookList(){
       
       DefaultTableModel table = (DefaultTableModel)jtable.getModel();
       table.setRowCount(0);
       getBookList();
       
   }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        radISBN = new javax.swing.JRadioButton();
        radBookName = new javax.swing.JRadioButton();
        radAuthor = new javax.swing.JRadioButton();
        radEdition = new javax.swing.JRadioButton();
        radPublication = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btnNewBook = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Library Management System");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        buttonGroup.add(radISBN);
        radISBN.setText("ISBN");

        buttonGroup.add(radBookName);
        radBookName.setText("Book Name");

        buttonGroup.add(radAuthor);
        radAuthor.setText("Author");

        buttonGroup.add(radEdition);
        radEdition.setText("Edition");

        buttonGroup.add(radPublication);
        radPublication.setText("Pubilcation");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSearch)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radISBN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radBookName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radEdition)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radPublication)
                    .addComponent(btnSearch))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radISBN)
                    .addComponent(radBookName)
                    .addComponent(radAuthor)
                    .addComponent(radEdition)
                    .addComponent(radPublication))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Book name", "Author", "Edition", "Publication"
            }
        ));
        jScrollPane1.setViewportView(jtable);

        btnNewBook.setText("New Book");
        btnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Book");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(102, 102, 102)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNewBook)
                        .addComponent(btnRefresh)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:]
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)jtable.getModel();
        table.removeRow(0);
        searchQuery();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refreshBookList();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Auth login = new Auth();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookActionPerformed
        // TODO add your handling code here:
        AddNewBook newbook = new AddNewBook();
        newbook.setVisible(true);
    }//GEN-LAST:event_btnNewBookActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)jtable.getModel();
       table.setRowCount(0);
        
    }//GEN-LAST:event_btnClearActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainscreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewBook;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable;
    private javax.swing.JRadioButton radAuthor;
    private javax.swing.JRadioButton radBookName;
    private javax.swing.JRadioButton radEdition;
    private javax.swing.JRadioButton radISBN;
    private javax.swing.JRadioButton radPublication;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
