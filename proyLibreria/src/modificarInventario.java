import java.io.*;

public class modificarInventario {

    public static void modificar(){
        try {
            int nuevaCant =0;
            String  nuevaFechaMod = "";
            String  nuevaHoraMod = "";
            StringBuffer bufferFecha, bufferHora;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int pos = mostrarInventario.devolverNumInventario();


            File fichero = new File("./proyLibreria/ficheros/listaInventario.dat");
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");




            int posicion;


            posicion = (pos - 1)*26; //Porque cada linea de inventario ocupa 26 bytes

            if (posicion >= file.length()){
                System.out.println("NO EXISTE LA LINEA DE INVENTARIO");
            }
            else{ //Sí que existe o puede existir
                System.out.println("Introduce la nueva cantidad:");
                nuevaCant = Integer.parseInt(br.readLine());

                System.out.println("Introduce la fecha de modifcación:");
                nuevaFechaMod = br.readLine();
                bufferFecha = new StringBuffer(nuevaFechaMod);
                bufferFecha.setLength(10);

                System.out.println("Introduce la hora de modifcación:");
                nuevaHoraMod = br.readLine();
                bufferHora = new StringBuffer(nuevaHoraMod);
                bufferHora.setLength(8);

                file.seek(posicion+4);
                file.writeInt(nuevaCant);
                file.writeUTF(bufferFecha.toString());
                file.writeUTF(bufferHora.toString());
            }
            file.close(); //Cerramos fichero
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
