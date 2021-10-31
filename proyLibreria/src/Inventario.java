import java.io.Serializable;

public class Inventario implements Serializable {

    private int cod_lib;
    private int cantidad;
    private double precio_lib;

    public Inventario(int cod_lib, int cantidad, double precio_lib) {
        this.cod_lib = cod_lib;
        this.cantidad = cantidad;
        this.precio_lib = precio_lib;
    }

    public int getCod_lib() {
        return cod_lib;
    }

    public void setCod_lib(int cod_lib) {
        this.cod_lib = cod_lib;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_lib() {
        return precio_lib;
    }

    public void setPrecio_lib(double precio_lib) {
        this.precio_lib = precio_lib;
    }
}
