package ctci.arraystrings;

/*
* @author Shambhuraj Bhande
*
* One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
*
* */
public class OneEditAway {
    public static void main(String[] args) {
        String inputString = "pale";
        String checkString = "ple";
        System.out.println((inputString.length() - checkString.length()) > 1 ? false : isEditAway(inputString, checkString));

    }

    private static boolean isEditAway(String inputString, String checkString) {
        if (inputString.length() == checkString.length()) {
            return isOneReplaceAway(inputString, checkString);
        } else if (inputString.length() + 1 == checkString.length()) {
            return isOneEditAway(inputString, checkString);
        } else if (inputString.length() - 1 == checkString.length()) {
            return isOneEditAway(checkString, inputString);
        }
        return false;
    }

    private static boolean isOneEditAway(String inputString, String checkString) {
        int addCount = 0;
        int removeCount = 0;
        while (removeCount < checkString.length() && addCount < inputString.length()) {
            if (inputString.charAt(addCount) != checkString.charAt(removeCount)) {
                if (addCount != removeCount) {
                    return false;
                }
                removeCount++;
            } else {
                addCount++;
                removeCount++;
            }
        }
        return true;
    }

    private static boolean isOneReplaceAway(String inputString, String checkString) {
        boolean isMoreReplace = false;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) != checkString.charAt(i)) {
                if (isMoreReplace)
                    return false;
                isMoreReplace = true;
            }
        }
        return isMoreReplace;
    }
}
