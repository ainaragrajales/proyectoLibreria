
import java.io.*;
import java.util.ArrayList;

public class mostrarVentas {

    public static void mostrar() {
        Object obj;
        String fileName = "./proyLibreria/ficheros/listaVentas.dat";
        ArrayList<Venta> lista = new ArrayList<>();
        try{
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                while ((obj = oIn.readObject()) != null) {
                    Venta u = (Venta) obj;
                    lista.add(u);
                }
            } catch (Exception e) {
                //System.out.println("Error");
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
        System.out.println("    Cod   CodLibro  Titulo            Cantidad    Precio      Total   Fecha       Hora\n" +
                "----------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf(" ---> %-4d%-10d%-20s%-10d%.2f€       %.2f€   %-12s%-12s\n", lista.get(i).getCodigo(), lista.get(i).getCodLibro(), lista.get(i).getTituloLibro(), lista.get(i).getCantidad(), lista.get(i).getPrecio(), lista.get(i).getTotal(), lista.get(i).getFecha(), lista.get(i).getHora());
        }
    }

    public static int ultimoCodVenta() {
        Object obj;
        String fileName = "./proyLibreria/ficheros/listaVentas.dat";
        String fileName2 = "./ficheros/listaLibros.dat";
        ArrayList<Venta> ventas = new ArrayList<>();
        int codSelec = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int codigo = 0;
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                while ((obj = oIn.readObject()) != null) {
                    Venta u = (Venta) obj;
                    ventas.add(u);
                }
                for (int i = 0; i < ventas.size(); i++) {
                    codSelec = codSelec + i;
                }
                codigo = ventas.get(codSelec).getCodigo();
            } catch (Exception e) {
                System.out.println("Error");
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
