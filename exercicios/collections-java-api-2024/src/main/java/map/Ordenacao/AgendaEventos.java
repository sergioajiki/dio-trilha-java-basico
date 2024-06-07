package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    //Adiciona um evento à agenda.
    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventoMap.put(data, new Evento(nome, atracao));
    }

    //Exibe a agenda de eventos em ordem crescente de data.
    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);
    }

    //Retorna o próximo evento que ocorrerá.
    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventoMapTreeMap = new TreeMap<>(eventoMap);

        for (Map.Entry<LocalDate, Evento> entry : eventoMapTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + "acontecerá na data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 15), "Evento1", "Atração1");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento2", "Atração2");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Evento3", "Atração3");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 1, 11), "Evento4", "Atração4");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 12, 10), "Evento5", "Atração5");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
