package com.luo.springboot.entities;

public class student {
    String sname;
    String sid;

    public void setsid(String sid) {
        this.sid = sid;
    }

    public void setsname(String sname) {
        this.sname = sname;
    }

    public String getsid() {
        return sid;
    }

    public String getsname() {
        return sname;
    }

}
