import java.io.Serializable;

public class Inventario implements Serializable {

    private int cod_lib;
    private int cantidad;
    private String fecha_mod;
    private String hora_mod;

    public Inventario(int cod_lib, int cantidad, String fecha_mod, String hora_mod) {
        this.cod_lib = cod_lib;
        this.cantidad = cantidad;
        this.fecha_mod = fecha_mod;
        this.hora_mod = hora_mod;
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

    public String getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(String fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public String getHora_mod() {
        return hora_mod;
    }

    public void setHora_mod(String hora_mod) {
        this.hora_mod = hora_mod;
    }
}
