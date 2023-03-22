package lab02;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu cpf:");
        String cpf = scan.next();
        System.out.println(cpf);
        boolean validacao;
        Cliente cliente = new Cliente("Pedro", cpf, "29/01/2004", 19,"Ab");
        validacao = cliente.validarCPF(cpf);

        if (validacao == true)
            System.out.println("O cpf está correto");
        else 
            System.out.println("O cpf está incorreto");
        
    }
}
