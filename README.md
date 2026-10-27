## Week 1 Exercise Tasks
> Each task has its own **pattern**, **calculation and time complexity** for the given problem and **reflection**.

1. [Task 1 - Sorting Manually](#task-1---sorting-manually)
2. [Task 2 - Search sorted and unsorted papers](#task-2---search-sorted-and-unsorted-papers)
3. [X-Task](src/TRAI_26_X1_prakigov.java)

---


### Task 1 - Sorting Manually
```text
You’ll get a task to sort manually stacks of A4-papers to alphabetical order according to
a name on each paper. What technique/method you would use if the number of papers
in a stack is
(a) 10
(b) 100
(c) 1000
(d) 10000
Estimate how long time the sorting of each stack takes (in seconds, minutes, or hours).
Calculate the time usage from your sorting method. Estimate the time needed for each
simple operation (such as comparing the names of two papers) and the calculate how
many such operations you’ll do in each stage.
```

#### Patterns found:
- Search the unsorted papers for the one that belongs first
- Add that paper to the end of a growing sorted pile
- Repeat on the papers that are left
- The unsorted part shrinks by one paper each round

#### Calculation behind the pattern:
- In the first round, we look at n papers
- In the second round, we look at n-1 papers, since the first paper is sorted 
- In the third round, we look at n-2 papers
- ...
- In the last round, we look at 1 paper
- The total number of comparisons is: n + (n-1) + (n-2) + ... + 1 = n(n+1)/2

- Therefore, the calculations for the given scenario would be:
  - (a) 10 papers: 10(10+1)/2 = 55 comparisons = 55 seconds
  - (b) 100 papers: 100(100+1)/2 = 5050 comparisons = 5050 seconds (~ 84 minutes)
  - (c) 1000 papers: 1000(1000+1)/2 = 500500 comparisons = 500500 seconds (~ 139 hours)
  - (d) 10000 papers: 10000(10000+1)/2 = 5000500 comparisons = 50005OO seconds (~ 1389 hours)

#### Time complexity: O(n^2)

#### Reflection
- Technique or method behind this calculation is called **'Selection Sort'**
- It is a simple sorting algorithm that divides the input into a sorted and an unsorted region, and repeatedly selects the smallest element from the unsorted region and moves it to the sorted region.
- It is not the most efficient sorting algorithm for large datasets, but it is easy to understand and implement.

---

### Task 2 - Search sorted and unsorted papers
``` text
Again we have the stacks of task 1. How long it would take to find a given paper (by
name) when
(a) the papers are not sorted
(b) papers are in sorted order
Reason again your time estimate. If the stack a not initially sorted, then it is not sensible
to sort them in order to make just one search. However, if we are going to make thousands
of searches, the sorting helps a lot. For each stack size, what is the limit on the number
of searches before we should do the sorting to reduce the overall work?
```

1. Patterns Found

| Situation	| Pattern |
|-------------|---------|
|Unsorted stack | The paper could be anywhere, so the number of looks depends on luck. Only the worst case is safe to plan with, and one only knows a name is missing after checking every paper.
|Sorted stack	| Look at the middle paper, then keep only the half the name must be in. Each look halves what’s left.
|Sorting cost vs searching	| Sorting happens once per stack, then every later search reuses it. Sorting is a one-time cost and a search is a per-use cost. 

2. Calculations

| Item	| Result |
| ------ | ------|
|Unsorted worst case	| n looks (10, 100, 1,000, 10,000)
|Sorted worst case	| floor(log₂ n) + 1 looks (4, 7, 10, 14)
|Sorting cost with selection sort	| n(n+1)/2 looks (55, 5,050, 500,500, 50,005,000)
|Break-even searches	| sorting cost ÷ looks saved per search, rounded down, plus 1
|Break-even results	| 10, 55, 506 and 5,008 searches

3. Time complexity

| Method                        | Complexity |
|-------------------------------|------------|
| Search unsorted stack	         | O(n)       |
| Binary search on sorted stack	 | O(log n)   |
| Selection sort (one-time)	     | O(n²)      |

4. Reflections and corrections

| Reflection	| Learned |
| ------------- | ---------------- |
|Counting looks	| The formula’s 0 for a one-paper stack showed it undercounts, so the exact count is the log plus one final look. The +1 doesn’t matter for O(log n) but does matter for exact break-even numbers.
|Rows in a table	| Sorting appears once in a total, not once per search.
|Sorting cost vs searching	| Sorting happens once per stack, then every later search reuses it. Sorting is a one-time cost and a search is a per-use cost. 
|Mental table scan vs method | 50 cups came from trying a few rows, with a raw mental calculation. The saving per use gives the exact answer, which was then applied to paper stack of 100 (5,050 ÷ 93 ≈ 54.3).| 
| The k + 1 rule	| Used to deduce the break-even searches and holds for whole-number quotients too.|

----

