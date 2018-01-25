package com.example.tmd.datepickerdialog_timepickerdialog;

import android.support.annotation.NonNull;

import java.util.Date;

import static com.example.tmd.datepickerdialog_timepickerdialog.MainActivity.sdfTime;

/**
 * Created by tmd on 27/03/2017.
 */

public class JobWeek implements Comparable<JobWeek>{
    private String mName;
    private String mContent;
    private Date mTimeFinish;

    @Override
    public String toString() {
        return "Tên công việc: " + mName + "\nNội dung: " + mContent + "\nThời gian hoàn thành: " + sdfTime.format(mTimeFinish.getTime());
    }

    public String getName() {
        return mName;
    }

    public String getContent() {
        return mContent;
    }

    public Date getTimeFinish() {
        return mTimeFinish;
    }

    public JobWeek(String name, String content, Date timeFinish) {

        mName = name;
        mContent = content;
        mTimeFinish = timeFinish;
    }

    @Override
    public int compareTo(@NonNull JobWeek o) {
        if (mTimeFinish.after(o.getTimeFinish())){
            if(mTimeFinish.after(o.getTimeFinish())){
                return 1;
            }
        }
        return -1;
    }
}
