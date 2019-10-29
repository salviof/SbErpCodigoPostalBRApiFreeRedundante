/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.fw.erp.implementacao.codigopostalbr.pepino.postMan;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.Serializable;
import org.junit.runner.RunWith;

/**
 *
 * @author desenvolvedorninja01
 * @since 23/10/2019
 * @version 1.0
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:pepino", tags = "@CepPostMan",
        glue = "br.org.coletivoJava.fw.erp.implementacao.codigopostalbr.pepino.postMan",
        monochrome = true, dryRun = false
)
public class FluxoPostman implements Serializable {

}
