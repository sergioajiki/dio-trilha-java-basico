package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    //atributos
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    //Adiciona um contato à agenda.

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    //Exibe todos os contatos da agenda.
    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    //Pesquisa contatos pelo nome e retorna uma conjunto com os contatos encontrados.
    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    //Atualiza o número de telefone de um contato específico.
    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Contato1", 123);
        agendaContatos.adicionarContato("Contato2", 456);
        agendaContatos.adicionarContato("3Contato", 789);
        agendaContatos.adicionarContato("Contato4", 999);
        agendaContatos.adicionarContato("Contato5", 111);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("3"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Contato4", 777777));

        agendaContatos.exibirContatos();


    }
}
