# Scrabble-Book

ABOUT

The objective of this project is to develop a scalable server for the Book Scrabble game. The game requires finding legal words from a set of books chosen for the game. However, searching for words in all the files for each query is not scalable as it would require a lot of I/O operations. Storing all the words in a HashSet would quickly run out of memory. To address these issues, the dictionary will use several filters.

The first filter is the Cache Manager, which will keep in memory the answers to the most common queries. The search in the Cache Manager will be in O(1) time, and its size will be fixed according to a parameter that we define. Thus, given a query, the server will quickly check if the answer exists in the Cache Manager. If the answer exists, the server will return it. Otherwise, the server will pass the query to the next filter.

The next filter is the Bloom Filter, an efficient and very economical algorithm that can say with absolute certainty whether a word is not found in the dictionary of books, and with a high probability whether a word is found. The Bloom Filter is a space-efficient data structure that can store a large number of items with a small memory footprint. It is suitable for our dictionary as we have a large number of words to store.

If a user challenges the dictionary, thinking that the dictionary was wrong and the word is actually not found, then an I/O based search will be performed. The rules of the game will fine the challenger with points if they bothered the server for nothing, or they will give them a bonus if they were right. In any case, when an answer comes back, the Cache Manager will be updated to save unnecessary searches.

Overall, this approach will make the dictionary scalable as it will minimize I/O operations and memory usage while providing fast and accurate responses to queries.

