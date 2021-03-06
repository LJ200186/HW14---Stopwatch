/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author ldjet
 */
public class StopwatchGUI extends javax.swing.JFrame {

    public static boolean Running = false;
    public static long StartTime = 0;
    public static long StopTime = 0;

    public StopwatchGUI() {
        initComponents();

        CompletableFuture.runAsync(() -> {
            Checker();
        });
    }

    public void Checker() {

        System.out.println("Loading Checker...");

        while (true) {
            if (Running == true) {

                long Difference = System.nanoTime() - StartTime;

                long MilliDifference = Difference / 1000000;
                long SecDifference = Difference / 1000000000;
                long MinDifference = SecDifference / 60;

                String StrMilliDiff = "";
                String StrMinDiff = "";
                String StrSecDiff = "";

                SecDifference = SecDifference - (MinDifference * 60);
                MilliDifference = MilliDifference - ((SecDifference * 1000) + (MinDifference * 60000));

                if (Long.toString(MilliDifference).length() == 3) {
                    StrMilliDiff = Long.toString(MilliDifference).substring(0, 2);
                } else if (Long.toString(MilliDifference).length() == 1) {
                    StrMilliDiff = "0" + Long.toString(MilliDifference);
                } else {
                    StrMilliDiff = Long.toString(MilliDifference);
                }

                if (Long.toString(MinDifference).length() == 1) {
                    StrMinDiff = "0" + MinDifference;
                } else {
                    StrMinDiff = Long.toString(MinDifference);
                }

                if (Long.toString(SecDifference).length() == 1) {
                    StrSecDiff = "0" + SecDifference;
                } else {
                    StrSecDiff = Long.toString(SecDifference);
                }

                Time.setText(StrMinDiff + ":" + StrSecDiff + ":" + StrMilliDiff);
            } else {
                System.out.print("");
            }
        }
    }

    public void playSound(String soundFile) {
        try {
            File f = new File("./" + soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Time = new javax.swing.JLabel();
        StartB = new javax.swing.JButton();
        StopB = new javax.swing.JButton();
        ResetB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Time.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 48)); // NOI18N
        Time.setText("00:00:00");

        StartB.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        StartB.setText("Start");
        StartB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBActionPerformed(evt);
            }
        });

        StopB.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        StopB.setText("Stop");
        StopB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBActionPerformed(evt);
            }
        });

        ResetB.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        ResetB.setText("Reset");
        ResetB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(Time, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(StartB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(StopB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(Time)
                .addGap(103, 103, 103))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(StartB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(StopB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(ResetB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(Time)
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StopB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ResetB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBActionPerformed

        if (Running == false) {

            if (StartTime == 0) {
                playSound("ding.wav");
                Running = true;
                StartTime = System.nanoTime();
            } else {
                playSound("ding.wav");
                StartTime = System.nanoTime() - (StopTime - StartTime);
                Running = true;
            }
        }

    }//GEN-LAST:event_StartBActionPerformed

    private void StopBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBActionPerformed
        Running = false;
        StopTime = System.nanoTime();
    }//GEN-LAST:event_StopBActionPerformed

    private void ResetBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBActionPerformed
        Running = false;
        Time.setText("00:00:00");
        StartTime = 0;
    }//GEN-LAST:event_ResetBActionPerformed

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
            java.util.logging.Logger.getLogger(StopwatchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StopwatchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StopwatchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StopwatchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StopwatchGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ResetB;
    private javax.swing.JButton StartB;
    private javax.swing.JButton StopB;
    private javax.swing.JLabel Time;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
