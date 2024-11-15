import java.util.ArrayList;

public class Caretaker {
    //Donde todos los mementos(estados) son guardados
    ArrayList<Memento> textoGuardado = new ArrayList<Memento>();

    //Agrega memento al ArrayList
    public void addMemento(Memento m) {
        //System.out.println("\nse agrega memento al arreglo\n");
        textoGuardado.add(m);
    }

    //obtener el memento deseado del ArrayList
    public Memento getMemento(int index) {
        //System.out.println("\nse regresa el ultimo memento agregado al arreglo\n");
        return textoGuardado.get(index);
    }
}
