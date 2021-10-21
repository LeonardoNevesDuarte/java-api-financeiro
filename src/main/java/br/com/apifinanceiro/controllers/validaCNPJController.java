package br.com.apifinanceiro.controllers;

import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apifinanceiro.beans.beanCNPJ;
import br.com.apifinanceiro.beans.beanResponseValidation;
import br.com.apifinanceiro.beans.beanStdRequest;

@RestController
public class validaCNPJController {

    @PostMapping(value="/validaCNPJ", consumes = MediaType.APPLICATION_JSON_VALUE)
    public beanResponseValidation validaCNPJ(@RequestBody beanStdRequest req) {
        
        beanCNPJ objCNPJ = new beanCNPJ();
        beanResponseValidation objResponse = new beanResponseValidation();
        ArrayList<Integer> lstOfOutputCNPJs = new ArrayList<Integer>();
        ArrayList<String> lstOfInputCNPJs = req.getParam();

        try {
            for(String inputCNPJ: lstOfInputCNPJs) {
                objCNPJ.setCNPJ(inputCNPJ);
                if (objCNPJ.doValidaCNPJ()) {
                    lstOfOutputCNPJs.add(1);
                } else {
                    lstOfOutputCNPJs.add(0);
                }
            }
            objResponse.setStatCode(200);
            objResponse.setStatMsg("OK");
            objResponse.setInfoMsg("");
            objResponse.setResult(lstOfOutputCNPJs);
        } catch(Exception e) {
            objResponse.setStatCode(500);
            objResponse.setStatMsg("Internal Server Error");
            objResponse.setInfoMsg(e.getMessage());
        }
        objCNPJ = null;
        return objResponse;
    }
}