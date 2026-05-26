import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApplication {

    JFrame frame;
    JLabel questionLabel;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup group;
    JButton nextButton;

    String[] questions = {
            "What is the capital of Germany?",
            "Which language is used for Android apps?",
            "2 + 5 = ?"
    };

    String[][] answers = {
            {"Berlin","Paris","Rome","Madrid"},
            {"Java","HTML","Photoshop","Excel"},
            {"5","10","7","9"}
    };

    int[] correctAnswers = {0,0,2};

    int currentQuestion = 0;
    int score = 0;

    public QuizApplication() {

        frame = new JFrame("Quiz Application");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        questionLabel = new JLabel();

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        group = new ButtonGroup();

        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        nextButton = new JButton("Next");

        nextButton.addActionListener(
                e -> checkAnswer()
        );

        frame.add(questionLabel);
        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(option4);
        frame.add(nextButton);

        loadQuestion();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void loadQuestion() {

        if(currentQuestion < questions.length){

            questionLabel.setText(
                    questions[currentQuestion]
            );

            option1.setText(
                    answers[currentQuestion][0]
            );

            option2.setText(
                    answers[currentQuestion][1]
            );

            option3.setText(
                    answers[currentQuestion][2]
            );

            option4.setText(
                    answers[currentQuestion][3]
            );

            group.clearSelection();

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Quiz Finished!\nScore: "
                    + score + "/"
                    + questions.length
            );

            System.exit(0);
        }
    }

    private void checkAnswer() {

        int selected = -1;

        if(option1.isSelected())
            selected = 0;

        if(option2.isSelected())
            selected = 1;

        if(option3.isSelected())
            selected = 2;

        if(option4.isSelected())
            selected = 3;

        if(selected ==
                correctAnswers[currentQuestion]){

            score++;
        }

        currentQuestion++;

        loadQuestion();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new QuizApplication()
        );
    }
}