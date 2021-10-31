import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable {

    private int codigo;
    private String titulo;
    private String autor;
    private String formato;
    private String genero;
    private double precio;

    public Libro() {
    }

    //constructor
    public Libro(int codigo, String titulo, String autor, String formato, String genero, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.genero = genero;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "--->  " + codigo + "    " + titulo + "    " + autor +
                    "    " + formato + "   " + genero + "   " + precio;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return codigo == libro.codigo && Double.compare(libro.precio, precio) == 0 && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(formato, libro.formato) && Objects.equals(genero, libro.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, titulo, autor, formato, genero, precio);
    }
}
