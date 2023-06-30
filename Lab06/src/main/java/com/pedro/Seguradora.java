package com.pedro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Os dados de Cliente, Condutor, Frota e veículo são utilizados para leitura e instanciação desses dados 
// Já para os arquivos de seguro e Sinistro será usado o método de gravar arquivo para transcrever os dados desses objetos
public class Seguradora {
    private final String cnpj;
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private List <SeguroPF> listaSeguroPFs;
    private List <SeguroPJ> listaSeguroPJs;
    private List <ClientePF>  listaClientePFs;
    private List <ClientePJ> listaClientePJs;
    private ArquivoClientePF arquivoClientePF;
    private ArquivoClientePJ arquivoClientePJ;
    private ArquivoCondutor arquivoCondutor;
    private ArquivoFrota arquivoFrota;
    private ArquivoSeguro arquivoSeguro;
    private ArquivoSinistro arquivoSinistro;
    private ArquivoVeiculo arquivoVeiculo;

    // Construtor
    public Seguradora ( String nome , String telefone , String email , String endereco, List <ClientePF> listaClientePFs, List <ClientePJ> listaClientePJs, String cnpj, List <SeguroPF> listaSeguroPFs, List <SeguroPJ> listaSeguroPJs, ArquivoClientePF arquivoClientePF, ArquivoClientePJ arquivoClientePJ, ArquivoCondutor arquivoCondutor, ArquivoFrota arquivoFrota, ArquivoSeguro arquivoSeguro, ArquivoSinistro arquivoSinistro, ArquivoVeiculo arquivoVeiculo) {
        this . nome = nome ;
        this . telefone = telefone ;
        this . email = email ;
        this . endereco = endereco ;
        if (listaClientePFs != null)
            this.listaSeguroPFs = listaSeguroPFs;
        else
            this.listaSeguroPFs = new ArrayList<>();
            
        if (listaClientePJs != null)
            this.listaSeguroPJs = listaSeguroPJs;
        else
            this.listaSeguroPJs = new ArrayList<>();

        this.listaClientePFs = new ArrayList<>();
        this.listaClientePJs = new ArrayList<>();

        if (arquivoClientePF != null)
            this.arquivoClientePF = arquivoClientePF;
        else
            this.arquivoClientePF = null;

        if (arquivoClientePJ != null)
            this.arquivoClientePJ = arquivoClientePJ;
        else
            this.arquivoClientePJ = null;

        if (arquivoCondutor != null)
            this.arquivoCondutor = arquivoCondutor;
        else
            this.arquivoCondutor = null;

        if (arquivoFrota != null)
            this.arquivoFrota = arquivoFrota;
        else
            this.arquivoFrota = null;
        
        if (arquivoSeguro != null)
            this.arquivoSeguro = arquivoSeguro;
        else
            this.arquivoSeguro = null;

        if (arquivoSinistro != null)
            this.arquivoSinistro = arquivoSinistro;
        else
            this.arquivoSinistro = null;

        if (arquivoVeiculo != null)
            this.arquivoVeiculo = arquivoVeiculo;
        else
            this.arquivoVeiculo = null;
        

        if(Validacao.ValidarCNPJ(cnpj))
            this.cnpj = cnpj;
        else
            throw new IllegalArgumentException("CNPJ inválido. A instância do objeto Seguradora foi cancelada.");

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
    public List<SeguroPF> getListaSeguroPFs() {
        return listaSeguroPFs;
    }
    public void setListaSeguroPFs(List<SeguroPF> listaSeguroPFs) {
        this.listaSeguroPFs = listaSeguroPFs;
    }
    public List<SeguroPJ> getListaSeguroPJs() {
        return listaSeguroPJs;
    }
    public void setListaSeguroPJs(List<SeguroPJ> listaSeguroPJs) {
        this.listaSeguroPJs = listaSeguroPJs;
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
    public String getCnpj() {
        return cnpj;
    }
    public ArquivoClientePF getArquivoClientePF() {
        return arquivoClientePF;
    }
    public void setArquivoClientePF(ArquivoClientePF arquivoClientePF) {
        this.arquivoClientePF = arquivoClientePF;
    }
    public ArquivoClientePJ getArquivoClientePJ() {
        return arquivoClientePJ;
    }
    public void setArquivoClientePJ(ArquivoClientePJ arquivoClientePJ) {
        this.arquivoClientePJ = arquivoClientePJ;
    }
    public ArquivoCondutor getArquivoCondutor() {
        return arquivoCondutor;
    }
    public void setArquivoCondutor(ArquivoCondutor arquivoCondutor) {
        this.arquivoCondutor = arquivoCondutor;
    }
    public ArquivoFrota getArquivoFrota() {
        return arquivoFrota;
    }
    public void setArquivoFrota(ArquivoFrota arquivoFrota) {
        this.arquivoFrota = arquivoFrota;
    }
    public ArquivoSeguro getArquivoSeguro() {
        return arquivoSeguro;
    }
    public void setArquivoSeguro(ArquivoSeguro arquivoSeguro) {
        this.arquivoSeguro = arquivoSeguro;
    }
    public ArquivoSinistro getArquivoSinistro() {
        return arquivoSinistro;
    }
    public void setArquivoSinistro(ArquivoSinistro arquivoSinistro) {
        this.arquivoSinistro = arquivoSinistro;
    }
    public ArquivoVeiculo getArquivoVeiculo() {
        return arquivoVeiculo;
    }
    public void setArquivoVeiculo(ArquivoVeiculo arquivoVeiculo) {
        this.arquivoVeiculo = arquivoVeiculo;
    }

    public boolean gerarSeguro(Cliente cliente, Scanner scanner, Veiculo veiculo,Frota frota) {
        if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            SeguroPJ seguroPJ = SeguroPJ.criaSeguroPJ(scanner, this, null, null, frota, clientePJ);
            listaSeguroPJs.add(seguroPJ);
            seguroPJ.calcularValor(clientePJ, this);
            System.out.println("Seguro gerado com sucesso");
            return true;
        } else if (cliente instanceof ClientePF) {
            ClientePF clientePF = (ClientePF) cliente;
            SeguroPF seguroPF = SeguroPF.criarSeguroPF(this, scanner, null, null, veiculo, clientePF);
            listaSeguroPFs.add(seguroPF);
            seguroPF.calcularValor(clientePF, this);
            System.out.println("Seguro gerado com sucesso");
            return true;
        }
        return false;
    }
    
    
    public boolean cancelarSeguro(Seguro seguro) {
        if (seguro instanceof SeguroPF) {
            SeguroPF seguroPF = (SeguroPF) seguro;
            if (listaSeguroPFs.remove(seguroPF)) {
                seguroPF.setSeguradora(null);
                return true;
            }
        } else if (seguro instanceof SeguroPJ) {
            SeguroPJ seguroPJ = (SeguroPJ) seguro;
            if (listaSeguroPJs.remove(seguroPJ)) {
                seguroPJ.setSeguradora(null);
                return true;
            }
        }
        return false;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente instanceof ClientePF) {
            ClientePF clientePF = (ClientePF) cliente;
            System.out.println("Cliente cadastrado");
            listaClientePFs.add(clientePF);
        } else if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            System.out.println("Cliente cadastrado");
            listaClientePJs.add(clientePJ);
        }
    }

    public boolean removerCliente(Cliente cliente) {
        if (cliente instanceof ClientePF) {
            ClientePF clientePF = (ClientePF) cliente;
            return listaClientePFs.remove(clientePF);
        } else if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            return listaClientePJs.remove(clientePJ);
        }
        return false;
    }

    public List<Seguro> getSegurosPorCliente(Cliente cliente) {
        List<Seguro> segurosCliente = new ArrayList<>();
    
        if (cliente instanceof ClientePF) {
            ClientePF clientePF = (ClientePF) cliente;
            for (Seguro seguro : listaSeguroPFs) {
                if (seguro instanceof SeguroPF && ((SeguroPF) seguro).getCliente().equals(clientePF)) {
                    segurosCliente.add(seguro);
                }
            }
        } else if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            for (Seguro seguro : listaSeguroPJs) {
                if (seguro instanceof SeguroPJ && ((SeguroPJ) seguro).getCliente().equals(clientePJ)) {
                    segurosCliente.add(seguro);
                }
            }
        }
    
        return segurosCliente;
    }
    

    public List<Sinistro> getSinistrosPorCliente(Cliente cliente) {
        List<Sinistro> sinistrosCliente = new ArrayList<>();
    
        if (cliente instanceof ClientePF) {
            ClientePF clientePF = (ClientePF) cliente;
            for (Seguro seguro : listaSeguroPFs) {
                if (seguro instanceof SeguroPF && ((SeguroPF) seguro).getCliente().equals(clientePF)) {
                    sinistrosCliente.addAll(((SeguroPF) seguro).getListaSinistros());
                }
            }
        } else if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            for (Seguro seguro : listaSeguroPJs) {
                if (seguro instanceof SeguroPJ && ((SeguroPJ) seguro).getCliente().equals(clientePJ)) {
                    sinistrosCliente.addAll(((SeguroPJ) seguro).getListaSinistros());
                }
            }
        }
    
        return sinistrosCliente;
    }
    
    public void calcularReceita(){
        double receita = 0;
        for(SeguroPF seguroPF : getListaSeguroPFs()){
            receita += seguroPF.getValorMensal();
        }
        for(SeguroPJ seguroPJ : getListaSeguroPJs()){
            receita += seguroPJ.getValorMensal();
        }
        System.out.println("O valor da receita da seguradora é: R$" + receita);
    }

    public void imprimirListaSegurosPFs() {
    if (listaSeguroPFs.isEmpty()) {
        System.out.println("A lista de seguros está vazia.");
    } else {
        System.out.println("Lista de Seguros:");
        for (SeguroPF seguroPF : listaSeguroPFs) {
            seguroPF.imprimirSeguroPF();
            System.out.println("-------------------------");
            }
        }
    }

    public void imprimirListaSegurosPJs() {
    if (listaSeguroPJs.isEmpty()) {
        System.out.println("A lista de seguros está vazia.");
    } else {
        System.out.println("Lista de Seguros:");
        for (SeguroPJ seguroPJ : listaSeguroPJs) {
            System.out.println(seguroPJ.toString());
            System.out.println("-------------------------");
            }
        }
    }

    public void imprimirListaClientePFs() {
    if (listaClientePFs.isEmpty()) {
        System.out.println("A lista de clientes PFs está vazia.");
    } else {
        System.out.println("Lista de Clientes PFs:");
        for (ClientePF clientePF : listaClientePFs) {
            System.out.println(clientePF.toString());
            System.out.println("-------------------------");
            }
        }
    }

    public void imprimirListaClientePJs() {
    System.out.println("-------------------------");
    if (listaClientePJs.isEmpty()) {
        System.out.println("A lista de clientes PJs está vazia.");
    } else {
        System.out.println("Lista de Clientes PJs:");
        System.out.println();
        for (ClientePJ clientePJ : listaClientePJs) {
            System.out.println(clientePJ.toString());
            System.out.println("-------------------------");
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seguradora: ").append(nome).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Lista de seguros físicos:\n");
        for (Seguro seguroPF : listaSeguroPFs) {
            sb.append(seguroPF.toString()).append("\n");
        }
        sb.append("Lista de seguros jurídicos:\n");
        for (SeguroPJ seguroPJ : listaSeguroPJs) {
            sb.append(seguroPJ.toString()).append("\n");
        }
        sb.append("Lista de clientes físicos:\n");
        for (ClientePF clientePf : listaClientePFs) {
            sb.append(clientePf.toString()).append("\n");
        }
        sb.append("Lista de clientes jurídicos:\n");
        for (ClientePJ clientePj : listaClientePJs) {
            sb.append(clientePj.toString()).append("\n");
        }
        return sb.toString();
    }
}
