import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Encomenda {
    private String aparelho;
    private String descricao;
    private final String id;
    private String proprietario;
    private LocalDate dataEntrada = LocalDate.now();
    private LocalDate dataSaidaPrevista = LocalDate.now().plusDays(15);

    public Encomenda(String aparelho, String proprietario, String descricao) {
        this.aparelho = aparelho;
        this.descricao = descricao;
        this.proprietario = proprietario;
        this.id = UUID.randomUUID().toString();
    }

    public Encomenda() {
        this("", "", "");
    }

    public String getAparelho() {
        return aparelho;
    }

    public void setAparelho(String aparelho) {
        this.aparelho = aparelho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaidaPrevista() {
        return dataSaidaPrevista;
    }

    @Override
    public String toString() {
        return "Objeto { " +
                "Aparelho = " + aparelho  + ", descrição = " + descricao + ", proprietario = " + proprietario +
                ", Data de entrada = " + dataEntrada + ", Data de saida prevista = " + dataSaidaPrevista + '}';
    }

    public static void main(String[] args) {
        int i = (int) Math.random()*100;
        System.out.println(i);
    }
}

