

public class ReverseWord {
	public static void main(String[] args) {
        String str = "Test Automation";
        String[] words = str.split(" ");

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }

        System.out.println(result.toString().trim());
    }

}
