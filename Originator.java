public class Originator {
    private String texto;

    //Asigna el texto
    public void set(String newTexto) {
        System.out.println("\nEn Originador: estado actual\n" + newTexto + "\n");
        this.texto = newTexto;
    }

    //Crea un nuevo memento con un nuevo texto
    public Memento guardarEnMemento() {
        System.out.println("En Originador: guardando a Memento\n");
        return new Memento(texto);
    }

    //Regresa el texto que actualmente esta guardado en Memento
    public String restaurarDeMemento(Memento memento) {
        texto = memento.getEstadoTexto();
        System.out.println("De Originador: texto previo guardado en Memento\n" + texto + "\n");
        return texto;
    }

}
