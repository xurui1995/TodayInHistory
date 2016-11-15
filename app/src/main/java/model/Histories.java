package model;

import java.util.List;

/**
 * Created by xw on 2016/11/15.
 */
public class Histories {
    private int error_code;

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

    public List<HistoryBean> getResult() {
        return result;
    }

    public void setResult(List<HistoryBean> result) {
        this.result = result;
    }

    private String reason;
    private List<HistoryBean> result;
   public static class HistoryBean{
        private int id;
        private String day;
        private String month;
        private String title;
        private String year;
        private String pic;



        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }
}
