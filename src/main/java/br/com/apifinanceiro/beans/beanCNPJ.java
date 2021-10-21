package br.com.apifinanceiro.beans;

import java.util.InputMismatchException;

public class beanCNPJ {
    
    private String cnpj;

    public void setCNPJ(String varCNPJ) {
        this.cnpj = varCNPJ;
    }

    private int randomiza(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    private int mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    public String doGeraCNPJ() {
        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = 0; // randomiza(n);
        int n10 = 0; // randomiza(n);
        int n11 = 0; // randomiza(n);
        int n12 = 1; // randomiza(n);
        int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

        d1=11-(mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

		d2 = 11 - (mod(d2, 11));

		if (d2 >= 10)
			d2 = 0;

		String retorno = null;
		retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

		return retorno;
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
