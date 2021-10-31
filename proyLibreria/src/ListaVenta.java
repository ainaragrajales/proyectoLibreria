import java.util.ArrayList;
import java.util.List;

public class ListaVenta {
    private List<Venta> lista = new ArrayList<>();

    public ListaVenta() {
    }

    public void add(Venta venta){
        lista.add(venta);
    }

    public List<Venta> getLista() {
        return lista;
    }
}
