import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Enumeration;


public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private World world;
    private Bird[] currentSearch;
    private String lastQuery;
    
    public DataGUI() {
        world = new World("data/names.txt", "data/color.txt", "data/diets.txt", "data/status.txt");
        setTitle("Bird Data Analyzer");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        JButton analyzeColorButton = new JButton("Analyze by Color");
        JButton analyzeDietButton = new JButton("Analyze by Diet");
        JButton analyzeStatusButton = new JButton("Analyze by Status");
        JButton commonColorButton = new JButton("Find Most Common Color");
        JButton commonDietButton = new JButton("Find Most Common Diet");
        JButton commonStatusButton = new JButton("Find Most Common Status");
        JButton statusPercentageButton = new JButton("Status Percentage");
        JButton countByColorButton = new JButton("Count by Color");
        JButton countByDietButton = new JButton("Count by Diet");
        JButton countByStatusButton = new JButton("Count by Status");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeColorButton);
        add(analyzeDietButton);
        add(analyzeStatusButton);
        add(commonColorButton);
        add(commonDietButton);
        add(commonStatusButton);
        add(statusPercentageButton);
        add(countByColorButton);
        add(countByDietButton);
        add(countByStatusButton);
        add(new JScrollPane(resultsArea));

        analyzeColorButton.addActionListener(e -> analyzeByColor());
        analyzeDietButton.addActionListener(e -> analyzeByDiet());
        analyzeStatusButton.addActionListener(e -> analyzeByStatus());
        commonColorButton.addActionListener(e -> getMostCommonColor());
        commonDietButton.addActionListener(e -> getMostCommonDiet());
        commonStatusButton.addActionListener(e -> getMostCommonStatus());
        statusPercentageButton.addActionListener(e -> getStatusPercentage());
        countByColorButton.addActionListener(e -> countByColor());
        countByDietButton.addActionListener(e -> countByDiet());
        countByStatusButton.addActionListener(e -> countByStatus());
    }

    private static String stringify(Bird[] arr) {
        String result = "";
        for(Bird s : arr) {
            result += s + "\n";
        }
        return result;
    }

    private static String stringify(Dictionary<String, Bird[]> dict) {
        String result = "";
        Enumeration<String> keys = dict.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            result += key + ": " + dict.get(key).length + "\n";
        }
        return result;
    }

    private void analyzeByColor(){
        Bird[] birds = world.searchByColor(inputField.getText());
        currentSearch = birds;
        lastQuery = "Birds with color " + inputField.getText();
        resultsArea.setText("Birds with color " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void analyzeByDiet(){
        Bird[] birds = world.searchByDiet(inputField.getText());
        currentSearch = birds;
        lastQuery = "Birds with diet " + inputField.getText();
        resultsArea.setText("Birds with diet " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void analyzeByStatus(){
        Bird[] birds = world.searchByStatus(inputField.getText());
        currentSearch = birds;
        lastQuery = "Birds with status " + inputField.getText();
        resultsArea.setText("Birds with status " + inputField.getText() + ": \n" + stringify(birds) + "\n");
    }

    private void getMostCommonColor(){
        String count = world.getMostCommonColor();
        resultsArea.setText("Most common color: " + count);
    }

    private void getMostCommonDiet(){
        String count = world.getMostCommonDiet();
        resultsArea.setText("Most common diet "+ ": " + count);
    }

    private void getMostCommonStatus(){
        String count = world.getMostCommonStatus();
        resultsArea.setText("Most common status "+ ": " + count);
    }

    private void getStatusPercentage(){
        // double percentage = DataAnalyzer.statusPercentage();
        resultsArea.setText("Percentage of birds with status "+ ": " + "percentage" + "%");
    }

    private void countByColor(){
        Dictionary<String, Bird[]> result = world.countByColor(currentSearch);
        resultsArea.setText(lastQuery + " counted by color: \n" + stringify(result) + "\n");
    }

    private void countByDiet(){
        Dictionary<String, Bird[]> result = world.countByDiet(currentSearch);
        resultsArea.setText(lastQuery + " counted by diet: \n" + stringify(result) + "\n");
    }

    private void countByStatus(){
        Dictionary<String, Bird[]> result = world.countByStatus(currentSearch);
        resultsArea.setText(lastQuery + " counted by status: \n" + stringify(result) + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}