
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class cities extends javax.swing.JFrame {
    public static String g="";
     //static ArrayList<String> out = new ArrayList<>();
    static class ListNode implements Comparable<ListNode> {
    int vertex, weight;
    String name;

    ListNode(int v, int w, String n) {
        vertex = v;
        weight = w;
        name = n;
    }

    int getVertex() {
        return vertex;
    }

    int getWeight() {
        return weight;
    }

    String getName() {
        return name;
    }

    @Override
    public int compareTo(ListNode other) {
        return Integer.compare(this.weight, other.weight);
    }
}

    static class In {
        String name;
        int time;

        In(int t, String name) {
            this.name = name;
            this.time = t;
        }

        String getName() {
            return name;
        }

        int getTime() {
            return time;
        }
    }
    
    
    
    
    public static String[] dijkstra(int V, ArrayList<ArrayList<ListNode>> graph,int src) {
        int[] distance = new int[V];
        String[] nameVer = new String[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
          nameVer[0]  = "  ";
        }
        
        
        for(int i=0; i < graph.size() ; i++)
            { 
                
              for(int j=0; j < graph.get(i).size() ; j++){
                if(graph.get(i).get(j).getVertex()==src)
                 nameVer[src]=graph.get(i).get(j).getName();
            
              }
                
            
            }   
        distance[src] = 0;

        PriorityQueue<ListNode> pq = new PriorityQueue<>();
        pq.add(new ListNode(src, 0 , "City 0"));

        while (pq.size() > 0) {
            ListNode current = pq.poll();
            for (ListNode n : graph.get(current.getVertex())) {
                if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                    distance[n.getVertex()] = n.getWeight() + distance[current.getVertex()];
                   
                    nameVer [n.getVertex()]=  nameVer[current.getVertex()]+" "+n.getName();
                    pq.add(new ListNode(n.getVertex(),distance[n.getVertex()] ,nameVer[n.getVertex()] ) );
                }
            }
        }
        
       
       for(int i=0  ; i<V ; i++)
       nameVer[i]= (String)"  distnce in km is : "+distance[i]+"  --> route is : " + nameVer[i];
       
       
        return nameVer;
    }
    
    
    static ArrayList<In> arrlist = new ArrayList<>();

Connection con2;
  Statement stmt2;
 DefaultTableModel model;
   ResultSet rs2;
    public cities() {
        initComponents();
        connectToSql();
    }
public void connectToSql(){
model=new DefaultTableModel(); 
    model.addColumn("time");
    model.addColumn("city");    
 table.setModel(model);

    String path="jdbc:sqlserver://localhost:1433;databaseName=algo";
    String user="sql";
    String pass="123";
    
try{ 
    con2=DriverManager.getConnection(path, user, pass);
    stmt2=con2.createStatement();
   rs2=stmt2.executeQuery("select*from city");
   while(rs2.next()){
    
    model.addRow(new Object[]{rs2.getInt("time"),rs2.getString("city")});
    
   }
    System.out.println("connect");
    }catch(SQLException e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    
   }
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        time_text = new javax.swing.JTextField();
        city_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Sava = new javax.swing.JButton();
        start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("time");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("city");

        Sava.setText("Save");
        Sava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavaActionPerformed(evt);
            }
        });

        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(time_text, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(city_text))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(Sava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(city_text, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sava, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavaActionPerformed
     int time=Integer.parseInt(time_text.getText());
      String city=city_text.getText();
      String query="insert into city values( "+ time+",'" + city +"' )";
      
        
      
        arrlist.add(new In(time,city));
      
       
                
      
      
      try{
        stmt2.executeUpdate(query);
         model.addRow(new Object[] {time,city});
        JOptionPane.showMessageDialog(this, "Inserted");
        
        }catch(SQLException ex){
            System.out.println("error");
        }         
    }//GEN-LAST:event_SavaActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
           
        
             Collections.sort(arrlist, new Comparator<In>() {
    @Override
    public int compare(In o1, In o2) {
        return Integer.compare(o1.getTime(), o2.getTime());
    }
});


  int V = 9;
        
        
         ArrayList<ArrayList<ListNode>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
         graph.add(new ArrayList());
         
        }
        
       graph.get(0).add(new ListNode(1, 4 , "Cairo"));
        graph.get(0).add(new ListNode(7, 8, "Alex"));
        graph.get(1).add(new ListNode(2, 8, "Giza"));
        graph.get(1).add(new ListNode(7, 11, "Alex"));
        graph.get(1).add(new ListNode(0, 7, "Posta"));
        graph.get(2).add(new ListNode(1, 8, "Cairo"));
        graph.get(2).add(new ListNode(3, 7, "Kom Hamada"));
        graph.get(2).add(new ListNode(8, 2, "Maadi"));
        graph.get(2).add(new ListNode(5, 4,"Matrouh"));
        graph.get(3).add(new ListNode(2, 7,"Giza"));
        graph.get(3).add(new ListNode(4, 9,"Hurgada"));
        graph.get(3).add(new ListNode(5, 14,"Matrouh"));
        graph.get(4).add(new ListNode(3, 9,"Kom Hamada"));
        graph.get(4).add(new ListNode(5, 10,"Matrouh"));
        graph.get(5).add(new ListNode(4, 10,"Hurgada"));
        graph.get(5).add(new ListNode(6, 2,"Aswan"));
        graph.get(6).add(new ListNode(5, 2,"Matrouh"));
        graph.get(6).add(new ListNode(7, 1,"Alex"));
        graph.get(6).add(new ListNode(8, 6,"Maadi"));
        graph.get(7).add(new ListNode(0, 8,"Posta"));
        graph.get(7).add(new ListNode(1, 11,"Cairo"));
        graph.get(7).add(new ListNode(6, 1,"Aswan"));
        graph.get(7).add(new ListNode(8, 7,"Maadi"));
        graph.get(8).add(new ListNode(2, 2,"Giza"));
        graph.get(8).add(new ListNode(6, 6,"Aswan"));
        graph.get(8).add(new ListNode(7, 1,"Alex"));

         
        for (int q = 0 ; q <arrlist.size() -1 ;q++)
        {
        int s=0; 
        for(int i=0; i < graph.size() ; i++)
            { 
                
              for(int j=0; j < graph.get(i).size() ; j++){
                if(graph.get(i).get(j).getName().equals(arrlist.get(q).getName()))
                 s=graph.get(i).get(j).getVertex();
            
              }
                
            
            }
 
        String[] distance = dijkstra(V, graph, s);
         //System.out.println(" Where do you want to go ?  ");
//         String  L = cinn.nextLine();
       for(int i=0; i < graph.size() ; i++)
            { 
                
              for(int j=0; j < graph.get(i).size() ; j++){
                if(graph.get(i).get(j).getName().equals(arrlist.get(q+1).getName()))
                 s=graph.get(i).get(j).getVertex();
            
              }
                
            
            }
//        int i = cin.nextInt();
       g=g+"||"+distance[s];
       // out.add(distance[s]);
       
        }      
          
     
   
        
        
        
        
        
        
        
       info f = new info();
f.setVisible(true);
dispose();
    }//GEN-LAST:event_startActionPerformed

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
            java.util.logging.Logger.getLogger(cities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cities().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sava;
    private javax.swing.JTextField city_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton start;
    private javax.swing.JTable table;
    private javax.swing.JTextField time_text;
    // End of variables declaration//GEN-END:variables
}
