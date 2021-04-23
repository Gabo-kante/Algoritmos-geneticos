/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maximizar;

import java.lang.reflect.Array;

/**
 *
 * @author gabri
 */
public class Binario {
//    public int[] binr;
    public int desc;
    public int resfit;
    public int[] ac1;
    public int[] ac2;

//    public int[] getBinr() {
//        return binr;
//    }
//
//    public void setBinr(int[] binr) {
//        this.binr = binr;
//    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    public int getResfit() {
        return resfit;
    }

    public void setResfit(int resfit) {
        this.resfit = resfit;
    }

    public int[] getAc1() {
        return ac1;
    }
    
    public int getAc1one(int pos) {
        return ac1[pos];
    }
    
    public void setAc1(int[] ac1) {
        this.ac1 = ac1;
    }

    public int[] getAc2() {
        return ac2;
    }
    
    public int getAc2one(int pos) {
        return ac2[pos];
    }

    public void setAc2(int[] ac2) {
        this.ac2 = ac2;
    }
    
    
    
    public Binario(){
    
    
    }
    
    public int bintoDes(int[] bin){//Binario a decimal 
        
        int tam=bin.length;
        int k=bin.length-1; // 11011   (1x2^4)+(1x2^3)+(1x0^2)+(1x2^1)+(1x2^0)= 27
        
        for(int i=0;i<tam;i++){
            desc+=(int) (bin[i]*(Math.pow(2, k--)));             
        }                                    
        return desc;
    }
    public int cal_Fintness(int des){
        resfit=(int) Math.pow(des,2);
        
        return resfit;
    }
    
    public void cruza(int[] c1, int[] c2, int[] mask){
        
        ac1=new int[mask.length];
        ac2=new int[mask.length];
        
        for(int i=0;i<mask.length;i++){
            if(mask[i]==1){
                ac1[i]=c1[i];
                ac2[i]=c2[i];
            }else{
                ac1[i]=c2[i];
                ac2[i]=c1[i];
            }                
        }
    }
    public static void main(String args[]){
        int[] binr = {0,1,1,0,1};   
        
        Binario bo = new Binario();
        
       System.out.println(bo.bintoDes(binr)); 
       System.out.println(bo.cal_Fintness(bo.getDesc())); 
       
       //parte cruza
       Binario cruza= new Binario();
       
       int[]a1= new int[]{1,1,1,0,1,0,0,1,0,0,0};
       int[]a2=new int[]{0,0,0,0,1,0,1,0,1,0,1};
       int[]maskara=new int[]{1,1,1,1,1,0,0,0,0,0,0};
       
       cruza.cruza(a1, a2, maskara);
       
       for(int i=0;i<maskara.length;i++){
           System.out.print(cruza.getAc1one(i)); 
       }
                  System.out.println("|");
       for(int i=0;i<maskara.length;i++){
           System.out.print(cruza.getAc2one(i));      
       } 
    }
}