# Scrabble-Book

ABUOT

This project contains the following elements:
- Use of design and architecture patterns
- Use of data structures
- Data streaming
- Implementation of algorithms
- Parallel programming using threads
- Event oriented programming, DESKTOP application with GUI

INTRODUCTION

The objective of this project is to develop a scalable server for the Book Scrabble game. The game requires finding legal words from a set of books chosen for the game. However, searching for words in all the files for each query is not scalable as it would require a lot of I/O operations. Storing all the words in a HashSet would quickly run out of memory. To address these issues, the dictionary will use several filters.

The first filter is the Cache Manager, which will keep in memory the answers to the most common queries. The search in the Cache Manager will be in O(1) time, and its size will be fixed according to a parameter that we define. Thus, given a query, the server will quickly check if the answer exists in the Cache Manager. If the answer exists, the server will return it. Otherwise, the server will pass the query to the next filter.

The next filter is the Bloom Filter, an efficient and very economical algorithm that can say with absolute certainty whether a word is not found in the dictionary of books, and with a high probability whether a word is found. The Bloom Filter is a space-efficient data structure that can store a large number of items with a small memory footprint. It is suitable for our dictionary as we have a large number of words to store.

If a user challenges the dictionary, thinking that the dictionary was wrong and the word is actually not found, then an I/O based search will be performed. The rules of the game will fine the challenger with points if they bothered the server for nothing, or they will give them a bonus if they were right. In any case, when an answer comes back, the Cache Manager will be updated to save unnecessary searches.

Overall, this approach will make the dictionary scalable as it will minimize I/O operations and memory usage while providing fast and accurate responses to queries.


FEATURES

The software implementation of Book Scrabble comprises several features designed to enhance user experience and gameplay. 
These include a user-friendly interface that facilitates the start and play of the game for up to four players, with support for concurrent player actions through the use of multi-threading technology.

The software also integrates various cache management algorithms, including LRU, LFU, and BloomFilter, which optimize performance and resource utilization. Additionally, data structures have been incorporated to enable efficient word storage and retrieval.

Furthermore, the software utilizes a dictionary to verify the validity of words created by players, ensuring adherence to game rules and fair play.
A point system has also been implemented to calculate scores for each player based on the words they create, adding a competitive element to the game.

Overall, these features enhance the functionality and usability of the software, providing a comprehensive and enjoyable gaming experience for users.




