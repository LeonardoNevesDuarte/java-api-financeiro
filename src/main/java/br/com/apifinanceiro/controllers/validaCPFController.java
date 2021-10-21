package br.com.apifinanceiro.controllers;

import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apifinanceiro.beans.beanCPF;
import br.com.apifinanceiro.beans.beanResponseValidation;
import br.com.apifinanceiro.beans.beanStdRequest;

@RestController
public class validaCPFController {

    @PostMapping(value="/validaCPF", consumes = MediaType.APPLICATION_JSON_VALUE)
    public beanResponseValidation validaCPF(@RequestBody beanStdRequest req) {
        
        beanCPF objCPF = new beanCPF();
        beanResponseValidation objResponse = new beanResponseValidation();
        ArrayList<Integer> lstOfOutputCPFs = new ArrayList<Integer>();
        ArrayList<String> lstOfInputCPFs = req.getParam();

        try {
            for(String inputCPF:lstOfInputCPFs) {
                objCPF.setCPF(inputCPF);
                if (objCPF.doValidaCPF()) {
                    lstOfOutputCPFs.add(1);
                } else {
                    lstOfOutputCPFs.add(0);
                }
            }
            objResponse.setStatCode(200);
            objResponse.setStatMsg("OK");
            objResponse.setInfoMsg("");
            objResponse.setResult(lstOfOutputCPFs);
        } catch(Exception e) {
            objResponse.setStatCode(500);
            objResponse.setStatMsg("Internal Server Error");
            objResponse.setInfoMsg(e.getMessage());
        }
        objCPF = null;
        return objResponse;
    }
}