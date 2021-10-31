import java.io.*;

public class modificarInventario {

    public static void modificar(){
        try {
            int mod = 0;
            int nuevaCant =0;
            double nuevoPrecio = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int pos = mostrarInventario.devolverNumInventario();


            File fichero = new File("./proyLibreria/ficheros/listaInventario.dat");
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");




            int posicion;


            posicion = (pos - 1)*16; //Porque cada linea de inventario ocupa 16 bytes

            if (posicion >= file.length()){
                System.out.println("NO EXISTE LA LINEA DE INVENTARIO");
            }
            else{ //Sí que existe o puede existir
                while (mod!=-1) {
                    System.out.println("¿Que datos quieres modificar?\n" +
                            " 1 cantidad\n" +
                            " 2 precio\n" +
                            " 3 ambos.");
                    mod = Integer.parseInt(br.readLine());
                    if (mod == 1){
                        System.out.println("Introduce la nueva cantidad:");
                        nuevaCant = Integer.parseInt(br.readLine());
                        file.seek(posicion+4);
                        file.writeInt(nuevaCant);
                    } else if (mod ==2){
                        System.out.println("Introduce el nuevo precio:");
                        nuevoPrecio = Double.parseDouble(br.readLine());
                        file.seek(posicion+4+4);
                        file.writeDouble(nuevoPrecio);
                    } else if (mod == 3){
                        System.out.println("Introduce la nueva cantidad:");
                        nuevaCant = Integer.parseInt(br.readLine());
                        file.seek(posicion+4);
                        file.writeInt(nuevaCant);

                        System.out.println("Introduce el nuevo precio:");
                        nuevoPrecio = Double.parseDouble(br.readLine());
                        file.seek(posicion+4+4);
                        file.writeDouble(nuevoPrecio);
                    } else {
                        mod = -1;
                    }
                }
            }
            file.close(); //Cerramos fichero
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
