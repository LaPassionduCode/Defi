/*******************************************************
 Nom ......... : decrypter.java
 Role ........ : classe permettant le décryptage du texte
 souhaité en fonction du numéro de décryptage
 Auteur ...... : Patrick Schwegler
 Version ..... : V1.1 du 19.03.2018
 Licence ..... : GPL
 ********************************************************/

public class decrypter {
    public static void decryptage(String text, int nbreCrypto) {
        char[] textArr = text.toCharArray(); //Permet de passer de String à un array de char

        System.out.println("\n***************************************");
        System.out.print("Le décryptage a fonctioné, voici le résultat : \n");

        //boucle permettant de passer par chaque valeur de l'array à traiter
        for (int i = 0; i < textArr.length; i++) {
            int textCharInt = textArr[i];
            if (textCharInt >= 65 && textCharInt <= 90) {
                textCharInt = textCharInt - nbreCrypto;
                if (textCharInt < 65) {
                    textCharInt = 91 - (65 - textCharInt);
                }
                textArr[i] = (char) textCharInt;
            }

            if (textCharInt >= 97 && textCharInt <= 122) {
                textCharInt = textCharInt - nbreCrypto;
                if (textCharInt < 97) {
                    textCharInt = 123 - (97 - textCharInt);
                }
                textArr[i] = (char) textCharInt;
            }
            System.out.print(textArr[i]);
        }
        System.out.println("\n***************************************\n");
    }
}
