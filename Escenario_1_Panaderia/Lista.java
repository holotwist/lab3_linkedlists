public class Lista {
    private Nodo cabeza;
    private Nodo cola;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregar(String cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
    }

    public void eliminar(String cliente) {
        if (cabeza == null) return;
        if (cabeza.cliente.equals(cliente)) {
            cabeza = cabeza.siguiente;
            if (cabeza == null) cola = null;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.cliente.equals(cliente)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente == null) cola = actual;
        }
    }

    public boolean buscar(String cliente) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.cliente.equals(cliente)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        System.out.print("Turnos: ");
        while (actual != null) {
            System.out.print(actual.cliente + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("Fin");
    }
}
