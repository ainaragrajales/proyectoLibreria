import java.io.*;

public class mostrarLibros {

    public static void open() {

        Object obj;
        String fileName = "./proyLibreria/ficheros/listaLibros.dat";
        String fileName2 = "./ficheros/listaLibros.dat";

        try {


            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);


            try {

                while ((obj = oIn.readObject()) != null) {

                    Libro u = (Libro) obj;
                    System.out.println(u);

                }

            } catch (Exception e) {
            }

            fin.close();
            oIn.close();

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);

        } catch (IOException e) {

            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);

        }
    }

}
