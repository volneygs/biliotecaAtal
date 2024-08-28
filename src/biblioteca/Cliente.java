package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String id;
    private List<String> livrosEmprestados;

    // Construtor
    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>(); // Inicializa a lista de livros emprestados
    }

    // Getter e Setter para o nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para o ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Método para pegar um livro emprestado
    public void pegarLivroEmprestado(String livro) {
        livrosEmprestados.add(livro);
        System.out.println("Livro \"" + livro + "\" emprestado ao cliente " + nome + ".");
    }

    // Método para devolver um livro
    public void devolverLivro(String livro) {
        if (livrosEmprestados.remove(livro)) {
            System.out.println("Livro \"" + livro + "\" devolvido pelo cliente " + nome + ".");
        } else {
            System.out.println("O cliente " + nome + " não possui o livro \"" + livro + "\" emprestado.");
        }
    }

    // Método para listar todos os livros emprestados
    public void listarLivrosEmprestados() {
        if (livrosEmprestados.isEmpty()) {
            System.out.println("O cliente " + nome + " não tem livros emprestados.");
        } else {
            System.out.println("Livros emprestados pelo cliente " + nome + ":");
            for (String livro : livrosEmprestados) {
                System.out.println("- " + livro);
            }
        }
    }
}


