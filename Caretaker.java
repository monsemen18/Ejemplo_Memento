import java.util.ArrayList;

public class Caretaker {
    // donde todos los mementos son guardados
    ArrayList<Memento> savedArticles = new ArrayList<Memento>();

    // agrega memento a la ArrayList
    public void addMemento(Memento m) {
        savedArticles.add(m);
    }

    // regresa el memento deseado del ArrayList
    public Memento getMemento(int index) {
        return savedArticles.get(index);
    }
}
