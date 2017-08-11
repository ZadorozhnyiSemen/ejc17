package task_06_csvparser.model;

import org.jetbrains.annotations.NotNull;

/**
 * Simple class that represents data about user activity
 * on web, activity forms from id, url that were visited,
 * time spent, and user name.
 * Comparable by user name
 */
public class UserDataUnit implements Comparable {
    private long id;
    private String url;
    private long timeSpend;
    private String name;

    public UserDataUnit(long id, String url, long timeSpend, String name) {
        this.id = id;
        this.url = url;
        this.timeSpend = timeSpend;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDataUnit{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", timeSpend=" + timeSpend +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTimeSpend() {
        return timeSpend;
    }

    public void setTimeSpend(long timeSpend) {
        this.timeSpend = timeSpend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        UserDataUnit dataUnit = (UserDataUnit) o;
        return this.getName().compareTo(dataUnit.getName());
    }
}
