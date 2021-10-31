

import java.util.ArrayList;
import java.util.List;

public class ListaLibros {
    private List<Libro> lista = new ArrayList<>();

    public ListaLibros() {
    }

    public void add(Libro lib) {
        lista.add(lib);
    }
    public List<Libro> getListaLibros(){
        return lista;
    }
}
