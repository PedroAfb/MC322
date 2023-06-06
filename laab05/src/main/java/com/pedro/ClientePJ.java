package com.pedro;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private int qntdFunc;
    private List <Frota> listaFrota;

    //Construtor
    public ClientePJ(int qntdFunc,String nome, String endereco, String email, String telefone, String cnpj, String dataFundacao, List<Frota> listaFrota) {
        super(nome, endereco, email, telefone);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataFundacao = format.parse(dataFundacao);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            e.printStackTrace();
        }

        this.listaFrota = new ArrayList<>();
        this.qntdFunc = qntdFunc;

        if(Validacao.ValidarCNPJ(cnpj))
            this.cnpj = cnpj.replaceAll("[^0-9]", "");
        else{
            this.cnpj = null;
            throw new IllegalArgumentException("CNPJ inválido. A instância do objeto ClientePJ foi cancelada.");
        }

    }
    
    //Setters e Getters
    public String getCnpj () {
        return cnpj ;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public List<Frota> getListaFrota() {
        return listaFrota;
    }
    public void setListaFrota(List<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }
    public int getQntdFunc() {
        return qntdFunc;
    }
    public void setQntdFunc(int qntdFunc) {
        this.qntdFunc = qntdFunc;
    }

    public boolean cadastrarFrota(Frota frota){
            if (frota != null){
                //Verifica se a frota já está cadastrada
                if(!listaFrota.contains(frota)){
                    //Adiciona a frota na lista de frotas do cliente
                    listaFrota.add(frota);
                    System.out.println("A frota foi cadastrada com sucesso");
                    return true;
                }
                else{
                    System.out.println("Essa frota já está cadastrada com esse cliente");
                    return false;
                }
            }
            else{
                System.out.println("Essa frota é inválida");
                return false;
            }
    }

    /*public boolean atualizarFrota(ClientePJ clientePJ ,Frota frotaNova){
        //esse método está diretamente ligado aos métodos add/remover veiculos na classe frota, o parâmetro frota nova irá
        // ser dado pelo próprio metodo na classe frota (o metodo atualizar frota é chamado apenas nos metodos da classe
        //frota)
        Frota frotaAntiga = Frota.buscaFarota(frotaNova.getCode(), clientePJ, null);
        if (frotaAntiga != null) {
            // Verifica se a frota antiga está cadastrada
            if (listaFrota.contains(frotaAntiga)) {
                // Remove a frota antiga da lista de frotas do cliente
                listaFrota.remove(frotaAntiga);
                // Verifica se a nova frota foi informada
                if (frotaNova != null) {
                    // Adiciona a nova frota à lista de frotas do cliente
                    listaFrota.add(frotaNova);
                    System.out.println("Frota atualizada com sucesso para o cliente PJ: " + getCnpj());
                } 
                else if (frotaNova == null) {
                    System.out.println("Frota removida com sucesso para o cliente PJ: " + getCnpj());
                }
                return true;
            } 
            else {
                System.out.println("A frota antiga não está cadastrada para o cliente PJ: " + getCnpj());
            }
        } else {
            System.out.println("Frota inválida.");
        }
        return false;
    }*/

    public boolean atualizarFrota(String codigo, Veiculo veiculo, boolean adicionar) {
        for (Frota frota : listaFrota) {
            if (frota.getCode().equals(codigo)) {
                if (adicionar) {
                    frota.addVeiculo(veiculo);
                } else {
                    frota.removeVeiculo(veiculo);
                }
                return true; // Frota atualizada com sucesso
            }
        }
        return false; // Frota não encontrada
    }

    public List <Veiculo> getVeiculosPorFrota(Frota frota){
        if(frota != null && frota.getListaVeiculos() != null)
            return frota.getListaVeiculos();
        else{
            System.out.println("A lista ou a frota não existe");
            return null;
        }
    }

    public static ClientePJ criarClientePJComInputScanner(Scanner scanner) {
        System.out.println("Digite o CNPJ do cliente:");
        String cnpj = scanner.nextLine();
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o endereço do cliente:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o e-mail do cliente:");
        String email = scanner.nextLine();
        System.out.println("Digite a quantidade de funcionários do cliente:");
        int qntdFunc = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a data de fundação da empresa do cliente:");
        String dataFundacao = scanner.nextLine();

        // Cria e retorna a instância do ClientePJ com os atributos preenchidos
        return new ClientePJ(qntdFunc, nome, endereco, email, telefone, cnpj, dataFundacao, null);
    }

    public static ClientePJ buscaClientePJ(Seguradora seguradora, Scanner scanner){
        System.out.println("Digite o cpf desse cliente:");
        String cnpj = scanner.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]", "");
        for (ClientePJ clientePJ3 : seguradora.getListaClientePJs()){
            if(clientePJ3.getCnpj().equals(cnpj)){
                return clientePJ3;
            }
        }

        throw new IllegalArgumentException("ClientePJ inválido, não foi encontrado.");
                        
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNome()).append("\n");
        sb.append("Endereço: ").append(this.getEndereco()).append("\n");
        sb.append("Email: ").append(this.getEmail()).append("\n");
        sb.append("Telefone: ").append(this.getTelefone()).append("\n");
        sb.append("Lista de Frota: \n");
        for (Frota frota : this.getListaFrota()) {
            System.out.println(frota.toString());
        }
        sb.append("CNPJ: ").append(this.getCnpj()).append("\n");
        sb.append("Data de Fundação: ").append(this.getDataFundacao()).append("\n");
        return sb.toString();
}
}
