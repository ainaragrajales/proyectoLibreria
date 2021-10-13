import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class crearInventario {

    public static void crear(){
        int[] codigos = {12045087, 74032998, 12321378};
        int[] cantidad = {20, 12, 35};
        double[] precios = {12.5, 10.4, 8.75};

        try {
            RandomAccessFile frandom = new RandomAccessFile("./ficheros/listaInventario.dat", "rw");

            //cada linea son 16bytes (codLib->entero 4 + cantidad->entero 4 + precio->doble 8)
            for (int i = 0; i < codigos.length; i++) {

                //codlib
                frandom.writeInt(codigos[i]);

                //cantidad
                frandom.writeInt(cantidad[i]);

                //precio
                frandom.writeDouble(precios[i]);

            }

            frandom.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
