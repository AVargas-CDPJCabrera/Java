package EjerciciosFicheros;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import Excepciones.PasswordException;
import Excepciones.PositionException;

public class golosinas {

    private FileReader fr;
    private BufferedReader br;

    public golosinas() throws IOException {
        Scanner leer = new Scanner(System.in);
        final String PASSWORD = "MaquinaExpendedora2017";

        File fichero = new File("golosinas.txt");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }

        fr = new FileReader(fichero);
        br = new BufferedReader(fr);

        // Leer tamaño de la matriz
        int tamaño = Integer.parseInt(br.readLine().trim());

        String[][] nombre = new String[tamaño][tamaño];
        double[][] precio = new double[tamaño][tamaño];
        int[][] existencias = new int[tamaño][tamaño];
        int[][]existenciasVendidas=new int[tamaño][tamaño];

        escribedatos(fichero, nombre, precio, existencias);

        boolean continuar=true;
        while (continuar) {
            mostrarMenu();
            String opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                try { pedirgolosina(nombre,precio,existencias,existenciasVendidas);
                    
                } catch (PositionException e) {
                    System.out.println(e.getMessage());
                }
                        
                    break;
                case "2":
                  mostrargolosinas(nombre,precio,existencias);
                    break;
                case "3":
                    try {
                 rellenarGolosinas(PASSWORD,nombre,existencias);

                        
                    } catch (PasswordException e) {
                        System.out.println(e.getMessage());
                    }
                default:
                    break;
            }
            
        }
        
    }

    private void rellenarGolosinas(String pASSWORD, String[][] nombre, int[][] existencias)throws PasswordException {
        Scanner leer = new Scanner(System.in);
        String contraseña;
        System.out.println("Introduzca la contraseña");
        contraseña=leer.nextLine();
        if (!contraseña.equals(pASSWORD)) {throw new PasswordException("Contraseña Incorrecta");
        }
        System.out.println("Introduce la posicion a rellenar");
        String pos = leer.nextLine();
        int fila=Character.getNumericValue(pos.charAt(0));
        int columna=Character.getNumericValue(pos.charAt(1));
        System.out.println("Introduce la cantidad a añadir");
        int cantidad=leer.nextInt();
        existencias[fila][columna]+=cantidad;
        
        
        

       
    }

    private void mostrargolosinas(String[][] nombre, double[][] precio, int[][] existencias) {
            System.out.println("\n---GOLOSINAS DISPONIBLES---");
            System.out.printf("%-8s%-25s%10s\n","Codigo","Nombre","Precio");
            System.out.println("-".repeat(45));

            for (int i = 0; i < existencias.length; i++) {
                for (int j = 0; j < existencias[i].length; j++) {
                    if (existencias[i][j]>0) {
                    String codigo=""+i+j;
                    String nombres=nombre[i][j];
                    double precios=precio[i][j];
                    System.out.printf("%-8s%-25s%9.2f\n",codigo,nombres,precios);
                        
                    }
                    
                }
                
            }
    }

    private void pedirgolosina(String[][] nombre, double[][] precio, int[][] existencias, int[][] existenciasVendidas) throws PositionException {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n---Pedir Golosina---");
        System.out.println("Introduce el Codigo de la Golosina Deseada (Solo Valores Numericos)");
        String codigo = leer.nextLine();
        validarPosicion(codigo,existencias);
        int fila = Character.getNumericValue(codigo.charAt(0));
        int columna = Character.getNumericValue(codigo.charAt(1));
        //Dispensamos la golosina
        existencias[fila][columna]--;
        double precios = precio[fila][columna];
        existenciasVendidas[fila][columna]++;
        System.out.println("Has recibido " + nombre[fila][columna]);
        System.out.printf("Precio:%.2f$\n",precios);
        System.out.println("Quedan "+existencias[fila][columna]+" unidades");



        }

    private void validarPosicion(String codigo,int[][]existencias)throws PositionException {
    //Comprobamos que no sea null y que tenga extactamente dos caracteres
    if (codigo==null||codigo.length()!=2) {throw new PositionException("Codigo Incorrecto");
    }
    
    if (!Character.isDigit(codigo.charAt(0))||!Character.isDigit(codigo.charAt(1))) {
        throw new PositionException("Codigo Incorrecto");
    }
    
    int fila=Character.getNumericValue(codigo.charAt(0));
    int columna=Character.getNumericValue(codigo.charAt(1));
    
    if (fila<0||fila>=existencias.length||columna<0||columna>=existencias.length) {
        throw new PositionException("Codigo Incorrecto");
        
    }
    
    if (existencias[fila][columna]<=0) {throw new PositionException("No quedan Existencias");
        
    }

        
       
    }

    private void mostrarMenu() {
        System.out.println("\n" + "=".repeat (50)); 
        System.out.println("MÁQUINA EXPENDEDORA DE GOLOSINAS"); System.out.println("=".repeat(50)); 
        System.out.println("1. Pedir golosina"); 
        System.out.println("2. Mostrar golosinas"); 
        System.out.println("3. Rellenar golosinas"); 
        System.out.println("4. Apagar máquina"); 
        System.out.println("=".repeat (50)); 
        System.out.print("\nSelecciona una opción (1-4): ");  
    }

    private void escribedatos(File fichero, String[][] nombre, double[][] precio, int[][] existencias)
            throws IOException,FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader(fichero));

        int numfilas = Integer.parseInt(br.readLine().trim());
        
        //Introduzo el nombre de los elementos de la maquina expendedora.
        for (int i = 0; i < numfilas; i++) {
        String linea=br.readLine();
        String[]partes=linea.split(",");
        for (int j = 0; j < partes.length; j++) {
        nombre[i][j]=partes[j];
            
        }
            
        }
        for (int i = 0; i < numfilas; i++) {
        String linea=br.readLine();
        String[]partes=linea.split(",");
        for (int j = 0; j < partes.length; j++) {
        precio[i][j]=Double.parseDouble(partes[j]);
            
        }
        }

        for (int i = 0; i <numfilas; i++) {
        String linea=br.readLine();
        String[]partes=linea.split(",");
        for (int j = 0; j < partes.length; j++) {
        existencias[i][j]=Integer.parseInt(partes[j]);
            
        }
            
        }

    }
}




