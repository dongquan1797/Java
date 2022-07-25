package Views;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.XuLyDuAn;
import Controllers.XuLyThanhPho;
import Models.DuAn;
import Models.KyNang;
import Models.ThanhPho;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class DUAN extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblMaTp;
	private JLabel lblTenTp;
	private JLabel lblTieuBang;
	private JLabel lblDanSo;
	private JTextField txtMaTP;
	private JTextField txtTenTP;
	private JTextField txtTieuBang;
	private JTextField txtDanSo;
	private JButton btnThemTP;
	private JButton btnSuaTP;
	private JButton btnXoaTP;
	private JPanel panel_2;
	private JList lstThanhPho;
	private JLabel lblMaDa;
	private JLabel lblTenDa;
	private JLabel lblKinhPhi;
	private JTextField txtMaDA;
	private JTextField txtTenDA;
	private JTextField txtKinhPhi;
	private JLabel lblMaKn;
	private JTextField txtMaKN_DA;
	private JButton btnThemDA;
	private JButton btnSuaDA;
	private JButton btnXoaDA;
	private JScrollPane scrollPane;
	private JTable tblDuAn;

	
	//jlist
	DefaultListModel<ThanhPho> lstModelThanhPho = new DefaultListModel<ThanhPho>();
	//ds thanh pho
	ArrayList<ThanhPho> dsThanhPho = new ArrayList<ThanhPho>();
	ThanhPho thanhPho = new ThanhPho();
	DuAn duAn = new DuAn();
	KyNang kyNang= new KyNang();
	//jtbl
	DefaultTableModel tblModelDuAn = new DefaultTableModel();
	
	//xuly
	XuLyThanhPho xlThanhPho = new XuLyThanhPho();
	XuLyDuAn xlDuAn = new XuLyDuAn();
	
	int idtable;
	
	
	//loadds thanhpho da co
	void loadDSThanhPho() {
		dsThanhPho = xlThanhPho.findAll();
		//load len lstModel
		for(ThanhPho tp: dsThanhPho){
			lstModelThanhPho.addElement(tp);
			//chay khi co db truyen vao
			tp.setDuAns(xlThanhPho.findDuAnByID(tp.getMaTP()));
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DUAN frame = new DUAN();
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
	public DUAN() {
		setTitle("Quan ly Du An");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 627);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		loadDSThanhPho();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00E0nh Ph\u1ED1", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
			panel.setBounds(10, 11, 358, 566);
			panel.setLayout(null);
			panel.add(getLblMaTp());
			panel.add(getLblTenTp());
			panel.add(getLblTieuBang());
			panel.add(getLblDanSo());
			panel.add(getTxtMaTP());
			panel.add(getTxtTenTP());
			panel.add(getTxtTieuBang());
			panel.add(getTxtDanSo());
			panel.add(getBtnThemTP());
			panel.add(getBtnSuaTP());
			panel.add(getBtnXoaTP());
			panel.add(getPanel_2());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "D\u1EF1 \u00C1n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(378, 11, 457, 566);
			panel_1.setLayout(null);
			panel_1.add(getLblMaDa());
			panel_1.add(getLblTenDa());
			panel_1.add(getLblKinhPhi());
			panel_1.add(getTxtMaDA());
			panel_1.add(getTxtTenDA());
			panel_1.add(getTxtKinhPhi());
			panel_1.add(getLblMaKn());
			panel_1.add(getTxtMaKN_DA());
			panel_1.add(getBtnThemDA());
			panel_1.add(getBtnSuaDA());
			panel_1.add(getBtnXoaDA());
			panel_1.add(getScrollPane());
		}
		return panel_1;
	}
	private JLabel getLblMaTp() {
		if (lblMaTp == null) {
			lblMaTp = new JLabel("Mã TP");
			lblMaTp.setBounds(22, 35, 46, 14);
		}
		return lblMaTp;
	}
	private JLabel getLblTenTp() {
		if (lblTenTp == null) {
			lblTenTp = new JLabel("Tên TP");
			lblTenTp.setBounds(22, 72, 46, 14);
		}
		return lblTenTp;
	}
	private JLabel getLblTieuBang() {
		if (lblTieuBang == null) {
			lblTieuBang = new JLabel("Tiểu bang");
			lblTieuBang.setBounds(22, 107, 60, 14);
		}
		return lblTieuBang;
	}
	private JLabel getLblDanSo() {
		if (lblDanSo == null) {
			lblDanSo = new JLabel("Dân số");
			lblDanSo.setBounds(22, 144, 46, 14);
		}
		return lblDanSo;
	}
	private JTextField getTxtMaTP() {
		if (txtMaTP == null) {
			txtMaTP = new JTextField();
			txtMaTP.setBackground(Color.PINK);
			txtMaTP.setBounds(133, 32, 129, 20);
			txtMaTP.setColumns(10);
		}
		return txtMaTP;
	}
	private JTextField getTxtTenTP() {
		if (txtTenTP == null) {
			txtTenTP = new JTextField();
			txtTenTP.setBackground(Color.PINK);
			txtTenTP.setBounds(133, 69, 130, 20);
			txtTenTP.setColumns(10);
		}
		return txtTenTP;
	}
	private JTextField getTxtTieuBang() {
		if (txtTieuBang == null) {
			txtTieuBang = new JTextField();
			txtTieuBang.setBackground(Color.PINK);
			txtTieuBang.setColumns(10);
			txtTieuBang.setBounds(132, 104, 130, 20);
		}
		return txtTieuBang;
	}
