# Quiz Bowl Answer Word Frequency Analyzer

A Java program that analyzes a PostgreSQL database of Quiz Bowl questions by computing word frequencies for a specified answer line. Given an answer, the program creates an appropriate SQL query to retrieve all questions with that answer and counts how often every individual word appears in the question text. This project is designed to help analyze patterns in Quiz Bowl questions and automate a process I once did manually.

## Features

- Connects to a PostgreSQL Quiz Bowl database
- Searches for questions matching a specified answer line
- Counts occurrences of every space-separated word
- Aggregates frequencies across all matching questions
- Outputs word frequency statistics

## Example

Given the answer line:

```text
Isaac Newton
```

If the database contains the questions:

```text
This scientist formulated the laws of motion.
```

```text
The laws of motion were developed by this English scientist.
```

The output might be:

```text
2  this
2  scientist
2  laws
2  of
2  motion
1  formulated
1  the
1  were
1  developed
1  by
1  english
```

## Possible Extensions

- Normalize capitalization
- Remove punctuation before counting
- Ignore common stop words
- Sort output by frequency
- Export results to CSV
- Support regular expression answer matching
- Generate TF-IDF scores
- Visualize word frequencies

## License

This project is provided as-is for educational and research purposes.
