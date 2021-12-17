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
                xstream.addImplicitCollection(ListaVenta.class, "lista");
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

    public static void convertirInventario(){
        try {
            File fichero = new File("./proyLibreria/ficheros/listaInventario.dat");
            //FileInputStream filein = new FileInputStream(fichero);//crea el flujo de entrada
            //conecta el flujo de bytes al flujo de datos
            //ObjectInputStream dataIS = new ObjectInputStream(filein);

            RandomAccessFile frandom = new RandomAccessFile("./proyLibreria/ficheros/listaInventario.dat", "r");
            int cod, cantidad;
            String fecha, hora;
            int posicion = 0;
            int num = 0;

            System.out.println("Comienza el proceso de creación del fichero a XML ...");
            //Creamos un objeto Lista de Personas
            //ListaVenta listaVenta = new ListaVenta();
            ListaInventario listaInventario = new ListaInventario();
            try {
                /*while (true) { //lectura del fichero
                    //Venta venta = (Venta) dataIS.readObject(); //leer una Persona
                    //listaVenta.add(venta); //a√±adir persona a la lista
                    Inventario inventario  ;
                }*/
                while (posicion < frandom.length() && posicion >= 0){

                    posicion = num * 30;

                    frandom.seek(posicion);

                    cod = frandom.readInt();

                    cantidad = frandom.readInt();

                    fecha = frandom.readUTF();

                    hora = frandom.readUTF();
                    Inventario inventario = new Inventario(cod, cantidad, fecha, hora);
                    listaInventario.add(inventario);
                    num +=1;

                }
            } catch (EOFException eo) {
                //System.out.println("Error1");
            }
            //dataIS.close(); //cerrar stream de entrada
            frandom.close();
            try {
                XStream xstream = new XStream();
                //cambiar de nombre a las etiquetas XML
                xstream.alias("ListaInventarioLibreria", ListaInventario.class);
                xstream.alias("DatosInventario", Inventario.class);
                //quitar etiqueta lista (atributo de la clase ListaPersonas)
                xstream.addImplicitCollection(ListaInventario.class, "lista");
                //Insrtar los objetos en el XML
                xstream.toXML(listaInventario, new FileOutputStream("./proyLibreria/ficheros/listaInventarioXML.xml"));
                System.out.println("Creado fichero XML....");
            } catch (Exception e) {
                System.out.println("Error2");
                //e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Error3");
            //e.printStackTrace();
        }
    }
}
