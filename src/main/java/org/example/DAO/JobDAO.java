package org.example.DAO;

import org.example.DTO.JobfilterDto;
import org.example.MODELS.jobs;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {


        private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\HrApiDay07\\src\\main\\java\\org\\example\\hr.db";
        private static final String SELECT_ALL_JOBS = "select * from jobs";
        private static final String SELECT_ONE_JOBS = "select * from jobs where job_ID = ?";
        private static final String SELECT_JOB_WITH_MIN = "select * from jobs where min_salary = ?";
        private static final String SELECT_JOB_WITH_MIN_PAGINATION = "select * from jobs where min_salary = ? order by job_ID limit ? offset ?";
    private static final String SELECT_JOB_WITH_PAGINATION = "select * from jobs order by job_ID  limit ? offset ?";


        private static final String INSERT_JOBS = "insert into jobs values (?, ?, ?, ?)";
        private static final String UPDATE_JOBS = "update jobs set job_title = ?, min_salary = ?, max_salary = ? where job_ID = ?";
        private static final String DELETE_JOBS = "delete from jobs where job_ID = ?";


        public void insertjobs (jobs d) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(INSERT_JOBS);
            st.setInt(1, d.getJob_ID());
            st.setString(2, d.getJob_title());
            st.setInt(3, d.getMin_salary());
            st.setInt(4, d.getMax_salary());
            st.executeUpdate();
        }

        public void updatejobs (jobs d) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(UPDATE_JOBS);
            st.setInt(4, d.getJob_ID());
            st.setString(1, d.getJob_title());
            st.setInt(2, d.getMin_salary());
            st.setInt(3, d.getMax_salary());
            st.executeUpdate();
        }

        public void deletejobs ( int job_ID) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(DELETE_JOBS);
            st.setInt(1, job_ID);
            st.executeUpdate();
        }

        public jobs selectjobs ( int job_ID) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(SELECT_ONE_JOBS);
            st.setInt(1, job_ID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new jobs(rs);
            } else {
                return null;
            }
        }
//
        public ArrayList<jobs> selectAllJOBS () throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st = conn.prepareStatement(SELECT_ALL_JOBS);
            ResultSet rs = st.executeQuery();
            ArrayList<jobs> jobs = new ArrayList<>();
            while (rs.next()) {
                jobs.add(new jobs(rs));
            }

            return jobs;
        }

    public ArrayList<jobs> selectAllJOBS(Integer min_salary, Integer limit, int offset) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;

        if(min_salary != null && limit != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MIN_PAGINATION);
            st.setInt(1,min_salary );
            st.setInt(2, limit);
            st.setInt(3, offset);
        }
        else if(min_salary != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MIN);
            st.setInt(1, min_salary);
        }
        else if(limit != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_PAGINATION);
            st.setInt(1, limit);
            st.setInt(2, offset);
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_JOBS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<jobs> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new jobs(rs));
        }

        return jobs;
    }
    public ArrayList<jobs> selectAllJOBS(JobfilterDto filter) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(filter.getMin_salary() != null && filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MIN_PAGINATION);
            st.setInt(1, filter.getMin_salary());
            st.setInt(2, filter.getLimit());
            st.setInt(3, filter.getOffset());
        }
        else if(filter.getMin_salary() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MIN);
            st.setInt(1, filter.getMin_salary());
        }
        else if(filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_PAGINATION);
            st.setInt(1, filter.getLimit());
            st.setInt(2, filter.getOffset());
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_JOBS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<jobs> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new jobs(rs));
        }

        return jobs;
    }
}


