package com.datamargin.domain;

public class UvCount implements Comparable<UvCount>{

    private Long time;
    private Long count;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public int compareTo(UvCount o) {
        long i = this.getTime() - o.getTime();
        return (int)i;
    }
}
