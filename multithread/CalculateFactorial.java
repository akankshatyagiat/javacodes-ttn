package com.multithread;
import java.util.concurrent.Callable;

public class CalculateFactorial implements Callable<Integer> {
    private final int number;
    public CalculateFactorial(int number){
        this.number=number;
    }
    @Override
    public Integer call() throws Exception {
        int res=1;
        if((number)==0 || (number==1))
            res=1;
        else{
            for(int i=2;i<=number;i++)
                res*=i;
        } //else
        System.out.println("Factorial of "+number
                +" is:: "+res);
        return res;
    } //call()
}