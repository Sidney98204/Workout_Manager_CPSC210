package logbook;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Date date = (Date) o;

        if (this.getDay() != date.getDay()) {
            return false;
        }

        if (this.getMonth() != date.getMonth()) {
            return false;
        }

        if (this.getYear() != date.getYear()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return day + month + year;
    }
}
