package com.ujjawal.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ujjawal.chatapp.dao.UserDAO;
import com.ujjawal.chatapp.dto.UserDTO;
import com.ujjawal.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		UserScreen window = new UserScreen();
	}

	public UserScreen() {
		setBackground(Color.BLACK);
		setResizable(false);
		setTitle("Login");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(292, 56, 224, 49);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(288, 174, 370, 32);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel useridlbl = new JLabel("User ID");
		useridlbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		useridlbl.setBounds(155, 177, 84, 23);
		getContentPane().add(useridlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pwdlbl.setBounds(155, 241, 84, 23);
		getContentPane().add(pwdlbl);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setBackground(Color.CYAN);
		loginbt.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		loginbt.setBounds(262, 331, 112, 40);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setBackground(Color.RED);
		registerbt.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		registerbt.setBounds(438, 331, 112, 40);
		getContentPane().add(registerbt);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(288, 238, 370, 32);
		getContentPane().add(passwordField);
		initialize();
	}
	
	UserDAO userDAO = new UserDAO();

	protected void doLogin() {
		// TODO Auto-generated method stub
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message = "";
			if(userDAO.isLogin(userDTO)) {
				message = "Welcome "+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				DashBoard dashBoard = new DashBoard(message);
				dashBoard.setVisible(true);
			}else {
				message = "Invalid Userid or Password";
				JOptionPane.showMessageDialog(this, message);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void register() {
		// TODO Auto-generated method stub
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			int result = userDAO.add(userDTO);
			if (result>0) {
				JOptionPane.showMessageDialog(this, "Registers Successfully");
//				System.out.println("Record Added...");
			} else {
				JOptionPane.showMessageDialog(this, "Registers Fail");
//				System.out.println("Record not Added...");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error...");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error...");
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Some generic Exception..");
			ex.printStackTrace();
		}
	}

	private void initialize() {
		setSize(833, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
