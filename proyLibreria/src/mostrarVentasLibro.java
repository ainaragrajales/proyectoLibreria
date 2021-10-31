
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class mostrarVentasLibro {
    public static void mostrarVentasLibroEspecifico(){
        int codLibroSelec = mostrarLibros.devolverCod();
        int cod;

        Object obj;
        String fileName = "./proyLibreria/ficheros/listaVentas.dat";
        int hay = -1;
        try{
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oIn = new ObjectInputStream(fin);
            try {
                while ((obj = oIn.readObject()) != null) {
                    Venta u = (Venta) obj;
                    cod = u.getCodLibro();
                    if (cod == codLibroSelec){
                        System.out.println(u);
                        hay = 1;
                    }
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
        if (hay!=1){
            System.out.println("No hay ventas de ese libro");
        }
    }
}
