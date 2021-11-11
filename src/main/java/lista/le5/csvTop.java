package lista.le5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class csvTop {

    ArrayList<Funcionario> f = new ArrayList<Funcionario>();
    ArrayList<ArrayList<Funcionario>> aux = new ArrayList<ArrayList<Funcionario>>();
    Path funcFilhos = Paths.get("FuncionariosComFilhos.csv");



    public Path gerarCsvFuncComFilhos(Path parte) {
        try {
            List<String> Linhas = Files.readAllLines(parte);
            Linhas.remove(0);

            Linhas.forEach(linha -> {
                String vetorSplit[] = linha.split(",");
                Funcionario funcTemp = new Funcionario(Integer.parseInt(vetorSplit[0]), Integer.parseInt(vetorSplit[3]), Double.parseDouble(vetorSplit[4]));
                f.add(funcTemp);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.writeString(funcFilhos,"ID"  + "," + "filhos" + "," +" Salario \n",StandardOpenOption.WRITE );
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Funcionario func : f ) {
            if(func.getNumFilhos()>0)
            {
                try {
                    Files.writeString(funcFilhos,  func.getId() +  " , " + func.getNumFilhos() +  " , " + func.getSalario() + "\n" ,StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return funcFilhos;
    }
}
