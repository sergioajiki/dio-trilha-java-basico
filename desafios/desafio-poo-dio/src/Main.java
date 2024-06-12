import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso Java");
        curso1.setDescricao("descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso JavaScript");
        curso2.setDescricao("descrição curso JavaScript");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de Java");
        mentoria.setDescricao("descrição mentoria Java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devSergio = new Dev();
        devSergio.setNome("Sergio");
        devSergio.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Sergio " + devSergio.getConteudosInscritos());
        System.out.println("-");
        devSergio.progredir();
        devSergio.progredir();
        devSergio.progredir();
        System.out.println("Conteúdos Concluidos Sergio " + devSergio.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos Sergio " + devSergio.getConteudosInscritos());
        System.out.println("XP: " + devSergio.calcularTotalXp());

        System.out.println("-----");

        Dev devDesenvolvedor1 = new Dev();
        devDesenvolvedor1.setNome("Dev01");
        devDesenvolvedor1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Dev01" + devDesenvolvedor1.getConteudosInscritos());
        System.out.println("-");
        devDesenvolvedor1.progredir();
        System.out.println("Conteúdos Concluidos Dev01 " + devDesenvolvedor1.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos Dev01" + devDesenvolvedor1.getConteudosInscritos());
        System.out.println("XP: " + devDesenvolvedor1.calcularTotalXp());

    }
}