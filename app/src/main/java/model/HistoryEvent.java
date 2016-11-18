package model;

import java.util.List;

/**
 * Created by xw on 2016/11/18.
 */
public class HistoryEvent  {
    private int error_code;
    private String reason;
    private List<EventItem> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<EventItem> getResult() {
        return result;
    }

    public void setResult(List<EventItem> result) {
        this.result = result;
    }

    public static class EventItem{
        String year;
        String month;
        String day;
        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }
}
