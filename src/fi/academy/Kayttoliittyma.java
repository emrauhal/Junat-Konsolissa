package fi.academy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private JunanTietojenHakija junanHakija;
    private Hakija hakija;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.junanHakija = new JunanTietojenHakija();
        this.hakija = new Hakija();
    }

    public void kayta(){

        printtaaLogo();
        printtaaJunanKuva();

        printtaaKomennot();

        boolean quit = false;
        while (!quit){
            System.out.print("\nSyötä komento --> ");

            String syote = lukija.nextLine();

            int komento;

            if (syote.equals("0") || syote.equals("1") || syote.equals("2") || syote.equals("3") || syote.equals("4") || syote.equals("5")) {
                komento = Integer.parseInt(syote);
            } else if (syote.isEmpty()){
                continue;
            } else {
                System.out.println("Tuntematon komento!");
                continue;
            }

            switch (komento){
                case 0:
                    System.out.println("\nTervetuloa käyttämään sovellusta uudelleen!");
                    quit = true;
                    break;

                case 1:
                    this.hakija.kysyMistaMinne();
                    break;

                case 2:
                    this.hakija.kysyLahtoasemaa();
                    break;

                case 3:
                    this.hakija.kysySaapumisasemalta();
                    break;

                case 4:
                    this.junanHakija.kysyJunannumero();
                    break;

                case 5:
                    printtaaKomennot();
                    break;

            }
        }
    }

    private void printtaaKomennot(){
        System.out.println("\nValitse komento syöttämällä numero: ");
        System.out.println("\t0 = Sulje ohjelma");
        System.out.println("\t1 = Hae reitti");
        System.out.println("\t2 = Hae asemalta lähtevät junat");
        System.out.println("\t3 = Hae asemalle saapuvat junat");
        System.out.println("\t4 = Hae tietyn junan sijainti ");
        System.out.println("\t5 = Tulosta valikko");
    }

    private void printtaaLogo(){
        try {
            Files.lines(Paths.get("logo.txt")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Virhe logon lukemisessa");
        }
    }

    private void printtaaJunanKuva(){
        try {
            Files.lines(Paths.get("junanKuva.txt")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Virhe kuvan lukemisessa");
        }

        System.out.print("\n\n\n\t\t\t\t\t\t\t\tPAINA ENTER: ");
        this.lukija.nextLine();


    }

}
