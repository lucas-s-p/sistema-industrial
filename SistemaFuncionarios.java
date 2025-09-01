import model.Funcionario;
import service.GerenciadorFuncionarios;
import util.ProcessadorRelatorios;

import java.util.*;

public class SistemaFuncionarios {

    public static void main(String[] args) {
        // Inicialização dos objetos principais do sistema
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();
        ProcessadorRelatorios relatorios = new ProcessadorRelatorios();

        // Adiciona funcionários iniciais ao sistema
        gerenciador.adicionarFuncionarios();

        // Remove um funcionário específico (João) da lista
        gerenciador.removerFuncionario("João");

        // Exibe todos os funcionários cadastrados
        System.out.println("LISTA DE TODOS OS FUNCIONÁRIOS:");
        relatorios.imprimirFuncionarios(gerenciador.getFuncionarios());

        // Aplica aumento salarial de 10% para todos os funcionários
        gerenciador.aplicarAumento(10.0);

        // Agrupa e exibe funcionários organizados por função
        System.out.println("FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO:");
        Map<String, List<Funcionario>> funcionariosPorFuncao = relatorios.agruparPorFuncao(gerenciador.getFuncionarios());
        relatorios.imprimirFuncionariosPorFuncao(funcionariosPorFuncao);

        // Filtra e exibe aniversariantes dos meses especificados (outubro e dezembro)
        System.out.println("ANIVERSARIANTES DOS MESES 10 E 12:");
        relatorios.imprimirAniversariantes(gerenciador.getFuncionarios(), Arrays.asList(10, 12));

        // Identifica e exibe o funcionário mais velho
        System.out.println("FUNCIONÁRIO COM MAIOR IDADE:");
        relatorios.imprimirFuncionarioMaiorIdade(gerenciador.getFuncionarios());

        // Exibe funcionários ordenados alfabeticamente pelo nome
        System.out.println("FUNCIONÁRIOS EM ORDEM ALFABÉTICA:");
        relatorios.imprimirFuncionariosOrdemAlfabetica(gerenciador.getFuncionarios());

        // Calcula e exibe a soma total de todos os salários
        System.out.println("TOTAL DOS SALÁRIOS:");
        relatorios.imprimirTotalSalarios(gerenciador.getFuncionarios());

        // Calcula quantos salários mínimos cada funcionário recebe
        System.out.println("SALÁRIOS EM RELAÇÃO AO SALÁRIO MÍNIMO:");
        relatorios.imprimirSalariosMinimos(gerenciador.getFuncionarios());
    }
}