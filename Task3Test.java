import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Task3Test {

    @Test
    public void shouldProcessAllRecordsCorrectly()
            throws InterruptedException {

        Task3.BankStatementBatchProcessor processor =
                new Task3.BankStatementBatchProcessor();

        List<StatementRecord> records = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            records.add(new StatementRecord());
        }

        processor.process(records);

        Assert.assertEquals(
                records.size(),
                processor.getProcessedCount()
        );
    }
}
