package br.com.apifinanceiro.beans;

import java.util.InputMismatchException;

public class beanCPF {
    
    private String cpf;

    public void setCPF(String varCPF) {
        this.cpf = varCPF;
    }

    public boolean doValidaCPF() {

        // Verifica se um número foi informado
        if (this.cpf == null || this.cpf == "") {
            return false;
        }
        // Elimina possivel mascara
        // cpf = preg_replace("/[^0-9]/", "", cpf);
        // cpf = str_pad(cpf, 11, "0", STR_PAD_LEFT);

        // Verifica se o numero de digitos informados é igual a 11
        if (this.cpf.length() != 11) {
            return false;
        }
        // Verifica se nenhuma das sequências invalidas abaixo
        // foi digitada. Caso afirmativo, retorna falso
        else if (this.cpf.equals("00000000000") || this.cpf.equals("11111111111") || this.cpf.equals("22222222222") || this.cpf.equals("33333333333")
                || this.cpf.equals("44444444444") || this.cpf.equals("55555555555") || this.cpf.equals("66666666666") || this.cpf.equals("77777777777")
                || this.cpf.equals("88888888888") || this.cpf.equals("99999999999")) {       
            return false;
            // Calcula os digitos verificadores para verificar se o
            // cpf é válido
        } else {

            char dig10, dig11;
            int sm, i, r, num, peso;

            try {
                // Calculo do 1o. Digito Verificador
                sm = 0;
                peso = 10;
                for (i=0; i<9; i++) {
                    // converte o i-esimo caractere do CPF em um numero:
                    // por exemplo, transforma o caractere '0' no inteiro 0
                    // (48 eh a posicao de '0' na tabela ASCII)
                    num = (int)(this.cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }
                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11))
                    dig10 = '0';
                else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 11;
                for(i=0; i<10; i++) {
                    num = (int)(this.cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11))
                    dig11 = '0';
                else dig11 = (char)(r + 48);

                // Verifica se os digitos calculados conferem com os digitos informados.
                if ((dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10)))
                    return(true);
                else return(false);
                    
            } catch (InputMismatchException erro) {
                return(false);
            }
        }
    }
}
