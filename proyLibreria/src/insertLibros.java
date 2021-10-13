import java.io.*;

public class insertLibros {
    public static void insert(){
        try {

            File fichero = new File("./ficheros/listaLibros.dat");
            FileOutputStream fileout = new FileOutputStream(fichero);
            ObjectOutputStream objectOS = new ObjectOutputStream(fileout);

            //primero crearlos desde programa, más adelante pedir al usuario que meta los datos del libr
            Libro l1 = new Libro(12045087, "Dune", "Frank Herbert", "libro bolsillo", "ciencia ficción", 12.5);
            Libro l3 = new Libro(12321378, "Moon called", "Patricia Briggs", "libro bolsillo", "ciencia ficción", 8.75);
            Libro l2 = new Libro(74032998, "The Martian", "Andy Weir", "libro bolsillo", "ciencia ficción", 10.4);

            objectOS.writeObject(l1);
            objectOS.writeObject(l3);
            objectOS.writeObject(l2);

            objectOS.close();


        } catch (FileNotFoundException fn) {

            System.out.println("No se encuentra el fichero");

        } catch (IOException e) {

            System.out.println("Error");

        }
    }
}
