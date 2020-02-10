package ctci.arraystrings;

/*
* @author Shambhuraj Bhande
*
* String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*
* */
public class StringCompression {
    public static void main(String[] args) {
        String compressionResult = getCompressString("aabccddvvvvS");
        System.out.println(compressionResult);
    }

    private static String getCompressString(String origional) {
        StringBuilder stringBuilder = new StringBuilder();
        int characterCount = 0;
        for (int i = 0; i < origional.length(); i++) {
            if (i + 1 >= origional.length() || origional.charAt(i) != origional.charAt(i + 1)) {
                stringBuilder.append(origional.charAt(i));
                stringBuilder.append(characterCount);
                characterCount = 0;
            }
            {
                characterCount++;
            }
        }
        System.out.println("Compressed String :" + stringBuilder.toString());
        return origional.length() > stringBuilder.length() ? origional : stringBuilder.toString();
    }
}
