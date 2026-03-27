public class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    public void agregar(String jugador) {
        Nodo nuevo = new Nodo(jugador);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            Nodo cola = cabeza.anterior;
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
    }

    public void eliminar(String jugador) {
        if (cabeza == null) return;
        Nodo actual = cabeza;
        do {
            if (actual.jugador.equals(jugador)) {
                if (actual.siguiente == actual) {
                    cabeza = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    if (actual == cabeza) cabeza = actual.siguiente;
                }
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public boolean buscar(String jugador) {
        if (cabeza == null) return false;
        Nodo actual = cabeza;
        do {
            if (actual.jugador.equals(jugador)) return true;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Mesa vacía");
            return;
        }
        Nodo actual = cabeza;
        System.out.print("Mesa: ");
        do {
            System.out.print(actual.jugador + " <-> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(repite " + cabeza.jugador + ")");
    }
}
