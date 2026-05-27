import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class Task4 {

    public static class ReportDAO {

        private DataSource dataSource;

        public List<ReportEntry> fetchMonthlyReport(String accountId,
                                                    int month,
                                                    int year)
                throws SQLException {

            // FIX: Use try-with-resources to ensure ResultSet,
            // PreparedStatement, and Connection are closed properly.

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                         "SELECT * FROM report_entries " +
                                 "WHERE account_id = ? AND MONTH(entry_date) = ? " +
                                 "AND YEAR(entry_date) = ?")) {

                ps.setString(1, accountId);
                ps.setInt(2, month);
                ps.setInt(3, year);

                // FIX: ResultSet also must be closed to prevent resource leaks
                try (ResultSet rs = ps.executeQuery()) {

                    List<ReportEntry> entries = new ArrayList<>();

                    while (rs.next()) {
                        entries.add(mapRow(rs));
                    }

                    return entries;
                }
            }
        }

        private ReportEntry mapRow(ResultSet rs) {
            return null;
        }
    }
}
