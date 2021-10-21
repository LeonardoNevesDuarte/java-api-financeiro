package br.com.apifinanceiro.controllers;

import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apifinanceiro.beans.beanCPF;
import br.com.apifinanceiro.beans.beanResponse;
import br.com.apifinanceiro.beans.beanRequestInt;

@RestController
public class geraCPFController {
   
    @GetMapping(value = "/geraCPF", consumes = MediaType.APPLICATION_JSON_VALUE)
    public beanResponse geraCPF(@RequestBody beanRequestInt req) {
        
        beanCPF objCPF = new beanCPF();
        beanResponse objResponse = new beanResponse();
        ArrayList<Integer> qtdCPF = req.getParam();
        ArrayList<String> lstOfOutputCPFs = new ArrayList<String>();

        try {
            if(qtdCPF.size() == 1) {
                int qtdGerada = 0;
                String auxCPF = "";
                boolean foundCPF = false;

                while(qtdGerada < qtdCPF.get(0)) {
                    auxCPF = objCPF.doGeraCPF();
                    foundCPF = false;
                    for (var i = 0; i < lstOfOutputCPFs.size(); i++) {
                        if(lstOfOutputCPFs.get(i) == auxCPF) {
                            foundCPF = true;
                        }
                    }
                    if(!foundCPF) {
                        lstOfOutputCPFs.add(auxCPF);
                        qtdGerada++;
                    }
                }
                
                objResponse.setStatCode(200);
                objResponse.setStatMsg("OK");
                objResponse.setInfoMsg("");
                objResponse.setResult(lstOfOutputCPFs);
            } else {
                objResponse.setStatCode(400);
                objResponse.setStatMsg("Bad request");
                objResponse.setInfoMsg("Too many parameters. Only one is expected");
                objResponse.setResult(lstOfOutputCPFs);
            }
        } catch(Exception e) {
            objResponse.setStatCode(500);
            objResponse.setStatMsg("Internal Server Error");
            objResponse.setInfoMsg(e.getMessage());
        }
        objCPF = null;
        qtdCPF = null;
        lstOfOutputCPFs = null;
        return objResponse;
    }
}