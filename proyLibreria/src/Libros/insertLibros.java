import java.io.*;

class Appendable_objectoutputstream extends ObjectOutputStream{

    public Appendable_objectoutputstream(OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        // TODO Auto-generated method stub
    }
}


public class insertLibros {

    public static boolean insertar(int codigo, String titulo, String autor, String formato, String genero, double precio){

        Libro libro1 = new Libro(codigo, titulo, autor, formato, genero, precio);

        File file = new File("./proyLibreria/ficheros/listaLibros.dat");

        boolean append = file.exists();

        FileOutputStream fOut;

        ObjectOutputStream oOut;
        try {

            if (append) {

                fOut = new FileOutputStream(file, true);
                oOut = new Appendable_objectoutputstream(fOut);

            } else {

                fOut = new FileOutputStream(file, true);
                oOut = new ObjectOutputStream(fOut);

            }

            oOut.writeObject(libro1);
            oOut.flush();
            oOut.close();
            fOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
