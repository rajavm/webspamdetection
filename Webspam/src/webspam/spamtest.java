/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;

import contentspam.contentfeature_analysis;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import linkspam.inlink_extraction;

/**
 *
 * @author Maheswari
 */
public class spamtest extends javax.swing.JFrame {

    /**
     * Creates new form spamtest
     */
    public spamtest() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("WEB SPAM DETECTION SYSTEM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter the URL");

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        b1.setText("Detect");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(b1)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(70, 70, 70)
                .addComponent(b1)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        String url=t1.getText();
        inlink_extraction i=new inlink_extraction();
        int linkflag=0;
        try {
             linkflag=i.run_inlink(url);
        } catch (IOException ex) {
            Logger.getLogger(spamtest.class.getName()).log(Level.SEVERE, null, ex);
        }
     /*   if(flg==1)
            JOptionPane.showMessageDialog(this,"Given url is spam", "result",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,"Given url is normal", "result",JOptionPane.INFORMATION_MESSAGE);*/
        
        contentfeature_analysis c=new contentfeature_analysis();
        int contentflag=0;
        try {
            contentflag=c.run_contentfeature(url);
        } catch (IOException ex) {
            Logger.getLogger(spamtest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BoilerpipeProcessingException ex) {
            Logger.getLogger(spamtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ldaflag = 0;
        System.out.println("\nTopic Modeling");
         String csvFile ="G:\\sem project\\output\\lda_output\\output_csv\\new.csv" ;
	BufferedReader br = null;
        String cvsSplitBy=",";
        String appendedurl="G:\\sem project\\output\\lda_dataset\\ldatest\\"+url+".txt";
         try {
		br = new BufferedReader(new FileReader(csvFile));
            String line="";
		while ((line = br.readLine()) != null) 
                {    
                    
			String[] s = line.split(cvsSplitBy);
                        if(s[1].equals(appendedurl))
                        {   
                           
                            int s2=Integer.parseInt(s[2]);
                            Double s3=Double.parseDouble(s[3]);
                            if(s3==0.5)
                            {
                                System.out.println("undecided");
                                ldaflag=2;
                            }
                            else if(s2==2)
                            {  System.out.println("normal");
                            ldaflag=0;
                            }
                            else
                            {   System.out.println("spam");
                                ldaflag=1;
                            }
                        }
                }
        }
        
             
     catch(Exception e)
     {
       System.out.println(e);
     }
       
        try {   
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(spamtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int finalans;
        
        int contwt=1,ldawt=1,linkwt=(int) 0.5;
        int res = 9999;
        if(ldaflag==2)
        {
            if(linkflag==0 && contentflag==0)
                res=0;
            else if(linkflag==1 && contentflag==1)
                res=1;
            else
                res=2;
        }
        
        else if(contentflag==2)
        {
            System.out.println("in else i");
            if(linkflag==0 && ldaflag==0)
                res=0;
            else if(linkflag==1 && ldaflag==1)
                res=1;
            else
                res=2;
        }
        
        else
        {
            System.out.println("in else");
            finalans=contentflag*contwt + ldaflag*ldawt + linkflag*linkwt;
            if(finalans>=1.5)
                res=1;
           
            else
                res=0;
        }
        if(ldaflag==1)
            res=1;
        
        
         if(res==1)
      JOptionPane.showMessageDialog(this,"Given url is spam", "result",JOptionPane.INFORMATION_MESSAGE);
         if(res==0)
      JOptionPane.showMessageDialog(this,"Given url is normal", "result",JOptionPane.INFORMATION_MESSAGE);
         if(res==2)
       JOptionPane.showMessageDialog(this,"Given url is undecided", "result",JOptionPane.INFORMATION_MESSAGE);

         /*  int ans=99999;                                //1 is spam , 0 is normal
         if(linkflag==1 && contentflag==1 && ldaflag==1)
             ans=1;
         else if(linkflag==0 && contentflag==0 && ldaflag==1)
             ans=1;
         else if(linkflag==1 && contentflag==1 && ldaflag==0)
             ans=1;
         else if(linkflag==1 && contentflag==0 && ldaflag==1)
             ans=1;
         else if(linkflag==1 && contentflag==0 && ldaflag==0)
             ans=0;
         else if(linkflag==0 && contentflag==0 && ldaflag==0)
             ans=0;
         else if(linkflag==0 && contentflag==1 && ldaflag==0)
             ans=0;
          else if(linkflag==0 && contentflag==1 && ldaflag==1)
              ans=1;
         
         
         if(ans==1)
      JOptionPane.showMessageDialog(this,"Given url is spam", "result",JOptionPane.INFORMATION_MESSAGE);
         if(ans==0)
      JOptionPane.showMessageDialog(this,"Given url is normal", "result",JOptionPane.INFORMATION_MESSAGE);
*/
    }//GEN-LAST:event_b1ActionPerformed

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
            java.util.logging.Logger.getLogger(spamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(spamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(spamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(spamtest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new spamtest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}