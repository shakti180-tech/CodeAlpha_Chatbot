import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

class Chatbot extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private Map<String, String> faqDatabase;

    public Chatbot() {

        initFAQDatabase();

        setTitle("Friendly AI Chatbot");
        setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Chat Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        chatArea.setBackground(new Color(245,245,245));
        chatArea.setMargin(new Insets(10,10,10,10));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));

        sendButton = new JButton("Send");
        sendButton.setBackground(new Color(0,122,255));
        sendButton.setForeground(Color.WHITE);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        appendMessage("Bot",
                "Hey friend 😄 I'm your chatbot buddy. Let's chat!");

        sendButton.addActionListener(new SendMessageListener());
        inputField.addActionListener(new SendMessageListener());
    }


    // Friend-style responses
    private void initFAQDatabase() {

        faqDatabase = new HashMap<>();

        faqDatabase.put("hello",
                "Hey buddy 😊 Nice to see you!");
        faqDatabase.put("hi",
                "Hi friend! How are you?");
        faqDatabase.put("hey",
                "Hey 😎 What's up?");
        faqDatabase.put("morning",
                "Good morning ☀️ Have a great day!");
        faqDatabase.put("night",
                "Good night 🌙 Sweet dreams!");
        faqDatabase.put("fine",
                "That's awesome 😄");
        faqDatabase.put("good",
                "Nice! Keep smiling 😊");
        faqDatabase.put("sad",
                "I'm here for you 😔");
        faqDatabase.put("happy",
                "Yay! I like happy news 😄");
        faqDatabase.put("friend",
                "Of course! We are friends 😎");
        faqDatabase.put("joke",
                "Why do programmers hate bugs? Because they bug them 😂");
        faqDatabase.put("music",
                "Music makes life better 🎵");
        faqDatabase.put("food",
                "Pizza sounds amazing 🍕");
        faqDatabase.put("thanks",
                "You're welcome buddy 😊");
        faqDatabase.put("bye",
                "Bye 👋 Take care friend!");
    }


    private String processInputAndGetResponse(String userInput) {

        String cleanInput = userInput.toLowerCase()
                .replaceAll("[^a-zA-Z0-9\\s]", "");

        // Phrase matching
        if(cleanInput.contains("how are you")){
            return "I'm doing great 😄 What about you?";
        }

        if(cleanInput.contains("what are you doing")){
            return "Just waiting to chat with you 😎";
        }

        if(cleanInput.contains("i am fine")){
            return "That's nice 😊";
        }

        if(cleanInput.contains("i am sad")){
            return "I'm sorry 😔 Things will get better.";
        }

        if(cleanInput.contains("my name is")){
            return "Nice to meet you 😄";
        }

        // Word matching
        String[] tokens = cleanInput.split("\\s+");

        for(String token : tokens){
            if(faqDatabase.containsKey(token)){
                return faqDatabase.get(token);
            }
        }

        // Random replies if no match
        String[] randomReplies = {
                "Interesting 🤔 Tell me more.",
                "Haha 😄",
                "Really? Sounds fun!",
                "I'm listening buddy 😊",
                "Tell me more 😎"
        };

        return randomReplies[
                (int)(Math.random()*randomReplies.length)
        ];
    }


    private void appendMessage(String sender, String text) {
        chatArea.append(sender + ": " + text + "\n\n");
        chatArea.setCaretPosition(
                chatArea.getDocument().getLength()
        );
    }


    private class SendMessageListener
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String userText =
                    inputField.getText().trim();

            if(!userText.isEmpty()) {

                appendMessage("You", userText);

                inputField.setText("");

                String botResponse =
                        processInputAndGetResponse(
                                userText);

                Timer timer = new Timer(
                        500,
                        new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent evt) {

                        appendMessage(
                                "Bot",
                                botResponse
                        );
                    }
                });

                timer.setRepeats(false);
                timer.start();
            }
        }
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new AIChatbot()
                        .setVisible(true)
        );
    }
}