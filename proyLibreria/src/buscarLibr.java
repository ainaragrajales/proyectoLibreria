

import java.io.*;

public class buscarLibr {

    public static void buscPorTitulo() {
        ObjectInputStream objectIS = null;
        //int no_encontrado = 0;
        String titulo;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            File fichero = new File("./proyLibreria/ficheros/listaLibros.dat");
            FileInputStream filein = new FileInputStream(fichero);
            objectIS = new ObjectInputStream(filein);

            System.out.println("Escribe el titulo del libro a buscar");
            titulo = br.readLine();

            System.out.println("\nResultado:");
            while (true) {
                Libro l1 = (Libro) objectIS.readObject();


                if (l1.getTitulo().contains(titulo)) {
                    System.out.println(l1);

                }
            }




        } catch (FileNotFoundException fn) {

            System.out.println("No se encuentra el fichero");

        } catch (ClassNotFoundException e) {

            System.out.println("Error");

        } catch (EOFException e) {

            //System.out.println("");

        } catch (IOException io) {

            System.out.println("");

        } finally {

            try {
                objectIS.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

