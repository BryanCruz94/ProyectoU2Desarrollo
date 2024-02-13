package com.espe.model.novelties;

public class view_novelties {
    private String novelty;
    private String hour;
    private String guard;

    public view_novelties() {
    }

    public view_novelties(String novelty, String hour, String guard) {
        this.novelty = novelty;
        this.hour = hour;
        this.guard = guard;
    }

    public String getNovelty() {
        return novelty;
    }

    public void setNovelty(String novelty) {
        this.novelty = novelty;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    @Override
    public String toString() {
        return "view_novelties{" +
                "novelty='" + novelty + '\'' +
                ", hour='" + hour + '\'' +
                ", guard='" + guard + '\'' +
                '}';
    }
}
