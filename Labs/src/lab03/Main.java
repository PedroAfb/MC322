package lab03;

//import java.util.Scanner;

public class Main {
    
    public static void main(String [] args){
        //Scanner scan = new Scanner(System.in);
        Cliente cliente1 = new Cliente(null, null, null, null, null, null, null);
        cliente1.implementacaoCliente(cliente1);
        Veiculo veiculo1 = new Veiculo(null, null, null, 0);
        veiculo1.implementacaoVeiculo(veiculo1);
        Seguradora seguradora = new Seguradora(null, null, null, null, null, null);
        seguradora.implementacaoSeguradora(seguradora);

    }
}
