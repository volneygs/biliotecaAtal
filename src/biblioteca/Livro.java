package biblioteca;

import java.time.LocalDate;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataEmprestimo = null;
        this.dataDevolucao = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }


    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
