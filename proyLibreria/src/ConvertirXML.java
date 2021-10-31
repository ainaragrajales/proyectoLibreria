import com.thoughtworks.xstream.XStream;

import java.io.*;

public class ConvertirXML {
    public static void convertirLibros() throws IOException {
        File fichero = new File("./proyLibreria/ficheros/listaLibros.dat");
        FileInputStream filein = new FileInputStream(fichero);//crea el flujo de entrada
        //conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso de creación del fichero a XML ...");
        //Creamos un objeto Lista de Personas
        ListaLibros listalib = new ListaLibros();
        try {
            while (true) { //lectura del fichero
                Libro lib = (Libro) dataIS.readObject(); //leer una Persona
                listalib.add(lib); //a√±adir persona a la lista

            }

        } catch (EOFException | ClassNotFoundException eo) {
        }
        dataIS.close(); //cerrar stream de entrada
        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaLibrosLibreria", ListaLibros.class);
            xstream.alias("DatosLibro", Libro.class);
            //quitar etiwueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaLibros.class, "lista");
            //Insrtar los objetos en el XML
            xstream.toXML(listalib, new FileOutputStream("./proyLibreria/ficheros/listaLibrosXML.xml"));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertirVentas(){
        try {
            File fichero = new File("./proyLibreria/ficheros/listaVentas.dat");
            FileInputStream filein = new FileInputStream(fichero);//crea el flujo de entrada
            //conecta el flujo de bytes al flujo de datos
            ObjectInputStream dataIS = new ObjectInputStream(filein);
            System.out.println("Comienza el proceso de creación del fichero a XML ...");
            //Creamos un objeto Lista de Personas
            ListaVenta listaVenta = new ListaVenta();
            try {
                while (true) { //lectura del fichero
                    Venta venta = (Venta) dataIS.readObject(); //leer una Persona
                    listaVenta.add(venta); //a√±adir persona a la lista
                }
            } catch (EOFException | ClassNotFoundException eo) {
            }
            dataIS.close(); //cerrar stream de entrada
            try {
                XStream xstream = new XStream();
                //cambiar de nombre a las etiquetas XML
                xstream.alias("ListaVentasLibreria", ListaVenta.class);
                xstream.alias("DatosVenta", Venta.class);
                //quitar etiwueta lista (atributo de la clase ListaPersonas)
                xstream.addImplicitCollection(ListaLibros.class, "lista");
                //Insrtar los objetos en el XML
                xstream.toXML(listaVenta, new FileOutputStream("./proyLibreria/ficheros/listaVentasXML.xml"));
                System.out.println("Creado fichero XML....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
