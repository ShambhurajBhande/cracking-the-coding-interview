package ctci.arraystrings;

/*
@author Shambhuraj Bhande
* String Rotation:Assumeyou have a method isSubstringwhich checks if oneword is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
* */
public class StringRotation {

    public static void main(String[] args) {
        String origional = "stringRotation";
        String rotated = "ingRotationstr";

        boolean isRotation = isSubstring(origional, rotated + rotated);
        System.out.println(isRotation);
    }

    private static boolean isSubstring(String origional, String rotated) {
        return rotated.contains(origional);
    }
}
