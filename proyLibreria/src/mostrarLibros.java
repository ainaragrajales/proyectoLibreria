import java.io.*;

public class mostrarLibros {
    public static void mostrar(){
        ObjectInputStream objectIS = null;

        try {
            File fichero = new File("./ficheros/listaLibros.dat");
            FileInputStream filein = new FileInputStream(fichero);
            objectIS = new ObjectInputStream(filein);


            while (true) {
                Libro l1 = (Libro) objectIS.readObject();
                System.out.println(l1);
            }

        } catch (FileNotFoundException fn) {

            System.out.println("No se encuentra el fichero");

        } catch (ClassNotFoundException e) {

            System.out.println("Error");

        } catch (EOFException e) {

            //System.out.println("");

        } catch (IOException io){
            System.out.println();
        } finally {
            try {
                objectIS.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}