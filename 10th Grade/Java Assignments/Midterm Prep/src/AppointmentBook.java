/*
public class AppointmentBook {
    public int findFreeBlock(int period, int duration) {
        for(int i = 0; i < 60 - duration; i++) {
            if(isMinuteFree(period, i) == true) {
                boolean foundTime = true;
                for(int j = i + 1; j < i + duration; j++) {
                    if(!isMinuteFree(period,j)) {
                        foundTime = false;
                        break;
                    }
                }

                if(foundTime == true) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        for(int i = startPeriod; i <= endPeriod; i++) {
            int startMinute = findFreeBlock(i, duration);
            if(startMinute != -1) {
                reserveBlock(i, startMinute, duration);
                return true;
            }
        }

        return false;
    }
}
*/