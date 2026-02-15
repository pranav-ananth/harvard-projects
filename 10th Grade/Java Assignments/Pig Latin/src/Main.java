class PigLatin{
    public static void main(String[] args){
        String first = "joe";
        String last = "polacco";
        String pigLatinFirst = toPigLatin(first);
        String pigLatinLast = toPigLatin(last);
        System.out.println(pigLatinFirst + " " + pigLatinLast);

    }
    public static String toPigLatin(String word){
        char FirstLetter = word.charAt(0);
        char secondLetter = word.toUpperCase().charAt(1);
        String newName = secondLetter + word.substring(2) + FirstLetter + "ay";
        return newName;
    }
}
