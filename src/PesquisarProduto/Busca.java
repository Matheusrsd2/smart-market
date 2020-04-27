/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PesquisarProduto;

import Lista.ListaProduto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.json.JSONArray;
import org.json.JSONObject;
import projetointegrador1.MensagemSistema;

/**
 *
 * @author natalia
 */
public class Busca {
    
    private int count;
    
    public Busca(){
        this.count = 0;
    }
    
    public void getAll(List list, MensagemSistema msg){
                
        new Thread() {
            @Override
            public void run(){
                
               msg.setMessageSistema("Buscando produtos...", "loading");
                
                try {
                    String url = "https://smart-market-api.herokuapp.com/tauste";
                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    // optional default is GET
                    con.setRequestMethod("GET");
                    //add request header
                    con.setRequestProperty("User-Agent", "Mozilla/5.0");
                    int responseCode = con.getResponseCode();
                    System.out.println("\nSending 'GET' request to URL : " + url);
                    System.out.println("Response Code : " + responseCode);
                    
                    if(responseCode == 200){
                        msg.setMessageSistema("Listando produtos", "loading");
                    }
                    else{
                       msg.setMessageSistema("Oops! Estamos com problemas...", "error"); 
                    }
                                       
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    String resp = response.toString().substring(1, response.toString().length()-1);
                    JSONArray myResponse = new JSONArray(response.toString());

                    int contProdutos = 0;
                    
                    for(int i=0; i< myResponse.length();i++)
                    {
                        contProdutos++;
                        
                        JSONObject row = myResponse.getJSONObject(i);
                        Produto p = new Produto();

                        String name = "";

                        if(row.has("name")){
                            name = (String)row.get("name");
                        }

                        String imageLink = "";

                        if(row.has("image")){
                            imageLink = (String)row.get("image");
                        }

                        ImageIcon img = null;

                        String preco = "";
                        if(row.has("price")){
                            preco = (String)row.get("price");
                        }

                        p.setNome(name);
                        p.setPreco(preco);
                        p.setImagem(imageLink);
                        list.add(p);
                    }
                    
                    msg.setMessageSistema(contProdutos + " produtos encontrados", "success");

                } catch (MalformedURLException ex) {
                    Logger.getLogger(winProduto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(winProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }
    
    public void getProduct(List<ListaProduto> lista, MensagemSistema msg){
        new Thread() {
            @Override
            public void run(){
                
                //System.out.println(lista.get(count));
                
                
                
                
                /*for(ListaProduto lp:lista){*/
                    try {
                        
                        ListaProduto lp = new ListaProduto();
                        lp = lista.get(count);

                        msg.setMessageSistema("Buscando "+lp.getTipoProduto().getDescricao(), "loading");
                        String url = "http://localhost:3000/confianca?produto="+lp.getTipoProduto().getDescricao();
                        URL obj = new URL(url);
                        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                        // optional default is GET
                        con.setRequestMethod("GET");
                        //add request header
                        con.setRequestProperty("User-Agent", "Mozilla/5.0");
                        int responseCode = con.getResponseCode();
                        System.out.println("\nSending 'GET' request to URL : " + url);
                        System.out.println("Response Code : " + responseCode);

                        if(responseCode == 200){
                            msg.setMessageSistema("Listando produtos", "loading");
                        }
                        else{
                           msg.setMessageSistema("Oops! Estamos com problemas...", "error"); 
                        }

                        BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();

                        String resp = response.toString().substring(1, response.toString().length()-1);
                        JSONArray myResponse = new JSONArray(response.toString());

                        int contProdutos = 0;

                        for(int i=0; i< 1;i++)
                        {
                            contProdutos++;

                            JSONObject row = myResponse.getJSONObject(i);
                            Produto p = new Produto();

                            String name = "";

                            if(row.has("name")){
                                name = (String)row.get("name");
                            }

                            String imageLink = "";

                            if(row.has("image")){
                                imageLink = (String)row.get("image");
                            }

                            ImageIcon img = null;

                            String preco = "";
                            if(row.has("price")){
                                preco = (String)row.get("price");
                            }

                            p.setNome(name);
                            p.setPreco(preco);
                            p.setImagem(imageLink);
                            //list.add(p);
                            lp.setProduto(p);
                            lista.set(count, lp);
                            System.out.printf("Nome: %s\n", lp.getProduto().getNome());
                            //System.out.printf("Preço: %s\n", preco);
                            //System.out.printf("Imagem: %s\n", imageLink);
                        }
                        
                        count++;
                        msg.setMessageSistema(count + " produtos encontrados", "success");
                        if(count < lista.size()){
                            getProduct(lista, msg);
                        }

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(winProduto.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(winProduto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                /*}*/
            }    
            
        }.start();
    }    
}
