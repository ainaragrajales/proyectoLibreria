import java.io.*;
import java.net.Socket;

public class mostrarInventario {

    public static void mostrar(){

        try {
            RandomAccessFile frandom = new RandomAccessFile("./proyLibreria/ficheros/listaInventario.dat", "r");
            int cod, cantidad;
            double precio;
            int posicion = 0;
            int num = 0;


            System.out.println("     Codigo          Cantidad        Precio\n\n" +
                               "--------------------------------------------------\n");
            while (posicion < frandom.length() && posicion >= 0){

                posicion = num * 16;

                frandom.seek(posicion);

                cod = frandom.readInt();

                cantidad = frandom.readInt();

                precio = frandom.readDouble();

                System.out.format("     %-16d%-16d%.2f €\n", cod, cantidad, precio);
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

    public static int devolverNumInventario(){
        int numero = 1;
        int correcto = -1;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            RandomAccessFile frandom = new RandomAccessFile("./proyLibreria/ficheros/listaInventario.dat", "r");
            int cod, cantidad;
            double precio;
            int posicion = 0;
            int num = 0;


            System.out.println("      Codigo          Cantidad        Precio\n\n" +
                    "--------------------------------------------------\n");
            while (posicion < frandom.length() && posicion >= 0){

                posicion = num * 16;

                frandom.seek(posicion);

                cod = frandom.readInt();

                cantidad = frandom.readInt();

                precio = frandom.readDouble();

                System.out.format((num+1) + "     %-16d%-16d%.2f €\n", cod, cantidad, precio);
                num +=1;


            }

            frandom.close();
            while (correcto!=1){
                System.out.println("Introduce el numero de la fila a modificar:");
                numero = Integer.parseInt(br.readLine());


                if (numero > 0 && numero <= num){
                    correcto = 1;
                } else {
                    correcto = 0;
                }

            }


        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        catch (EOFException ef){

        } catch (IOException e) {
            e.printStackTrace();
        }

        return numero;
    }
}
