package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidado {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidado() {
        this.convidadoSet = new HashSet<>();
    }

    //Adiciona um convidado ao conjunto.
    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    //Remove um convidado do conjunto com base no código do convite.
    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoParaRemover = null;
        for (Convidado c : convidadoSet) {
            if(c.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = c;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    //Conta o número total de convidados no Set.
    public int contarConvidados(){
        return convidadoSet.size();
    }

    //Exibe todos os convidados do conjunto.
    public  void exibirConvidados() {
        System.out.println(convidadoSet);
    }
}
