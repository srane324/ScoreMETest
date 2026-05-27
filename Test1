import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException on result.add()
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Prevent NullPointerException when accounts itself is null
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            // FIX: dueDate can be null for restructured accounts
            if (account.getDueDate() != null
                    && account.getDueDate().before(new Date())) {

                // FIX: Ignore accounts with zero or negative outstanding balance
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
