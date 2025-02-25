import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Encomenda {
    private String aparelho;
    private String descricao;
    private int id;
    private String proprietario;
    private LocalDate dataEntrada = LocalDate.now();
    private LocalDate dataSaidaPrevista = LocalDate.now().plusDays(15);

    public Encomenda(String aparelho, String proprietario, String descricao) {
        this.aparelho = aparelho;
        this.descricao = descricao;
        this.proprietario = proprietario;
        this.id = getId();
    }

    public Encomenda() {
        this("", "", "");
    }

    public int generateId(){
        int i = (int) Math.random()*100;
        return i;
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

    public Integer getId() {
        return id;
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

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaidaPrevista() {
        return dataSaidaPrevista;
    }

    public void setDataSaidaPrevista(LocalDate dataSaidaPrevista) {
        this.dataSaidaPrevista = dataSaidaPrevista;
    }

    @Override
    public String toString() {
        return "Objeto { " +
                "Aparelho = " + aparelho  + ", descrição = " + descricao + ", proprietario = " + proprietario +
                ", Data de entrada = " + dataEntrada + ", Data de saida prevista = " + dataSaidaPrevista + '}';
    }
}

