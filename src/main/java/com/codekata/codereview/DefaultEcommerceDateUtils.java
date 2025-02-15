package com.codekata.codereview;


import org.apache.commons.lang3.StringUtils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DefaultEcommerceDateUtils {

    public static final String WEB_SERVICE_DATE_FORMAT = "dd-MM-yyyy";
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final String DATE_PATTERN_CONSIGNMENT = "yyyy-MM-dd";

    public Optional<Date> convert(final String dateString) {
        return convert(dateString, DATE_PATTERN);
    }

    public Optional<Date> convert(final String dateString, final String datePattern) {

        Optional<Date> optionalDate = Optional.empty();

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        try {
            if (StringUtils.isNotEmpty(dateString)) {
                optionalDate = Optional.of(simpleDateFormat.parse(dateString
                        .replace(".", "/")
                        .replace("-", "/")
                        .replace(":", "/")));
            }
        } catch (ParseException e) {
            //nothing
        }
        return optionalDate;
    }

    public Optional<Date> convertWithPattern(final String candidate, final String datePattern) {
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
            if (StringUtils.isNotEmpty(candidate)) {
                return Optional.of(simpleDateFormat.parse(candidate));
            }
        } catch (ParseException e) {
        }
        return Optional.empty();
    }


    public Optional<String> convertWithPatternAndFormat(final String candidate, final String datePattern, final String format) {
        final DateFormat df = new SimpleDateFormat(datePattern, Locale.ENGLISH);
        final SimpleDateFormat myFormat = new SimpleDateFormat(format);

        try {
            return Optional.of(myFormat.format(df.parse(candidate)));
        } catch (ParseException e) {
        }
        return Optional.empty();
    }

    public Optional<Date> convertWithPatternAndTimezone(final String candidate, final String datePattern, final String timeZone) {
        try {
            final DateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
            if (StringUtils.isNotBlank(timeZone)) {
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
            }
            if (StringUtils.isNotEmpty(candidate)) {
                return Optional.of(simpleDateFormat.parse(candidate));
            }
        } catch (ParseException e) {
        }
        return Optional.empty();
    }

    public String convert(final Date date) {
        return convert(date, DATE_PATTERN);
    }


    public String convert(final Date date, final String datePattern) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        return simpleDateFormat.format(date);
    }

    public String convertWithPatternAndTimezone(final Date candidate, final String datePattern, final String timeZone) {
        final DateFormat dateFormat = new SimpleDateFormat(datePattern);
        if (StringUtils.isNotBlank(timeZone)) {
            dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        }
        return dateFormat.format(candidate);
    }

    public String tomorrow(final String datePattern) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = cal.getTime();
        return convert(tomorrow, datePattern);
    }

    public String addDayWithPattern(final String datePattern, final int day) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, day);
        final Date added = cal.getTime();
        return convert(added, datePattern);
    }

    public Date convertForConsignment(final String dateString) {
        Date date = null;

        final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_CONSIGNMENT);
        if (StringUtils.isNotEmpty(dateString)) {
            try {
                date = dateFormat.parse(dateString);
            } catch (final ParseException e) {
            }
        }
        return date;
    }


    public Date addDayToDate(final Date date, final int day) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    public Date addMinutesToDate(final Date date, final int minute) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }

    public Date substractMonthsToDate(final Date date, final int months) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -months);
        return c.getTime();
    }

    public boolean isSameDay(final Date date1, final Date date2) {
        final SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }

    public Date addWorkingDaysByHours(final Date date, final int hours) {
        if (hours > 0) {
            int days = hours / 24;
            int estimatedHours = hours % 24;

            LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            LocalDateTime localDateOrderCancelledDate = localDateTime.with(addWorkingDays(days));

            if (estimatedHours > 0) {
                localDateOrderCancelledDate = localDateOrderCancelledDate.plusHours(estimatedHours);
            }

            return Date.from(localDateOrderCancelledDate.atZone(ZoneId.systemDefault()).toInstant());
        }
        return date;
    }


    private TemporalAdjuster addWorkingDays(final long workingDays) {
        return TemporalAdjusters.ofDateAdjuster(d -> addWorkingDays(d, workingDays));
    }

    private LocalDate addWorkingDays(final LocalDate startingDate, final long workingDays) {
        if (workingDays == 0) {
            return nextOrSameWorkingDay(startingDate);
        }

        LocalDate result = startingDate;
        int step = Long.signum(workingDays); //are we going forward or backward?

        for (long i = 0; i < Math.abs(workingDays); i++) {
            result = nextWorkingDay(result, step);
        }

        return result;
    }

    private LocalDate nextOrSameWorkingDay(final LocalDate date) {
        return isWeekEnd(date) ? nextWorkingDay(date, 1) : date;
    }

    private LocalDate nextWorkingDay(LocalDate date, final int step) {
        do {
            date = date.plusDays(step);
        }
        while (isWeekEnd(date));
        return date;
    }

    private boolean isWeekEnd(final LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        return dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY;
    }

    public String formatForWebService(final Date candidate) {
        return convert(candidate, WEB_SERVICE_DATE_FORMAT);
    }


}
