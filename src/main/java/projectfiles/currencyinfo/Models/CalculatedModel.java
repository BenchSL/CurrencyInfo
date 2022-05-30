package projectfiles.currencyinfo.Models;

public class CalculatedModel
{
    String tag;
    String date;
    Double value;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CalculatedModel{" +
                "tag='" + tag + '\'' +
                ", date='" + date + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
