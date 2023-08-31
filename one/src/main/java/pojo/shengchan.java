package pojo;

public class shengchan {
    private int id;
    private String time;
    private int idHetong;
    private int idPeople;
    private int idGroup;
    private int everyday;
    private String timeStart;
    private String timeEnd;
    private int people;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIdHetong() {
        return idHetong;
    }

    public void setIdHetong(int idHetong) {
        this.idHetong = idHetong;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getEveryday() {
        return everyday;
    }

    public void setEveryday(int everyday) {
        this.everyday = everyday;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "shengchan{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", idHetong=" + idHetong +
                ", idPeople=" + idPeople +
                ", idGroup=" + idGroup +
                ", everyday=" + everyday +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", people=" + people +
                '}';
    }
}
