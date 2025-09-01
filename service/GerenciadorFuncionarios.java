package service;

import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionarios() {
        try {
            funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18),
                    new BigDecimal("2009.44"), "Operador"));
            funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12),
                    new BigDecimal("2284.38"), "Operador"));
            funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2),
                    new BigDecimal("9836.14"), "Coordenador"));
            funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14),
                    new BigDecimal("19119.88"), "Diretor"));
            funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5),
                    new BigDecimal("2234.68"), "Recepcionista"));
            funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19),
                    new BigDecimal("1582.72"), "Operador"));
            funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31),
                    new BigDecimal("4071.84"), "Contador"));
            funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8),
                    new BigDecimal("3017.45"), "Gerente"));
            funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),
                    new BigDecimal("1606.85"), "Eletricista"));
            funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2),
                    new BigDecimal("2799.93"), "Gerente"));
            System.out.println("Funcionários inseridos com sucesso!\n");
        } catch (Exception e) {
            System.err.println("Erro ao inserir funcionários.");
        }
    }

    public void removerFuncionario(String nome) {
        try {
            funcionarios.removeIf(f -> f.getNome().equals(nome));
            System.out.println("Funcionário João removido da lista.\n");
        } catch (Exception e) {
            System.err.println("Erro ao remover funcionário.");
        }
    }

    public void aplicarAumento(double percentual) {
        try {
            funcionarios.forEach(f -> f.aplicarAumento(percentual));
            System.out.println("Aumento aplicado com sucesso!\n");
        } catch (Exception e) {
            System.err.println("Erro ao aplicar aumento.");
        }
    }

    public List<Funcionario> getFuncionarios() {
        return new ArrayList<>(funcionarios);
    }
}