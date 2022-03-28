package me.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static int i = 0;

    static String value = "";

    static ReentrantLock lock = new ReentrantLock();

    static List<Integer> numbers = new ArrayList<>();


    public static void main(String[] args) {



        // dela jobb mellan trådarna
        // man uppnår detta med Queues
        // en lista med saker som trådarna ska göra.. sedan plockar bara trådarna från listan..

        // skriv nummer i consolen sedan tar en tråd som hinner först att gör det den ska..
        // tex första tråden tar nummret och låser "låset".. andra tråden ser då låset är sträng och kör ej sin kod
        // den snabbaste tråden tar kommando..varierar vem som är snabbast..
        // förståelse problemet var att den kollar om den är låst vid lock.lock(); om den är redan låst så körs det inte.. annars låser den och kör..

        /*
        new Thread(() ->{
            while(true){
                lock.lock();
                    if(!numbers.isEmpty()){
                        int i = numbers.get(0);
                        System.out.println("Thread - " + Thread.currentThread().getId() + ": " + (5 + i));
                        numbers.remove(0);
                    }
                lock.unlock();
            }
        }).start();

        new Thread(() ->{
            while(true){
                lock.lock();
                if(!numbers.isEmpty()){
                    int i = numbers.get(0);
                    System.out.println("Thread - " + Thread.currentThread().getId() + ": " + (5 + i));
                    numbers.remove(0);
                }
                lock.unlock();
            }
        }).start();

       Scanner scanner = new Scanner(System.in);

       //java egna huvud tråden
       while(true){
           int number = scanner.nextInt();
          lock.lock();
           numbers.add(number);
           lock.unlock();
       }

         */


        //thread safety
        //ReentrantLock..
        //viktigt att ha ett lås per objekt man vill använda..
        //låset appliceras på "låset" i sig inte på ett objekt tydligen..som objektet value i syncronized exemplet nedan..
        //kolla i ec föreläsninge rooten för skillnaden med reentrantlock och syncronized..men sök på google lite mer..
        // ett exempel han gjorde var om man hade en flera djur klasser..så hade man haft ett lock per djur.. Vet inte
        //hur det hade blivit med syncronized då..
        // " man hade haft ett lås per djur - alla får sitt eget - eftersom det appliceras på själva låset och inte på objektet.. "
        // ovan är exemplet på seg i förståelse lite i gamla hhemi läget.. för det läser inte vad som står ordagrant utan håller på
        // visualiserar med felaktiga antaganden.. läser man vad som står och accepterar det förstår man mycket snabbare.. SEDAN
        // kan man börja visualisera på ideer som detta kan användas på olika sätt..

        /*
        new Thread(() -> {
            lock.lock();
                if (value != null) {
                    System.out.println(value);
                }
                lock.unlock();

        }).start();

        new Thread(() -> {
            lock.lock();
                if (value != null) {
                    System.out.println(value);
                }
                lock.unlock();

        }).start();

         */

        //thread safety
        //syncronized -> låser objektet..andra tråden väntar till andra tråden är klar med objektet.
        //syncronized appliceras på ett objekt.. tex value
        /*
        new Thread(() -> {

            synchronized (value) {
                if (value != null) {
                    System.out.println(value);
                }
            }

        }).start();

        new Thread(() -> {

            synchronized (value) {
                if (value != null) {
                    System.out.println(value);
                }
            }

        }).start();

         */



        // andra exemplet.. race condition mellan trådar..värden kommer läsas in 0 på båda trådar och
        // resultaten blir 1 efter första runnet..istället för 2..
        /*
        new Thread(() -> {
            while (true)
            System.out.println(i++);
        }).start();

        new Thread(() -> {
            while (true)
            System.out.println(i++);

        }).start();

         */

        // tredje exemplet.. säg första tråden skriver ut om värdet inte är null.. men anta andra tråden gör värdet till null samtidigt
        // då kommer första tråden skriva null.. blir inge bra då..
        // STATELESSNESS.. det är därför statelessness är bra.. man delar inte på data..hantera minnet på ett bra sätt
        // Kallas för thread safety..
        /*
        new Thread(() -> {

            if(value != null){
                System.out.println(value);
            }

        }).start();

        new Thread(() -> {
            if(value != null){
                System.out.println(value);
            }


        }).start();

         */




        /* först exemplet trådarna körs lite random --
        TestRun runX = new TestRun("greken");
        Thread thread = new Thread(runX);

        thread.start();

        String name = "osten";

        Thread thread2 = new Thread(() -> {
           System.out.println("TRÅD 2");
            System.out.println("TRÅD 2 " + name);
        });
        // skapar lamba för runnable är funktionel interface..då går det göra lambda av det..

        thread2.start();


         */

    }


}
