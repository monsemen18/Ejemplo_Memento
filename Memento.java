public class Memento {
    // el doc es almacenado en un objeto memento
    private String article;

    // guardar un nuevo doc String a un objeto memento
    public Memento(String articleSave) {
        article = articleSave;
    }

    public String getSavedArticle() {
        return article;
    }
}