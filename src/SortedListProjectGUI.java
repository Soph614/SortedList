import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SortedListProjectGUI extends JFrame {
    private SortedList list;

    JPanel mainPnl;
    JPanel enterDataPnl;
    JPanel listDisplayPnl;
    JPanel searchPnl;

    JLabel enterDataLbl;
    JTextField enterDataTF;
    String userInput;

    JTextArea listDisplayTA;
    JScrollPane listDisplayScrollPane;

    JLabel searchLbl;
    JTextField searchTF;
    String searchTerm;

    public SortedListProjectGUI() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createEnterDataPnl();
        mainPnl.add(enterDataPnl, BorderLayout.NORTH);

        createListDisplayPnl();
        mainPnl.add(listDisplayPnl, BorderLayout.CENTER);

        createSearchPnl();
        mainPnl.add(searchPnl, BorderLayout.SOUTH);

        createActionListeners();

        list = new SortedList();

        add(mainPnl);
        {
            // SET SIZE AND LOCATION...CODE ADAPTED FROM CAY HORSTMANN
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenHeight = screenSize.height;
            int screenWidth = screenSize.width;

            double onePointFive = 1.5;
            setSize(screenWidth / 3, screenHeight / 2);
            setLocation(screenWidth / 3, screenHeight / 4);

            setTitle("Make and Search Sorted List");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    public void createActionListeners() {
        // enterDataTF action listener
        enterDataTF.addActionListener((ActionEvent ae) -> {
            userInput = enterDataTF.getText();
            enterDataTF.setText("");
            list.add(userInput);
                // after successful adding...
            if (!list.isEmpty()) {
                searchPnl.setVisible(true);
                searchTF.setEnabled(true);
            }
        });

        // searchTF action listener
        searchTF.addActionListener((ActionEvent ae) -> {
            searchTerm = searchTF.getText();
            listDisplayTA.append(list.performBinarySearch(searchTerm) + "\n");
            searchTF.setText("");
        });
    }

    public void createEnterDataPnl() {
        enterDataPnl = new JPanel();
        enterDataPnl.setLayout(new BorderLayout());
        enterDataPnl.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        enterDataLbl = new JLabel("Enter strings to add to the list:");
        enterDataTF = new JTextField(20);

        enterDataPnl.add(enterDataLbl, BorderLayout.WEST);
        enterDataPnl.add(enterDataTF, BorderLayout.EAST);
    }

    public void createListDisplayPnl() {
        listDisplayPnl = new JPanel();

        Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "YOUR SORTED LIST");
        listDisplayPnl.setBorder(new CompoundBorder(padding, titledBorder));

        listDisplayTA = new JTextArea(7, 33);
        listDisplayTA.setEditable(false);

        listDisplayScrollPane = new JScrollPane(listDisplayTA);

        listDisplayPnl.add(listDisplayScrollPane);
    }

    public void createSearchPnl() {
        searchPnl = new JPanel();
        searchPnl.setLayout(new BorderLayout());
        searchPnl.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        searchPnl.setVisible(false);

        searchLbl = new JLabel("Search list:");
        searchTF = new JTextField(30);
        searchTF.setEnabled(false); // keep the user from searching for items until they've added some

        searchPnl.add(searchLbl, BorderLayout.WEST);
        searchPnl.add(searchTF, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame frame = new SortedListProjectGUI();
        frame.pack();
    }
}
