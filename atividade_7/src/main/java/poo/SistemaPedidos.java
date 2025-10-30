package poo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SistemaPedidos {

    public static void main(String[] args) {
        SpringApplication.run(SistemaPedidos.class, args);
    }

    @GetMapping("/ola")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Olá,  %s!", name);
    }
    @GetMapping("/produto")
    public Produto prod() {
        Produto prod = new Produto("mouse", 15.99, 30, "0001", "Mouse Dell");
        return prod;
    }
    @GetMapping("/produtos")
    public List<Produto> produtos() {
        List<Produto> produtos = new ArrayList<>();
        try{
            FileReader reader = new FileReader("produtos.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);
            //lê o cabeçalho
            bufferedReader.readLine();
            String linha;

            while((linha = bufferedReader.readLine() )!= null){

                String colunas[] = linha.split(",");
                Produto produto = new Produto(colunas[1], Double.parseDouble(colunas[2]), Integer.parseInt(colunas[4]), colunas[0], colunas[3]);

                produtos.add(produto);
            }
        }catch(IOException e){

        }
        return produtos;
    }

}

