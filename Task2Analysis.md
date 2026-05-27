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

## 3. Provide the minimal code change (one or two lines) that resolves this safely.

Use Iterator.remove() instead of modifying the collection directly.

Correct fix:

```java
Iterator<Transaction> itr = transactions.iterator();

while (itr.hasNext()) {

    Transaction t = itr.next();

    if (condition) {

        itr.remove();

    }
}
