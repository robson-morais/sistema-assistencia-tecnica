import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Encomenda {
    private String aparelho;
    private String descricao;
    private Categoria categoria;
    private String proprietario;
    private LocalDate dataEntrada = LocalDate.now();
    private LocalDate dataSaidaPrevista = LocalDate.now().plusDays(15);
    private String status;
    private int id;


    public Encomenda(String cliente, String aparelho, String descricao, Categoria categoria, int codigo) {
        this.proprietario = cliente;
        this.aparelho = aparelho;
        this.descricao = descricao;
        this.categoria = categoria;
        this.id = codigo;
        this.status = "'A FAZER'";
    }

    public Encomenda() {
        this("", "", "", Categoria.INDEFINIDO, 0);
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

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaidaPrevista() {
        return dataSaidaPrevista;
    }

    public int getId() {
        return this.id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Objeto com status "+ status.toUpperCase() + " { " +
                "Aparelho = " + aparelho  + ", descrição = " + descricao + ", proprietario = " + proprietario +
                ", Data de entrada = " + dataEntrada + ", Data de saida prevista = " + dataSaidaPrevista + '}';
    }
}

