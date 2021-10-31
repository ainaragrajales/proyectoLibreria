import java.io.*;



public class crearVentas {

    public static void insertar() {
        File file = new File("./proyLibreria/ficheros/listaVentas.dat");

        boolean append = file.exists();

        Libro libro;
        Venta venta = new Venta();
        FileOutputStream fOut;
        ObjectOutputStream oOut;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cod, cant;
        double precio;
        String fecha, hora;
        try {
            libro = mostrarLibros.seleccionarLibro();
            System.out.println("Introduce la cantidad a comprar: ");
            cant = Integer.parseInt(br.readLine());
            System.out.println("Introduce el precio del producto: ");
            precio = Double.parseDouble(br.readLine());
            System.out.println("Introduce la fecha de compra: ");
            fecha = br.readLine();
            System.out.println("Introduce la hora de compra: ");
            hora = br.readLine();

            fOut = new FileOutputStream(file, true);
            if (append) {

                oOut = new Appendable_objectoutputstream(fOut);
                cod = mostrarVentas.ultimoCodVenta();
                venta.setCodigo(cod);
            } else {

                oOut = new ObjectOutputStream(fOut);
                venta.setCodigo(1);


            }
            venta.setCodLibro(libro.getCodigo());
            venta.setTituloLibro(libro.getTitulo());
            venta.setCantidad(cant);
            venta.setPrecio(precio);
            venta.setTotal(cant * precio);
            venta.setFecha(fecha);
            venta.setHora(hora);

            oOut.writeObject(venta);
            oOut.flush();
            oOut.close();
            fOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //return false;
        } catch (IOException e) {
            e.printStackTrace();
            //return false;
        }
    }
}
