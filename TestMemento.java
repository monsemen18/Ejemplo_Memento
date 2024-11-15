import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestMemento extends JFrame {
    public static void main(String[] args) {
        new TestMemento();
    }

    private JButton botonGuardar, botonDeshacer, botonRehacer;
    private JTextArea areaTexto = new JTextArea(40, 60);

    // Crear los objetos Originator y Caretaker
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();

    int saveFiles = 0;
    int textoActual = 0;

    public TestMemento() {
        this.setSize(750, 780);
        this.setTitle("Memento Design Pattern");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el layout de JFrame
        this.setLayout(new BorderLayout());

        // Panel para el título, centrado en la parte superior
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("DOCUMENTO"));
        this.add(titlePanel, BorderLayout.NORTH);

        // Agregar JTextArea en el centro
        JPanel textPanel = new JPanel();
        textPanel.add(areaTexto);
        this.add(textPanel, BorderLayout.CENTER);

        // Panel para los botones, centrados en la parte inferior
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(saveListener);

        botonDeshacer = new JButton("Deshacer");
        botonDeshacer.addActionListener(undoListener);

        botonRehacer = new JButton("Rehacer");
        botonRehacer.addActionListener(redoListener);

        buttonPanel.add(botonGuardar);
        buttonPanel.add(botonDeshacer);
        buttonPanel.add(botonRehacer);

        // Agregar el panel de botones en la parte inferior
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonGuardar) {
                String textInTextArea = areaTexto.getText();
                originator.set(textInTextArea);
                caretaker.addMemento(originator.guardarEnMemento());
                saveFiles++;
                textoActual++;
                System.out.println("texto " + saveFiles + " guardado");
                System.out.println("-------------------------------------------------------------");
                botonDeshacer.setEnabled(true);
            } else if (e.getSource() == botonDeshacer) {
                if (textoActual >= 1) {
                    textoActual--;
                    String textBoxString = originator.restaurarDeMemento(caretaker.getMemento(textoActual));
                    areaTexto.setText(textBoxString);
                    botonRehacer.setEnabled(true);
                } else {
                    botonDeshacer.setEnabled(false);
                }
            } else if (e.getSource() == botonRehacer) {
                if ((saveFiles - 1) > textoActual) {
                    textoActual++;
                    String textBoxString = originator.restaurarDeMemento(caretaker.getMemento(textoActual));
                    areaTexto.setText(textBoxString);
                    botonDeshacer.setEnabled(true);
                } else {
                    botonRehacer.setEnabled(false);
                }
            }
        }
    }
}