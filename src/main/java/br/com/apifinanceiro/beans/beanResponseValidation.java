package br.com.apifinanceiro.beans;

import java.util.ArrayList;

//This is a class that represents the standard response for validation
// Usually { "statCode":200, "statMsg":"<message>","result":[<validation for item 1: 0 or 1>,<validation for item n: 0 or 1>] }

public class beanResponseValidation {

    private int statCode;
    private String statMsg;
    private String infoMsg;
    private ArrayList<Integer> result;

    //Constructor
    public beanResponseValidation() {
        this.statCode = 0;
        this.statMsg = "";
        this.infoMsg = "";
        this.result = new ArrayList<Integer>();
    }

    public void setStatCode(int varStatCode) {
        this.statCode = varStatCode;
    };

    public void setStatMsg(String varStatMsg) {
        this.statMsg = varStatMsg;
    };

    public void setInfoMsg(String varInfoMsg) {
        this.infoMsg = varInfoMsg;
    };

    public void setResult(ArrayList<Integer> varResult) {
        this.result = varResult;
    };

    public int getStatCode() {
        return statCode;
    };

    public String getStatMsg() {
        return statMsg;
    };

    public String getInfoMsg() {
        return infoMsg;
    };

    public ArrayList<Integer> getResult() {
        return result;
    };
}
