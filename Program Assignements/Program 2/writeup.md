# Write up

## Time Complexity
- Line Readear until null: o(n)
- Regex cleaning for punctuation and capital: o(n)
- Word Array sorting : o(n log n)
  - https://www.gregorygaines.com/blog/what-is-the-time-complexity-arrays-and-collections-sort/
- Dictionary insertion : o(1)
- Write dict to file : o(n)

Sum of Complexity: O(n) + O(n) + O(n \log n) + O(1) + O(n) = O(3n + n \log n + 1)
Bottle Neck Complexity Or Worst Case Complexity: O(n log n) 

This means that as the input size increases, the time taken to process the input will grow logarithmically, making the algorithm efficient for larger datasets.
The data structure is linear since it a hash map with a key for insetion and retrieval. The sorting is the bottleneck since it has to compare each letter in the word to sort it, which can be the more time consuming task for a machine.


