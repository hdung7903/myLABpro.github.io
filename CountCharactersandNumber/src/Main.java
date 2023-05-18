import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String str=generateRandomString(40);
        System.out.println("Random String: " + str);
        List<String> letterGroups = getCharacterGroups(str, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        List<String> evenNumGroups = getCharacterGroups(str, "02468");
        List<String> oddNumGroups = getCharacterGroups(str, "13579");
        List<String> specialCharGroups = getCharacterGroups(str, "!@#$%^&*()");

        System.out.println("Letter Groups: " + letterGroups.toString());
        System.out.println("Even Number Groups: " + evenNumGroups.toString());
        System.out.println("Odd Number Groups: " + oddNumGroups.toString());
        System.out.println("Special Character Groups: " + specialCharGroups.toString());
    }

    public static List<String> getCharacterGroups(String str, String characters) {
        List<String> groups = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (characters.contains(String.valueOf(c))) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    groups.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if (sb.length() > 0) {
            groups.add(sb.toString());
        }

        return groups;
    }
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
