package com.pedro;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

    public class Sinistro {
        private final int id = GeraID();
        private Date data;
        private String endereco;
        private Condutor condutor;
        private SeguroPF seguroPF;
        private SeguroPJ seguroPJ;

        public Sinistro(String data, String endereco, Condutor condutor, SeguroPF seguroPF, SeguroPJ seguroPJ){
            this.condutor = condutor;
            this.seguroPF = seguroPF;
            this.seguroPJ = seguroPJ;
            this.endereco = endereco;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.data = format.parse(data);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido!");
                e.printStackTrace();
            }
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
        public SeguroPF getSeguroPF() {
            return seguroPF;
        }
        public void setSeguroPF(SeguroPF seguroPF) {
            this.seguroPF = seguroPF;
        }
        public SeguroPJ getSeguroPJ() {
            return seguroPJ;
        }
        public void setSeguroPJ(SeguroPJ seguroPJ) {
            this.seguroPJ = seguroPJ;
        }
      
        public int GeraID(){
            // Gera um número int aleatório para o id
            Random gerador = new Random();
            return gerador.nextInt(100);
    
        }

        public String toString() {
            return "Sinistro{" +
                    "id=" + id +
                    ", data=" + data +
                    ", endereco='" + endereco + '\'' +
                    ", condutor=" + condutor +
                    ", seguroPF=" + seguroPF +
                    ", seguroPJ=" + seguroPJ +
                    '}';
        }

    } 