private JTextField getTxtDanSo() {
		if (txtDanSo == null) {
			txtDanSo = new JTextField();
			txtDanSo.setBackground(Color.PINK);
txtDanSo.setColumns(10);
			txtDanSo.setBounds(132, 141, 130, 20);
		}
		return txtDanSo;
	}
	private JButton getBtnThemTP() {
		if (btnThemTP == null) {
			btnThemTP = new JButton("Thêm");
			btnThemTP.setForeground(Color.BLACK);
			btnThemTP.setBackground(Color.PINK);
			btnThemTP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String ma = txtMaTP.getText();
					String ten = txtTenTP.getText();
					String tieuBang = txtTieuBang.getText();
					int danSo = Integer.parseInt(txtDanSo.getText());
					
					thanhPho = new ThanhPho(ma, ten, tieuBang, danSo);
					if(dsThanhPho.contains(thanhPho)){
						JOptionPane.showMessageDialog(null, "Thanh pho da ton tai");
					} else{
						lstModelThanhPho.addElement(thanhPho);
						dsThanhPho.add(thanhPho);
					}
					xlThanhPho.insert(thanhPho);
				}
			});
			btnThemTP.setBounds(10, 191, 89, 23);
		}
		return btnThemTP;
	}
	private JButton getBtnSuaTP() {
		if (btnSuaTP == null) {
			btnSuaTP = new JButton("Sửa");
			btnSuaTP.setBackground(Color.PINK);
			btnSuaTP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idtable = lstThanhPho.getSelectedIndex();
					if(idtable>=0){
						thanhPho = dsThanhPho.get(idtable);
						thanhPho.setTenTP(txtTenTP.getText());
						thanhPho.setTieuBang(txtTieuBang.getText());
						thanhPho.setDanSo(Integer.parseInt(txtDanSo.getText()));
						
						lstModelThanhPho.setElementAt(thanhPho, idtable);
						xlThanhPho.update(thanhPho);
					}
				}
			});
			btnSuaTP.setBounds(125, 191, 89, 23);
		}
		return btnSuaTP;
	}
	private JButton getBtnXoaTP() {
		if (btnXoaTP == null) {
			btnXoaTP = new JButton("Xóa");
			btnXoaTP.setBackground(Color.PINK);
			btnXoaTP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					thanhPho = (ThanhPho) lstThanhPho.getSelectedValue();
					xlThanhPho.delete(thanhPho);
					//xoa du lieu hien co tren jlst
					dsThanhPho.remove(thanhPho);
					lstModelThanhPho.removeElement(thanhPho);
					//xoa tren cac dieu khien
					txtMaTP.setText(null);
					txtTenTP.setText(null);
					txtTieuBang.setText(null);
					txtDanSo.setText(null);
				}
			});
			btnXoaTP.setBounds(243, 191, 89, 23);
		}
		return btnXoaTP;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch th\u00E0nh ph\u1ED1", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
			panel_2.setBounds(10, 238, 338, 317);
			panel_2.setLayout(null);
			panel_2.add(getLstThanhPho());
		}
		return panel_2;
	}
	private JList getLstThanhPho() {
		if (lstThanhPho == null) {
			lstThanhPho = new JList();
lstThanhPho.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					thanhPho = (ThanhPho) lstThanhPho.getSelectedValue();
					//hien thi thong tin thanh pho duoc chon
					txtMaTP.setText(thanhPho.getMaTP());
					txtTenTP.setText(thanhPho.getTenTP());
					txtTieuBang.setText(thanhPho.getTieuBang());
					txtDanSo.setText(Integer.toString(thanhPho.getDanSo()));
//////////////////////////////////////////////////////////////
					// hien thi danh muc du an cua thanh pho dang chon tren jtbl
					// xoa danh muc hien co tren jtbl khi chuyen qua thanh pho khac
					tblModelDuAn.setRowCount(0);
					//hien thi danh muc cua thanh pho dang chon
					if(thanhPho.getDuAns()!=null){
						for(DuAn da: thanhPho.getDuAns()){
							Object o[] = {da.getMaDuAn(), da.getTenDuAn(), da.getKinhPhi(), da.getThanhPho().getMaTP(), da.getKyNang().getMaKyNang()};
							tblModelDuAn.addRow(o);
						}
					}
				}
			});
			lstThanhPho.setBounds(0, 22, 338, 295);
			lstThanhPho.setModel(lstModelThanhPho);
		}
		return lstThanhPho;
	}
	private JLabel getLblMaDa() {
		if (lblMaDa == null) {
			lblMaDa = new JLabel("Mã Dự Án");
			lblMaDa.setBounds(10, 23, 134, 14);
		}
		return lblMaDa;
	}
	private JLabel getLblTenDa() {
		if (lblTenDa == null) {
			lblTenDa = new JLabel("Tên Dự Án");
			lblTenDa.setBounds(10, 59, 134, 14);
		}
		return lblTenDa;
	}
	private JLabel getLblKinhPhi() {
		if (lblKinhPhi == null) {
			lblKinhPhi = new JLabel("Kinh phí");
			lblKinhPhi.setBounds(10, 94, 134, 14);
		}
		return lblKinhPhi;
	}
	private JTextField getTxtMaDA() {
		if (txtMaDA == null) {
			txtMaDA = new JTextField();
			txtMaDA.setBackground(Color.PINK);
			txtMaDA.setBounds(185, 20, 208, 20);
			txtMaDA.setColumns(10);
		}
		return txtMaDA;
	}
	private JTextField getTxtTenDA() {
		if (txtTenDA == null) {
			txtTenDA = new JTextField();
			txtTenDA.setBackground(Color.PINK);
			txtTenDA.setColumns(10);
			txtTenDA.setBounds(185, 56, 208, 20);
		}
		return txtTenDA;
	}
	private JTextField getTxtKinhPhi() {
		if (txtKinhPhi == null) {
			txtKinhPhi = new JTextField();
			txtKinhPhi.setBackground(Color.PINK);
			txtKinhPhi.setColumns(10);
			txtKinhPhi.setBounds(185, 91, 208, 20);
		}
		return txtKinhPhi;
	}
	private JLabel getLblMaKn() {
		if (lblMaKn == null) {
			lblMaKn = new JLabel("Mã kỹ năng");
			lblMaKn.setBounds(10, 122, 134, 20);
		}
		return lblMaKn;
	}
	private JTextField getTxtMaKN_DA() {
		if (txtMaKN_DA == null) {
			txtMaKN_DA = new JTextField();
			txtMaKN_DA.setBackground(Color.PINK);
			txtMaKN_DA.setColumns(10);
			txtMaKN_DA.setBounds(185, 122, 208, 20);
		}
		return txtMaKN_DA;
	}
	private JButton getBtnThemDA() {
		if (btnThemDA == null) {
			btnThemDA = new JButton("Thêm");
			btnThemDA.setBackground(Color.PINK);
			btnThemDA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ma = txtMaDA.getText();
					String ten = txtTenDA.getText();
int kinhPhi = Integer.parseInt(txtKinhPhi.getText());
					String maTP = txtMaTP.getText();
					String maKN = txtMaKN_DA.getText();
					thanhPho.setMaTP(maTP);
					kyNang.setMaKyNang(maKN);
					duAn = new DuAn(ma, ten, kinhPhi, thanhPho, kyNang);
					
					//them vao jtbl
Object o[] = {ma, ten, kinhPhi, maTP, maKN};
					tblModelDuAn.addRow(o);
					//them vao ds thanh pho dc chon
					thanhPho.getDuAns().add(duAn);
					//them vao csdl
					xlDuAn.insert(duAn);
					
					
				}
			});
			btnThemDA.setBounds(10, 184, 89, 23);
		}
		return btnThemDA;
	}
	private JButton getBtnSuaDA() {
		if (btnSuaDA == null) {
			btnSuaDA = new JButton("Sửa");
			btnSuaDA.setBackground(Color.PINK);
			btnSuaDA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//xac dinh du an dang chon de cap nhap
					String ten = txtTenDA.getText();
					int kinhPhi = Integer.parseInt(txtKinhPhi.getText());
					String matp = txtMaTP.getText();
					String makn = txtMaKN_DA.getText();
					thanhPho.setMaTP(matp);
					kyNang.setMaKyNang(makn);
					// cap nhap vao ds du an cua thanh pho dang dc chon
					
					
					duAn.setTenDuAn(ten);
					duAn.setKinhPhi(kinhPhi);
					duAn.setThanhPho(thanhPho);
					duAn.setKyNang(kyNang);
					// cap nhap tren jtbl
					tblModelDuAn.setValueAt(txtMaDA.getText(), idtable, 0);
					tblModelDuAn.setValueAt(ten, idtable, 1);
					tblModelDuAn.setValueAt(kinhPhi, idtable, 2);
					tblModelDuAn.setValueAt(matp, idtable, 3);
					tblModelDuAn.setValueAt(makn, idtable, 4);
					// 4.3 cap nhap tren csdl
					xlDuAn.update(duAn);
				}
			});
			btnSuaDA.setBounds(160, 184, 89, 23);
		}
		return btnSuaDA;
	}
	private JButton getBtnXoaDA() {
		if (btnXoaDA == null) {
			btnXoaDA = new JButton("Xóa");
			btnXoaDA.setBackground(Color.PINK);
			btnXoaDA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idtable = tblDuAn.getSelectedRow();
					
					if (idtable>=0){
						//xoa ten tbl
						tblModelDuAn.removeRow(idtable);
						//xoa trong danh sach du an cua thanh pho dang chon
						thanhPho.getDuAns().remove(idtable);
						//xoa trong csdl
						xlDuAn.delete(duAn);
					}
				}
			});
			btnXoaDA.setBounds(304, 184, 89, 23);
		}
		return btnXoaDA;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 239, 437, 316);
			scrollPane.setViewportView(getTblDuAn());
			scrollPane.setBackground(Color.pink);
		}
		return scrollPane;
	}
	private JTable getTblDuAn() {
		if (tblDuAn == null) {
			tblDuAn = new JTable();
			tblDuAn.setBackground(Color.PINK);
			tblDuAn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//xac dinh du an dang chon
					idtable = tblDuAn.getSelectedRow();
					duAn = thanhPho.getDuAns().get(idtable); //lay chi muc
					//hien thong tin len control
                    /*thanhPho.setMaTP(duAn.getThanhPho().getMaTP());*/
					kyNang.setMaKyNang(duAn.getKyNang().getMaKyNang());		
					txtMaDA.setText(duAn.getMaDuAn().trim());
					txtTenDA.setText(duAn.getTenDuAn());
					txtKinhPhi.setText(Integer.toString(duAn.getKinhPhi()));
				    /*txtMaTP_DA.setText(thanhPho.getMaTP());*/
					txtMaKN_DA.setText(duAn.getKyNang().getMaKyNang().trim());
					
				}
			});
			//xet cot tbl
			tblModelDuAn.addColumn("Mã Dự Án");
			tblModelDuAn.addColumn("Tên Dự Án");
            tblModelDuAn.addColumn("Kinh Phí");
			/*tblModelDuAn.addColumn("Ma TP");*/
			/*tblModelDuAn.addColumn("Mã Kỹ Năng");*/
			
			tblDuAn.setModel(tblModelDuAn);
		}
		return tblDuAn;
	}
}