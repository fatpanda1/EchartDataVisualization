package com.datamargin.domain;

public class PvCount implements Comparable<PvCount>{

    private String time;
    private Long count;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public int compareTo(PvCount o) {
        int i = Integer.parseInt(this.getTime().substring(0,2)) - Integer.parseInt(o.getTime().substring(0,2));
        return i;
    }
}
