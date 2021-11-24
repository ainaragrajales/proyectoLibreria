import java.util.ArrayList;
import java.util.List;

public class ListaInventario {
    private List<Inventario> lista = new ArrayList<>();

    public ListaInventario() {
    }

    public void add(Inventario inventario) { lista.add(inventario);}

    public List<Inventario> getListaInventario(){return lista;}
}
