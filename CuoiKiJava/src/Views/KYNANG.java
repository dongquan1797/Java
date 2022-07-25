package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.XuLyKyNang;
import Models.KyNang;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KYNANG extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tblKyNang;
	private JLabel lblMaKiNang;
	private JLabel lblTenKiNang;
	private JLabel lblChuThich;
	private JTextField txtMaKyNang;
	private JTextField txtTenKiNang;
	private JTextField txtChuThichKyNang;
	private JButton btnThemKN;
	private JButton btnSuaKN;
	private JButton btnXoaKN;
	private JButton btnThoatKN;
	private JPanel panel;
	private JLabel lblNhapMaTen;
	private JTextField txtTimKiemKN;
	private JButton btnTimKiemKN;

	
	//danh sach ky nag:
	ArrayList<KyNang> dsKyNang = new ArrayList<>();
	KyNang kyNang;
	//jtbl
	DefaultTableModel tblModelKyNang = new DefaultTableModel();
	//khai bao chi so bang duoc chon
	int idtable;
	//xu ly
	XuLyKyNang xlKyNang = new XuLyKyNang();
	
	//load ds ky nang
	void loadDSKyNang() {
		dsKyNang = xlKyNang.findAll();
		for(KyNang kn: dsKyNang) {
			Object o[] = {kn.getMaKyNang(), kn.getTenKynang(), kn.getChuThich()};
			tblModelKyNang.addRow(o);
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KYNANG frame = new KYNANG();
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
	public KYNANG() {
		setTitle("KỸ NĂNG");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 692, 606);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblMaKiNang());
		contentPane.add(getLblTenKiNang());
		contentPane.add(getLblChuThich());
		contentPane.add(getTxtMaKyNang());
		contentPane.add(getTxtTenKiNang());
		contentPane.add(getTxtChuThichKyNang());
		contentPane.add(getBtnThemKN());
		contentPane.add(getBtnSuaKN());
		contentPane.add(getBtnXoaKN());
		contentPane.add(getBtnThoatKN());
		contentPane.add(getPanel());
		//goi ham
		loadDSKyNang();
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(322, 45, 344, 325);
			scrollPane.setViewportView(getTblKyNang());
					}
					return scrollPane;
				}
				private JTable getTblKyNang() {
					if (tblKyNang == null) {
						tblKyNang = new JTable();
						tblKyNang.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								//xac dinh ky nang dang duoc chon
								idtable = tblKyNang.getSelectedRow();
								//hien thi thong tin len control
								if(idtable>=0){
									kyNang = dsKyNang.get(idtable);
									txtMaKyNang.setText(kyNang.getMaKyNang());
									txtTenKiNang.setText(kyNang.getTenKynang());
									txtChuThichKyNang.setText(kyNang.getChuThich());
									
								}
							}
						});
						//xet cot cho tbl
						tblModelKyNang.addColumn("Ma KN");
						tblModelKyNang.addColumn("Ten KN");
						
						tblKyNang.setModel(tblModelKyNang);
						
					}
					return tblKyNang;
				}
				private JLabel getLblMaKiNang() {
					if (lblMaKiNang == null) {
						lblMaKiNang = new JLabel("Mã kỹ năng");
						lblMaKiNang.setBounds(22, 95, 96, 14);
					}
					return lblMaKiNang;
				}
				private JLabel getLblTenKiNang() {
					if (lblTenKiNang == null) {
						lblTenKiNang = new JLabel("Tên kỹ năng");
						lblTenKiNang.setBounds(22, 145, 96, 14);
					}
					return lblTenKiNang;
				}
				private JLabel getLblChuThich() {
					if (lblChuThich == null) {
						lblChuThich = new JLabel("Chú thích");
						lblChuThich.setBounds(22, 190, 96, 14);
					}
					return lblChuThich;
				}
				private JTextField getTxtMaKyNang() {
					if (txtMaKyNang == null) {
						txtMaKyNang = new JTextField();
						txtMaKyNang.setBounds(142, 92, 107, 20);
						txtMaKyNang.setColumns(10);
					}
					return txtMaKyNang;
				}
				private JTextField getTxtTenKiNang() {
					if (txtTenKiNang == null) {
						txtTenKiNang = new JTextField();
						txtTenKiNang.setBounds(142, 142, 107, 20);
						txtTenKiNang.setColumns(10);
					}
					return txtTenKiNang;
				}
				private JTextField getTxtChuThichKyNang() {
					if (txtChuThichKyNang == null) {
						txtChuThichKyNang = new JTextField();
						txtChuThichKyNang.setBounds(142, 187, 107, 20);
						txtChuThichKyNang.setColumns(10);
					}
					return txtChuThichKyNang;
				}
				private JButton getBtnThemKN() {
					if (btnThemKN == null) {
						btnThemKN = new JButton("Thêm");
						btnThemKN.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String ma = txtMaKyNang.getText();
								String ten = txtTenKiNang.getText();
								String ct = txtChuThichKyNang.getText();
								try{
									kyNang = new KyNang(ma, ten, ct);
									//them vao tbl
									Object o[] = {ma, ten};
									tblModelKyNang.addRow(o);
									//them vao csdl
									xlKyNang.insert(kyNang);
								} catch(Exception e1){
									e1.printStackTrace();
								}
							}
						});
						btnThemKN.setBounds(29, 254, 89, 23);
					}
					return btnThemKN;
				}
				private JButton getBtnSuaKN() {
					if (btnSuaKN == null) {
						btnSuaKN = new JButton("Sửa");
						btnSuaKN.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								//xac dinh ky nang dang chon de cap nhat
								String ten = txtTenKiNang.getText();
								String ct = txtChuThichKyNang.getText();
								//cap nhap vao ds kn dang chon
								kyNang.setTenKynang(ten);
								kyNang.setChuThich(ct);
								//cap nhap tren tbl
								tblModelKyNang.setValueAt(kyNang.getMaKyNang(), idtable, 0);
								tblModelKyNang.setValueAt(ten, idtable, 1);
								
								//cap nhat tren csdl
								xlKyNang.update(kyNang);
							}
						});
						btnSuaKN.setBounds(160, 254, 89, 23);
					}
					return btnSuaKN;
				}
				private JButton getBtnXoaKN() {
					if (btnXoaKN == null) {
						btnXoaKN = new JButton("Xóa");
						btnXoaKN.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								idtable = tblKyNang.getSelectedRow();
								if(idtable>=0){
									//xoa tren tbl
									tblModelKyNang.removeRow(idtable);
									//xoa trong csdl
									xlKyNang.delete(kyNang);
								}
							}
						});
						btnXoaKN.setBounds(29, 324, 89, 23);
					}
					return btnXoaKN;
				}
				private JButton getBtnThoatKN() {
					if (btnThoatKN == null) {
						btnThoatKN = new JButton("Thoát");
						btnThoatKN.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(null, "Nguoi dung dang thoat");
								System.exit(1);
							}
						});
						btnThoatKN.setBounds(160, 324, 89, 23);
					}
					return btnThoatKN;
				}
				private JPanel getPanel() {
					if (panel == null) {
						panel = new JPanel();
						panel.setBackground(Color.PINK);
						panel.setBorder(new TitledBorder(new MatteBorder(16, 1, 1, 1, (Color) new Color(255, 255, 255)), "T\u00ECm ki\u1EBFm K\u1EF9 N\u0103ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
						panel.setBounds(43, 408, 610, 148);
						panel.setLayout(null);
						panel.add(getLblNhapMaTen());
						panel.add(getTxtTimKiemKN());
						panel.add(getBtnTimKiemKN());
					}
					return panel;
				}
				private JLabel getLblNhapMaTen() {
					if (lblNhapMaTen == null) {
						lblNhapMaTen = new JLabel("Nhập mã/ tên kỹ năng");
						lblNhapMaTen.setBounds(244, 49, 133, 14);
					}
					return lblNhapMaTen;
				}
				private JTextField getTxtTimKiemKN() {
					if (txtTimKiemKN == null) {
						txtTimKiemKN = new JTextField();
						txtTimKiemKN.setBounds(222, 78, 152, 20);
						txtTimKiemKN.setColumns(10);
					}
					return txtTimKiemKN;
				}
				private JButton getBtnTimKiemKN() {
					if (btnTimKiemKN == null) {
						btnTimKiemKN = new JButton("Tìm");
						btnTimKiemKN.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								//tim va hien tren tbl
								
								ArrayList<KyNang> dsKyNangTimKiem = xlKyNang.search(txtTimKiemKN.getText());
								dsKyNang = dsKyNangTimKiem;
								if(dsKyNangTimKiem.size()==0){
									JOptionPane.showMessageDialog(null, "ko tim thay ky nang");
									JOptionPane.showMessageDialog(null, "Moi ban nhap lai");
								} else{
									//xoa data tren jtbl
									tblModelKyNang.setRowCount(0);
									//load data len jtbl
									for(KyNang kn: dsKyNang){
										Object o[] = {kn.getMaKyNang(), kn.getTenKynang()};
										tblModelKyNang.addRow(o);
									}
								}
							}
						});
						btnTimKiemKN.setBounds(406, 77, 89, 23);
					}
					return btnTimKiemKN;
				}
			}