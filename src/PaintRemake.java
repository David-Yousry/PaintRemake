/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PaintRemake.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.w3c.dom.events.MouseEvent;

import PaintRemake.src.models.*;

/**
 *
 * @author pc
 */
public class PaintRemake extends javax.swing.JFrame {
    
    private Color color;
    private char currentShape;
    private int x1,x2,y1,y2;
    private int width, height;

    

    /**
     * Creates new form PaintRemake
     */
    public PaintRemake() {
        initComponents();

        addMouseListener(new PressListener());
        addMouseMotionListener(new DragListener());
    }
        class DragListener implements MouseMotionListener{

            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                if(currentShape == 'B'){ // brush
                //TODO: brush
                }
                else if (currentShape == 'L'){ //line
                    x2 = e.getX();
                    y2 = e.getY();
                }else{ // rectangle or oval
                    width = e.getX() - x1;
                    height = e.getY()- y1;
                    
                }
                if(e.getY() > 106)
                    repaint();
            }
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
            }
            

            
    }
    
    class PressListener implements MouseListener{

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            if(currentShape == 'B'){ // brush
                 //TODO: brush
            }
            else{ // rectangle, oval or line
                x1 = e.getX();
                y1 = e.getY();
            }
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            if(currentShape == 'B'){ // brush
                //TODO: brush
            }
            else if (currentShape == 'L'){ //line
                Line line = new Line(x1, y1, x2, y2);
            }
            else if(currentShape == 'R'){ //rectangle
                Rectangle rectangle = new Rectangle(x1, y1, solidCheckBox.isSelected(), width, height);
            }
            else if(currentShape == 'O'){ //oval
                Oval oval = new Oval(x1, y1, solidCheckBox.isSelected(), width, height);
            }
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
           
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

        jPanel1 = new javax.swing.JPanel();
        brushButton = new javax.swing.JButton();
        lineButton = new javax.swing.JButton();
        rectangleButton = new javax.swing.JButton();
        ovalButton = new javax.swing.JButton();
        eraserButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        solidCheckBox = new javax.swing.JCheckBox();
        redButton = new javax.swing.JButton();
        blackButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        aquaButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 222, 222));

        brushButton.setText("Brush");
        brushButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brushButtonActionPerformed(evt);
            }
        });

        lineButton.setText("Line");
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButtonActionPerformed(evt);
            }
        });

        rectangleButton.setText("Rectangle");
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        ovalButton.setText("Oval");
        ovalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalButtonActionPerformed(evt);
            }
        });

        eraserButton.setBackground(new java.awt.Color(204, 204, 204));
        eraserButton.setForeground(new java.awt.Color(0, 0, 0));
        eraserButton.setText("Eraser");

        undoButton.setBackground(new java.awt.Color(204, 204, 204));
        undoButton.setForeground(new java.awt.Color(0, 0, 0));
        undoButton.setText("Undo");

        clearButton.setBackground(new java.awt.Color(204, 204, 204));
        clearButton.setForeground(new java.awt.Color(0, 0, 0));
        clearButton.setText("Clear");

        solidCheckBox.setText("Solid");

        redButton.setBackground(new java.awt.Color(255, 0, 0));
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        blackButton.setBackground(new java.awt.Color(0, 0, 0));
        blackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackButtonActionPerformed(evt);
            }
        });

        greenButton.setBackground(new java.awt.Color(0, 255, 0));
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        aquaButton.setBackground(new java.awt.Color(51, 255, 255));
        aquaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aquaButtonActionPerformed(evt);
            }
        });

        yellowButton.setBackground(new java.awt.Color(255, 255, 0));
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        blueButton.setBackground(new java.awt.Color(0, 0, 255));
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aquaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(brushButton)
                        .addGap(18, 18, 18)
                        .addComponent(lineButton)
                        .addGap(18, 18, 18)
                        .addComponent(rectangleButton)
                        .addGap(18, 18, 18)
                        .addComponent(ovalButton)
                        .addGap(18, 18, 18)
                        .addComponent(eraserButton)
                        .addGap(115, 115, 115)
                        .addComponent(undoButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)
                        .addGap(120, 120, 120)
                        .addComponent(solidCheckBox)
                        .addGap(131, 131, 131)
                        .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(brushButton)
                        .addComponent(lineButton)
                        .addComponent(rectangleButton)
                        .addComponent(ovalButton)
                        .addComponent(eraserButton)
                        .addComponent(undoButton)
                        .addComponent(clearButton)
                        .addComponent(solidCheckBox)
                        .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aquaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(225, 225, 225));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        this.color = Color.RED;
    }//GEN-LAST:event_redButtonActionPerformed

    private void blackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackButtonActionPerformed
        this.color = Color.BLACK;
    }//GEN-LAST:event_blackButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        this.color = Color.GREEN;
    }//GEN-LAST:event_greenButtonActionPerformed

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        this.color = Color.BLUE;
    }//GEN-LAST:event_blueButtonActionPerformed

    private void aquaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aquaButtonActionPerformed
        this.color = Color.CYAN;
    }//GEN-LAST:event_aquaButtonActionPerformed

    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowButtonActionPerformed
        this.color = Color.YELLOW;
    }//GEN-LAST:event_yellowButtonActionPerformed

    private void brushButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brushButtonActionPerformed
        this.currentShape = 'B';
    }//GEN-LAST:event_brushButtonActionPerformed

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButtonActionPerformed
        this.currentShape = 'L';
    }//GEN-LAST:event_lineButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        this.currentShape = 'R';
    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void ovalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalButtonActionPerformed
        this.currentShape = 'O';
    }//GEN-LAST:event_ovalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaintRemake().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aquaButton;
    private javax.swing.JButton blackButton;
    private javax.swing.JButton blueButton;
    private javax.swing.JButton brushButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton eraserButton;
    private javax.swing.JButton greenButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lineButton;
    private javax.swing.JButton ovalButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JButton redButton;
    private javax.swing.JCheckBox solidCheckBox;
    private javax.swing.JButton undoButton;
    private javax.swing.JButton yellowButton;
    // End of variables declaration//GEN-END:variables


    @Override
    public void paint(Graphics g) {

        super.paint(g); 
        g.setColor(color);
        if(currentShape == 'B'){ // brush
            //TODO: brush
        
        }
        else if (currentShape == 'L'){ //line
            g.drawLine(x1, y1, x2, y2);
        }
        else{ // rectangle or oval
        
            // in rectangle and oval we need to normalize the x and y in case the user drags the mouse to the left or up which will result in negative width or height
            int normalizedX = x1;
            int normalizedY = y1;
            int normalizedWidth = width;
            int normalizedHeight = height;

            if (width < 0) {
                normalizedX += width;
                normalizedWidth = -width;
            }
            if (height < 0) {
                normalizedY += height;
                normalizedHeight = -height;
            }
        
            if(currentShape == 'R'){ //rectangle
                if(solidCheckBox.isSelected()){
                    g.fillRect(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                }else{
                    g.drawRect(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                }
            }
            else if(currentShape == 'O'){ //oval
                if(solidCheckBox.isSelected()){
                    g.fillOval(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                }else{
                    g.drawOval(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                }
            }
        }
        
        
        
    
    }

}
