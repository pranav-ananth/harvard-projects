
/**
 * Write a description of class Love here.
 *
 * @author Pranav Ananth
 * @version 9/11/2021
 */
public class Love {

    /**
     * Takes a String and replaces the first occurrence of "hate" with "love".
     * If the word "hate" does not appear in the String, this method returns
     * the original String.
     * If the word "hate" occurs more than once in the String,
     * this method replaces only the first occurrence of "hate".
     *
     * Note: you can only use the indexOf and substring methods. You will not get
     * credit if you use any of the other String methods such as replace()
     */
    public String loveNotHate(String str) {
        String lowerStr = str.toLowerCase();
        int index = -1;
        for(int i = 0; i < lowerStr.length() - 4; i++) { // if string is the first letter
            if (lowerStr.substring(i, i + 4).equals("hate")) { // now check character before and after

                if (i == 0) { //case it's at the start of the string

                    if (('a' <= lowerStr.charAt(i+3)) && (lowerStr.charAt(i+3) <= 'z')) { // check that the character after the string isn't a lowercase letter
                        continue; // skip to the next iteration
                    }
                    else {
                        index = i;
                        break;
                    }
                }

                else if (i == (lowerStr.length() - 4)) { // don't check character after end of substring

                    if (('a' <= lowerStr.charAt(i-1)) && (lowerStr.charAt(i-1) <= 'z')) { // check that the character before the string isn't a lowercase letter
                        continue; //skip to the next iteration
                    }
                    else {
                        index = i;
                        break;
                    }
                }

                else { // if string is in the middle
                    if ((('a' <= lowerStr.charAt(i - 1)) && (lowerStr.charAt(i - 1)<= 'z')) && (('a' <= lowerStr.charAt(i + 3)) && (lowerStr.charAt(i + 3) <= 'z'))) {
                        continue;
                    }
                    else {
                        index = i;
                        break;
                    }
                }
            }
        }

        System.out.println(index);
        if(index == -1) {
            return str;
        }
        else {
            return str.substring(0, index) + "love" + str.substring(index + 4);
        }

    }
}