
---

# Task3.java

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    public static class BankStatementBatchProcessor {

        // FIX: int increment is not thread-safe in multi-threaded execution.
        // Multiple threads updating processedCount simultaneously causes race conditions.
        // AtomicInteger provides atomic increment operations safely.
        private AtomicInteger processedCount = new AtomicInteger(0);

        public void process(List<StatementRecord> records)
                throws InterruptedException {

            ExecutorService executor = Executors.newFixedThreadPool(10);

            for (StatementRecord record : records) {

                executor.submit(() -> {
                    processRecord(record);

                    // FIX: Use atomic increment instead of processedCount++
                    processedCount.incrementAndGet();
                });
            }

            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.MINUTES);
        }

        public int getProcessedCount() {
            return processedCount.get();
        }

        private void processRecord(StatementRecord record) {
            // existing logic
        }
    }
}
