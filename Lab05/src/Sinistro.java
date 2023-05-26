    import java.util.Date;


    public class Sinistro {
        private final int id;
        private Date data;
        private String endereco;
        private Condutor condutor;
        private Seguro seguro;

        public Sinistro(int id, Date data, String endereco, Condutor condutor, Seguro seguro){
            this.id = id;
            this.condutor = condutor;
            this.data = data;
            this.seguro = seguro;
            this.endereco = endereco;
        }

        public Condutor getCondutor() {
            return condutor;
        }
        public void setCondutor(Condutor condutor) {
            this.condutor = condutor;
        }
        public Date getData() {
            return data;
        }
        public void setData(Date data) {
            this.data = data;
        }
        public String getEndereco() {
            return endereco;
        }
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
        public int getId() {
            return id;
        }
        public Seguro getSeguro() {
            return seguro;
        }
        public void setSeguro(Seguro seguro) {
            this.seguro = seguro;
        }

        public String toString() {
            return "Sinistro {" +
                    "id=" + getId()+
                    ", data='" + getData() + '\'' +
                    ", endereco='" + getEndereco()+
                    '}';
        }
    } 

