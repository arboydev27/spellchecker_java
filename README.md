# spellchecker_java
A refactored version of a spell checker program that uses ArrayLists instead of arrays for managing dictionary data, making it more memory-efficient and scalable. The spell checker includes a common dictionary and a personal dictionary, allowing users to add custom words.

Features:
• Dynamic Data Structure: Utilizes ArrayLists for storing dictionary words, eliminating fixed-size constraints and enhancing memory usage.
• Spell Checking: Verifies if a word exists in either the common or personal dictionary, leveraging binary search for efficient lookups.
• File Operations:
    - Load Dictionary: Reads words from a file into an ArrayList, creating the file if it doesn’t exist.
    - Save Personal Dictionary: Saves custom words to the personal dictionary file.
    - Dictionary Management: Supports sorting and binary searching for both dictionaries using Java's Collections framework.

Refactored Methods:
- readFile: Reads words from a file into an ArrayList, dynamically resizing as needed.
- checkSpelling: Checks if a word exists in either dictionary by searching within ArrayLists.
- writeFile: Saves an ArrayList of words to a specified file.
- Main Refactoring: Updated to integrate the refactored methods and manage dictionaries as ArrayLists.

Getting Started:
1. Setup: Clone the repository, add the common dictionary file to the project directory, and import it into an IDE (e.g., Eclipse).
2. Run: Execute the program, which will read from the common and personal dictionaries and perform spell checks based on user input.
3. Add Words: Users can add custom words to the personal dictionary, which are saved for future sessions.

Additional Notes:
Scalability: This refactoring enables automatic resizing of dictionaries, removing fixed-size limitations of traditional arrays.
Code Cleanup: Improved readability with concise methods, meaningful variable names, and encapsulated data operations using ArrayLists.
