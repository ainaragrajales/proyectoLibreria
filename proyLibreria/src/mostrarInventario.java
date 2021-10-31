import java.io.*;
import java.net.Socket;

public class mostrarInventario {

    public static void mostrar(){

        try {
            RandomAccessFile frandom = new RandomAccessFile("./proyLibreria/ficheros/listaInventario.dat", "r");
            int cod, cantidad;
            String fecha, hora;
            int posicion = 0;
            int num = 0;


            System.out.println("     Codigo          Cantidad        Fecha      Hora\n\n" +
                               "----------------------------------------------------------------------\n");
            while (posicion < frandom.length() && posicion >= 0){

                posicion = num * 30;

                frandom.seek(posicion);

                cod = frandom.readInt();

                cantidad = frandom.readInt();

                fecha = frandom.readUTF();

                hora = frandom.readUTF();

                System.out.format("     %-16d%-16d%-16s%-16s\n", cod, cantidad, fecha, hora);
                num +=1;

            }
            System.out.println("\n");

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        try {

            RandomAccessFile frandom = new RandomAccessFile("./proyLibreria/ficheros/listaInventario.dat", "r");
            int cod, cantidad;
            String fecha, hora;
            int posicion = 0;



            System.out.println("Pos     Codigo          Cantidad        Fecha      Hora\n\n" +
                    "----------------------------------------------------------------------\n");
            while (posicion < frandom.length() && posicion >= 0){

                posicion = num * 30;

                frandom.seek(posicion);

                cod = frandom.readInt();

                cantidad = frandom.readInt();

                fecha = frandom.readUTF();
                hora = frandom.readUTF();

                System.out.format((num+1)+"     %-16d%-16d%-16s%-16s\n", cod, cantidad, fecha, hora);
                num +=1;


            }
            System.out.println("\n");
            frandom.close();



        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        catch (EOFException ef){

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (correcto!=1){
            System.out.println("Introduce el numero de la fila a modificar:");
            try {
                numero = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("Introduce un valor válido");
            }


            if (numero > 0 && numero <= num){
                correcto = 1;
            } else {
                correcto = 0;
            }

        }

        return numero;
    }
}
