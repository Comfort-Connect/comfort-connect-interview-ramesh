# Challenge 3: Algorithms & Data Structures

## Problems

This challenge contains two independent problems. Solve both.

---

### Problem 1: Move Zeros (`MoveZeros.java`)

Given an array of integers, move all the zeros to the end of the array **in-place** while maintaining the relative order of all non-zero elements.

**Examples:**
```
Input:  [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]

Input:  [10, 20, 30]
Output: [10, 20, 30]

Input:  [0, 0]
Output: [0, 0]
```

**Requirements:**
- Modify the array in-place (do not return a new array)
- Maintain the relative order of non-zero elements
- Test cases are provided in the `main` method — all should produce correct output

**Run:** `cd Challenge-3 && javac MoveZeros.java && java MoveZeros`

---

### Problem 2: Contractor Search (`ContractorSearch.java`)

A homeowner needs to hire a contractor. There are several contractors spread across various locations, each connected by travel routes with a priority score (based on ratings, availability, etc.). Given the homeowner's location as the source, find the **top K contractors** who are closest (fewest hops) to the homeowner, breaking ties by highest priority score.

**You need to implement three classes:**

1. `ContractorGraph.build()` — Build an undirected adjacency list from the connections
2. `ContractorFinder.findTopK()` — BFS/graph traversal to find the top K closest contractors
3. `ResultDisplay.print()` — Pretty-print the results

**Requirements:**
- Rank by fewest hops first, then highest priority score as tiebreaker
- The homeowner node should not appear in the results
- Test data and expected call flow are provided in the `main` method

**Run:** `cd Challenge-3 && javac ContractorSearch.java && java ContractorSearch`

---

## Evaluation Criteria

- Correctness and handling of edge cases
- Time and space complexity awareness
- Clean, readable code

## Create your EXPLANATION.md in this folder when done
