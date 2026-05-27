import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Task5 {

    public static class DocumentValidator {

        // FIX: Use SLF4J logger instead of printStackTrace()
        private static final Logger logger =
                LoggerFactory.getLogger(DocumentValidator.class);

        public ValidationResult validate(Document doc) {

            try {

                // FIX: Validation failures are expected cases.
                // Use IllegalArgumentException instead of generic RuntimeException.
                if (doc == null) {
                    throw new IllegalArgumentException("Document is null");
                }

                String content = doc.extractContent();

                // FIX: Prevent NullPointerException when content is null
                if (content == null || content.isEmpty()) {
                    throw new IllegalArgumentException("Empty content");
                }

                return runValidationRules(content);

            } catch (IllegalArgumentException e) {

                // FIX: Expected validation failures should be logged as warnings,
                // not full stack traces.
                logger.warn("Validation failed: {}", e.getMessage());

                // FIX: Never return null from validation flow
                return ValidationResult.invalid(e.getMessage());

            } catch (Exception e) {

                // FIX: Unexpected runtime exceptions should be logged with stack trace
                logger.error("Unexpected error during validation", e);

                return ValidationResult.invalid("Unexpected validation error");
            }
        }

        public void validateBatch(List<Document> docs) {

            for (Document doc : docs) {

                try {

                    ValidationResult r = validate(doc);

                    // FIX: Prevent NullPointerException if validation result is invalid/null
                    if (r != null && r.isValid()) {
                        saveResult(r);
                    }

                } catch (Exception e) {

                    // FIX: Exception must not be swallowed silently
                    logger.error("Failed to validate document in batch", e);
                }
            }
        }

        private ValidationResult runValidationRules(String content) {
            return null;
        }

        private void saveResult(ValidationResult r) {
        }
    }
}
