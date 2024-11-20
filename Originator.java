public class Originator {
    private String texto;

    //Produce/asigna el texto
    public void set(String nuevoTexto) {
        System.out.println("\nEn Originador: estado actual\n" + nuevoTexto + "\n");
        this.texto = nuevoTexto;
    }

    //Crea un nuevo memento con un nuevo texto
    public Memento crearMemento() {
        System.out.println("En Originador: guardando a Memento\n");
        return new Memento(texto);
    }

    //Regresa el texto que actualmente esta guardado en Memento
    public String restaurarDeMemento(Memento memento) {
        texto = memento.getTextoGuardado();
        //System.out.println("De Originador: texto previo guardado en Memento\n" + texto + "\n");
        return texto;
    }

}

