/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author DAW
 */
public class Operaciones {
    
    int num1, num2;
    public Operaciones(int n1, int n2){
        this.num1=n1;
        this.num2=n2;
    }
    
    public int suma(){
        int resultado=0;
        resultado=this.num1+this.num2;
        return resultado;
       
    }
    
    public int resta(){
       int resultado=0;
        resultado=this.num1-this.num2;
        return resultado;
    }
    
    public int mul(){
       int resultado=0;
        resultado=this.num1*this.num2;
        return resultado;

    }
    
    public int div(){
       int resultado=0;
        resultado=this.num1/this.num2;
        return resultado;

    }
    
    
    
}
