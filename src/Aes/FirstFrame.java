package Aes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FirstFrame extends JFrame  implements ActionListener {

	JButton Encrypt;
	JButton Decrypt;
	JLabel Header;
	
	public FirstFrame()
	{
		Encrypt= new JButton("Encrypt File");
		Decrypt = new JButton("Decrypt File");
		Header = new JLabel("AES ENcryptr");
		Encrypt.addActionListener(this);
		Decrypt.addActionListener(this);
		Header.setFont(new Font("San-Serif", Font.ITALIC, 24));
		setSize(400,400);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("AES ENcryptr");
		setVisible(true);
	}
	
	public void addComponents()
	{
	setLayout(new GridBagLayout());
	
	GridBagConstraints gb = new GridBagConstraints();
	setBackground(Color.WHITE);
	
	gb.gridx=0;
	gb.gridy=0;
	gb.anchor=GridBagConstraints.CENTER;
	add(Header,gb);
			
	gb.gridx=0;
	gb.gridy=1;
	gb.fill=GridBagConstraints.HORIZONTAL;
	add(Encrypt,gb);
	
	gb.gridx=0;
	gb.gridy=2;
	gb.fill=GridBagConstraints.HORIZONTAL;
	add(Decrypt,gb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Encrypt)
		{
			encryptFrame ef= new encryptFrame();
			ef.addComponents();
			
		}else if(e.getSource()==Decrypt)
		{
			decryptFrame df= new decryptFrame();
			df.addComponents();
		}
		
	}
	
	
}
