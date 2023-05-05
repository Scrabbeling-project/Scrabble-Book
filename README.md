# Scrabble-Book



  **ABOUT**

This project contains the following elements:
- Use of design and architecture patterns
- Use of data structures
- Data streaming
- Implementation of algorithms
- Parallel programming using threads
- Event oriented programming, desktop application with GUI












  **INTRODUCTION**

- Objective: develop a scalable server for Book Scrabble game that finds legal words from set of books.
- Searching all files for each query is not scalable due to many I/O operations.
- Storing all words in a HashSet would quickly run out of memory
- Dictionary will use several filters to address these issues
- First filter: Cache Manager keeps answers to most common queries in memory for O(1) time search; size fixed according to defined parameter
- Server checks if answer exists in Cache Manager; returns if found, passes query to next filter if not
- Second filter: Bloom Filter is space-efficient data structure suitable for storing large number of words in dictionary; can say with certainty if word not found, with high probability if found
- If user challenges dictionary and I/O search performed, rules of game fine challenger with points if wrong, give bonus if right; Cache Manager updated to avoid unnecessary searches
- Overall approach minimizes I/O operations and memory usage while providing fast and accurate responses to queries, making dictionary scalable for Book Scrabble game.










   **FEATURES**

- Software implementation of Book Scrabble includes features to enhance user experience and gameplay
- User-friendly interface facilitates start and play of game for up to four players, with support for concurrent player actions through multi-threading technology
- Various cache management algorithms, including LRU, LFU, and BloomFilter, optimize performance and resource utilization
- Data structures incorporated to enable efficient word storage and retrieval
- Dictionary used to verify validity of words created by players, ensuring adherence to game rules and fair play
- Point system implemented to calculate scores for each player based on words they create, adding competitive element to game
- Overall, features enhance functionality and usability of software, providing comprehensive and enjoyable gaming experience for users.










**Definitions**

**Tile**:
- A small board containing a letter and its value in the game - the amount of points the letter is worth.
- In the following chart you can see how much each letter is worth in the game.
   

![229486188-1f5ab09f-8f78-4e12-b2d1-8aea60616c7c](https://user-images.githubusercontent.com/120463766/230888262-b253da60-e33e-4fab-b39c-9737560c0379.png)










**Bag**:

- A bag containing 98 tiles
- Allows players to randomly remove tiles
- The number of false tiles for each letter at the beginning of the game:

![229486334-5985074d-ffa1-4366-bc21-8acfd1d4445d](https://user-images.githubusercontent.com/120463766/230883575-bdfdd520-95bc-4762-8a04-2ad453644cc5.png)


**Board**:

    
  -  Two-dimensional board size 15x15.
  
     For the board some bonus slots:
- The central square (marked with a star) doubles the value of the word written on it.
- Squares that double the value of the letter on them (light blue).
- Squares that triple the value of the letter on them (blue).
- Slots that double the value of the entire word (yellow).
- Squares that match the value of the entire word (red).
 
![229484247-4854a0a0-7e4f-4f2d-9e87-60fadd52d077](https://user-images.githubusercontent.com/120463766/230883630-63829917-9393-4991-81f6-1978aa649f5d.png)
 
 
 
 
