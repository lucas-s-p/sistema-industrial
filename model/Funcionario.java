package model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Getter
@Setter
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getSalarioFormatado() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);
        return formatter.format(salario);
    }

    public void aplicarAumento(double percentual) {
        BigDecimal aumento = salario.multiply(BigDecimal.valueOf(percentual / 100));
        this.salario = salario.add(aumento);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Data Nascimento: %s | Salário: R$ %s | Função: %s",
                getNome(), getDataNascimentoFormatada(), getSalarioFormatado(), funcao);
    }
}