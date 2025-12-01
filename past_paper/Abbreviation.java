/*
Write a Java program to read a file line-by-line:
1. For the first line of the file (e.g., "University of X.Y.Z."), print its abbreviation
("U.O.X.Y.Z.").
2. For the second line (e.g., "in my humble opinion"), print its abbreviation ("I.M.H.O.")
followed by a TAB character.
*/

public class Abbreviation {
    public static void main(String[] args) {
        System.out.println(makeAbbr("in my humble opinion"));
    }

    public static String makeAbbr(String line) {
        String[] sArr = line.split(" ");
        String result = "";

        for (String string : sArr) {
            if (string.charAt(1) == '.') {
                result += string.substring(0, 2);
                if (string.length() >= 4) {
                    if (string.charAt(3) == '.') {
                        result += string.substring(2, 4);
                        
                    }
                }
                if (string.length() >= 6) {
                    if (string.charAt(5) == '.') {
                        result += string.substring(4, 6);

                    }
                }
            } else {
                result += string.substring(0, 1).toUpperCase() + ".";
            }
        }

        return result;

    }
}
