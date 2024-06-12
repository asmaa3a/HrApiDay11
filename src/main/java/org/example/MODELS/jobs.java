
package org.example.MODELS;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.SQLException;

@XmlRootElement
public class jobs {

    private int job_ID;
    private String job_title;
    private int min_salary;
    private int max_salary;

    public jobs(ResultSet rs) throws SQLException {
        job_ID=rs.getInt("job_ID");
        job_title =rs.getString("job_title");
        min_salary =rs.getInt("min_salary") ;
        max_salary = rs.getInt("max_salary");
    }

    public jobs() {
    }

    public jobs(int job_ID, String job_title, int min_salary, int max_salary) {
        this.job_ID = job_ID;
        this.job_title = job_title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public int getJob_ID() {
        return job_ID;
    }

    public void setJob_ID(int job_ID) {
        this.job_ID = job_ID;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int min_salary) {
        this.max_salary = max_salary;
    }



    @Override
    public String toString() {
        return job_ID + ": " + job_title + ":" + min_salary;
    }
}

