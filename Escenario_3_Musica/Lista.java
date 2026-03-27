public class Lista {
    private Nodo cabeza;
    private Nodo cola;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregar(String cancion) {
        Nodo nuevo = new Nodo(cancion);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
    }

    public void eliminar(String cancion) {
        if (cabeza == null) return;
        if (cabeza.cancion.equals(cancion) && cabeza == cola) {
            cabeza = null;
            cola = null;
            return;
        }
        if (cabeza.cancion.equals(cancion)) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != cabeza && !actual.siguiente.cancion.equals(cancion)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != cabeza) {
            if (actual.siguiente == cola) cola = actual;
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public boolean buscar(String cancion) {
        if (cabeza == null) return false;
        Nodo actual = cabeza;
        do {
            if (actual.cancion.equals(cancion)) return true;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo actual = cabeza;
        System.out.print("Playlist: ");
        do {
            System.out.print(actual.cancion + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(repite " + cabeza.cancion + ")");
    }
}
