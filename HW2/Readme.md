# Anagram Solver 


## initial idea 
- Frst read the word list line by line 
  - parse the line (i see that some words in the list has punctionation marks so ill just remove them) 
  - then reference the word speeling in a dictionaty  
    - then check if the word is an anagram of any word in the dictionary by revesing the word
      - if it is then append the word to the key
      - if not create a new key in the dictionary with the word as the key
- print resulting dict to a "anagrams" file