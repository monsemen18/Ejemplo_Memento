public class Originator {
    private String article;

    // asigna el valor para el articulo
    public void set(String newArticle) {
        System.out.println("En Originador: versión actual\n" + newArticle + "\n");
        this.article = newArticle;
    }

    // crea un nuevo memento con un nuevo articulo
    public Memento storeInMemento() {
        System.out.println("En Originador: guardando a Memento");
        return new Memento(article);
    }

    // regresa el articulo que actualmente esta guardado en Memento
    public String restoreFromMemento(Memento memento) {
        article = memento.getSavedArticle();
        System.out.println("De Originador: Articulo previo guardado en Memento" + article + "\n");
        return article;
    }

}
