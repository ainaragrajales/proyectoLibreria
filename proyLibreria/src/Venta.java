import java.io.Serializable;

public class Venta implements Serializable {
    public int codigo;
    public int codLibro;
    public String tituloLibro;
    public int cantidad;
    public double precio;
    public double total;
    public String fecha;
    public String hora;

    public Venta() {
    }

    public Venta(int codigo, int codLibro, String tituloLibro, int cantidad, double precio, double total, String fecha, String hora) {
        this.codigo = codigo;
        this.codLibro = codLibro;
        this.tituloLibro = tituloLibro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo=" + codigo +
                ", codLibro=" + codLibro +
                ", tituloLibro='" + tituloLibro + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", total=" + total +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
