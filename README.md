# Scrabble-Book


![CF603C93-C869-4166-90B9-D1303EAA8F24](https://user-images.githubusercontent.com/120463766/230883838-ea935b61-6318-4176-a5c8-4c84e8de1a7d.jpg)



  ABOUT

This project contains the following elements:
- Use of design and architecture patterns
- Use of data structures
- Data streaming
- Implementation of algorithms
- Parallel programming using threads
- Event oriented programming, desktop application with GUI

![229486334-5985074d-ffa1-4366-bc21-8acfd1d4445d](https://user-images.githubusercontent.com/120463766/230883575-bdfdd520-95bc-4762-8a04-2ad453644cc5.png)


  INTRODUCTION

- Objective: develop a scalable server for Book Scrabble game that finds legal words from set of books.
- Searching all files for each query is not scalable due to many I/O operations.
- Storing all words in a HashSet would quickly run out of memory
- Dictionary will use several filters to address these issues
- First filter: Cache Manager keeps answers to most common queries in memory for O(1) time search; size fixed according to defined parameter
- Server checks if answer exists in Cache Manager; returns if found, passes query to next filter if not
- Second filter: Bloom Filter is space-efficient data structure suitable for storing large number of words in dictionary; can say with certainty if word not found, with high probability if found
- If user challenges dictionary and I/O search performed, rules of game fine challenger with points if wrong, give bonus if right; Cache Manager updated to avoid unnecessary searches
- Overall approach minimizes I/O operations and memory usage while providing fast and accurate responses to queries, making dictionary scalable for Book Scrabble game.=

![229486188-1f5ab09f-8f78-4e12-b2d1-8aea60616c7c](https://user-images.githubusercontent.com/120463766/230883676-bcb89b16-e991-4994-8a3e-40540a2f3acc.png)


   FEATURES

- Software implementation of Book Scrabble includes features to enhance user experience and gameplay
- User-friendly interface facilitates start and play of game for up to four players, with support for concurrent player actions through multi-threading technology
- Various cache management algorithms, including LRU, LFU, and BloomFilter, optimize performance and resource utilization
- Data structures incorporated to enable efficient word storage and retrieval
- Dictionary used to verify validity of words created by players, ensuring adherence to game rules and fair play
- Point system implemented to calculate scores for each player based on words they create, adding competitive element to game
- Overall, features enhance functionality and usability of software, providing comprehensive and enjoyable gaming experience for users.


![229484247-4854a0a0-7e4f-4f2d-9e87-60fadd52d077](https://user-images.githubusercontent.com/120463766/230883630-63829917-9393-4991-81f6-1978aa649f5d.png)


