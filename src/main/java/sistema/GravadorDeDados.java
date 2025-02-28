package sistema;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    public static final String ARQUIVOS_ENCOMENDAS = "encomendas.dat";

    public Map<Integer, Encomenda> recuperarDados() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVOS_ENCOMENDAS))) {
            return (Map<Integer, Encomenda>) in.readObject();
        } catch (ClassNotFoundException | FileNotFoundException c) {
            return new HashMap<>();
        }
    }

    public void salvarDados (Map<Integer, Encomenda> encomendas) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVOS_ENCOMENDAS))) {
            out.writeObject(encomendas);
        }
    }
}
