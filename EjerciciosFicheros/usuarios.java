package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.annotation.processing.Filer;

public class usuarios {
    private FileReader fr;
    private BufferedReader br;
    public usuarios() throws IOException{
    //Este Programa busca en un fichero de texto un nombre de usuario y una contraseña
    //A continuacion debe dar su tarjeta de claves
    //********************************************************************************

    //Preparacion del fichero
    File fichero = new File("usuarios.txt");
    if (!fichero.exists()) {fichero.createNewFile();
    }
    fr = new FileReader(fichero);
    br = new BufferedReader(fr);
    //*********************************************************************************
    
    //Pedimos usuario y contraseña
    String usuario;
    String contraseña;
    Scanner leer = new Scanner(System.in);
    System.out.println("Introduce un Usuario");
    usuario=leer.nextLine();
    System.out.println("Introduce tu contraseña");
    contraseña=leer.nextLine();
    //*********************************************************************************

    //Comprobamos que existen en el fichero
    String usuarioFichero=br.readLine();
    boolean Encontrado=false;
    String claveCorrecta=null;
    while (usuarioFichero!=null) {

        String contraseñaFichero=br.readLine();
        String claveFichero=br.readLine();

        if (contraseñaFichero==null||claveFichero==null)break;

        if (usuarioFichero.equals(usuario)&&contraseñaFichero.equals(contraseña)) {
            Encontrado=true;
            claveCorrecta=claveFichero;
            break;
            
        }
        usuarioFichero=br.readLine();
    }
    String[]partes=claveCorrecta.split(",");
    int[]claves=new int[25];
    for (int i = 0; i < 25; i++) {
        claves[i]=Integer.parseInt(partes[i].trim());
        
    }
    int[][]tarjeta=new int[5][5];
    int indice=0;
    for (int i = 0; i < tarjeta.length; i++) {
        for (int j = 0; j < tarjeta.length; j++) {
            tarjeta[i][j]=claves[indice];
            indice++;
        }
    }
    String[]Letras={"A","B","C","E","D"};
    String[]Numeros={"1","2","3","4","5"};
    for (int i = 0; i < Numeros.length; i++) {
        System.out.print(Numeros[i]+" ");
    }
    for (int i = 0; i < tarjeta.length; i++) {
        System.out.println();
        System.out.print(Letras[i]+" ");
        for (int j = 0; j < tarjeta[i].length; j++) {
            System.out.print(tarjeta[i][j]+" ");
        }
    }
    //*********************************************************************************



        
   

    }

}
