package br.com.apifinanceiro.beans;

import java.util.ArrayList;

public class beanRequestInt {
    
    private String authKey;
    private ArrayList<Integer> param;

    // Constructor
    public beanRequestInt(String varAuthKey, ArrayList<Integer> varParam) {
        this.authKey = varAuthKey;
        this.param = varParam;
    }
    public void setAuthKey(String varAuthKey) {
        this.authKey = varAuthKey;
    }
    public String getAuthKey() {
        return authKey;
    }
    public void setParam(ArrayList<Integer> varParam) {
        this.param = varParam;
    }

    public ArrayList<Integer> getParam() {
        return param;
    }
    /*
    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("clsStdRequest{");
        sb.append("authKey='").append(authKey).append('\'');
        sb.append(", param={'").append("01204908702").append("\'}");
        sb.append('}');
        return sb.toString();
    }*/

}
