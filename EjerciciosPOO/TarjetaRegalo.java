package EjerciciosPOO;
import Excepciones.SaldoException;

public class TarjetaRegalo {
    private int numeroTarjeta;
    double saldoInicial;

    public TarjetaRegalo(double saldoInicial) throws SaldoException {
        this.numeroTarjeta = setNumerotarjeta();
        this.saldoInicial = saldoInicial;
    }
    
    public int setNumerotarjeta() {
        int min = 10000;
        int max = 99999;
        int ale = (int) (Math.random() * (max - min + 1) + min);
        return ale;
    }
    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public double getSaldo(){
        return saldoInicial;
    }

    public void gastar (double cantidad) throws SaldoException {

        double saldoActual = saldoInicial;

        if (cantidad>saldoActual) {throw new SaldoException("Saldo Insuficiente");
            
        } else{saldoInicial-=cantidad;}      
}
    public TarjetaRegalo fusionar(TarjetaRegalo otraTarjeta) throws SaldoException {
        double saldoTotal=this.saldoInicial + otraTarjeta.saldoInicial;

        TarjetaRegalo nueva = new TarjetaRegalo(saldoTotal);

        this.saldoInicial=0;
        otraTarjeta.saldoInicial=0;
    return nueva;
        

}
}
