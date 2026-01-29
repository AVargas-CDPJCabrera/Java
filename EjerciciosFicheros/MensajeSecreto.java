package EjerciciosFicheros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MensajeSecreto {
    private FileReader fr;
    private BufferedReader br;
    
    public MensajeSecreto ()throws FileNotFoundException, IOException{
    File fichero = new File("mensajesecreto.txt");
    if (!fichero.exists()) {fichero.createNewFile();
        
    }
    fr = new FileReader(fichero);
    br = new BufferedReader(fr);
    String[] alfabeto = {
    "A","B","C","D","E","F","G","H","I","J","K","L","M",
    "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String linea=br.readLine();
    String[] numeros = linea.split("[, ]+");
    System.out.println(Arrays.toString(numeros));
    decodificador(alfabeto,numeros);
    

        
    





    }

    private void decodificador(String[] alfabeto, String[] numeros) {
    String numpalabras=numeros[0];
    int numeropalabras=Integer.parseInt(numpalabras);
    int indice=1;
    int numletras;
    String frase="";
    for (int i = 0; i < numeropalabras; i++) {
        String palabra="";
        numletras=Integer.parseInt(numeros[indice]);
        indice++;
    for (int j = 0; j < numletras; j++) {
    String posicion=numeros[indice];
    String parImpar=numeros[indice+1];
    int pos=Integer.parseInt(posicion);
    int par=Integer.parseInt(parImpar);
    String letra=" ";
    if (par%2==0) {
    letra=alfabeto[pos-1];
    
        
    }else if (par%2!=0) {
    letra=alfabeto[26-pos];
        
    }
    palabra+=letra;

    indice+=2;

        
    }
        
        frase+=palabra+" ";
    }

    System.out.println(frase);
    }

}
