public class Memento {
    //El texto es almacenado en un objeto Memento
    private String texto;

    //Guardar un nuevo String(texto) a un objeto Memento
    public Memento(String texto) {
        this.texto = texto;
    }

    //Regresa el texto almacenado
    public String getTextoGuardado() {
        return texto;
    }
}
