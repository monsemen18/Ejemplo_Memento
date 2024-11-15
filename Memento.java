public class Memento {
    //El texto es almacenado en un objeto memento
    private String estadoTexto;

    //Guardar un nuevo String(texto) a un objeto memento
    public Memento(String estadoTexto) {
        //System.out.println("\nestado(memento)\n");
        this.estadoTexto = estadoTexto;
    }

    public String getEstadoTexto() {
        //System.out.println("\nobtener estado");
        return estadoTexto;
    }
}