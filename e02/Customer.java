package exam_xier.e02;

import java.time.LocalDate;

public class Customer {
    String name;
    int times=1;
    LocalDate latestTime;
    private Animal wantAnimal;

    public Customer(){}

    public Customer(String name, int times) {
        this.name = name;
        this.times = times;
    }

    //(姓名,来过次数,最新到店时间)
    public Customer(String name, int times, LocalDate latestTime) {
        this.name = name;
        this.times = times;
        this.latestTime = latestTime;
    }

    public Customer(String name, int times, LocalDate latestTime,Animal wantAnimal) {
        this.name = name;
        this.times = times;
        this.latestTime = latestTime;
        this.wantAnimal=wantAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public LocalDate getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(LocalDate latestTime) {
        this.latestTime = latestTime;
    }

    public Animal getWantAnimal() {
        return wantAnimal;
    }

    public void setWantAnimal(Animal wantAnimal) {
        this.wantAnimal = wantAnimal;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", times=" + times +
                ", latestTime=" + latestTime +
                '}';
    }
}
