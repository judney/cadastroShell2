package Utils;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//import javax.swing.JOptionPane;

import com.google.gson.Gson;

//import Applications.TelaInicio;

public class ServicoDeCep {
    static String webService = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public static Endereco buscaEnderecoPelo(String cep) throws Exception {
        String urlParaChamada = webService + cep + "/json";
        //System.out.printf( "Url..: [%s]\n ", urlParaChamada ) ;  
        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            //System.out.printf("Conexao..:%s\n",  conexao);
            //System.out.printf("retorno da conexao ..: %s\n", conexao.getResponseCode());
            if (conexao.getResponseCode() != codigoSucesso)
            { 
                throw new RuntimeException("HTTP error code number  : " + conexao.getResponseCode());
                //FrameInicio.JOptionPane.showMessageDialog( null ,"Erro de conexao ") ; 
            } 
            else 
            {
                    BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
                    //System.out.printf("Resposta ....: %s\n ", resposta.toString() );
                    String jsonEmString = Util.converteJsonEmString(resposta);
                    //System.out.printf("Resposta em String %s \n ", jsonEmString);  
                    Gson gson = new Gson();
                    
                    Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
                    //System.out.printf("Endereço ..cep %s\n ", endereco); 
                    return endereco;
            }
        } catch (Exception e) {
        	
            throw new Exception("ERRO: " + e);
        }
    }
}