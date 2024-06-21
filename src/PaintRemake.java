/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package PaintRemake.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import PaintRemake.src.models.*;

/**
 *
 * @author pc
 */
public class PaintRemake extends javax.swing.JFrame {

    private static ArrayList<Drawing> drawings = new ArrayList<>();
    private Color color = Color.BLACK;
    private char currentShape = 'B'; // 'B' for brush, 'L' for line, 'R' for rectangle and 'O' for oval
    private int x1, x2, y1, y2 = 107;
    private int width, height;
    private char paintMode = 'D'; // 'D' for draw, 'E' for erase
    private boolean undo, clear;
    private boolean isPressedInPanel2;

    /**
     * Creates new form PaintRemake
     */
    public PaintRemake() {
        initComponents();

        addMouseListener(new PressListener());
        addMouseMotionListener(new DragListener());
        setTitle("Paint Remake");

        ImageIcon logo = new ImageIcon("src/main/java/PaintRemake/src/media/logo.png"); // FIXME : check logo path
        setIconImage(logo.getImage());
    }

    class DragListener implements MouseMotionListener {

        @Override
        public void mouseDragged(java.awt.event.MouseEvent e) {
            if (!isPressedInPanel2) {
                return;
            }
            if (paintMode == 'E') { // erase
                try {
                    x1 = (int) getMousePosition().getX();
                    y1 = (int) getMousePosition().getY();
                } catch (NullPointerException ex) {
                }
                if (drawings.get(drawings.size() - 1) instanceof Eraser) {
                    Eraser eraser = (Eraser) drawings.get(drawings.size() - 1);
                    if (y1 > 106)
                        eraser.addPoint(x1, y1);
                } else
                    drawings.add(new Eraser(jPanel2.getBackground()));
            } else {
                if (currentShape == 'B') { // brush
                    try {
                        x1 = (int) e.getX();
                        y1 = (int) e.getY();
                    } catch (NullPointerException ex) {
                    }
                    if (drawings.get(drawings.size() - 1) instanceof Brush) {
                        Brush brush = (Brush) drawings.get(drawings.size() - 1);
                        if (y1 > 106)
                            brush.addPoint(x1, y1);
                    } else
                        drawings.add(new Brush(color));
                } else if (currentShape == 'L') { // line
                    x2 = e.getX();
                    if (y2 > 106)
                        y2 = e.getY();
                } else { // rectangle or oval
                    width = e.getX() - x1;
                    if (y2 > 106)
                        height = e.getY() - y1;
                }
            }
            if (e.getY() > 106)
                repaint();
        }

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
        }

    }

    class PressListener implements MouseListener {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            if (e.getY() <= 106) {
                isPressedInPanel2 = false;

            } else {
                isPressedInPanel2 = true;

                if (paintMode == 'E') {
                    x1 = (int) getMousePosition().getX();
                    y1 = (int) getMousePosition().getY();
                    Eraser eraser = new Eraser(jPanel2.getBackground());
                    drawings.add(eraser);
                } else {
                    if (currentShape == 'B') { // brush
                        x1 = (int) getMousePosition().getX();
                        y1 = (int) getMousePosition().getY();
                        Brush brush = new Brush(color);
                        drawings.add(brush);
                    } else { // rectangle, oval or line

                        x1 = e.getX();
                        y1 = e.getY();
                    }
                }
            }
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            if (!isPressedInPanel2) {
                return;
            }
            if (paintMode == 'E') {
                return;
            }
            if (currentShape == 'B') { // brush
                // TODO: brush
            } else if (currentShape == 'L') { // line
                Line line = new Line(x1, y1, x2, y2, color);
                drawings.add(line);
            } else if (currentShape == 'R') { // rectangle
                Rectangle rectangle = new Rectangle(x1, y1, solidCheckBox.isSelected(), width, height, color);
                drawings.add(rectangle);

            } else if (currentShape == 'O') { // oval
                Oval oval = new Oval(x1, y1, solidCheckBox.isSelected(), width, height, color);
                drawings.add(oval);
            }

            if (e.getY() > 106)
                repaint();
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {

        }

    }

    public void activeButton(javax.swing.JButton button) {
        brushButton.setBackground(new Color(204, 204, 204));
        brushButton.setForeground(new Color(0, 0, 0));
        lineButton.setBackground(new Color(204, 204, 204));
        lineButton.setForeground(new Color(0, 0, 0));
        rectangleButton.setBackground(new Color(204, 204, 204));
        rectangleButton.setForeground(new Color(0, 0, 0));
        ovalButton.setBackground(new Color(204, 204, 204));
        ovalButton.setForeground(new Color(0, 0, 0));
        eraserButton.setBackground(new Color(204, 204, 204));
        eraserButton.setForeground(new Color(0, 0, 0));
        button.setBackground(new Color(0, 0, 0));
        button.setForeground(new Color(255, 255, 255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
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
        eraserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraserButtonActionPerformed(evt);
            }
        });

        undoButton.setBackground(new java.awt.Color(204, 204, 204));
        undoButton.setForeground(new java.awt.Color(0, 0, 0));
        undoButton.setText("Undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(204, 204, 204));
        clearButton.setForeground(new java.awt.Color(0, 0, 0));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

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
                                        .addComponent(aquaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(blackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(brushButton)
                                                .addComponent(lineButton)
                                                .addComponent(rectangleButton)
                                                .addComponent(ovalButton)
                                                .addComponent(eraserButton)
                                                .addComponent(undoButton)
                                                .addComponent(clearButton)
                                                .addComponent(solidCheckBox)
                                                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(blackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(aquaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel2.setBackground(new java.awt.Color(225, 225, 225));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 663, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_redButtonActionPerformed
        this.color = Color.RED;

    }// GEN-LAST:event_redButtonActionPerformed

    private void blackButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_blackButtonActionPerformed
        this.color = Color.BLACK;
    }// GEN-LAST:event_blackButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_greenButtonActionPerformed
        this.color = Color.GREEN;
    }// GEN-LAST:event_greenButtonActionPerformed

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_blueButtonActionPerformed
        this.color = Color.BLUE;
    }// GEN-LAST:event_blueButtonActionPerformed

    private void aquaButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_aquaButtonActionPerformed
        this.color = Color.CYAN;
    }// GEN-LAST:event_aquaButtonActionPerformed

    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_yellowButtonActionPerformed
        this.color = Color.YELLOW;
    }// GEN-LAST:event_yellowButtonActionPerformed

    private void brushButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_brushButtonActionPerformed
        this.currentShape = 'B';
        this.paintMode = 'D';
        activeButton(brushButton);
    }// GEN-LAST:event_brushButtonActionPerformed

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_lineButtonActionPerformed
        this.currentShape = 'L';
        this.paintMode = 'D';
        activeButton(lineButton);
    }// GEN-LAST:event_lineButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rectangleButtonActionPerformed
        this.currentShape = 'R';
        this.paintMode = 'D';
        activeButton(rectangleButton);
    }// GEN-LAST:event_rectangleButtonActionPerformed

    private void ovalButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ovalButtonActionPerformed
        this.currentShape = 'O';
        this.paintMode = 'D';
        activeButton(ovalButton);
    }// GEN-LAST:event_ovalButtonActionPerformed

    private void eraserButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_eraserButtonActionPerformed
        paintMode = 'E';
        activeButton(eraserButton);
    }// GEN-LAST:event_eraserButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_clearButtonActionPerformed
        clear = true;
        currentShape = 'B';
        activeButton(brushButton);
        repaint();

    }// GEN-LAST:event_clearButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_undoButtonActionPerformed
        undo = true;
        repaint();
    }// GEN-LAST:event_undoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaintRemake.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

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

        if (undo || clear) {
            if (undo) { // undo
                if (drawings.size() > 0)
                    drawings.remove(drawings.size() - 1);
                undo = false;
            } else if (clear) { // clear
                g.setColor(jPanel2.getBackground());
                g.fillRect(x1, y1, width, height);
                drawings.clear();
                clear = false;
                paintMode = 'D';
            }
        } else {
            if (paintMode == 'D') { // draw

                if (currentShape == 'B') { // brush
                    g.fillRect(x1, y1, 10, 10);

                } else if (currentShape == 'L') { // line
                    g.drawLine(x1, y1, x2, y2);
                } else { // rectangle or oval

                    // in rectangle and oval we need to normalize the x and y in case the user drags
                    // the mouse to the left or up which will result in negative width or height
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

                    if (currentShape == 'R') { // rectangle
                        if (solidCheckBox.isSelected()) {
                            g.fillRect(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                        } else {
                            g.drawRect(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                        }
                    } else if (currentShape == 'O') { // oval
                        if (solidCheckBox.isSelected()) {
                            g.fillOval(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                        } else {
                            g.drawOval(normalizedX, normalizedY, normalizedWidth, normalizedHeight);
                        }
                    }
                }
            } else if (paintMode == 'E') { // erase
                g.setColor(jPanel2.getBackground());
                g.fillRect(x1, y1, 20, 20);
                g.setColor(color);
            }
        }

        // drawing the past shapes
        for (int i = 0; i < drawings.size(); i++) {
            Drawing drawing = drawings.get(i);
            g.setColor(drawing.getColor());
            if (drawing instanceof Line) {
                Line line = (Line) drawing;
                g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            } else if (drawing instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) drawing;
                if (rectangle.isSolid()) {
                    g.fillRect(rectangle.getX1(), rectangle.getY1(), rectangle.getWidth(), rectangle.getHeight());
                } else {
                    g.drawRect(rectangle.getX1(), rectangle.getY1(), rectangle.getWidth(), rectangle.getHeight());
                }
            } else if (drawing instanceof Oval) {
                Oval oval = (Oval) drawing;
                if (oval.isSolid()) {
                    g.fillOval(oval.getX1(), oval.getY1(), oval.getWidth(), oval.getHeight());
                } else {
                    g.drawOval(oval.getX1(), oval.getY1(), oval.getWidth(), oval.getHeight());
                }
            } else if (drawing instanceof Eraser) { // eraser
                Eraser eraser = (Eraser) drawing;
                for (int k = 0; k < eraser.getPoints().size(); k++) {
                    g.fillRect(eraser.getPoints().get(k).x, eraser.getPoints().get(k).y, 20, 20);
                }
            } else { // brush
                Brush brush = (Brush) drawing;
                for (int k = 0; k < brush.getPoints().size(); k++) {
                    g.fillRect(brush.getPoints().get(k).x, brush.getPoints().get(k).y, 10, 10);
                }
            }
        }

    }

}
