import org.junit.Assert;
import org.junit.Test;

public class Task5Test {

    @Test
    public void shouldReturnInvalidResultForNullDocument() {

        Task5.DocumentValidator validator =
                new Task5.DocumentValidator();

        ValidationResult result =
                validator.validate(null);

        Assert.assertNotNull(result);

        Assert.assertFalse(result.isValid());
    }
}
