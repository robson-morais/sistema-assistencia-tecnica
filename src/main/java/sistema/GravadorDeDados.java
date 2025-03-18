package sistema;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    public static final String ARQUIVOS_ENCOMENDAS = "encomendas.txt";

    public Map<String, Servico> recuperarDados() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVOS_ENCOMENDAS))) {
            return (Map<String, Servico>) in.readObject();
        } catch (ClassNotFoundException | FileNotFoundException c) {
            return new HashMap<>();
        }
    }

    public void salvarDados (Map<String, Servico> encomendas) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_ENCOMENDAS))) {
            out.writeObject(encomendas);
        }
    }
}
