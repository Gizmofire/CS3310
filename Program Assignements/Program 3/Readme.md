# Canoe cost Solver 


## How to run
### For Grader 😀 (cmdl)
1. Clone the repository to your local machine using:
   ```
   git clone https://github.com/Gizmofire/CS3310.git
    ```
2. Navigate to the desired assignment folder using 
    ```bash 
    cd ./Program\ Assignements/Program\ 3/
    ```
3.  Run the test case using 
    ```bash 
    java main.java  
    ```
Or just run the big block below in your terminal
```bash
git clone https://github.com/Gizmofire/CS3310.git
cd ./Program\ Assignements/Program\ 3/
java main.java  
```
Thanks for grading!


## Challenge
- Given a set of canoe rental prices, determine the most cost effective solution from one post to another or down to the next post.
- Each post has a rental price associated with it. The goal is to minimize the total rental cost from the starting post to the ending post.
- The canoe can be rented from any post to any subsequent post, but not backwards.
- The solution should account for the possibility of skipping posts if it results in a lower overall cost.
- The program should output the minimum cost and the sequence of posts rented to achieve that cost.


## initial idea 
- Recursive approach to explore all possible rental paths.
  - Consider that waste of resources when there are many posts.
  - Check if the total cost exceeds the current minimum cost found for a simple optimization.
- Dynamic programming to store the minimum cost to reach each post.
  - Create an array to keep track of the minimum cost to reach each post.
  - Update the array as we evaluate each post and its rental options. 
  - Using a singular table of the costs to build up the solution iteratively i can compare from the start to the end and build up the solution.
    - This approach is more efficient than recursion as it avoids redundant calculations.
    - It also allows for easy tracking of the optimal path by storing split points.
  - New secondary Matrix needs to be made to track the points where a potential path split is created to get the most optimal cost from one post to another.



## Findings 
- Reading the file give is just a raw text to parsing and convert to usable data structures, such as 2D arrays or lists.
- The singular condition to determine to contiue the path is enough to retire the consideration of other paths.
