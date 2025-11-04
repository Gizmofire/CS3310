# Anagram Solver 


## How to run
### For Grader 😀 (cmdl)
1. Clone the repository to your local machine using:
   ```
   git clone https://github.com/Gizmofire/CS3310.git
    ```
2. Navigate to the desired assignment folder using 
    ```bash 
    cd ./Program\ Assignements/Program\ 2/
    ```
3.  Run the test case using 
    ```bash 
    java main.java  
    ```
Or just run the big block below in your terminal
```bash
git clone https://github.com/Gizmofire/CS3310.git
cd ./Program\ Assignements/Program\ 2/
java main.java  
```
Thanks for grading!
## Challenge
- Given a list of words, group the words that are anagrams of each other together.
- Considerations:
  - Ignore capitalization
  - Ignore punctuation
  - Output the anagrams to a file

## initial idea 
- Frst read the word list line by line 
  - parse the line (i see that some words in the list has punctionation marks so ill just remove them) 
  - then reference the word speeling in a dictionaty  
    - then check if the word is an anagram of any word in the dictionary by revesing the word
      - if it is then append the word to the key
      - if not create a new key in the dictionary with the word as the key
- print resulting dict to a "anagrams" file

## Findings 
- Some words are repeated in the word list such as letters or words that are plural or possesive. 
  - Plural and possevive has 0 distinction in anagrams so i will just treat them as the same word

## Time Complexity
- Line Readear until null: o(n)
- Regex cleaning for punctuation and capital: o(n)
- Word Array sorting : o(n log n)
  - https://www.gregorygaines.com/blog/what-is-the-time-complexity-arrays-and-collections-sort/
- Dictionary insertion : o(1)
- Write dict to file : o(n)