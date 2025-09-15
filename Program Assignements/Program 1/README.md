# Assigment 1 

## Challeneges
- must pass file in cli 
- read contnets of txt file 
- be able to catch lone edges
- be able to catch reapeated edge pairs 

## Description
The program reads the verticies and edges of the input file then returns the adjacency list of the graph

## For Grader 😀
1. Clone the repository to your local machine using:
   ```
   git clone https://github.com/Gizmofire/CS3310.git
    ```
2. Navigate to the desired assignment folder using 
    ```bash 
    cd ./Program\ Assignements/Program\ 1/
    ```
3.  Run the test case using 
    ```bash 
    java solution.java ./Givens/SampleInput.txt 
    ```
Or just run the big block below in your terminal
```bash
git clone https://github.com/Gizmofire/CS3310.git
cd ./Program\ Assignements/Program\ 1/
java solution.java ./Givens/SampleInput.txt
```
Thanks for grading!

## How to run
```bash 
java solution.java ./Givens/SampleInput.txt 
```
## Thought Proce
- read file
- parse and solve per line in file 
  - breakdown the string in to recognizeable parts
    - it has spaces to divy up the parts
  - store the parts in a data structure 
    - used arrayList for edges for ease of manipulation 
- print results
