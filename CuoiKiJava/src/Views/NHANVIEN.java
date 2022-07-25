package Views;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.XuLyNhanVien;
import Controllers.XuLyThanNhan;
import Models.NhanVien;
import Models.PhongBan;
import Models.ThanNhan;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class NHANVIEN extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JList lstNhanVien;
	private JLabel lblMaNhanVien;
	private JLabel lblHo;
	private JLabel lblTen;
	private JLabel lblGioiTinh;
	private JLabel lblSdt;
	private JTextField txtMaNV;
	private JTextField txtHoNV;
	private JTextField txtTenNV;
	private JTextField txtGioiTinhNV;
	private JTextField txtSDTNV;
	private JLabel lblNgayVaoLam;
	private JLabel lblCongViec;
	private JLabel lblMaPb;
	private JTextField txtNgayVLNV;
	private JTextField txtCongViecNV;
	private JTextField txtMaPBNV;
	private JButton btnThemNV;
	private JButton btnSuaNV;
	private JButton btnXoaNV;
	//jlist
		DefaultListModel<NhanVien> lstModelNhanVien = new DefaultListModel<NhanVien>();
		//ds nhan vien
		ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
		NhanVien nhanVien = new NhanVien();
		ThanNhan thanNhan = new ThanNhan();
		PhongBan phongBan = new PhongBan();
		//jtbl
		DefaultTableModel tblModelThanNhan = new DefaultTableModel();
		// xu ly
		XuLyNhanVien xlNhanVien = new XuLyNhanVien();
		XuLyThanNhan xlThanNhan = new XuLyThanNhan();
		
		//khai bao chi so duoc chon
		int idTable;
		private JLabel lblMaThanNhan_1;
		private JPanel panel_4;
		private JRadioButton rdbtnVo;
		private JRadioButton rdbtnChong;
		private JTextField txtThanNhanNV;
		private JTextField txtTimNV;
		private JButton btnTimNV;
		private JPanel panel_1;
		private JButton btnTimKiem;
		
		
	//xay dung phuong thuc bo tro
		//hien thi danh sach nhan vien da co
		void loadDSNhanVien(){
			dsNhanVien = xlNhanVien.findAll();
			
			//load len lstModel
			for(NhanVien nv: dsNhanVien){
				lstModelNhanVien.addElement(nv);
				//chay khi co db
				/*nv.setThanNhans(xlNhanVien.findThanNhanByID(nv.getMaNV()));*/
				
			}
		}
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NHANVIEN frame = new NHANVIEN();
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
	public NHANVIEN() {
		setBackground(Color.PINK);
		setTitle("Quan Ly Nhan Vien");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		loadDSNhanVien();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.PINK);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nh\u00E2n Vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 466, 658);
			panel.setLayout(null);
			panel.add(getPanel_2());
			panel.add(getLblMaNhanVien());
			panel.add(getLblHo());
			panel.add(getLblTen());
			panel.add(getLblGioiTinh());
			panel.add(getLblSdt());
			panel.add(getTxtMaNV());
			panel.add(getTxtHoNV());
			panel.add(getTxtTenNV());
			panel.add(getTxtGioiTinhNV());
			panel.add(getTxtSDTNV());
			panel.add(getLblNgayVaoLam());
			panel.add(getLblCongViec());
			panel.add(getLblMaPb());
			panel.add(getTxtNgayVLNV());
			panel.add(getTxtCongViecNV());
			panel.add(getTxtMaPBNV());
			panel.add(getBtnThemNV());
			panel.add(getBtnSuaNV());
			panel.add(getBtnXoaNV());
			panel.add(getLblMaThanNhan_1());
			panel.add(getPanel_4_1());
			panel.add(getTxtThanNhanNV());
			panel.add(getPanel_1());
		}
		return panel;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.PINK);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh m\u1EE5c nh\u00E2n vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(10, 404, 446, 243);
			panel_2.setLayout(null);
			panel_2.add(getLstNhanVien());
		}
		return panel_2;
	}
	private JList getLstNhanVien() {
		if (lstNhanVien == null) {
			lstNhanVien = new JList();
			lstNhanVien.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					nhanVien = (NhanVien) lstNhanVien.getSelectedValue();
					//hien thi thong tin nhan vien dc chon
					txtMaNV.setText(Integer.toString(nhanVien.getMaNV()));
					txtHoNV.setText(nhanVien.getHo());
					txtTenNV.setText(nhanVien.getTen());
					txtGioiTinhNV.setText(nhanVien.getGioiTinh());
					txtSDTNV.setText(Integer.toString(nhanVien.getSDT()));
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					txtNgayVLNV.setText(sdf.format(nhanVien.getNgayVaoLam()));
					txtCongViecNV.setText(nhanVien.getCongViec());
					txtMaPBNV.setText(xlNhanVien.findPB(nhanVien.getPhongBan().getMaPhongBan()));
					
					
					//hien thi danh muc tn cua nhan vien dang chon tren jtbl
					//xoa danh muc hien co tren jtbl khi chuyen qua nv khac
					tblModelThanNhan.setRowCount(0);
					//hien thi danh muc cua nhan vien dang chon
					if(nhanVien.getThanNhans()!=null){
						for(ThanNhan tn: nhanVien.getThanNhans()){
							Object o[] = {tn.getMaThanNhan(), tn.getMoiQuanHe()};
							tblModelThanNhan.addRow(o);
							txtThanNhanNV.setText(tn.getMaThanNhan());
						
							if(tn.getMoiQuanHe().toLowerCase().trim().equals("vo")){
								rdbtnVo.setSelected(true);
								rdbtnChong.setSelected(false);
							} else{
								rdbtnChong.setSelected(true);
								rdbtnVo.setSelected(false);
							}
						}
					}
				}
			});
			lstNhanVien.setBounds(10, 24, 426, 208);
			lstNhanVien.setModel(lstModelNhanVien);
		}
		return lstNhanVien;
	}
	private JLabel getLblMaNhanVien() {
		if (lblMaNhanVien == null) {
			lblMaNhanVien = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
			lblMaNhanVien.setBounds(20, 37, 84, 14);
		}
		return lblMaNhanVien;
	}
	private JLabel getLblHo() {
		if (lblHo == null) {
			lblHo = new JLabel("H\u1ECD");
			lblHo.setBounds(20, 76, 84, 14);
		}
		return lblHo;
	}
	private JLabel getLblTen() {
		if (lblTen == null) {
			lblTen = new JLabel("T\u00EAn");
			lblTen.setBounds(20, 110, 84, 14);
		}
		return lblTen;
	}
	private JLabel getLblGioiTinh() {
		if (lblGioiTinh == null) {
			lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh");
			lblGioiTinh.setBounds(20, 157, 84, 14);
		}
		return lblGioiTinh;
	}
	private JLabel getLblSdt() {
		if (lblSdt == null) {
			lblSdt = new JLabel("SDT");
			lblSdt.setBounds(20, 203, 84, 14);
		}
		return lblSdt;
	}
	private JTextField getTxtMaNV() {
		if (txtMaNV == null) {
			txtMaNV = new JTextField();
			txtMaNV.setBounds(114, 34, 86, 20);
			txtMaNV.setColumns(10);
		}
		return txtMaNV;
	}
	private JTextField getTxtHoNV() {
		if (txtHoNV == null) {
			txtHoNV = new JTextField();
			txtHoNV.setBounds(114, 73, 86, 20);
			txtHoNV.setColumns(10);
		}
		return txtHoNV;
	}
	private JTextField getTxtTenNV() {
		if (txtTenNV == null) {
			txtTenNV = new JTextField();
			txtTenNV.setColumns(10);
			txtTenNV.setBounds(114, 107, 86, 20);
		}
		return txtTenNV;
	}
	private JTextField getTxtGioiTinhNV() {
		if (txtGioiTinhNV == null) {
			txtGioiTinhNV = new JTextField();
			txtGioiTinhNV.setColumns(10);
			txtGioiTinhNV.setBounds(114, 154, 86, 20);
		}
		return txtGioiTinhNV;
	}
	private JTextField getTxtSDTNV() {
		if (txtSDTNV == null) {
			txtSDTNV = new JTextField();
			txtSDTNV.setColumns(10);
			txtSDTNV.setBounds(114, 200, 86, 20);
		}
		return txtSDTNV;
	}
	private JLabel getLblNgayVaoLam() {
		if (lblNgayVaoLam == null) {
			lblNgayVaoLam = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
			lblNgayVaoLam.setBounds(240, 37, 89, 14);
		}
		return lblNgayVaoLam;
	}
	private JLabel getLblCongViec() {
		if (lblCongViec == null) {
			lblCongViec = new JLabel("C\u00F4ng vi\u1EC7c");
			lblCongViec.setBounds(240, 76, 89, 14);
		}
		return lblCongViec;
	}
	private JLabel getLblMaPb() {
		if (lblMaPb == null) {
			lblMaPb = new JLabel("M\u00E3 PB");
			lblMaPb.setBounds(240, 110, 89, 14);
		}
		return lblMaPb;
	}
	private JTextField getTxtNgayVLNV() {
		if (txtNgayVLNV == null) {
			txtNgayVLNV = new JTextField();
			txtNgayVLNV.setBounds(339, 34, 86, 20);
			txtNgayVLNV.setColumns(10);
		}
		return txtNgayVLNV;
	}
	private JTextField getTxtCongViecNV() {
		if (txtCongViecNV == null) {
			txtCongViecNV = new JTextField();
			txtCongViecNV.setColumns(10);
			txtCongViecNV.setBounds(339, 73, 86, 20);
		}
		return txtCongViecNV;
	}
	private JTextField getTxtMaPBNV() {
		if (txtMaPBNV == null) {
			txtMaPBNV = new JTextField();
			txtMaPBNV.setColumns(10);
			txtMaPBNV.setBounds(339, 107, 86, 20);
		}
		return txtMaPBNV;
	}
	private JButton getBtnThemNV() {
		if (btnThemNV == null) {
			btnThemNV = new JButton("Th\u00EAm");
			btnThemNV.setBackground(Color.PINK);
			btnThemNV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int ma = Integer.parseInt(txtMaNV.getText());
					String ho = txtHoNV.getText();
					String ten = txtTenNV.getText();
					String gt = txtGioiTinhNV.getText();
					int sdt = Integer.parseInt(txtSDTNV.getText());
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String strngayvl = sdf.format(txtNgayVLNV.getText());
					Date ngayvl;
					try {
						ngayvl = sdf.parse(strngayvl);
						String congviec = txtCongViecNV.getText();
						String pb = txtMaPBNV.getText();
						phongBan.setMaPhongBan(pb);
						nhanVien = new NhanVien(ma, ho, ten, gt, sdt, ngayvl, congviec, phongBan);
						if(dsNhanVien.contains(nhanVien)){
							JOptionPane.showMessageDialog(null, "Ma nhan vien da ton tai");
						} else{
							lstModelNhanVien.addElement(nhanVien);
							dsNhanVien.add(nhanVien);
						}
						xlNhanVien.insert(nhanVien);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnThemNV.setBounds(20, 242, 89, 23);
		}
		return btnThemNV;
	}
	private JButton getBtnSuaNV() {
		if (btnSuaNV == null) {
			btnSuaNV = new JButton("S\u1EEDa");
			btnSuaNV.setBackground(Color.PINK);
			btnSuaNV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idTable = lstNhanVien.getSelectedIndex();
					if(idTable>=0){
						nhanVien = dsNhanVien.get(idTable);
						nhanVien.setHo(txtHoNV.getText());
						nhanVien.setTen(txtTenNV.getText());
						nhanVien.setGioiTinh(txtGioiTinhNV.getText());
						nhanVien.setSDT(Integer.parseInt(txtSDTNV.getText()));
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						try {
							nhanVien.setNgayVaoLam(sdf.parse(txtNgayVLNV.getText()));
							nhanVien.setCongViec(txtCongViecNV.getText());
							nhanVien.getPhongBan().setMaPhongBan(txtMaPBNV.getText());
							
							lstModelNhanVien.setElementAt(nhanVien, idTable);
							xlNhanVien.update(nhanVien);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			});
			btnSuaNV.setBounds(166, 242, 89, 23);
		}
		return btnSuaNV;
	}
	private JButton getBtnXoaNV() {
		if (btnXoaNV == null) {
			btnXoaNV = new JButton("X\u00F3a");
			btnXoaNV.setBackground(Color.PINK);
			btnXoaNV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nhanVien = (NhanVien) lstNhanVien.getSelectedValue();
					xlNhanVien.delete(nhanVien);
					//xoa du lieu hien co tren jlst
					dsNhanVien.remove(nhanVien);
					//xoa tren cac bang dieu khien
					txtMaNV.setText(null);
					txtHoNV.setText(null);
					txtHoNV.setText(null);
					txtGioiTinhNV.setText(null);
					txtSDTNV.setText(null);
					txtNgayVLNV.setText(null);
					txtCongViecNV.setText(null);
					txtMaPBNV.setText(null);
				}
			});
			btnXoaNV.setBounds(315, 242, 89, 23);
		}
		return btnXoaNV;
	}
	private JLabel getLblMaThanNhan_1() {
		if (lblMaThanNhan_1 == null) {
			lblMaThanNhan_1 = new JLabel("M\u00E3 th\u00E2n nh\u00E2n");
			lblMaThanNhan_1.setBounds(240, 154, 89, 14);
		}
		return lblMaThanNhan_1;
	}
	private JPanel getPanel_4_1() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.PINK);
			panel_4.setBounds(245, 179, 156, 47);
			panel_4.setLayout(null);
			panel_4.add(getRdbtnVo());
			panel_4.add(getRdbtnChong());
		}
		return panel_4;
	}
	private JRadioButton getRdbtnVo() {
		if (rdbtnVo == null) {
			rdbtnVo = new JRadioButton("V\u1EE3");
			rdbtnVo.setBackground(Color.PINK);
			rdbtnVo.setBounds(6, 7, 53, 23);
		}
		return rdbtnVo;
	}
	private JRadioButton getRdbtnChong() {
		if (rdbtnChong == null) {
			rdbtnChong = new JRadioButton("Ch\u1ED3ng");
			rdbtnChong.setBackground(Color.PINK);
			rdbtnChong.setBounds(86, 7, 64, 23);
		}
		return rdbtnChong;
	}
	private JTextField getTxtThanNhanNV() {
		if (txtThanNhanNV == null) {
			txtThanNhanNV = new JTextField();
			txtThanNhanNV.setBounds(339, 154, 86, 20);
			txtThanNhanNV.setColumns(10);
		}
		return txtThanNhanNV;
	}
	private JTextField getTxtTimNV() {
		if (txtTimNV == null) {
			txtTimNV = new JTextField();
			txtTimNV.setBounds(10, 43, 206, 20);
			txtTimNV.setColumns(10);
		}
		return txtTimNV;
	}
	private JButton getBtnTimNV() {
		//xoa
		lstModelNhanVien.clear();
		if (btnTimNV == null) {
			btnTimNV = new JButton("Tim");
			btnTimNV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<NhanVien> dsNhanVienTimKiem = xlNhanVien.search(txtTimNV.getText());
					dsNhanVien = dsNhanVienTimKiem ;
					if(dsNhanVienTimKiem.size()==0){
						JOptionPane.showMessageDialog(null, "ko tim thay nhan vien");
						
					} else{
						//xoa data tren jtbl
						//tblModelNhanVien.setRowCount(0);
						lstModelNhanVien.setSize(0);
						
						//load data len jtbl
						for(NhanVien nv: dsNhanVien){
							Object o[] = {nv.getHo(), nv.getTen()};
							lstModelNhanVien.addElement(nv);
						}
					}
				}
			});
			btnTimNV.setBounds(31, 145, 89, 23);
		}
		return btnTimNV;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.PINK);
			panel_1.setBounds(10, 275, 446, 113);
			panel_1.setLayout(null);
			panel_1.add(getTxtTimNV());
			panel_1.add(getBtnTimKiem());
		}
		return panel_1;
	}
	private JButton getBtnTimKiem() {
		if (btnTimKiem == null) {
			btnTimKiem = new JButton("T\u00ECm");
			btnTimKiem.setBackground(Color.WHITE);
			btnTimKiem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						ArrayList<NhanVien> dsNhanVienTimKiem = xlNhanVien.search(txtTimNV.getText());
						dsNhanVien = dsNhanVienTimKiem ;
						if(dsNhanVienTimKiem.size()==0){
							JOptionPane.showMessageDialog(null, "ko tim thay nhan vien");
							
						} else{
							//xoa data tren jtbl
							//tblModelNhanVien.setRowCount(0);
							lstModelNhanVien.setSize(0);
							
							//load data len jtbl
							for(NhanVien nv: dsNhanVien){
								Object o[] = {nv.getHo(), nv.getTen()};
								lstModelNhanVien.addElement(nv);
							}
						}
				}
			});
			btnTimKiem.setBounds(239, 42, 89, 23);
		}
		return btnTimKiem;
	}
}
