package com.phoneix.taskmanager.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "task_tbl")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tsk_name;
    private String tsk_desc;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsk_date;
    private Boolean tsk_finish;

    public Task()
    {

    }

    public Task(String tsk_name, String tsk_desc, Date tsk_date, Boolean tsk_finish) {
        super();
        this.tsk_name = tsk_name;
        this.tsk_desc = tsk_desc;
        this.tsk_date = tsk_date;
        this.tsk_finish = tsk_finish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTsk_name() {
        return tsk_name;
    }

    public void setTsk_name(String tsk_name) {
        this.tsk_name = tsk_name;
    }

    public String getTsk_desc() {
        return tsk_desc;
    }

    public void setTsk_desc(String tsk_desc) {
        this.tsk_desc = tsk_desc;
    }

    public Date getTsk_date() {
        return tsk_date;
    }

    public void setTsk_date(Date tsk_date) {
        this.tsk_date = tsk_date;
    }

    public Boolean getTsk_finish() {
        return tsk_finish;
    }

    public void setTsk_finish(Boolean tsk_finish) {
        this.tsk_finish = tsk_finish;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", tsk_name='" + tsk_name + '\'' +
                ", tsk_desc='" + tsk_desc + '\'' +
                ", tsk_date=" + tsk_date +
                ", tsk_finish=" + tsk_finish +
                '}';
    }
}
