import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class mostrarInventario {

    public static void mostrar(){

        try {
            RandomAccessFile frandom = new RandomAccessFile("./ficheros/listaInventario.dat", "r");
            int cod, cantidad;
            Double precio;
            int posicion = 0;
            int num = 0;


            while (posicion < frandom.length() && posicion >= 0){

                posicion = num * 16;

                frandom.seek(posicion);

                cod = frandom.readInt();

                cantidad = frandom.readInt();

                precio = frandom.readDouble();

                System.out.format("%-5d%-5d%.2f €\n", cod, cantidad, precio);
                num +=1;

            }

            frandom.close();

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        catch (EOFException ef){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
