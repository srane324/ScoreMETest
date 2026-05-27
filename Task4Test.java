import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class Task4Test {

    @Test
    public void shouldFetchMonthlyReportWithoutException()
            throws SQLException {

        Task4.ReportDAO dao = new Task4.ReportDAO();

        List<ReportEntry> result =
                dao.fetchMonthlyReport("ACC001", 5, 2026);

        Assert.assertNotNull(result);
    }
}
