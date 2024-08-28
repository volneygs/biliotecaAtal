package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Cliente> clientes;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Método para cadastrar um livro na biblioteca
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro \"" + livro.getTitulo() + "\" cadastrado na biblioteca.");
    }

    // Método para excluir um livro da biblioteca
    public void excluirLivro(Livro livro) {
        if (livros.remove(livro)) {
            System.out.println("Livro \"" + livro.getTitulo() + "\" excluído da biblioteca.");
        } else {
            System.out.println("Livro \"" + livro.getTitulo() + "\" não encontrado na biblioteca.");
        }
    }

    // Método para cadastrar um cliente na biblioteca
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente \"" + cliente.getNome() + "\" cadastrado na biblioteca.");
    }

    // Método para excluir um cliente da biblioteca
    public void excluirCliente(Cliente cliente) {
        if (clientes.remove(cliente)) {
            System.out.println("Cliente \"" + cliente.getNome() + "\" excluído da biblioteca.");
        } else {
            System.out.println("Cliente \"" + cliente.getNome() + "\" não encontrado na biblioteca.");
        }
    }

    // Método para emprestar um livro a um cliente
    public void emprestarLivro(Cliente cliente, Livro livro) {
        if (!livros.contains(livro)) {
            System.out.println("Livro \"" + livro.getTitulo() + "\" não está disponível na biblioteca.");
            return;
        }

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusDays(10);
        livro.setDataEmprestimo(dataEmprestimo);
        livro.setDataDevolucao(dataDevolucao);

        cliente.pegarLivroEmprestado(livro.getTitulo());
        livros.remove(livro); // Remover o livro da biblioteca

        System.out.println("Livro \"" + livro.getTitulo() + "\" emprestado ao cliente " + cliente.getNome() + 
            ". Data de devolução: " + dataDevolucao);
    }

    // Método para receber um livro devolvido de um cliente
    public void receberLivro(Cliente cliente, Livro livro) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataDevolucao = livro.getDataDevolucao();

        if (dataDevolucao != null && dataAtual.isAfter(dataDevolucao)) {
            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, dataAtual);
            double multa = diasAtraso * 1.00;
            System.out.println("Livro devolvido com atraso de " + diasAtraso + " dias. Multa de R$ " + multa);
        } else {
            System.out.println("Livro devolvido no prazo.");
        }

        // Remover o livro da lista de empréstimos do cliente
        cliente.devolverLivro(livro.getTitulo());
        livro.setDataEmprestimo(null);
        livro.setDataDevolucao(null);
        livros.add(livro); // Adicionar o livro de volta à biblioteca
    }

}
