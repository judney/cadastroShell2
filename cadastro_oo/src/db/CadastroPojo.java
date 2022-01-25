package db;

import java.util.Date;

public class CadastroPojo {
        private int codigo;
        private String nome;
        private String cep ; 
        private String logradouro ; 
        private String numero ; 
        private String Complemento ; 
        private String Bairro ; 
        private String Cidade ;
        private  String Identidade ; 
        private String Emissor ; 
        private String  DataEmiss ; 
        private String DataNasc ; 
        private String EstCivil ; 
        private String Nacionalidade ; 
        private String Naturalidade ; 
        private String Obs ; 
        
        
        
		
		
		public String getObs() {
			return Obs;
		}

		public void setObs(String obs) {
			Obs = obs;
		}

		public String getEstCivil() {
			return EstCivil;
		}

		public void setEstCivil(String estCivil) {
			EstCivil = estCivil;
		}

		public String getNacionalidade() {
			return Nacionalidade;
		}

		public void setNacionalidade(String nacionalidade) {
			Nacionalidade = nacionalidade;
		}

		public String getNaturalidade() {
			return Naturalidade;
		}

		public void setNaturalidade(String naturalidade) {
			Naturalidade = naturalidade;
		}

		public String getDataNasc() {
			return DataNasc;
		}

		public void setDataNasc(String dataNasc) {
			DataNasc = dataNasc;
		}

		public String getDataEmiss() {
			return DataEmiss;
		}

		public void setDataEmiss(String dataEmiss) {
			DataEmiss = dataEmiss;
		}

		public String getIdentidade() {
			return Identidade;
		}

		public void setIdentidade(String identidade) {
			Identidade = identidade;
		}

		public String getEmissor() {
			return Emissor;
		}

		public void setEmissor(String emissor) {
			Emissor = emissor;
		}

		/// 01/11
        private String TipoDoc ;
        private String Cpf ; 
        private String Cnpj ; 
        
        
        
                public String getCnpj() {
			return Cnpj;
		}

		public void setCnpj(String cnpj) {
			Cnpj = cnpj;
		}

				public String getTipoDoc() {
			return TipoDoc;
		}

		public void setTipoDoc(String tipoDoc) {
			TipoDoc = tipoDoc;
		}

				public String getCpf() {
			return Cpf;
		}

		public void setCpf(String cpf) {
			Cpf = cpf;
		}

				public String getNumero() {
                        return numero;
                }

                public void setNumero(String numero) {
                        this.numero = numero;
                }

                public String getComplemento() {
                        return Complemento;
                }

                public void setComplemento(String complemento) {
                        Complemento = complemento;
                }

                public String getBairro() {
                        return Bairro;
                }

                public void setBairro(String bairro) {
                        Bairro = bairro;
                }

                public String getCidade() {
                        return Cidade;
                }

                public void setCidade(String cidade) {
                        Cidade = cidade;
                }

                public String getUF() {
                        return UF;
                }

                public void setUF(String uF) {
                        UF = uF;
                }

                private String UF ; 
        

        public String getLogradouro() {
                        return logradouro;
                }

                public void setLogradouro(String logradouro) {
                        this.logradouro = logradouro;
                }

                public int getCodigo() {
                return codigo;
        }

        public void setCodigo(int codigo) {
        

                this.codigo = codigo;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        
        public String getCep() {
            return cep ;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

		

        
}  