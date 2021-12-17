import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Cargar {

    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8083/exist/xmlrpc/db/PruebasLibreria"; //URI colección
    static String usu = "admin"; //Usuario
    static String usuPwd = ""; //Clave
    static Collection col = null;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void crearColeccion() {
        String URIcrear = "xmldb:exist://localhost:8083/exist/xmlrpc/db/";
        try {
            Class cl = Class.forName(driver); //Cargar del driver
            Database database = (Database) cl.getDeclaredConstructor().newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
            col = DatabaseManager.getCollection(URIcrear, usu, usuPwd);
            CollectionManagementService cserv = (CollectionManagementService) col.getService("CollectionManagementService", "1.0");
            cserv.createCollection("PruebasLibreria");
            System.out.println("Colección creada");
            col.close();
        } catch (XMLDBException e) {
            System.out.println("Error al inicializar la BD eXist.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver.");
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error al instanciar la BD.");
        } catch (InvocationTargetException e) {
            System.out.println("Error");
        } catch (NoSuchMethodException e) {
            System.out.println("Error2");
        }
    }

    public static Collection conectar() {

        try {
            Class cl = Class.forName(driver); //Cargar del driver
            Database database = (Database) cl.getDeclaredConstructor().newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
            col = DatabaseManager.getCollection(URI, usu, usuPwd);
            return col;
        } catch (XMLDBException e) {
            System.out.println("Error al inicializar la BD eXist.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver.");
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error al instanciar la BD.");
        } catch (InvocationTargetException e) {
            System.out.println("Error");
        } catch (NoSuchMethodException e) {
            System.out.println("Error2");
        }
        return null;
    }

    public static void cargarColeccion(String nombreXML) {
        if (conectar() != null) {
            try {
                // Inicializamos el recurso
                XMLResource res = null;
                // Creamos el recurso -> recibe 2 parámetros tipo String:
                // s: nombre.xml (si lo dejamos null, pondrá un nombre aleatorio)
                // s1: tipo recurso (en este caso, siempre será XMLResource)
                res = (XMLResource) col.createResource(nombreXML, "XMLResource");
                // Elegimos el fichero .xml que queremos añadir a la colección
                File f = new File("./ficheros/" + nombreXML);

                // Fijamos como contenido ese archivo .xml elegido
                res.setContent(f);
                col.storeResource(res); // lo añadimos a la colección

                // Listamos la colección para ver que en efecto se ha añadido
                System.out.println("\nListado de la colección");
                for (String colRe : col.listResources())
                    System.out.println("    --> " + colRe);

                col.close();

            } catch (XMLDBException e) {
                System.out.println("Error en la base de datos xml");
            }
        } else {
            System.out.println("Error en la conexión. Comprueba los datos.");

        }
    }

    public static String listarConsultas() {
        String selec = "";
        File carpeta = new File("./consultas");
        String[] listaFicheros = carpeta.list();
        for (int i = 0; i < listaFicheros.length; i++) {
            System.out.println(i + " --> " + listaFicheros[i]);
        }
        int pos;
        try {
            System.out.println("Elige la posición de la consulta");
            pos = Integer.parseInt(br.readLine());
            selec = listaFicheros[pos];
        } catch (IOException e) {
            System.out.println("Error");
        }

        return selec;
    }

    public static void ejecutarConsultaFichero(String consul) {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(consul));
            String linea = null;
            StringBuilder stringBuilder = new StringBuilder();
            String salto = System.getProperty("line.separator");
            while ((linea = entrada.readLine()) != null) {
                stringBuilder.append(linea);
                stringBuilder.append(salto);
            }
            String consulta = stringBuilder.toString();
            System.out.println("Consulta: " + consulta);
            //Ejecutar la consulta
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService",
                    "1.0");
            ResourceSet result = servicio.query(consulta);
            ResourceIterator i;
            i = result.getIterator();
            if (!i.hasMoreResources()) {
                System.out.println("La consulta no devuelve nada");
            }
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                System.out.println("Elemento: " + (String) r.getContent());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error fichero no encontrado: " +
                    consul);
        } catch (XMLDBException e) {
            System.out.println("Error");
        } catch (IOException e) {
            System.out.println("Error no controlado");
        }

    }

    public static void ejecutarConsulta(String consulta) {
        try {
            //Ejecutar la consulta
            XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService",
                    "1.0");
            ResourceSet result = servicio.query(consulta);
            ResourceIterator i;
            i = result.getIterator();
            if (!i.hasMoreResources()) {
                System.out.println("La consulta no devuelve nada");
            }
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                System.out.println("Elemento: " + (String) r.getContent());
            }
        } catch (XMLDBException e) {
            System.out.println("Error");
        }
    }

    public static void consultas() {
        int opcion;
        String consult;
        System.out.println("Opciones:\n" +
                "   1.- Elegir consulta existente.\n" +
                "   2.- Introducir consulta por teclado.\n" +
                "   3.- Volver al menú.\n");

        try {
            opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 1:
                    System.out.println("Mostrando consultas, elige una de ellas");
                    consult = listarConsultas();
                    ejecutarConsultaFichero(consult);
                    break;
                case 2:
                    System.out.println("Escribe la consulta a realizar");
                    consult = br.readLine();
                    ejecutarConsulta(consult);
                    break;
                case 3:
                    System.out.println("Volviendo al menú.");
                    break;
                default:
                    System.out.println("Opción no válida, introduce una correcta.");
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error de valor. Introduce el valor correcto.");
        }


    }

    public static void insertar(int opcion, String datos) {

        if (conectar() != null) {
            if (opcion == 1) {
                //Insertar libro
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    System.out.printf("Inserto: %s \n", datos);
                    //Consulta para insertar --> update insert ... into
                    ResourceSet result = servicio.query("update insert " + datos + " into /ListaLibrosLibreria");
                    col.close(); //borramos
                    System.out.println("Libro insertado.");
                } catch (Exception e) {
                    System.out.println("Error al insertar el libro.");
                }
            } else if (opcion == 2) {
                //Insertar venta
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    System.out.printf("Inserto: %s \n", datos);
                    //Consulta para insertar --> update insert ... into
                    ResourceSet result = servicio.query("update insert " + datos + " into /ListaVentasLibreria");
                    col.close(); //borramos
                    System.out.println("Venta insertado.");
                } catch (Exception e) {
                    System.out.println("Error al insertar la venta.");
                }
            } else {
                //Insertar inventario
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    System.out.printf("Inserto: %s \n", datos);
                    //Consulta para insertar --> update insert ... into
                    ResourceSet result = servicio.query("update insert " + datos + " into /ListaInventarioLibreria");
                    col.close(); //borramos
                    System.out.println("Libro insertado.");
                } catch (Exception e) {
                    System.out.println("Error al insertar el libro.");
                }
            }
        } else {
            System.out.println("Error en la conexión. Comprueba los datos.");
        }
    }

    public static void modificar(int opcion, int mod, int cod) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String libro = "";
        if (conectar() != null) {

            if (opcion == 1) {
                //Modificar libro
                if (existeLibro(cod)) {
                    switch (mod) {
                        case 1:
                            try {
                                System.out.println("Introduce el nuevo formato del libro");
                                String formato = br.readLine();

                                System.out.printf("Actualizo el libro: %s\n", libro);
                                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                                //Consulta para modificar/actualizar un valor --> update value
                                ResourceSet result = servicio.query(
                                        "update value /ListaLibrosLibreria/DatosLibro[codigo=" + libro + "]/titulo/autor/formato with data('" + formato + "') ");

                                col.close();
                                System.out.println("libro actualizado.");
                            } catch (Exception e) {
                                System.out.println("Error al actualizar.");
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Introduce el nuevo género del libro");
                                String genero = br.readLine();

                                System.out.printf("Actualizo el libro: %s\n", libro);
                                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                                //Consulta para modificar/actualizar un valor --> update value
                                ResourceSet result = servicio.query(
                                        "update value /ListaLibrosLibreria/DatosLibro[codigo=" + libro + "]/titulo/autor/formato/genero with data('" + genero + "') ");

                                col.close();
                                System.out.println("libro actualizado.");
                            } catch (Exception e) {
                                System.out.println("Error al actualizar.");
                            }
                            break;
                        case 3:
                            try {
                                System.out.println("Introduce el nuevo precio del libro");
                                double precio = Double.parseDouble(br.readLine());

                                System.out.printf("Actualizo el libro: %s\n", libro);
                                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                                //Consulta para modificar/actualizar un valor --> update value
                                ResourceSet result = servicio.query(
                                        "update value /ListaLibrosLibreria/DatosLibro[codigo=" + libro + "]/titulo/autor/formato/genero/precio with data('" + precio + "') ");

                                col.close();
                                System.out.println("libro actualizado.");
                            } catch (Exception e) {
                                System.out.println("Error al actualizar.");
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("El libro NO EXISTE.");
                }
            } else if (opcion == 2) {
                //Modificar inventario
                if (existeInventario(cod)) {
                    try {
                        System.out.println("Introduce la nueva cantidad del inventario");
                        int cant = Integer.parseInt(br.readLine());


                        System.out.printf("Actualizo el libro: %s\n", libro);
                        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                        //Consulta para modificar/actualizar un valor --> update value
                        ResourceSet result = servicio.query(
                                "update value /ListaInventarioLibreria/DatosInventario[cod__lib=" + libro + "]/cantidad with data('" + cant + "') ");

                        col.close();
                        System.out.println("libro actualizado.");
                    } catch (Exception e) {
                        System.out.println("Error al actualizar.");
                    }
                } else {
                    System.out.println("El inventario NO EXISTE.");
                }
            }

        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }

    public static void eliminar(int opcion, int cod) {
        String codLibro = "";
        if (conectar() != null) {
            if (opcion == 1) {
                //Eliminar libro
                if (existeLibro(cod)) {
                    try {
                        System.out.printf("Borro el libro: %s\n", codLibro);
                        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                        //Consulta para borrar un libro --> update delete
                        ResourceSet result = servicio.query(
                                "update delete /ListaLibrosLibreria/DatosLibro[codigo=" + codLibro + "]");
                        col.close();
                        System.out.println("Libro borrado.");
                    } catch (Exception e) {
                        System.out.println("Error al borrar el libro.");
                    }
                } else {
                    System.out.println("El libro NO EXISTE.");
                }
            } else if (opcion == 2) {
                //Eliminar venta
                if (existeVenta(cod)) {
                    try {
                        System.out.printf("Borro la venta: %s\n", codLibro);
                        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                        //Consulta para borrar un libro --> update delete
                        ResourceSet result = servicio.query(
                                "update delete /ListaVentasLibreria/lista/DatosVenta[codigo=" + codLibro + "]");
                        col.close();
                        System.out.println("Venta borrada.");
                    } catch (Exception e) {
                        System.out.println("Error al borrar la venta.");
                    }
                } else {
                    System.out.println("La venta NO EXISTE.");
                }
            } else {
                //Eliminar inventario
                if (existeInventario(cod)) {
                    try {
                        System.out.printf("Borro el inventario: %s\n", codLibro);
                        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                        //Consulta para borrar un libro --> update delete
                        ResourceSet result = servicio.query(
                                "update delete /ListaInventarioLibreria/DatosInventario[codigo=" + codLibro + "]");
                        col.close();
                        System.out.println("Inventario borrado.");
                    } catch (Exception e) {
                        System.out.println("Error al borrar el inventario.");
                    }
                } else {
                    System.out.println("El inventario NO EXISTE.");
                }
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }

    }

    public static void listar(int opcion) {
        if (conectar() != null) {

            if (opcion == 1) {
                try {
                    XPathQueryService servicio;
                    servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Preparamos la consulta
                    ResourceSet result = servicio.query("for $dep in /ListaLibrosLibreria/DatosLibro return $dep");
                    // recorrer los datos del recurso.
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                    }
                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        System.out.println("--------------------------------------------");
                        System.out.println((String) r.getContent());
                    }
                    col.close();
                } catch (XMLDBException e) {
                    System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                }
            } else if (opcion == 2) {
                try {
                    XPathQueryService servicio;
                    servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Preparamos la consulta
                    ResourceSet result = servicio.query("for $dep in /ListaVentasLibreria/lista/DatosVenta return $dep");
                    // recorrer los datos del recurso.
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                    }
                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        System.out.println("--------------------------------------------");
                        System.out.println((String) r.getContent());
                    }
                    col.close();
                } catch (XMLDBException e) {
                    System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                }
            } else {
                try {
                    XPathQueryService servicio;
                    servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Preparamos la consulta
                    ResourceSet result = servicio.query("for $dep in /ListaInventarioLibreria/DatosInventario return $dep");
                    // recorrer los datos del recurso.
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                    }
                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        System.out.println("--------------------------------------------");
                        System.out.println((String) r.getContent());
                    }
                    col.close();
                } catch (XMLDBException e) {
                    System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                }
            }

        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }

    public static boolean existeLibro(int cod) {
        String dep = "";
        boolean existe = true;
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para consultar la información de un departamento
                ResourceSet result = servicio.query("/ListaLibrosLibreria/DatosLibro[codigo=" + cod + "]");
                ResourceIterator i;
                i = result.getIterator();
                col.close();
                if (!i.hasMoreResources()) {
                    //return false;
                    existe = false;
                }

            } catch (Exception e) {
                System.out.println("Error al consultar.");
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }

        //return false;
        return existe;
    }

    public static boolean existeVenta(int cod) {
        String dep = "";
        boolean existe = true;
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para consultar la información de un departamento
                ResourceSet result = servicio.query("/ListaVentasLibreria/DatosVenta[codigo=" + cod + "]");
                ResourceIterator i;
                i = result.getIterator();
                col.close();
                if (!i.hasMoreResources()) {
                    //return false;
                    existe = false;
                }

            } catch (Exception e) {
                System.out.println("Error al consultar.");
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }

        //return false;
        return existe;
    }

    public static boolean existeInventario(int cod) {
        boolean existe = true;
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para consultar la información de un departamento
                ResourceSet result = servicio.query("/ListaInventarioLibreria/DatosInventario[cod__lib=" + cod + "]");
                ResourceIterator i;
                i = result.getIterator();
                col.close();
                if (!i.hasMoreResources()) {
                    //return false;
                    existe = false;
                }

            } catch (Exception e) {
                System.out.println("Error al consultar.");
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }

        //return false;
        return existe;
    }


}
