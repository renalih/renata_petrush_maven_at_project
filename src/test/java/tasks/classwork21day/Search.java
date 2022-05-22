package tasks.classwork21day;

import java.util.Objects;

public class Search {

    public String user;
    boolean strict;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Search(String user, boolean strict) {
        this.user = user;
        this.strict = strict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return strict == search.strict && user.equals(search.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, strict);
    }

    @Override
    public String toString() {
        return "Search{" +
                "user='" + user + '\'' +
                ", strict=" + strict +
                '}';
    }


}
