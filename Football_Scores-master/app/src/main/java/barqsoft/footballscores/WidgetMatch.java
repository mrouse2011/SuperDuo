package barqsoft.footballscores;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by marlonrouse on 12/11/2015.
 */
public class WidgetMatch implements Parcelable {
    private String homeName;
    private String awayName;
    private String homeGoals;
    private String awayGoals;
    private String time;

    public WidgetMatch(String homeName, String awayName, String homeGoals, String awayGoals, String time) {
        this.homeName = homeName;
        this.awayName = awayName;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.time = time;
    }

    protected WidgetMatch(Parcel in) {
        homeName = in.readString();
        awayName = in.readString();
        homeGoals = in.readString();
        awayGoals = in.readString();
        time = in.readString();
    }

    public static final Creator<WidgetMatch> CREATOR = new Creator<WidgetMatch>() {
        @Override
        public WidgetMatch createFromParcel(Parcel in) {
            return new WidgetMatch(in);
        }

        @Override
        public WidgetMatch[] newArray(int size) {
            return new WidgetMatch[size];
        }
    };

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(homeName);
        dest.writeString(awayName);
        dest.writeString(homeGoals);
        dest.writeString(awayGoals);
        dest.writeString(time);
    }
}
