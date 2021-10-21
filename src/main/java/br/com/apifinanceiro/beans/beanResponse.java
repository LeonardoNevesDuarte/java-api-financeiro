package br.com.apifinanceiro.beans;

import java.util.ArrayList;

//This is a class that represents the standard response
// Usually { "statCode":200, "statMsg":"<message>","result":[<result item 1>,<result item 2>,<result item n>] }

public class beanResponse {

    private int statCode;
    private String statMsg;
    private String infoMsg;
    private ArrayList<String> result;

    public void setStatCode(int varStatCode) {
        this.statCode = varStatCode;
    };
    public void setStatMsg(String varStatMsg) {
        this.statMsg = varStatMsg;
    };
    public void setInfoMsg(String varInfoMsg) {
        this.infoMsg = varInfoMsg;
    };
    public void setResult(ArrayList<String> varResult) {
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
    public ArrayList<String> getResult() {
        return result;
    };
}
