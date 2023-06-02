package com.pedro;

import java.util.Date;


    public class Sinistro {
        private final int id;
        private Date data;
        private String endereco;
        private Condutor condutor;
        private SeguroPF seguroPF;
        private SeguroPJ seguroPJ;

        public Sinistro(int id, Date data, String endereco, Condutor condutor, SeguroPF seguroPF, SeguroPJ seguroPJ){
            this.id = id;
            this.condutor = condutor;
            this.data = data;
            this.seguroPF = seguroPF;
            this.seguroPJ = seguroPJ;
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

