package sistema;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import sistema.enums.Categoria;

public class Servico implements Serializable {
    private String aparelho;
    private String descricao;
    private Categoria categoria;
    private LocalDate dataEntrada = LocalDate.now();
    private LocalDate dataSaidaPrevista = LocalDate.now().plusDays(15);
    private String status;
    private String id;


    public Servico(String aparelho, String descricao, Categoria categoria, String cpf) {
        this.aparelho = aparelho;
        this.descricao = descricao;
        this.categoria = categoria;
        this.id = cpf;
        this.status = "A FAZER";
    }

    public Servico() {
        this("", "", Categoria.OUTROS, "Cliente não identificado");
    }


    public String getAparelho() {
        return aparelho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getIdToString() {
        String [] C = this.id.split("");
        //TODO: Otimizar os intervalos entre 0-2, 3-4, 6-8 e 9-10;
        String cpfFormatado = C[0] + C[1] + C[2] + "." + C[3] + C[4] + C[5] + "." + C[6] + C[7] + C[8] + "-" + C[9] + C[10];
        return cpfFormatado;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Servico encomenda = (Servico) o;
        return id == encomenda.id && Objects.equals(aparelho, encomenda.aparelho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aparelho, id);
    }

    @Override
    public String toString() {
        return " ====================\nObjeto com status " + status.toUpperCase() + " {\n" +
                "Aparelho = " + aparelho  + ",\nDescrição = " + descricao +
                ",\nData de entrada = " + dataEntrada + ",\nData de saida prevista = " + dataSaidaPrevista + "\nCPF do cliente = " + getIdToString()+ "}\n";
    }

    public static void main(String[] args) {
        Servico a = new Servico("Aparelho", "Descrição", Categoria.LIMPEZA, "12887204408");
        System.out.println(a.getIdToString());
    }
}

