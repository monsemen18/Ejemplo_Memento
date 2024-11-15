import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;

public class TestMemento extends JFrame {
    public static void main(String[] args) {
        new TestMemento();
    }

    private JButton saveBut, undoBut, redoBut;

    // JTextArea(rows, columns)
    private JTextArea theArticle = new JTextArea(40, 60);

    // ------------------------------------------------------
    /**
     * crear un caretaker que contiene el ArrayList
     * con todos los articulos en él. Puede agregar y
     * regresar articulos del ArrayList
     */

    Caretaker caretaker = new Caretaker();

    /**
     * Él originador asigna el valor para el articulo,
     * crea un nuevo memento con un nuevo articulo
     * y regresa el articulo guardado en el actual memento
     */

    Originator originator = new Originator();

    int saveFiles = 0;
    int currentArticle = 0;

    // --------------------------------------------------------

    public TestMemento() {
        // informacion del panel para los elementos del GUI
        this.setSize(750, 780);
        this.setTitle("Memento Design Pattern");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();

        // agregar label al panel
        panel1.add(new JLabel("Article"));

        // agregar JTextArea al panel
        panel1.add(theArticle);

        // agregar los buttons y ButtonListeners al panel
        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();

        saveBut = new JButton("Save");
        saveBut.addActionListener(saveListener);

        undoBut = new JButton("undo");
        undoBut.addActionListener(undoListener);

        redoBut = new JButton("Redo");
        redoBut.addActionListener(redoListener);

        panel1.add(saveBut);
        panel1.add(undoBut);
        panel1.add(redoBut);

        // agregar panel al frame que se muestra en la pantalla
        this.add(panel1);
        this.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == saveBut) {
                // obtener texto en JTextArea
                String textInTextArea = theArticle.getText();

                // asignar el valor del actual memento
                originator.set(textInTextArea);

                // agregar nuevo articulo al ArrayList
                caretaker.addMemento(originator.storeInMemento());

                // saveFiles monitorea cuantos articulos han sido guardados
                // currentArticle monitorea the articulo mostrado

                saveFiles++;
                currentArticle++;

                System.out.println("Guardar archivo " + saveFiles);

                // opcion de deshacer
                undoBut.setEnabled(true);
            } else if (e.getSource() == undoBut) {
                if (currentArticle >= 1) {
                    // decrementar al articulo actual mostrado
                    currentArticle--;
                    // regresar el articulo anterior guardado y mostrarlo
                    // en el JTextArea

                    String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
                    theArticle.setText(textBoxString);

                    // opcion de redo
                    redoBut.setEnabled(true);
                } else {
                    // no perimitir al usuario deshacer
                    undoBut.setEnabled(false);
                }
            } else if (e.getSource() == redoBut) {
                if ((saveFiles - 1) > currentArticle) {
                    // incrementar al actual articulo mostrado
                    currentArticle++;
                    // regresar el utlimo articuo guardado y mostrarlo
                    // en el JTextArea
                    String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
                    theArticle.setText(textBoxString);

                    // opcion de undo
                    undoBut.setEnabled(true);
                } else {
                    // no permitir al usuario rehacer
                    redoBut.setEnabled(false);
                }
            }
        }
    }
}