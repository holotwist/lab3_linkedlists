public class Nodo {
    String url;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(String url) {
        this.url = url;
        this.siguiente = null;
        this.anterior = null;
    }
}
