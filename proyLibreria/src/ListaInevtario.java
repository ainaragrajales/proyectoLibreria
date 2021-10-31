import java.util.ArrayList;
import java.util.List;

public class ListaInevtario {
    private List<Inventario> lista = new ArrayList<>();

    public ListaInevtario() {
    }
    public void add(Inventario invent){
        lista.add(invent);
    }

    public List<Inventario> getLista() {
        return lista;
    }
}
