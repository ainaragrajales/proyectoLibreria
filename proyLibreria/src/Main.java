import java.io.*;

public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcionPrinc = 0;

        while (opcionPrinc != 4) {
            System.out.println("Menú: \n" +
                    "       1.- Libros.\n" +
                    "       2.- Almacen.\n" +
                    "       3.- Ventas.\n" +
                    "       4.- Salir.\n\n" +
                    "Opción:");
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

                        System.out.println("Menú libros:\n" +
                                "       1.- Mostrar libros.\n" +
                                "       2.- Buscar libro por título.\n" +
                                "       3.- Añadir un libro.\n" +
                                "       4.- Volver al menú principal.\n\n" +
                                "Opción:");
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
                                String respuesta;
                                System.out.println("\n");
                                //mostrarLibros.mostrar();
                                mostrarLibros.open();
                                System.out.println("¿Quieres convertir en fichero XML la lista de libros? s/n");
                                try {
                                    respuesta = br.readLine();
                                    if (respuesta.equalsIgnoreCase("s")){
                                        ConvertirXML.convertirLibros();
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
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
                                    while (cont){
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
                                        if (continuar.equalsIgnoreCase("true")){
                                            cont = true;
                                        } else {
                                            cont = false;
                                        }
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
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
                    //System.out.println("Opción Almacen.");
                    int opcionInvent = 0;

                    while (opcionInvent != 4) {

                        System.out.println("Menú inventario:\n" +
                                "       1.- Crear fichero inventario.\n" +
                                "       2.- Mostrar inventario.\n" +
                                "       3.- Modificar inventario.\n" +
                                "       4.- Volver al menú principal.\n\n" +
                                "Opción:");
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
                                crearInventario.crear();
                                System.out.println("\n");
                                break;
                            case 2:
                                System.out.println("\n");
                                mostrarInventario.mostrar();
                                System.out.println("\n");
                                break;
                            case 3:
                                System.out.println("\n");
                                //mostrarInventario.mostrar();
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

                        System.out.println("Menú ventas:\n" +
                                "       1.- Crear fichero ventas.\n" +
                                "       2.- Mostrar ventas.\n" +
                                "       3.- Añadir una venta.\n" +
                                "       4.- Volver al menú principal.\n\n" +
                                "Opción:");
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

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:
                                System.out.println("\nVolviendo al menú principal.\n");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nSaliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }


    }

   /*
    public static void menuLibros() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcionLib = 0;

        while (opcionLib != 5) {

            System.out.println("Menú libros:\n" +
                    "       1.- Crear fichero libros.\n" +
                    "       2.- Mostrar libros.\n" +
                    "       3.- Buscar libro por título.\n" +
                    "       4.- Añadir un libro.\n" +
                    "       5.- Volver al menú principal.\n\n" +
                    "Opción:");
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

                    break;
                case 2:
                    //mostrarLibros.mostrar();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("\nVolviendo al menú principal.\n");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
*/
   /* public static void menuInventario() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcionInvent = 0;

        while (opcionInvent != 4) {

            System.out.println("Menú inventario:\n" +
                    "       1.- Crear fichero inventario.\n" +
                    "       2.- Mostrar inventario.\n" +
                    "       3.- Modificar inventario.\n" +
                    "       4.- Volver al menú principal.\n\n" +
                    "Opción:");
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("\nVolviendo al menú principal.\n");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }*/

    /*public static void menuVenta() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcionVenta = 0;

        while (opcionVenta != 4) {

            System.out.println("Menú ventas:\n" +
                    "       1.- Crear fichero ventas.\n" +
                    "       2.- Mostrar ventas.\n" +
                    "       3.- Añadir una venta.\n" +
                    "       4.- Volver al menú principal.\n\n" +
                    "Opción:");
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("\nVolviendo al menú principal.\n");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }*/


}
