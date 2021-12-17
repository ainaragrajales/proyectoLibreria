import java.io.*;


public class Main {
    public static void main(String[] args) {
        String menuInicio = "Menú:\n" +
                "   1.- Trabajar con ficheros (primer proyecto)\n" +
                "   2.- Trabajar con bd exist.\n" +
                "   3.- Salir.\n" +
                "Opción:";
        String menuExist = "Menú Exist:\n" +
                "   1.- Crear colección.\n" +
                "   2.- Cargar colección en la base.\n" +
                "   3.- Consultas.\n" +
                "   4.- Insertar datos.\n" +
                "   5.- Modificar datos.\n" +
                "   6.- Eliminar datos.\n" +
                "   7.- Mostrar todos los datos.\n" +
                "   8.- Volver al menú inicio.\n" +
                "Opción:";
        String menuPrincipal = "Menú:\n" +
                "       1.- Libros.\n" +
                "       2.- Inventario.\n" +
                "       3.- Ventas.\n" +
                "       4.- Salir.\n" +
                "Opción:";
        String menuLibros = "Menú Libros:\n" +
                "       1.- Mostrar libros.\n" +
                "       2.- Buscar libro por título.\n" +
                "       3.- Añadir un libro.\n" +
                "       4.- Salir.\n" +
                "Opción:";
        String menuInventario = "Menú Inventario:\n" +
                "       1.- Añadir en el inventario.\n" +
                "       2.- Mostrar el inventario.\n" +
                "       3.- Modificar inventario.\n" +
                "       4.- Salir.\n" +
                "Opción:";
        String menuVentas = "Menú: Ventas\n" +
                "       1.- Crear fichero ventas.\n" +
                "       2.- Mostrar ventas.\n" +
                "       3.- Mostrar ventas de un libro específico.\n" +
                "       4.- Salir.\n" +
                "Opcióm:";
        String respuesta;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcionInicio = 0;

        while (opcionInicio != 3) {
            System.out.println(menuInicio);
            try {
                opcionInicio = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("\nError\n");
            } catch (NumberFormatException ne) {
                System.out.println("\nValor erroneo, introduce un número del menú\n");
                opcionInicio = 0;
            }

            switch (opcionInicio) {

                case 1:
                    int opcionPrinc = 0;
                    while (opcionPrinc != 4) {
                        System.out.println(menuPrincipal);
                        try {
                            opcionPrinc = Integer.parseInt(br.readLine());
                        } catch (IOException e) {
                            System.out.println("\nError\n");
                        } catch (NumberFormatException ne) {
                            System.out.println("\nValor erroneo, introduce un número del menú\n");
                            opcionPrinc = 0;
                        }

                        switch (opcionPrinc) {
                            case 1:
                                //System.out.println("Opción Libros.");
                                int opcionLib = 0;

                                while (opcionLib != 4) {

                                    System.out.println(menuLibros);
                                    try {
                                        opcionLib = Integer.parseInt(br.readLine());
                                    } catch (IOException e) {
                                        System.out.println("\nError\n");
                                    } catch (NumberFormatException ne) {
                                        System.out.println("\nValor erroneo, introduce un número del menú\n");
                                        opcionLib = 0;
                                    }

                                    switch (opcionLib) {
                                        case 1:
                                            System.out.println("\n");
                                            mostrarLibros.open();
                                            System.out.println("\n¿Quieres convertir en fichero XML la lista de libros? s/n");
                                            try {
                                                respuesta = br.readLine();
                                                if (respuesta.equalsIgnoreCase("s")) {
                                                    ConvertirXML.convertirLibros();
                                                }
                                            } catch (IOException e) {
                                                System.out.println("\nError\n");
                                            }
                                            System.out.println("\n");
                                            break;
                                        case 2:
                                            System.out.println("\n");
                                            buscarLibr.buscPorTitulo();
                                            System.out.println("\n");
                                            break;
                                        case 3:
                                            String titulo, autor, formato, genero, continuar;
                                            boolean cont = true;

                                            int cod;
                                            double precio;
                                            System.out.println("\n");
                                            try {
                                                while (cont) {
                                                    System.out.println("Introduce el codigo del libro");
                                                    cod = Integer.parseInt(br.readLine());
                                                    System.out.println("Introduce el titulo del libro");
                                                    titulo = br.readLine();
                                                    System.out.println("Introduce el nombre del autor.");
                                                    autor = br.readLine();
                                                    System.out.println("Introduce el formato del libro");
                                                    formato = br.readLine();
                                                    System.out.println("Introduce el género del libro");
                                                    genero = br.readLine();
                                                    System.out.println("Introduce el precio del libro.");
                                                    precio = Double.parseDouble(br.readLine());
                                                    insertLibros.insertar(cod, titulo, autor, formato, genero, precio);
                                                    System.out.println("¿Quieres añadir otro libro? true/false");
                                                    continuar = br.readLine();
                                                    if (continuar.equalsIgnoreCase("true")) {
                                                        cont = true;
                                                    } else {
                                                        cont = false;
                                                    }
                                                }

                                            } catch (IOException e) {
                                                System.out.println("\nError\n");
                                            }

                                            System.out.println("\n");
                                            break;
                                        case 4:
                                            System.out.println("\nVolviendo al menú principal.\n");
                                            break;
                                        default:
                                            System.out.println("Opción no válida.");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                //System.out.println("Opción Inventario.");
                                int opcionInvent = 0;

                                while (opcionInvent != 4) {

                                    System.out.println(menuInventario);
                                    try {
                                        opcionInvent = Integer.parseInt(br.readLine());
                                    } catch (IOException e) {
                                        System.out.println("\nError\n");
                                    } catch (NumberFormatException ne) {
                                        System.out.println("\nValor erroneo, introduce un número del menú\n");
                                        opcionInvent = 0;
                                    }

                                    switch (opcionInvent) {
                                        case 1:
                                            System.out.println("\n");
                                            //crearInventario.crear();
                                            addInventario.add();
                                            System.out.println("\n");
                                            break;
                                        case 2:
                                            System.out.println("\n");
                                            mostrarInventario.mostrar();
                                            System.out.println("¿Quieres convertir en fichero XML la lista de inventario? s/n");
                                            try {
                                                respuesta = br.readLine();
                                                if (respuesta.equalsIgnoreCase("s")) {
                                                    ConvertirXML.convertirInventario();
                                                }
                                            } catch (IOException e) {
                                                System.out.println("\nError\n");
                                            }
                                            System.out.println("\n");
                                            break;
                                        case 3:
                                            System.out.println("\n");
                                            modificarInventario.modificar();
                                            System.out.println("\n");
                                            break;
                                        case 4:
                                            System.out.println("\nVolviendo al menú principal.\n");
                                            break;
                                        default:
                                            System.out.println("Opción no válida.");
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                //System.out.println("Opción Ventas.");
                                int opcionVenta = 0;

                                while (opcionVenta != 4) {

                                    System.out.println(menuVentas);
                                    try {
                                        opcionVenta = Integer.parseInt(br.readLine());
                                    } catch (IOException e) {
                                        System.out.println("\nError\n");
                                    } catch (NumberFormatException ne) {
                                        System.out.println("\nValor erroneo, introduce un número del menú\n");
                                        opcionVenta = 0;
                                    }

                                    switch (opcionVenta) {
                                        case 1:
                                            System.out.println("\n");
                                            crearVentas.insertar();
                                            System.out.println("\n");
                                            break;
                                        case 2:
                                            System.out.println("\n");
                                            mostrarVentas.mostrar();
                                            System.out.println("¿Quieres convertir en fichero XML la lista de ventas? s/n");
                                            try {
                                                respuesta = br.readLine();
                                                if (respuesta.equalsIgnoreCase("s")) {
                                                    ConvertirXML.convertirVentas();
                                                }
                                            } catch (IOException e) {
                                                System.out.println("\nError\n");
                                            }
                                            System.out.println("\n");
                                            break;
                                        case 3:
                                            System.out.println("\n");
                                            mostrarVentasLibro.mostrarVentasLibroEspecifico();
                                            System.out.println("\n");
                                            break;
                                        case 4:
                                            System.out.println("\nVolviendo al menú principal.\n");
                                            break;
                                        default:
                                            System.out.println("Opción no válida.");
                                            break;
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("\nSaliendo del menú.");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;
                case 2:
                    int opcionExist = 0;
                    while (opcionExist != 8){
                        System.out.println(menuExist);
                        try {
                            opcionExist = Integer.parseInt(br.readLine());
                        } catch (IOException e) {
                            System.out.println("\nError\n");
                        } catch (NumberFormatException ne) {
                            System.out.println("\nValor erroneo, introduce un número del menú\n");
                            opcionExist = 0;
                        }

                        switch (opcionExist){
                            case 1:
                                Cargar.crearColeccion();
                                break;
                            case 2:
                                System.out.println("Cargar colección");
                                Cargar.cargarColeccion("listaLibrosXML.xml");
                                Cargar.cargarColeccion("listaInventarioXML.xml");
                                Cargar.cargarColeccion("listaVentasXML.xml");

                                break;
                            case 3:
                                Cargar.consultas();
                                break;
                            case 4:
                                String datosInsert = "";
                                System.out.println("Elige el fichero en el que insertar filas:\n" +
                                        "1.- Libros.\n" +
                                        "2.- Ventas.\n" +
                                        "3.- Inventario.");
                                try {
                                    int opcInsert = Integer.parseInt(br.readLine());
                                    if (opcInsert >= 1 && opcInsert <= 3){
                                        switch (opcInsert){
                                            case 1:
                                                String titulo, autor, formato, genero;
                                                int cod;
                                                double precio;
                                                System.out.println("Introduce los datos del libro");
                                                System.out.println("Introduce el codigo del libro");
                                                cod = Integer.parseInt(br.readLine());
                                                System.out.println("Introduce el titulo del libro");
                                                titulo = br.readLine();
                                                System.out.println("Introduce el nombre del autor.");
                                                autor = br.readLine();
                                                System.out.println("Introduce el formato del libro");
                                                formato = br.readLine();
                                                System.out.println("Introduce el género del libro");
                                                genero = br.readLine();
                                                System.out.println("Introduce el precio del libro.");
                                                precio = Double.parseDouble(br.readLine());
                                                datosInsert = "<DatosLibro><codigo>" +
                                                        cod + "</codigo><titulo>" +
                                                        titulo + "</titulo><autor>" +
                                                        autor + "</autor><formato>" +
                                                        formato + "</formato><genero>" +
                                                        genero + "</genero><precio>" +
                                                        precio + "</precio></DatosLibro>";

                                                break;
                                            case 2:
                                                System.out.println("Introduce los datos de la venta");
                                                Cargar.listar(2);
                                                System.out.println("Elige el código del libro");
                                                int codLib = Integer.parseInt(br.readLine());

                                                System.out.println("Introduce la cantidad a comprar: ");
                                                int cant = Integer.parseInt(br.readLine());
                                                System.out.println("Introduce el precio del producto: ");
                                                precio = Double.parseDouble(br.readLine());
                                                System.out.println("Introduce la fecha de compra: ");
                                                String fecha = br.readLine();
                                                System.out.println("Introduce la hora de compra: ");
                                                String hora = br.readLine();

                                                datosInsert = "<DatosVenta><codigo>" +
                                                        "1" + "</codigo><codLibro>" +
                                                        codLib + "</codLibro><tituloLibro>" +
                                                        "Hyde and Seek" + "</tituloLibro><cantidad>" +
                                                        cant + "</cantidad><precio>" +
                                                        precio + "</precio><total>" +
                                                        (cant*precio) + "</total><fecha>" +
                                                        fecha + "</fecha><hora>" +
                                                        hora + "</hora></DatosVenta>";

                                                break;
                                            case 3:
                                                System.out.println("Introduce los datos del inventario");
                                                Cargar.listar(2);
                                                System.out.println("Elige el código del libro");
                                                int codLib2 = Integer.parseInt(br.readLine());
                                                System.out.println("Introduce la cantidad del inventario:");
                                                int cantidad = Integer.parseInt(br.readLine());
                                                System.out.println("Introduce la fecha de modificación:");
                                                String fecha_mod = br.readLine();
                                                System.out.println("Introduce la hora de modificación:");
                                                String hora_mod = br.readLine();

                                                datosInsert = "<DatosInventario><cod__lib>" +
                                                        codLib2 + "</cod__lib><cantidad>" +
                                                        cantidad + "</cantidad><fecha__mod>" +
                                                        fecha_mod + "</fecha__mod><hora__mod>" +
                                                        hora_mod + "</hora__mod></DatosInventario>";

                                                break;
                                        }
                                        Cargar.insertar(opcInsert, datosInsert);
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error en la entrada de datos");
                                }
                                break;
                            case 5:
                                System.out.println("Elige el fichero en el que modificar filas:\n" +
                                        "1.- Libros.\n" +
                                        "2.- Inventario.");
                                try {
                                    int opcMod = Integer.parseInt(br.readLine());
                                    if (opcMod == 1){
                                        Cargar.listar(opcMod);
                                        System.out.println("Escribe el código de la fila a modificar");
                                        int codMod = Integer.parseInt(br.readLine());
                                        System.out.println("Elige:\n" +
                                                "1.- Modificar el formato del libro.\n" +
                                                "2.- Modificar el género del libro.\n" +
                                                "3.- Modificar el precio del libro");
                                        int modLib = Integer.parseInt(br.readLine());
                                        Cargar.modificar(opcMod, modLib,codMod);
                                    } else if (opcMod == 2){
                                        Cargar.listar(3);
                                        System.out.println("Escribe el código de la fila a modificar");
                                        int codMod = Integer.parseInt(br.readLine());
                                        Cargar.modificar(opcMod, 1,codMod);
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error en la entrada de datos, introduce un número entero");
                                }
                                break;
                            case 6:
                                System.out.println("Elige el fichero en el que eliminar filas:\n" +
                                        "1.- Libros.\n" +
                                        "2.- Ventas.\n" +
                                        "3.- Inventario.");
                                try {
                                    int opcElim = Integer.parseInt(br.readLine());
                                    if (opcElim >= 1 && opcElim <= 3){
                                        Cargar.listar(opcElim);
                                        System.out.println("Escribe el código de la fila a eliminar");
                                        int codElim = Integer.parseInt(br.readLine());
                                        Cargar.eliminar(opcElim, codElim);
                                    } else {
                                        System.out.println("Opción no válida");
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error");
                                }

                                break;
                            case 7:
                                System.out.println("Elige:\n" +
                                        "   1.- Mostrar los datos de los libros.\n" +
                                        "   2.- Mostrar los datos de las ventas.\n" +
                                        "   3.- Mostrar los datos de el inventario.");
                                try {
                                    int opcList = Integer.parseInt(br.readLine());
                                    if (opcList >= 1 && opcList <= 3){
                                        Cargar.listar(opcList);
                                    } else {
                                        System.out.println("Opción no válida");
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error");
                                }
                            case 8:
                                //System.out.println("\nSaliendo del programa.");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;

            }
        }
    }
}


