package lista.le5;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path arquivo = Paths.get("funcionarios.csv");
        new csvTop().gerarCsvFuncComFilhos(arquivo);
    }

}
