import java.util.ArrayList;

public class Caretaker {
    //Donde todos los mementos(estados) son guardados
    ArrayList<Memento> textoGuardado = new ArrayList<Memento>();

    //Agrega memento al ArrayList
    public void addMemento(Memento m) {
        textoGuardado.add(m);
    }

    //Obtener el memento deseado del ArrayList
    public Memento getMemento(int index) {
        return textoGuardado.get(index);
    }
}
