
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seguradora {
    private final String cnpj;
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private List <Seguro> listaSegurosPfs;
    //private List <Seguro> listaSeguros;
    private List <SeguroPJ> listaSegurosPjs;
    private List <ClientePF>  listaClientePFs;
    private List <ClientePJ> listaClientePJs;

    // Construtor
    public Seguradora ( String nome , String telefone , String email , String endereco, List <ClientePF> listaClientePFs, List <ClientePJ> listaClientePJs, String cnpj, List <Seguro> listaSeguros) {
        this . nome = nome ;
        this . telefone = telefone ;
        this . email = email ;
        this . endereco = endereco ;
        this.cnpj = cnpj;
        this.listaSegurosPfs = listaSegurosPfs != null ? listaSegurosPfs : new ArrayList<>();
        this.listaSegurosPjs = listaSegurosPjs != null ? listaSegurosPjs : new ArrayList<>();
        //this.listaSeguros = listaSeguros != null ? listaSeguros : new ArrayList<>();
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
    public List<Seguro> getListaSegurosPfs() {
        return listaSegurosPfs;
    }
    public void setListaSegurosPfs(List<Seguro> listaSegurosPfs) {
        this.listaSegurosPfs = listaSegurosPfs;
    }
    public List<SeguroPJ> getListaSegurosPjs() {
        return listaSegurosPjs;
    }
    public void setListaSegurosPjs(List<SeguroPJ> listaSegurosPjs) {
        this.listaSegurosPjs = listaSegurosPjs;
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
    /*public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }
    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }*/
    public String getCnpj() {
        return cnpj;
    }

    public boolean gerarSeguro(Cliente cliente, Seguro seguro) {

        /*É necessário fazer a implementação na main para chamar o método, exemplo: // Pergunta se deseja gerar um seguro PF ou PJ
        System.out.println("Deseja gerar um seguro PF ou PJ? (PF/PJ)");
        String tipoSeguro = scanner.nextLine();

        // Cria o objeto seguroPF ou seguroPJ de acordo com a resposta
        Seguro seguro;
        if (tipoSeguro.equalsIgnoreCase("PF")) {
            seguro = new SeguroPF();
        } else if (tipoSeguro.equalsIgnoreCase("PJ")) {
            seguro = new SeguroPJ();
        } else {
            System.out.println("Opção inválida. Encerrando o programa.");
            return;
        }

        // Cria o objeto clientePF ou clientePJ
        Cliente cliente;
        if (seguro instanceof SeguroPF) {
            cliente = new ClientePF();
            // Configura os atributos específicos do clientePF
        } else {
            cliente = new ClientePJ();
            // Configura os atributos específicos do clientePJ
        }

        // Chama o método gerarSeguro da seguradora
        Seguradora seguradora = new Seguradora();
        boolean resultado = seguradora.gerarSeguro(cliente, seguro);

        if (resultado) {
            System.out.println("Seguro gerado com sucesso!");
        } else {
            System.out.println("Não foi possível gerar o seguro.");
        }
    } */

        if (cliente instanceof ClientePF && seguro instanceof SeguroPF) {
            ClientePF clientePF = (ClientePF) cliente;
            SeguroPF seguroPF = (SeguroPF) seguro;
    
            // Verifica se o cliente já possui o veículo registrado
            if (clientePF.getListaVeiculos().contains(seguroPF.getVeiculo())) {
                // Atualiza a seguradora do seguro
                seguroPF.setSeguradora(this);
    
                // Adiciona o seguro à lista de seguros da seguradora
                listaSegurosPfs.add(seguroPF);
    
                return true;
            }
        } else if (cliente instanceof ClientePJ && seguro instanceof SeguroPJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            SeguroPJ seguroPJ = (SeguroPJ) seguro;
    
            // Verifica se o cliente já possui a frota registrada
            if (clientePJ.getListaFrota().contains(seguroPJ.getFrota())) {
                // Atualiza a seguradora do seguro
                seguroPJ.setSeguradora(this);
    
                // Adiciona o seguro à lista de seguros da seguradora
                listaSegurosPjs.add(seguroPJ);
    
                return true;
            }
        }
    
        return false;
    }
    
    public boolean cancelarSeguro(Seguro seguro) {
        if (seguro instanceof SeguroPF) {
            SeguroPF seguroPF = (SeguroPF) seguro;
            if (listaSegurosPfs.remove(seguroPF)) {
                seguroPF.setSeguradora(null);
                return true;
            }
        } else if (seguro instanceof SeguroPJ) {
            SeguroPJ seguroPJ = (SeguroPJ) seguro;
            if (listaSegurosPjs.remove(seguroPJ)) {
                seguroPJ.setSeguradora(null);
                return true;
            }
        }
        return false;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente instanceof ClientePF) {
            ClientePF clientePF = (ClientePF) cliente;
            listaClientePFs.add(clientePF);
        } else if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
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
            for (Seguro seguro : listaSegurosPfs) {
                if (seguro instanceof SeguroPF && ((SeguroPF) seguro).getCliente().equals(clientePF)) {
                    segurosCliente.add(seguro);
                }
            }
        } else if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            for (Seguro seguro : listaSegurosPjs) {
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
            for (Seguro seguro : listaSegurosPfs) {
                if (seguro instanceof SeguroPF && ((SeguroPF) seguro).getCliente().equals(clientePF)) {
                    sinistrosCliente.addAll(((SeguroPF) seguro).getListaSinistros());
                }
            }
        } else if (cliente instanceof ClientePJ) {
            ClientePJ clientePJ = (ClientePJ) cliente;
            for (Seguro seguro : listaSegurosPjs) {
                if (seguro instanceof SeguroPJ && ((SeguroPJ) seguro).getCliente().equals(clientePJ)) {
                    sinistrosCliente.addAll(((SeguroPJ) seguro).getListaSinistros());
                }
            }
        }
    
        return sinistrosCliente;
    }
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seguradora: ").append(nome).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Lista de seguros físicos:\n");
        for (Seguro seguroPF : listaSegurosPfs) {
            sb.append(seguroPF).append("\n");
        }
        sb.append("Lista de seguros jurídicos:\n");
        for (SeguroPJ seguroPJ : listaSegurosPjs) {
            sb.append(seguroPJ).append("\n");
        }
        /*sb.append("Lista de seguros:\n");
        for (Seguro seguro : listaSeguros) {
            sb.append(seguro).append("\n");
        }*/
        sb.append("Lista de clientes físicos:\n");
        for (ClientePF clientePf : listaClientePFs) {
            sb.append(clientePf).append("\n");
        }
        sb.append("Lista de clientes jurídicos:\n");
        for (ClientePJ clientePj : listaClientePJs) {
            sb.append(clientePj).append("\n");
        }
        return sb.toString();
    }
}
