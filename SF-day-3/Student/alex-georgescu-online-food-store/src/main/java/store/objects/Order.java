package store.objects;

import java.time.LocalDate;

public class Order {

    private int mId;
    private String mName;
    private LocalDate mDate;
    private String mDescription;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public LocalDate getmDate() {
        return mDate;
    }

    public void setmDate(LocalDate mDate) {
        this.mDate = mDate;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + mId +
                ", Name='" + mName + '\'' +
                ", Date=" + mDate +
                ", Description='" + mDescription + '\'' +
                '}';
    }
}
