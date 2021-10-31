import java.io.*;
import java.util.ArrayList;

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

    public static int devolverCod(){
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

                while (lista.get(codSelec) != null){
                    System.out.println("Pos     Libro\n\n" +
                            "-------------------------------------------------------------\n");
                    for (int i = 0; i < lista.size(); i++){
                        System.out.println(i + "  " + lista.get(i));
                    }
                    System.out.println("Escribe la posicion del libro que quieres seleccionar:");
                    codSelec = Integer.parseInt(br.readLine());
                }
                codigo = lista.get(codSelec).getCodigo();


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
        return codigo;
    }
}
