import java.util.Scanner;

class MonthException extends Exception {
    public MonthException(String message) {
        super(message);
    }
}

class DayException extends Exception {
    public DayException(String message) {
        super(message);
    }
}

class YearException extends Exception {
    public YearException(String message) {
        super(message);
    }
}

public class DateConverter {
    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = 0, day = 0, year = 0;

        while (true) {
            try {
                System.out.print("Enter month (1-12): ");
                month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    throw new MonthException("Invalid month. Please enter a number between 1 and 12.");
                }
                break;
            } catch (MonthException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.print("Enter year (1000-3000): ");
                year = scanner.nextInt();
                if (year < 1000 || year > 3000) {
                    throw new YearException("Invalid year. Please enter a number between 1000 and 3000.");
                }
                break;
            } catch (YearException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.print("Enter day: ");
                day = scanner.nextInt();
                if (day < 1 || day > daysInMonth(month, year)) {
                    throw new DayException("Invalid day. Please enter a valid day for the given month and year.");
                }
                break;
            } catch (DayException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        System.out.println("Converted date: " + MONTHS[month - 1] + " " + day + ", " + year);
        scanner.close();
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        if(year % 4 == 0)
            return true;
        return false;
    }
}
