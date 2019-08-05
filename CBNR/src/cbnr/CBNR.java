/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbnr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Carlos Serrano A
 */
public class CBNR {

    static BigInteger factorial(BigInteger num) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= num.intValue(); i++) fact = fact.multiply(BigInteger.valueOf(i));
        return fact;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("digite n: ");
        BigInteger n = scan.nextBigInteger();
        System.out.println("digite k: ");
        //BigInteger k = scan.nextBigInteger();
        BigInteger k = BigInteger.valueOf(30);
        long [] tiempos = new long[30];
        File archivo = new File("tiempos.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

        for (int i = 0; i < 30; i++) {
            long initime = System.nanoTime();
            BigInteger ans = factorial(n).divide(factorial(k).multiply(factorial(n.subtract(k))));
            long fintime = System.nanoTime() - initime;
            System.out.println("La respuesta es: " + ans);
            tiempos[i] = fintime;
            writer.write(fintime + ", ");
            k = k.subtract(BigInteger.ONE);
        }
        writer.close();
        System.out.println("tiempos: ");
        System.out.println(Arrays.toString(tiempos));
    }

}
