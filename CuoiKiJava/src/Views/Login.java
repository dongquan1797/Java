package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;


import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnReset;
	private JButton btnExit;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(Color.PINK);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(getSeparator_1());
		frmLogin.getContentPane().add(getLblNewLabel());
		frmLogin.getContentPane().add(getLblUsername());
		frmLogin.getContentPane().add(getTxtUsername());
		frmLogin.getContentPane().add(getLblPassword());
		frmLogin.getContentPane().add(getSeparator());
		frmLogin.getContentPane().add(getBtnLogin());
		frmLogin.getContentPane().add(getBtnReset());
		frmLogin.getContentPane().add(getBtnExit());
		frmLogin.getContentPane().add(getTxtPassword());
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 57, 434, 14);
		}
		return separator_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ĐĂNG NHẬP");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(150, 11, 156, 29);
		}
		return lblNewLabel;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Tên đăng nhập");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblUsername.setBounds(10, 82, 200, 25);
		}
		return lblUsername;
	}
	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setBounds(220, 82, 204, 20);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Mật khẩu");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblPassword.setBounds(10, 136, 112, 25);
		}
		return lblPassword;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 204, 434, 2);
		}
		return separator;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Đăng nhập");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String password = txtPassword.getText();
					String username = txtUsername.getText();
					
					if(password.contains("123") && username.contains("123")){
						txtPassword.setText(null);
						txtUsername.setText(null);
						
						TONG tg  = new TONG();
						/*tg.main(null);*/
						tg.setVisible(true);
						
						
					} else{
						JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
						/*txtPassword.setText(null);
						txtUsername.setText(null);*/
					}
				}
			});
			btnLogin.setBounds(27, 217, 106, 23);
		}
		return btnLogin;
	}
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("Làm mới");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtUsername.setText(null);
					txtPassword.setText(null);
				}
			});
			btnReset.setBounds(165, 217, 110, 23);
		}
		return btnReset;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Thoát");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnExit.setBounds(304, 217, 106, 23);
		}
		return btnExit;
	}
	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(220, 136, 204, 20);
		}
		return txtPassword;
	}
}
