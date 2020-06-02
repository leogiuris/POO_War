package VIEW;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame{
	
	private BoardPanel boardPanel;
	private CadastroPanel cadastroPanel;
	static private List<JTextField> playerNameTextFields = new ArrayList<JTextField>();
	
	static public void Exemplo() {
		JFrame f= new JFrame("War");    
        JPanel panel=new JPanel();  
        panel.setBounds(40,80,400,400);    
        panel.setBackground(Color.gray);
        for (int i = 0; i < 6; i++) {
			JTextField playerName = new JTextField();
			playerName.setMaximumSize(new Dimension(400, 100));
			playerName.setBackground(Color.BLACK);
			playerName.setFont(new Font("Arial", Font.PLAIN, 34));
			playerNameTextFields.add(playerName);
			JButton submitButton = new JButton("Submit");
			panel.add(playerName); panel.add(submitButton);
		}
        JButton b1=new JButton("Button 1");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   
        JButton b2=new JButton("Button 2");   
        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);   
        JButton submitButton = new JButton("End");
        submitButton.setBackground(Color.CYAN);
        panel.add(b1); panel.add(b2); panel.add(submitButton);
        f.add(panel);  
                f.setSize(400,400);    
                f.setLayout(null);    
                f.setVisible(true); 
	}
	
	public MainFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("War");
		this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		
		this.cadastroPanel = new CadastroPanel();
		getContentPane().add(cadastroPanel);
		this.setVisible(true);
	}
	
	
}
