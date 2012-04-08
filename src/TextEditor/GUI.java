/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author GV
 */
public class GUI implements KeyListener, IObserver, ActionListener {

    protected javax.swing.JFrame frame = new JFrame();
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextPane1;
    private javax.swing.JButton jButtonCopy;
    private javax.swing.JButton jButtonPaste;
    private javax.swing.JPanel jPanel1;
    protected AbstractUI ui;

    public GUI() {
        initComponents();
        frame.setVisible(true);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButtonCopy = new javax.swing.JButton();
        jButtonPaste = new javax.swing.JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new java.awt.GridBagLayout());

        jTextPane1.setPreferredSize(new java.awt.Dimension(350, 350));
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        frame.getContentPane().add(jScrollPane1, gridBagConstraints);
        jButtonCopy.setText("Copy");
        jPanel1.add(jButtonCopy);
        jButtonCopy.getAccessibleContext().setAccessibleName("copy");

        jButtonPaste.setText("Paste");
        jPanel1.add(jButtonPaste);
        jButtonPaste.getAccessibleContext().setAccessibleName("paste");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        frame.getContentPane().add(jPanel1, gridBagConstraints);
        jTextPane1.setEditable(false);
        jTextPane1.getCaret().setVisible(true);
        jTextPane1.setLineWrap(true);
        frame.pack();

        jTextPane1.addKeyListener(this);
        jButtonCopy.addActionListener(this);
        jButtonPaste.addActionListener(this);

        //frame.setLocationRelativeTo(null);
    }

    private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ui.buffer.CaretDebut=jTextPane1.getSelectionStart();
        ui.buffer.CaretFin=jTextPane1.getSelectionEnd();
        this.jTextPane1.setText("");
        if (e.getKeyChar() == '\b') {
            ui.invoqueBackSpace();
        } else {
            ui.content = "" + e.getKeyChar();
            ui.invoqueInsert();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void update(ISubject s) {
        if (s instanceof Buffer) {
            String content = ((Buffer) s).getText();
            this.jTextPane1.setText("");
            this.jTextPane1.setText(content);
        }
        jTextPane1.getCaret().setVisible(true);
    }

    public AbstractUI getUi() {
        return ui;
    }

    public void setUi(AbstractUI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ui.buffer.CaretDebut=jTextPane1.getSelectionStart();
        ui.buffer.CaretFin=jTextPane1.getSelectionEnd();
        if (ae.getSource().equals(jButtonCopy)) {
            String Selection = this.jTextPane1.getSelectedText();
            ui.ClipBoard = Selection;
            ui.invoqueCopy();
        }
        if (ae.getSource().equals(jButtonPaste)) {
            ui.invoquePaste();
        }
        jTextPane1.getCaret().setVisible(true);
    }
}