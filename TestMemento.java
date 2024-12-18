import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TestMemento extends JFrame {
    public static void main(String[] args) {
        new TestMemento();
    }

    private JButton botonGuardar, botonDeshacer, botonRehacer;
    private JTextArea areaTexto = new JTextArea(40, 60);

    // Crear los objetos Originator y Caretaker
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();

    int textoGuardado = 0;
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
        textPanel.add(new JScrollPane(areaTexto));
        this.add(textPanel, BorderLayout.CENTER);

        // Panel para los botones, centrados en la parte inferior
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        Controlador accionGuardar = new Controlador();
        Controlador accionDeshacer = new Controlador();
        Controlador accionRehacer = new Controlador();

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(accionGuardar);
        botonGuardar.setEnabled(false); // Deshabilitar el botón inicialmente

        botonDeshacer = new JButton("Deshacer");
        botonDeshacer.addActionListener(accionDeshacer);

        botonRehacer = new JButton("Rehacer");
        botonRehacer.addActionListener(accionRehacer);

        buttonPanel.add(botonGuardar);
        buttonPanel.add(botonDeshacer);
        buttonPanel.add(botonRehacer);

        // Agregar el panel de botones en la parte inferior
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar DocumentListener al área de texto
        areaTexto.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                actualizarEstadoBotonGuardar();
            }

            public void removeUpdate(DocumentEvent e) {
                actualizarEstadoBotonGuardar();
            }

            public void insertUpdate(DocumentEvent e) {
                actualizarEstadoBotonGuardar();
            }
        });

        this.setVisible(true);
    }

    private void actualizarEstadoBotonGuardar() {
        botonGuardar.setEnabled(!areaTexto.getText().trim().isEmpty());
    }

    class Controlador implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonGuardar) {
                String textoEnTextArea = areaTexto.getText();
                originator.set(textoEnTextArea);
                caretaker.addMemento(originator.crearMemento());
                textoGuardado++;
                textoActual++;
                System.out.println("texto " + textoGuardado + " guardado");
                System.out.println("-------------------------------------------------------------");
                botonGuardar.setEnabled(false); // Deshabilitar el botón después de guardar
                botonDeshacer.setEnabled(true);
            } else if (e.getSource() == botonDeshacer) {
                if (textoActual >= 1) {
                    textoActual--;
                    String textoEnCuadro = originator.restaurarDeMemento(caretaker.getMemento(textoActual));
                    areaTexto.setText(textoEnCuadro);
                    botonRehacer.setEnabled(true);
                    botonGuardar.setEnabled(false);
                } else {
                    botonDeshacer.setEnabled(false);
                }
            } else if (e.getSource() == botonRehacer) {
                if ((textoGuardado - 1) > textoActual) {
                    textoActual++;
                    String textoEnCuadro = originator.restaurarDeMemento(caretaker.getMemento(textoActual));
                    areaTexto.setText(textoEnCuadro);
                    botonDeshacer.setEnabled(true);
                    botonGuardar.setEnabled(false);
                } else {
                    botonRehacer.setEnabled(false);
                }
            }
        }
    }
}

