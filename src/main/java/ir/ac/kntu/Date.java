package ir.ac.kntu;

/**
 * Date class
 */
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public Date(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }

    /**
     * @param year  a positive value defining the year
     * @param month a positive value defining the month
     * @param day   a positive value defining the month
     */
    private void checkAndSetDate(int year, int month, int day) {
        if (checkInputs(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
        }
    }

    /**
     * @param year  a positive value defining the year
     * @param month a positive value defining the month
     * @param day   a positive value defining the month
     * @return a boolean defining the validity of the year , month and day input
     */
    private boolean checkInputs(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || month > 6
                && day == 31) {
            return false;
        }
        return month != 12 || day != 30 || isLeapYear(year);
    }

    public void setDate(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        checkAndSetDate(year, this.month, this.day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        checkAndSetDate(this.year, month, this.day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        checkAndSetDate(this.year, this.month, day);
    }

    /**
     * @return the fields of the object as a string
     */
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    /**
     * @return the next day as an object
     */
    public Date nextDay() {
        Date curDate = new Date(this);
        Date nextDate = new Date(this);
        if (curDate.month == 12) {
            handleTheLastMonth(curDate, nextDate);
        } else if (curDate.day < 30) {
            nextDate.day++;
        } else if (curDate.day == 30 && curDate.month < 7) {
            nextDate.day++;
        } else {
            nextDate.day = 1;
            nextDate.month++;
        }
        return nextDate;
    }

    /**
     * @param curDate  an object of the current date
     * @param nextDate an object of the next date
     */
    private void handleTheLastMonth(Date curDate, Date nextDate) {
        int endOfMonthDay = 29;
        if (isLeapYear(curDate.year)) {
            endOfMonthDay = 30;
        }
        if (curDate.day == endOfMonthDay) {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        } else {
            nextDate.day++;
        }
    }

    /**
     * @param year a positive value defining the year
     * @return a boolean defining whether a year is a leap year or not
     */
    private boolean isLeapYear(int year) {
        int firstFraction, secondFraction;
        final double a = 0.025d;
        final double b = 266d;
        double c, d;
        if (year > 0) {
            c = ((year + 38) % 2820) * 0.24219 + a;
            d = ((year + 39) % 2820) * 0.24219 + a;
        } else if (year < 0) {
            c = ((year + 39) % 2820) * 0.24219 + a;
            d = ((year + 40) % 2820) * 0.24219 + a;
        } else {
            return false;
        }
        firstFraction = (int) ((c - Math.floor(c)) * 1000);
        secondFraction = (int) ((d - Math.floor(d)) * 1000);
        return firstFraction <= b && secondFraction > b;
    }

    static int compareDate( Date date1 , Date date2){
        if ( date1.year > date2.year){
            return 1 ;
        }else if ( date1.year < date2.year ){
            return -1;
        }else if ( date1.month > date2.month){
            return 1 ;
        }else if ( date1.month <date2.month ){
            return -1 ;
        }else if ( date1.day > date2.day){
            return 1 ;
        }else if ( date1.day < date2.day ){
            return -1 ;
        }else{
            return 0 ;
        }
    }
}


