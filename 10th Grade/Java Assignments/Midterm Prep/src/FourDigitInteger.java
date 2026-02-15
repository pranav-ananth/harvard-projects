public class FourDigitInteger {

    public int value;

    public FourDigitInteger(int value) {
        this.value = value;
    }

    public boolean isOdd() {
        if((value % 2) == 1)
            return true;
        else
            return false;
    }

    public boolean isPalindrome() {
        int digit1 = value / 1000;
        int digit2 = (value / 100) % 10;
        int digit3 = (value / 10) % 10;
        int digit4 = value % 10;

        if(digit1 == digit4 && digit2 == digit3) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isPerfectSquare() {
        for(int n = 31; n <= 100; n++) {
            if(n * n == value) {
                return true;
            }
        }

        return false;
    }


}
