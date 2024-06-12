import org.example.mappers.jobMapper;
import org.example.MODELS.jobs;
import org.example.DAO.JobDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;


@ExtendWith(MockitoExtension.class)
public class testjobDao {

    @InjectMocks
    JobDAO dao;

    @Test
    public void testupdatejob() throws SQLException, ClassNotFoundException {
        jobs j = new jobs(11, "ooooo", 1455,4555);

        Assertions.assertDoesNotThrow(() -> dao.updatejobs(j));

        jobs newJ = dao.selectjobs(j.getJob_ID());

        Assertions.assertNotNull(newJ);
        Assertions.assertEquals(newJ.getJob_title(), j.getJob_title());
        Assertions.assertEquals(newJ.getMin_salary(), j.getMin_salary());
        Assertions.assertEquals(newJ.getMax_salary(), j.getMax_salary());

    }
}
