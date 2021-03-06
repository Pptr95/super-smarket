package model;

import java.io.Serializable;
import java.time.LocalDate;

/** 
 * Basic implementation of MyCustomDate, using java.time.LocalDate class.
 */
public class MyCustomDateImpl implements MyCustomDate, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3098079862058120408L;
    private static final int DAYS_IN_A_YEAR = 365;
    private LocalDate date;

    /**
     * Basic constructor.
     * @param year 0 - 9999
     * @param month 1 - 12
     * @param day 1 - 31
     */
    public MyCustomDateImpl(final int year, final int month, final int day) {
        this.date = LocalDate.of(year, month, day);
    }

    private MyCustomDateImpl(final LocalDate now) {
        this(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
    }

    /**
     * Creates the customDate after n days after the starting date.
     * @param now the starting date
     * @param daysToAdd how many days after the date
     */
    public MyCustomDateImpl(final LocalDate now, final long daysToAdd) {
        this(now.plusDays(daysToAdd));
    }

    @Override
    public int getDifferenceInDays(final MyCustomDate other) {
        // getYear / 4 adds one day every 4 years, taking care of leap years
        final int daysOfThis = this.getYear() * DAYS_IN_A_YEAR + this.getYear() / 4 + this.getDayOfYear();
        final int daysOfOther = other.getYear() * DAYS_IN_A_YEAR + other.getYear() / 4 + other.getDayOfYear();
        return daysOfThis - daysOfOther;
    }


    @Override
    public int getYear() {
        return this.date.getYear();
    }

    @Override
    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    @Override
    public String toString() {
        return "year: " + date.getYear() + "dayOfYear: " + date.getDayOfYear();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!MyCustomDateImpl.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final MyCustomDateImpl o = (MyCustomDateImpl) obj;
        return (this.getDifferenceInDays(o) == 0);
    }

    /**
     * Return the current date.
     * @return A MyCustomDate object representing today's date
     */
    public static MyCustomDate today() {
        return new MyCustomDateImpl(LocalDate.now());
    }

    @Override
    public String getDateToString() {
        return this.date.toString();
    }

}
