import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Task1Test {

    @Test
    public void shouldReturnOnlyOverdueAccountsWithPositiveBalance() {

        Task1 service = new Task1();

        List<LoanAccount> accounts = new ArrayList<>();

        LoanAccount valid = new LoanAccount();
        valid.setOutstandingBalance(1000);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -5);
        valid.setDueDate(cal.getTime());

        LoanAccount zeroBalance = new LoanAccount();
        zeroBalance.setOutstandingBalance(0);
        zeroBalance.setDueDate(cal.getTime());

        LoanAccount nullDate = new LoanAccount();
        nullDate.setOutstandingBalance(500);
        nullDate.setDueDate(null);

        accounts.add(valid);
        accounts.add(zeroBalance);
        accounts.add(nullDate);

        List<LoanAccount> result =
                service.getOverdueLoans(accounts);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(valid, result.get(0));
    }
}
