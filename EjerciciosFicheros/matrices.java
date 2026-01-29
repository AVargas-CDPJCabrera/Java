package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class matrices {
    private FileReader fr;
    private BufferedReader br;
    public matrices()throws IOException{
    File fichero = new File("matrices.txt");
    if (!fichero.exists()) {fichero.createNewFile();
    }
    fr = new FileReader(fichero);
    br = new BufferedReader(fr);
    
    String numeroMatrices=br.readLine();
    int numeroVueltas=Integer.parseInt(numeroMatrices);
    String tamaño;
    
for (int i = 0; i < numeroVueltas; i++) {
    
System.out.println("\nMatriz " + (i+1));

tamaño=br.readLine();
int tamañoMatriz=Integer.parseInt(tamaño);
int[][]matriz=new int[tamañoMatriz][tamañoMatriz];

for (int j = 0; j < tamañoMatriz; j++) {
String num=br.readLine();
String[] partes=num.split("[, ]+");
System.out.println();

for (int k = 0; k < tamañoMatriz; k++) {
int numeros=Integer.parseInt(partes[k]);
matriz[j][k] = numeros;
System.out.print(matriz[j][k]+" ");

}

}

}

    }

}
