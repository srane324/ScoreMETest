# Task 2 Analysis

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is modified
(structurally changed like add/remove) while it is being iterated using
an Iterator, enhanced for-loop, or stream operation.

The iterator detects that the collection's modification count has changed
unexpectedly during iteration.

---

## 2. What code pattern at line 142 most likely triggered this error?

Most likely pattern:

```java
for (Transaction t : transactions) {
    if (condition) {
        transactions.remove(t);
    }
}

This error occurs because the collection is being modified directly
while iterating over it.


