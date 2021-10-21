package br.com.apifinanceiro.beans;

import java.util.InputMismatchException;

public class beanCNPJ {
    
    private String cnpj;

    public void setCNPJ(String varCNPJ) {
        this.cnpj = varCNPJ;
    }

    public boolean doValidaCNPJ() {

        // Verifica se um número foi informado
        if (this.cnpj == null || this.cnpj == "") {
            return false;
        }
        // Elimina possivel mascara
        // cpf = preg_replace("/[^0-9]/", "", cpf);
        // cpf = str_pad(cpf, 11, "0", STR_PAD_LEFT);

        // Verifica se o numero de digitos informados é igual a 11
        if (this.cnpj.length() != 14) {
            return false;
        }
        // Verifica se nenhuma das sequências invalidas abaixo
        // foi digitada. Caso afirmativo, retorna falso
        else if (this.cnpj.equals("00000000000000") || this.cnpj.equals("11111111111111") || this.cnpj.equals("22222222222222") || this.cnpj.equals("33333333333333")
                || this.cnpj.equals("44444444444444") || this.cnpj.equals("55555555555555") || this.cnpj.equals("66666666666666") || this.cnpj.equals("77777777777777")
                || this.cnpj.equals("88888888888888") || this.cnpj.equals("99999999999999")) {       
            return false;
            // Calcula os digitos verificadores para verificar se o
            // cpf é válido
        } else {

            char dig13, dig14;
            int sm, i, r, num, peso;

            // "try" - protege o código para eventuais erros de conversao de tipo (int)
            try {
                // Calculo do 1o. Digito Verificador
                sm = 0;
                peso = 2;
                for (i=11; i>=0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                    num = (int)(this.cnpj.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso + 1;
                    if (peso == 10)
                    peso = 2;
                }

                r = sm % 11;
                if ((r == 0) || (r == 1))
                    dig13 = '0';
                else dig13 = (char)((11-r) + 48);

                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 2;
                for (i=12; i>=0; i--) {
                    num = (int)(this.cnpj.charAt(i)- 48);
                    sm = sm + (num * peso);
                    peso = peso + 1;
                    if (peso == 10)
                    peso = 2;
                }

                r = sm % 11;
                if ((r == 0) || (r == 1))
                    dig14 = '0';
                else dig14 = (char)((11-r) + 48);

                // Verifica se os dígitos calculados conferem com os dígitos informados.
                if ((dig13 == this.cnpj.charAt(12)) && (dig14 == this.cnpj.charAt(13)))
                    return(true);
                else return(false);
            } catch (InputMismatchException erro) {
                return(false);
            }
        }
    }
}
