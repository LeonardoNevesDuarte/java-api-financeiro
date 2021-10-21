package br.com.apifinanceiro.controllers;

import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apifinanceiro.beans.beanCNPJ;
import br.com.apifinanceiro.beans.beanResponse;
import br.com.apifinanceiro.beans.beanRequestInt;

@RestController
public class geraCNPJController {
   
    @GetMapping(value = "/geraCNPJ", consumes = MediaType.APPLICATION_JSON_VALUE)
    public beanResponse geraCNPJ(@RequestBody beanRequestInt req) {
        
        beanCNPJ objCNPJ = new beanCNPJ();
        beanResponse objResponse = new beanResponse();
        ArrayList<Integer> qtdCNPJ = req.getParam();
        ArrayList<String> lstOfOutputCNPJs = new ArrayList<String>();

        try {
            if(qtdCNPJ.size() == 1) {
                int qtdGerada = 0;
                String auxCNPJ = "";
                boolean foundCNPJ = false;

                while(qtdGerada < qtdCNPJ.get(0)) {
                    auxCNPJ = objCNPJ.doGeraCNPJ();
                    foundCNPJ = false;
                    for (var i = 0; i < lstOfOutputCNPJs.size(); i++) {
                        if(lstOfOutputCNPJs.get(i) == auxCNPJ) {
                            foundCNPJ = true;
                        }
                    }
                    if(!foundCNPJ) {
                        lstOfOutputCNPJs.add(auxCNPJ);
                        qtdGerada++;
                    }
                }
                objResponse.setStatCode(200);
                objResponse.setStatMsg("OK");
                objResponse.setInfoMsg("");
                objResponse.setResult(lstOfOutputCNPJs);
            } else {
                objResponse.setStatCode(400);
                objResponse.setStatMsg("Bad request");
                objResponse.setInfoMsg("Too many parameters. Only one is expected");
                objResponse.setResult(lstOfOutputCNPJs);
            }
            
        } catch(Exception e) {
            objResponse.setStatCode(500);
            objResponse.setStatMsg("Internal Server Error");
            objResponse.setInfoMsg(e.getMessage());
        }
        objCNPJ = null;
        qtdCNPJ = null;
        lstOfOutputCNPJs = null;
        return objResponse;
    }
}