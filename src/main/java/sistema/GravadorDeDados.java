package sistema;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    public static final String ARQUIVOS_ENCOMENDAS = "encomendas.txt";

    public Map<String, Encomenda> recuperarDados() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVOS_ENCOMENDAS))) {
            return (Map<String, Encomenda>) in.readObject();
        } catch (ClassNotFoundException | FileNotFoundException c) {
            return new HashMap<>();
        }
    }

    public void salvarDados (Map<String, Encomenda> encomendas) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_ENCOMENDAS))) {
            out.writeObject(encomendas);
        }
    }
}
