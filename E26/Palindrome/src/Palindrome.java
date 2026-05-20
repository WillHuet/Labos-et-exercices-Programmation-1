public class Palindrome {
    static void main() {
        boolean validation = true;
        String[] tab = {"kayak", "Pip", "laval", "lol"};
        for (String str : tab) {
            int longueur = str.length();
            for (int i = 0; i < longueur / 2; i++) {
                if (str.toLowerCase().charAt(i) != str.charAt((longueur - 1) - i)) {
                    validation = false;
                }
            }
        }
        if (validation) {
            System.out.println("Tous les éléments du tableaux sont des palindromes");
        } else {
            System.out.println("Certains éléments ne sont pas des palindromes");
        }
    }
}
