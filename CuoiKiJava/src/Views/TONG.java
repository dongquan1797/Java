package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.KyNang;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class TONG extends JFrame {

	private JPanel contentPane;
	private JButton btnKyNang;
	private JLabel lblQuanLyNhan;
	private JButton btnNhanVien;
	private JButton btnDuAn;
	private JButton btnPhongBan;
	private JButton btnThoat;
	private JSeparator separator_1;
	private JButton btnPhnCng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TONG frame = new TONG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TONG() {
		setTitle("Giao dien chinh");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 478);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnKyNang());
		contentPane.add(getLblQuanLyNhan());
		contentPane.add(getBtnNhanVien());
		contentPane.add(getBtnDuAn());
		contentPane.add(getBtnPhongBan());
		contentPane.add(getBtnThoat());
		contentPane.add(getSeparator_1());
		contentPane.add(getBtnPhnCng());
	}

	private JButton getBtnKyNang() {
		if (btnKyNang == null) {
			btnKyNang = new JButton("KỸ NĂNG");
			btnKyNang.setFont(new Font("Verdana", Font.PLAIN, 15));
			btnKyNang.setForeground(Color.DARK_GRAY);
			btnKyNang.setBackground(Color.LIGHT_GRAY);
			btnKyNang.setToolTipText("Day la noi tong hop cac ky nang cua nhan vien");
			btnKyNang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showConfirmDialog(null, "B", title, optionType, messageType)
					KYNANG kn = new KYNANG();
					kn.setVisible(true);
				}
			});
			btnKyNang.setBounds(23, 129, 129, 72);
		}
		return btnKyNang;
	}
	private JLabel getLblQuanLyNhan() {
		if (lblQuanLyNhan == null) {
			lblQuanLyNhan = new JLabel("QUẢN LÝ NHÂN SỰ");
			lblQuanLyNhan.setForeground(Color.WHITE);
			lblQuanLyNhan.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuanLyNhan.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblQuanLyNhan.setBounds(170, 27, 283, 87);
		}
		return lblQuanLyNhan;
	}
	private JButton getBtnNhanVien() {
		if (btnNhanVien == null) {
			btnNhanVien = new JButton("NHÂN VIÊN");
			btnNhanVien.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnNhanVien.setForeground(Color.DARK_GRAY);
			btnNhanVien.setBackground(Color.LIGHT_GRAY);
			btnNhanVien.setToolTipText("Tong hop nhan vien va cac than nhan lien quan");
			btnNhanVien.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//JOptionPane.showMessageDialog(null, "BAN DANG DANG NHAP VAO FORM NHAN VIEN");
					NHANVIEN nv = new NHANVIEN();
					nv.setVisible(true);
				}
			});
			btnNhanVien.setBounds(330, 131, 129, 72);
		}
		return btnNhanVien;
	}
	private JButton getBtnDuAn() {
if (btnDuAn == null) {
			btnDuAn = new JButton("DỰ ÁN");
			btnDuAn.setBackground(Color.LIGHT_GRAY);
			btnDuAn.setForeground(Color.DARK_GRAY);
			btnDuAn.setFont(new Font("Verdana", Font.PLAIN, 15));
			btnDuAn.setToolTipText("Tong hop du an va cac thanh pho lien quan");
			btnDuAn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//JOptionPane.showMessageDialog(null, "BAN DANG DANG NHAP VAO FORM DU AN");
					DUAN da = new DUAN();
					da.setVisible(true);
				}
			});
			btnDuAn.setBounds(180, 129, 129, 72);
		}
		return btnDuAn;
	}
	private JButton getBtnPhongBan() {
		if (btnPhongBan == null) {
			btnPhongBan = new JButton("PHÒNG BAN");
			btnPhongBan.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnPhongBan.setForeground(Color.DARK_GRAY);
			btnPhongBan.setBackground(Color.LIGHT_GRAY);
			btnPhongBan.setToolTipText("Tong hop cac phong ban va Nha cung cap");
			btnPhongBan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(null, "BAN DANG DANG NHAP VAO FORM PHONG BAN");
					PHONGBAN pb =new PHONGBAN();
					pb.setVisible(true);
				}
			});
			btnPhongBan.setBounds(486, 131, 129, 72);
		}
		return btnPhongBan;
	}
	private JButton getBtnThoat() {
		if (btnThoat == null) {
			btnThoat = new JButton("THOÁT");
			btnThoat.setFont(new Font("Verdana", Font.PLAIN, 20));
			btnThoat.setForeground(Color.DARK_GRAY);
			btnThoat.setBackground(Color.PINK);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "BAN DANG THOAT");
					System.exit(0);
				}
			});
			btnThoat.setBounds(249, 322, 118, 72);
		}
		return btnThoat;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 93, 639, 14);
		}
		return separator_1;
	}
	private JButton getBtnPhnCng() {
		if (btnPhnCng == null) {
			btnPhnCng = new JButton("PHÂN CÔNG");
			btnPhnCng.setBackground(Color.LIGHT_GRAY);
			btnPhnCng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PHANCONG pc = new PHANCONG();
					pc.setVisible(true);
					
				}
			});
			btnPhnCng.setBounds(23, 218, 191, 72);
		}
		return btnPhnCng;
	}
}