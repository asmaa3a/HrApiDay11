
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.UriBuilder;
import org.example.MODELS.jobs;
import org.example.DAO.JobDAO;
import org.example.CONTROLLER.jobcontroller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;
import java.sql.SQLException;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class testjobcontroller {

    @InjectMocks
    jobcontroller jobcontroller;

    @Mock
    UriInfo uriInfo;

    @Test
    public void testupdate()throws SQLException, ClassNotFoundException
    {
        jobs j = new jobs(11, "ooooo", 1455,4555);

        URI uri = URI.create("http://localhost/api/department/1");

//        when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromUri(uri));

        Assertions.assertDoesNotThrow(() -> jobcontroller.updatejob(j.getJob_ID(), j));

    }



}
