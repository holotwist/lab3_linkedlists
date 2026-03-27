public class Lista {
    private Nodo cabeza;
    private Nodo actual;

    public Lista() {
        this.cabeza = null;
        this.actual = null;
    }

    public void agregar(String url) {
        Nodo nuevo = new Nodo(url);
        if (cabeza == null) {
            cabeza = nuevo;
            actual = nuevo;
        } else {
            nuevo.anterior = actual;
            actual.siguiente = nuevo;
            actual = nuevo;
        }
    }

    public void eliminar(String url) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.url.equals(url)) {
                if (temp.anterior != null) temp.anterior.siguiente = temp.siguiente;
                else cabeza = temp.siguiente;
                if (temp.siguiente != null) temp.siguiente.anterior = temp.anterior;
                if (temp == actual) actual = temp.anterior != null ? temp.anterior : temp.siguiente;
                return;
            }
            temp = temp.siguiente;
        }
    }

    public boolean buscar(String url) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.url.equals(url)) return true;
            temp = temp.siguiente;
        }
        return false;
    }

    public void mostrar() {
        Nodo temp = cabeza;
        System.out.print("Historial: ");
        while (temp != null) {
            if (temp == actual) System.out.print("[" + temp.url + "] <-> ");
            else System.out.print(temp.url + " <-> ");
            temp = temp.siguiente;
        }
        System.out.println("Fin");
    }
}
