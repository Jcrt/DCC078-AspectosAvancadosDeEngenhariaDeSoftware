
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio R. Trindade
 */
public class IMC {
    private boolean sexo;
    private double peso;
    private double altura;
    private double IMC = 0;
    
    public IMC(){};
    
    public IMC(boolean sexo, double peso, double altura){
        super();
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double getIMC() {
        return IMC;
    }

    public double calculoIMC(){
        
        double imcParc = (double)(peso / Math.pow(altura, 2));
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        
        DecimalFormat df = new DecimalFormat("#.00", dfs);
        String format = df.format(imcParc);
        
        IMC = Double.parseDouble(format);
        
        return IMC;
    }
    
    public String resultadoIMC(){
        
        calculoIMC();
        String resultado;
        
        if(this.sexo){ //1
            if(IMC < 20.7){ //2
                resultado = "abaixo do peso"; //3
            } else if(IMC < 26.4){ //4
                resultado = "no peso normal"; //5
            } else if(IMC < 27.8){ //6
                resultado = "marginalmente acima do peso"; //7
            } else if(IMC < 31.1){ //8
                resultado = "acima do peso ideal"; //9
            } else{
                resultado = "Obeso"; //10
            }
        } else{
            if(IMC < 19.1){ //11
                resultado = "abaixo do peso"; //12
            } else if(IMC < 25.8){ //13
                resultado = "no peso normal"; //14
            } else if(IMC < 27.3){ //15
                resultado = "marginalmente acima do peso"; //16
            } else if(IMC < 32.3){ //17
                resultado = "acima do peso ideal"; //18
            } else{
                resultado = "Obeso"; //19
            }
        }
        return resultado;
    }
}

