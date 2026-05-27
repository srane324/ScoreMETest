# Task 2 — Root Cause Analysis

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is structurally modified while it is being iterated using an Iterator, enhanced for-loop, or stream traversal.

Examples of structural modifications:
- add()
- remove()
- clear()

The iterator internally checks whether the collection was modified unexpectedly during iteration. If detected, it throws ConcurrentModificationException.

---

## 2. What code pattern at line 142 most likely triggered this error?

Most likely problematic code:

```java
for (Transaction t : transactions) {

    if (t.isInvalid()) {

        transactions.remove(t);

    }
}

```

## 3. Provide the minimal code change that resolves this safely.

//Use Iterator.remove() instead of list.remove().

Iterator<Transaction> itr = transactions.iterator();
while (itr.hasNext()) {
  Transaction t = itr.next();
    if (t.isInvalid()) {
        itr.remove();
    }
}

//Iterator.remove() safely updates the iterator state while removing elements, preventing ConcurrentModificationException.
