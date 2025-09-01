package util;

import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class ProcessadorRelatorios {
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(System.out::println);
        System.out.println();
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("FUNÇÃO: " + funcao);
            lista.forEach(f -> System.out.println("  " + f));
            System.out.println();
        });
    }

    public void imprimirAniversariantes(List<Funcionario> funcionarios, List<Integer> meses) {
        funcionarios.stream()
                .filter(f -> meses.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> System.out.println(f.getNome() + " - " + f.getDataNascimentoFormatada()));
        System.out.println();
    }

    public void imprimirFuncionarioMaiorIdade(List<Funcionario> funcionarios) {
        Optional<Funcionario> maisVelho = funcionarios.stream()
                .max((f1, f2) -> {
                    int idade1 = calcularIdade(f1);
                    int idade2 = calcularIdade(f2);
                    return Integer.compare(idade1, idade2);
                });

        if (maisVelho.isPresent()) {
            Funcionario f = maisVelho.get();
            int idade = calcularIdade(f);
            System.out.println("Nome: " + f.getNome() + " | Idade: " + idade + " anos");
        }
        System.out.println();
    }

    public void imprimirFuncionariosOrdemAlfabetica(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);
        System.out.println();
    }

    public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total dos salários: R$ " + FormatadorNumerico.formatarValor(total));
        System.out.println();
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        funcionarios.forEach(f -> {
            BigDecimal quantidadeSalariosMinimos = f.getSalario()
                    .divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " +
                    FormatadorNumerico.formatarValor(quantidadeSalariosMinimos) + " salários mínimos");
        });
        System.out.println();
    }

    private int calcularIdade(Funcionario funcionario) {
        return Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
    }
}
