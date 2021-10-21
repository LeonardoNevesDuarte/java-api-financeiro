package br.com.apifinanceiro.beans;

import java.util.ArrayList;

public class beanStdRequest {
    
    private String authKey;
    private ArrayList<String> param;

    //Constructor
    public beanStdRequest() {
    }

    // Constructor
    public beanStdRequest(String varAuthKey, ArrayList<String> varParam) {
        this.authKey = varAuthKey;
        this.param = varParam;
    }
    public void setAuthKey(String varAuthKey) {
        this.authKey = varAuthKey;
    }
    public String getAuthKey() {
        return authKey;
    }
    public void setParam(ArrayList<String> varParam) {
        this.param = varParam;
    }

    public ArrayList<String> getParam() {
        return param;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("clsStdRequest{");
        sb.append("authKey='").append(authKey).append('\'');
        sb.append(", param={'").append("01204908702").append("\'}");
        sb.append('}');
        return sb.toString();
    }

}
