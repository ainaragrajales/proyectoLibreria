package Inventario;

import Libros.mostrarLibros;

import java.io.*;

public class addInventario {

    public static void add(){

        int cod = mostrarLibros.devolverCod();
        int cantidad = 0;
        double precio = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            System.out.println("Introduce la cantidad del inventario:");
            cantidad = Integer.parseInt(br.readLine());
            System.out.println("Introduce el precio:");
            precio = Double.parseDouble(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile fileEscribir = new RandomAccessFile("./ficheros/AleatEmple.dat", "rw");
            //posicion final
            long file_length = fileEscribir.length();

            //ir a la posicion del ultimo registro
            fileEscribir.seek(file_length);


            //añadir los datos del nuevo registro de inventario
            fileEscribir.writeInt(cod);
            fileEscribir.writeInt(cantidad);
            fileEscribir.writeDouble(precio);

            fileEscribir.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
