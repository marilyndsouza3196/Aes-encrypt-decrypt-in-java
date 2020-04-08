package Aes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class decryptFrame extends JFrame implements ActionListener{
	JButton Choose;
	JButton Decrypt;
	JLabel Header;
	JLabel EncryptFile;
	JTextField Secret;
	File file1;
	String fileCopy;
	String content ;
	String encryptFile;
	String secretkey;
	
	public decryptFrame()
	{
		Choose= new JButton("Choose");
		EncryptFile= new JLabel();
		Secret= new JTextField();
		Decrypt = new JButton("SAve");
		Header = new JLabel("AES Decryption");
		Choose.addActionListener(this);
		Decrypt.addActionListener(this);
		Header.setFont(new Font("San-Serif", Font.ITALIC, 18));
		setSize(400,400);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(" Decryption ");
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
	add(EncryptFile,gb);
	
	gb.gridx=1;
	gb.gridy=1;
	gb.fill=GridBagConstraints.HORIZONTAL;
	add(Choose,gb);
	
	gb.gridx=0;
	gb.gridy=2;
	gb.fill=GridBagConstraints.HORIZONTAL;
	add(Secret,gb);
	
	gb.gridx=0;
	gb.gridy=3;
	gb.fill=GridBagConstraints.HORIZONTAL;
	add(Decrypt,gb);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Choose)
		{
			JFileChooser f= new JFileChooser();
			int i = f.showOpenDialog(this);
			if(i==JFileChooser.APPROVE_OPTION)
			{
				file1= f.getSelectedFile().getAbsoluteFile();
				fileCopy= f.getSelectedFile().getAbsolutePath();
				EncryptFile.setText(f.getSelectedFile().getAbsolutePath());
				try {
					content = new String (Files.readAllBytes(Paths.get(fileCopy)));
					//System.out.println(content);    
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}if(e.getSource()==Decrypt)
		{
			JFileChooser f1 = new JFileChooser();
		 int i1 =f1.showSaveDialog(this);
		 if(i1== JFileChooser.APPROVE_OPTION)
		 {
			 fileCopy= f1.getSelectedFile().getAbsolutePath();
			 secretkey= Secret.getText();
			encryptFile=Security.decrypt(content, secretkey); 
			byte[] buff=encryptFile.getBytes();
			try (FileOutputStream fos= new FileOutputStream(fileCopy)){
				for(int i=0;i<buff.length;i++)
				{
					fos.write(buff[i]);
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
	}
		}
		}
}
