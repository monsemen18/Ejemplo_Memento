public class Memento {
    //El texto es almacenado en un objeto memento
    private String texto;

    //Guardar un nuevo String(texto) a un objeto memento
    public Memento(String texto) {
        this.texto = texto;
    }

    public String getTextoGuardado() {
        return texto;
    }
}