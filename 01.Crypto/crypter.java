/*******************************************************
 Nom ......... : crypter.java
 Role ........ : classe permettant le cryptage du texte
 souhaité en fonction du numéro de cryptage
 Auteur ...... : Patrick Schwegler
 Version ..... : V1.1 du 19.03.2018
 Licence ..... : GPL
 ********************************************************/

public class crypter {
    public static void cryptage(String text, int nbreCrypto){
        char[] textArr = text.toCharArray(); //Permet de passer de String à un array de char

        System.out.println("\n***************************************");
        System.out.print("Le cryptage à fonctioné, voici le résultat. \n");

        //boucle permettant de passer par chaque valeur de l'array à traiter
        for (int i = 0; i < textArr.length; i++){
            int textCharInt = textArr[i]; //on convertie le charcactère en son nombre

            //Deux conditions qui permmette que si la valeur dépasse la correspondance d'une lettre de l'alphabet
            //il recommence au début de l'alphabet et fini de compter.
            if (textCharInt >= 65 && textCharInt <= 90 ){ //condition pour les majuscule
                textCharInt = textCharInt + nbreCrypto;
                if (textCharInt > 90){
                    textCharInt = 65 + (textCharInt - 91);
                }
                textArr[i] = (char) textCharInt; //reconvertie le nombre en sa correspondance de la lettre de l'alphabet
            }

            if (textCharInt >= 97 && textCharInt <= 122 ){ //condition pour les minuscule
                textCharInt = textCharInt + nbreCrypto;
                if (textCharInt > 122){
                    textCharInt = 97 + (textCharInt - 123);
                }
                textArr[i] = (char) textCharInt;
            }
            System.out.print(textArr[i]);
        }
        System.out.println("\n***************************************\n");
    }
}
