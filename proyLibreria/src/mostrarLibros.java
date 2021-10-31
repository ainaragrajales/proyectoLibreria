


import java.io.*;
import java.util.ArrayList;

public class mostrarLibros {

    public static void open() {
        Object obj;
        String fileName = "./proyLibreria/ficheros/listaLibros.dat";
        String fileName2 = "./ficheros/listaLibros.dat";
        ArrayList<Libro> lista = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {

                while ((obj = oIn.readObject()) != null) {
                    Libro u = (Libro) obj;
                    lista.add(u);
                    //System.out.println(u);
                }
            } catch (Exception e) {
                //System.out.println("\nFin del archivo\n");
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

        System.out.println("      Codigo    Titulo              Autor                         Formato             Genero            Precio\n\n" +
                "------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf(" ---> %-10d%-20s%-30s%-20s%-18s%.2f €\n", lista.get(i).getCodigo(), lista.get(i).getTitulo(), lista.get(i).getAutor(), lista.get(i).getFormato(), lista.get(i).getGenero(), lista.get(i).getPrecio());
        }

    }

    public static int devolverCod() {
        Object obj;
        String fileName = "./proyLibreria/ficheros/listaLibros.dat";
        String fileName2 = "./ficheros/listaLibros.dat";
        ArrayList<Libro> lista = new ArrayList<>();
        int codSelec = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int codigo = 0;

        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {

                while ((obj = oIn.readObject()) != null) {
                    Libro u = (Libro) obj;
                    lista.add(u);
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
        System.out.println("Pos     Codigo      Titulo                    Autor                         Formato           Genero            Precio\n\n" +
                "------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("%2s   %-16d%-25s%-30s%-18s%-18s%.2f € \n", i, lista.get(i).getCodigo(), lista.get(i).getTitulo(), lista.get(i).getAutor(), lista.get(i).getFormato(), lista.get(i).getGenero(), lista.get(i).getPrecio());

        }
        System.out.println("\nEscribe la posicion del libro que quieres seleccionar:");
        try {
            codSelec = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        codigo = lista.get(codSelec).getCodigo();
        return codigo;
    }

    public static Libro seleccionarLibro() {
        Object obj;
        String fileName = "./proyLibreria/ficheros/listaLibros.dat";
        String fileName2 = "./ficheros/listaLibros.dat";
        ArrayList<Libro> libros = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Libro libroSelec = new Libro();
        int selec = 0;
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {

                while ((obj = oIn.readObject()) != null) {
                    Libro u = (Libro) obj;
                    libros.add(u);

                }
            } catch (Exception e) {
                //System.out.println("Error");
            }
            fin.close();
            oIn.close();
            System.out.println("Pos     Codigo      Titulo                    Autor                         Formato           Genero            Precio\n\n" +
                    "------------------------------------------------------------------------------------------------------------------------------------------\n");
            for (int i = 0; i < libros.size(); i++) {
                System.out.printf("%2s   %-16d%-25s%-30s%-18s%-18s%.2f € \n", i, libros.get(i).getCodigo(), libros.get(i).getTitulo(), libros.get(i).getAutor(), libros.get(i).getFormato(), libros.get(i).getGenero(), libros.get(i).getPrecio());

            }
            System.out.println("\nEscribe la posicion del libro que quieres seleccionar:");
            selec = Integer.parseInt(br.readLine());
            libroSelec = libros.get(selec);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read : " + e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("failed to read2 : " + e);
        }
        return libroSelec;
    }
}
