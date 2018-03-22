/*******************************************************
 Nom ......... : crypto.java
 Role ........ : Petit programme qui sert à crypter et
 décrypter du texte en fonction d'une clef donnée (chiffre)
 par ex : la lettre "a" avec comme clef "1" donnerais "b"
 Auteur ...... : Patrick Schwegler
 Version ..... : V1.1 du 19.03.2018
 Licence ..... : GPL

 Modif depuis dernière version :    - Rajout du error handling pour la première rentrer de l'utilisateur pour être sûr
                                      qu'il rentre un integer.
                                    - Rajout/compléter les commentaires
 ********************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class crypto {
    public static void main (String[] args){
        int boucle = 1;
        //initiation de la variable pour la boucle principal, puis boucle principal pour garder le programme
        //lancer tant que le 0 n'est pas entrer
        while (boucle != 0){
            Scanner boucleScan = new Scanner(System.in);
            System.out.println("\n***************************************");
            System.out.print("Pour le cryptage tapez 1. \nPour le décryptage tapez 2. " +
                    "\nPour quitter tapez 0. \nQue voulez vous faire : ");
            //permet d'intercepter une erreur plus particulèrement si l'utlisateur rentre des lettres. Affiche un petit
            //message et attribue à la variable boucle une valeur qui permet de rester dans la boucle while.
            try{
                boucle = boucleScan.nextInt();
            }catch(InputMismatchException e){
                System.out.print("!! Je veux une valeur entre 0 et 3 !!");
                boucle = 3;
            }
            System.out.println("\n***************************************\n");

            //condition qui permet de savoir d'executer le cryptage ou décryptage celon le souhait de l'utilisateur
            if (boucle == 1){
                Scanner entreCrypt = new Scanner(System.in);
                System.out.print("Ecrivez ce que vous voulez crypter : ");
                String text = entreCrypt.nextLine();
                System.out.print("Quel chiffrement de César voulez-vous ? : ");
                //On écoute la valeur pour la clef que l'utilisateur veux et on fait le modulo de celui-ci pour être
                //sûr d'avoir un chiffre entre 0 et 25
                int nbreCrypto = entreCrypt.nextInt() % 26;
                //appelle la classe et la fonction pour crypter en lui donnant les donner à convertir
                crypter.cryptage(text, nbreCrypto);

            }else if (boucle == 2){
                Scanner entreDecript = new Scanner(System.in);
                System.out.print("Ecrivez ce que vous voulez decrypter : ");
                String text = entreDecript.nextLine();
                System.out.print("Quel est le chiffrement de César ? : ");
                int nbreCrypto = entreDecript.nextInt() % 26;
                //appelle la classe et la fonction pour décrypter en lui donnant les donner à convertir
                decrypter.decryptage(text, nbreCrypto);
            }
        }
    }
}
