import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel title, nameLabel, rollLabel, emailLabel, genderLabel, courseLabel, hobbyLabel, addressLabel;
    JTextField nameField, rollField, emailField;
    JRadioButton male, female, other;
    JComboBox<String> courseBox;
    JCheckBox sports, music, reading;
    JTextArea addressArea;
    JButton submit, reset;
    ButtonGroup genderGroup;

    StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new JLabel("Student Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(110, 20, 300, 40);
        add(title);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 90, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(170, 90, 250, 30);
        add(nameField);

        rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(50, 135, 100, 30);
        add(rollLabel);

        rollField = new JTextField();
        rollField.setBounds(170, 135, 250, 30);
        add(rollField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 180, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(170, 180, 250, 30);
        add(emailField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 225, 100, 30);
        add(genderLabel);

        male = new JRadioButton("Male");
        male.setBounds(170, 225, 70, 30);

        female = new JRadioButton("Female");
        female.setBounds(245, 225, 80, 30);

        other = new JRadioButton("Other");
        other.setBounds(330, 225, 70, 30);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        add(male);
        add(female);
        add(other);

        courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 270, 100, 30);
        add(courseLabel);

        String[] courses = {"Select Course", "BCA", "B.Sc", "B.Tech", "MCA", "M.Sc"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(170, 270, 250, 30);
        add(courseBox);

        hobbyLabel = new JLabel("Hobbies:");
        hobbyLabel.setBounds(50, 315, 100, 30);
        add(hobbyLabel);

        sports = new JCheckBox("Sports");
        sports.setBounds(170, 315, 80, 30);

        music = new JCheckBox("Music");
        music.setBounds(250, 315, 80, 30);

        reading = new JCheckBox("Reading");
        reading.setBounds(330, 315, 90, 30);

        add(sports);
        add(music);
        add(reading);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 360, 100, 30);
        add(addressLabel);

        addressArea = new JTextArea();
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(170, 360, 250, 70);
        add(scrollPane);

        submit = new JButton("Submit");
        submit.setBounds(150, 470, 90, 35);
        submit.addActionListener(this);
        add(submit);

        reset = new JButton("Reset");
        reset.setBounds(260, 470, 90, 35);
        reset.addActionListener(this);
        add(reset);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = nameField.getText();
            String roll = rollField.getText();
            String email = emailField.getText();
            String gender = "";

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else if (other.isSelected())
                gender = "Other";

            String course = (String) courseBox.getSelectedItem();
            String hobbies = "";

            if (sports.isSelected())
                hobbies += "Sports ";
            if (music.isSelected())
                hobbies += "Music ";
            if (reading.isSelected())
                hobbies += "Reading ";

            JOptionPane.showMessageDialog(this,
                    "Registration Successful!\n\n" +
                    "Name: " + name +
                    "\nRoll No: " + roll +
                    "\nEmail: " + email +
                    "\nGender: " + gender +
                    "\nCourse: " + course +
                    "\nHobbies: " + hobbies +
                    "\nAddress: " + addressArea.getText());

        } else if (e.getSource() == reset) {
            nameField.setText("");
            rollField.setText("");
            emailField.setText("");
            genderGroup.clearSelection();
            courseBox.setSelectedIndex(0);
            sports.setSelected(false);
            music.setSelected(false);
            reading.setSelected(false);
            addressArea.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
