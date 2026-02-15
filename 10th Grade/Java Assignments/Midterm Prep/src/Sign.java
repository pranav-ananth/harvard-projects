import java.lang.Math;

public class Sign {
    private String string;
    private int width;

    public Sign(String string, int width) {
        this.string = string;
        this.width = width;
    }

    public int numberOfLines() {
        return (int) Math.round( (1.0*string.length()) / width);
    }

    public String getLines() {
        if(string.length() < width) {
            return string;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);

        for(int i = numberOfLines() - 1; i >= 1; i--) {
            stringBuilder.insert(width * i, ';');
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str;
        int x;

        Sign sign1 = new Sign("ABC222DE", 3);
        x = sign1.numberOfLines();
        System.out.println(x);
        str = sign1.getLines();
        str = sign1.getLines();
        System.out.println(str);

        Sign sign2 = new Sign("ABCD", 10);
        x = sign2.numberOfLines();
        System.out.println(x);
        str = sign2.getLines();
        System.out.println(str);
    }
}
