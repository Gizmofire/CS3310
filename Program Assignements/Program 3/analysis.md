1.  The formula used to solve the problem is 3 loops: 
    1.  One loop to iterate through each post as a starting point.
    2.  One nested loop to iterate through each possible ending post from the starting point.
    3.  One innermost loop to calculate the cost from the starting post to the ending post and update the minimum cost if a cheaper option is found.
2. Time analysis:
   1.  The time complexity of the algorithm is O(n^3), where n is the number of posts, another n is the destiantion of the post. And lastly another n because for each post, we potentially check all subsequent posts to find the minimum cost path.