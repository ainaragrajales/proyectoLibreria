

import java.io.*;

public class addInventario {

    public static void add() {

        int cod = mostrarLibros.devolverCod();
        int cantidad = 0;
        String fecha_mod = "";
        String hora_mod = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer buffer, buffer1;


        try {
            System.out.println("Introduce la cantidad del inventario:");
            cantidad = Integer.parseInt(br.readLine());
            System.out.println("Introduce la fecha de modificación:");
            fecha_mod = br.readLine();
            System.out.println("Introduce la hora de modificación:");
            hora_mod = br.readLine();

        } catch (IOException e) {
            System.out.println("Error");
        }

        try {
            RandomAccessFile fileEscribir = new RandomAccessFile("./proyLibreria/ficheros/listaInventario.dat", "rw");
            //posicion final
            long file_length = fileEscribir.length();

            //ir a la posicion del ultimo registro
            fileEscribir.seek(file_length);


            //añadir los datos del nuevo registro de inventario
            fileEscribir.writeInt(cod);
            fileEscribir.writeInt(cantidad);
            buffer = new StringBuffer(fecha_mod);
            buffer.setLength(10);
            fileEscribir.writeUTF(buffer.toString());
            buffer1 = new StringBuffer(hora_mod);
            buffer1.setLength(8);
            fileEscribir.writeUTF(buffer1.toString());

            fileEscribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
