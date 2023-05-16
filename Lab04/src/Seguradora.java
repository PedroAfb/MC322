
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seguradora {
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private List <Sinistro> listaSinistros;
    private List <Cliente> listaClientes;
    private List <ClientePF> listaClientePFs;
    private List <ClientePJ> listaClientePJs;

    // Construtor
    public Seguradora ( String nome , String telefone , String email , String endereco, List <Sinistro> listaSinistros, List <Cliente> listaClientes, List <ClientePF> listaClientePFs, List <ClientePJ> listaClientePJs ) {
        this . nome = nome ;
        this . telefone = telefone ;
        this . email = email ;
        this . endereco = endereco ;
        this.listaSinistros = listaSinistros != null ? listaSinistros : new ArrayList<>();
        this.listaClientes = listaClientes != null ? listaClientes : new ArrayList<>();
        this.listaClientePFs = listaClientePFs != null ? listaClientePFs : new ArrayList<>();
        this.listaClientePJs = listaClientePJs != null ? listaClientePJs : new ArrayList<>();


    }

    // Getters e setters
    public String getNome () {
        return nome ;
    }

    public void setNome ( String nome ) {
        this . nome = nome ;
    }

    public String getTelefone () {
        return telefone ;
    }

    public void setTelefone ( String telefone ) {
        this . telefone = telefone ;
    }

    public String getEmail () {
        return email ;
    }

    public void setEmail ( String email ) {
        this . email = email ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }
    public List <Cliente> getListaClientes () {
        return listaClientes ;
    }

    public void setListaClientes ( List <Cliente> listaClientes ) {
        this . listaClientes = listaClientes ;
    }
    public List <Sinistro> getListaSinistros () {
        return listaSinistros ;
    }

    public void setListaSinistros ( List <Sinistro> listaSinistros ) {
        this . listaSinistros = listaSinistros ;
    }
    public List<ClientePF> getListaClientePFs() {
        return listaClientePFs;
    }
    public void setListaClientePFs(List<ClientePF> listaClientePFs) {
        this.listaClientePFs = listaClientePFs;
    }
    public List<ClientePJ> getListaClientePJs() {
        return listaClientePJs;
    }
    public void setListaClientePJs(List<ClientePJ> listaClientePJs) {
        this.listaClientePJs = listaClientePJs;
    }

    public boolean geraSinistro(Cliente cliente, Veiculo veiculo, Seguradora seguradora, Scanner scanner) {
        // Gera um novo sinistro para o cliente indicado
        Sinistro sinistro = new Sinistro(0, "", "", null, null, null);
        System.out.println("Coloque a data do acontecimento:");
        sinistro.setData(scanner.nextLine());
        System.out.println("Coloque o endereço:");
        sinistro.setEndereco(scanner.nextLine());

        sinistro.implementacaoSinistro(sinistro, veiculo, seguradora, cliente, scanner);
        seguradora.getListaSinistros().add(sinistro);
        return true;
    }


    public void visualizarSinistro(String cliente) {
        // Printa o sinistro de um cliente específico
        for (Sinistro sinistro : listaSinistros) {
            Cliente nome = sinistro.getCliente();
            if (nome.getNome().equals(cliente)) {
                String str = sinistro.toString();
                System.out.println(str);
            }
        }
    }

    public void listarSinistro(){
        for (Sinistro sinistro: listaSinistros){
            System.out.println(sinistro.toString());
        }
    }
    
    public boolean cadastrarCliente(Cliente cliente) {
        // Verifica se o cliente já está cadastrado na lista
        if (listaClientes.contains(cliente)) {
            System.out.println("Cliente já cadastrado.");
            return false;
        }
        // Adiciona o novo cliente à lista
        listaClientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
        return true;
    }

    public boolean removerCliente(Cliente cliente) {
        if (listaClientes.contains(cliente)) {
            System.out.println("Cliente removido.");
            return true;
        }
        else{
            System.out.println("Cliente inexistente");
            return false;
        }
}

    public void listarClientes(){
        /*Imprime as informações de todos os clientes 
                     da seguradora*/ 
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.toString());
            }
    }

    public void relacionandoObjetos(Cliente cliente, Seguradora seguradora, Veiculo veiculo, Sinistro sinistro){
        cliente.getListaVeiculos().add(veiculo);
        sinistro.setCliente(cliente);
        sinistro.setSeguradora(seguradora);
        sinistro.setVeiculo(veiculo);
        seguradora.getListaSinistros().add(sinistro);

    }

    public double calcularPrecoSeguroCliente(ClientePF cliente, Seguradora seguradora){
        List <Sinistro> sinistros = seguradora.getListaSinistros();
        int qtd=0;
        for(Sinistro sinistro:sinistros){
            if(sinistro.getCliente() == cliente)
                qtd++;
        }
        double valor = cliente.calculaScore(cliente) * (1 + qtd);
        return valor;
    }

    public double calcularPrecoSeguroCliente(ClientePJ cliente, Seguradora seguradora){
        List <Sinistro> sinistros = seguradora.getListaSinistros();
        int qtd=0;
        for(Sinistro sinistro:sinistros){
            if(sinistro.getCliente() == cliente)
                qtd++;
        }
        double valor = cliente.calculaScore(cliente) * (1 + qtd);
        return valor;
    }

    public double calcularReceita(Seguradora seguradora){
        double receita = 0;
        for (Cliente cliente:seguradora.getListaClientes()){
            int qntdSinistro = 0;
            for(Sinistro sinistro: seguradora.getListaSinistros()){
                if(sinistro.getCliente().getNome().equals(cliente.getNome()))
                    qntdSinistro++;
            }
            receita += cliente.getValorSeguro() * (1 + qntdSinistro);
        }
        System.out.println("A receita é de " + receita + " reais.");
        return receita;
    }

    public void trocaSeguro(Cliente cTroca, Cliente cRecebe){
        cRecebe.setListaVeiculos(cTroca.getListaVeiculos());
        cRecebe.setValorSeguro(cTroca.getValorSeguro());
    }

    public static Seguradora cadastrarSeguradora(Scanner scan){
        System.out.println("nome da Seguradora:");
        String nome = scan.nextLine();
        System.out.println("endereco da Seguradora:");
        String endereco = scan.nextLine();
        System.out.println("telefone da Seguradora:");
        String telefone = scan.nextLine();
        System.out.println("email da Seguradora:");
        String email = scan.nextLine();
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco, null, null, null, null);
        seguradora.setListaClientes(new ArrayList<Cliente>());
        seguradora.setListaSinistros(new ArrayList<Sinistro>());
        seguradora.setListaClientePFs(new ArrayList<ClientePF>());
        seguradora.setListaClientePJs(new ArrayList<ClientePJ>());

        return seguradora;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seguradora: ").append(nome).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Lista de sinistros:\n");
        for (Sinistro sinistro : listaSinistros) {
            sb.append(sinistro).append("\n");
        }
        sb.append("Lista de clientes:\n");
        for (Cliente cliente : listaClientes) {
            sb.append(cliente).append("\n");
        }
        return sb.toString();
    }
}
