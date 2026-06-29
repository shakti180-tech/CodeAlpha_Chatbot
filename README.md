# CodeAlpha_Chatbot
A java Based  predefined Chatbot
Friendly  Chatbot 

A simple Java Swing-based  Chatbot application with a friendly conversation style. The chatbot provides predefined responses, phrase matching, keyword detection, and random replies to create an interactive chat experience.

Features

- Graphical User Interface (GUI) built with Java Swing
- Friendly chatbot responses with emojis
- FAQ database using "HashMap"
- Keyword-based response system
- Phrase matching support
- Random responses for unknown messages
- Simulated typing delay using "Timer"
- Clean and user-friendly design

---

Technologies Used

- Java
- Swing (GUI framework)
- AWT
- HashMap Collections

---

Project Structure

Chatbot.java
README.md

---

How It Works

The chatbot processes user input using the following steps:

1. Converts user text to lowercase
2. Removes special characters
3. Checks predefined phrases
4. Searches for matching keywords in the FAQ database
5. Returns a random response if no match is found

Example conversation:

Bot: Hey friend 😄 I'm your chatbot buddy. Let's chat!

You: Hello
Bot: Hey buddy 😊 Nice to see you!

You: Tell me a joke
Bot: Why do programmers hate bugs? Because they bug them 😂

---

Installation & Run

Step 1: Clone the repository

git clone <repository-url>

Step 2: Compile the program

javac Chatbot.java

Step 3: Run the application

java Chatbot

---
Current code:

SwingUtilities.invokeLater(
    () -> new Chatbot()
            .setVisible(true)
);
---

Possible Future Improvements

- Add machine learning/NLP support
- Store chat history
- Add dark mode
- Support multiple languages
- Connect with APIs like OpenAI
- Add typing animation
- Voice input/output support

---

Author - Shakti Kumar Rai

Created using Java Swing for learning and chatbot practice.
