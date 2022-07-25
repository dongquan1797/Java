package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.XuLyPhanCong;
import Models.DuAn;
import Models.KyNang;
import Models.NhanVien;
import Models.PhanCong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PHANCONG extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tblPhanCong;
	private JPanel panel;
	private JLabel lblMNhnVin;
	private JTextField txtNhanVien_PC;
	private JLabel lblMDn;
	private JTextField txtDuAn_PC;
	private JLabel lblMKNng;
	private JTextField txtKyNang_PC;
	private JButton btnThemPC;
	private JButton btnSuaPC;
	private JButton btnXoaPC;
	private JPanel panel_1;
	private JLabel lblNhpThngTin;
	private JTextField txtTimKiemPC;
	private JButton btnTmKiemPC;
	
	//danh sach phan cong
	ArrayList<PhanCong> dsPhanCong = new ArrayList<>();
	PhanCong phanCong = new PhanCong();
	NhanVien nhanVien = new NhanVien();
	DuAn duAn = new DuAn();
	KyNang kyNang = new KyNang();
	//jtbl
	DefaultTableModel tblModelPhanCong = new DefaultTableModel();
	int idTable;
	//xu ly
	XuLyPhanCong xlPhanCong = new XuLyPhanCong();
	
	//load ds phan cong
	void loadDSPhanCong() {
		dsPhanCong = xlPhanCong.findAll();
		for(PhanCong pc : dsPhanCong){
			Object o[] = {pc.getNhanVien().getMaNV(), pc.getDuAn().getMaDuAn(), pc.getKyNang().getMaKyNang()};
			tblModelPhanCong.addRow(o);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PHANCONG frame = new PHANCONG();
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
	public PHANCONG() {
		setTitle("Phan Cong");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 634);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		//goi ham
		loadDSPhanCong();
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 328, 437, 256);
			scrollPane.setViewportView(getTblPhanCong());
		}
		return scrollPane;
	}
	private JTable getTblPhanCong() {
		if (tblPhanCong == null) {
			tblPhanCong = new JTable();
			tblPhanCong.addMouseListener(new MouseAdapter() {
@Override
				public void mouseClicked(MouseEvent arg0) {
					//xac dinh phan cong dc chon
					idTable = tblPhanCong.getSelectedRow();
					//hien thi thong tin len control
					if(idTable>=0){
						phanCong = dsPhanCong.get(idTable);
						txtNhanVien_PC.setText(Integer.toString(phanCong.getNhanVien().getMaNV()));
						txtDuAn_PC.setText(phanCong.getDuAn().getMaDuAn());
						txtKyNang_PC.setText(phanCong.getKyNang().getMaKyNang());
						
					}
				}
			});
			//xet cot tbl
			tblModelPhanCong.addColumn("Mã Nhân Viên");
			tblModelPhanCong.addColumn("Mã Dự Án");
			tblModelPhanCong.addColumn("Mã Kỹ Năng");
			
			tblPhanCong.setModel(tblModelPhanCong);
		}
		return tblPhanCong;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin Ph\u00E2n c\u00F4ng", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(10, 29, 437, 158);
			panel.setLayout(null);
			panel.add(getLblMNhnVin());
			panel.add(getTxtNhanVien_PC());
			panel.add(getLblMDn());
			panel.add(getTxtDuAn_PC());
			panel.add(getLblMKNng());
			panel.add(getTxtKyNang_PC());
			panel.add(getBtnThemPC());
			panel.add(getBtnSuaPC());
			panel.add(getBtnXoaPC());
		}
		return panel;
	}
	private JLabel getLblMNhnVin() {
		if (lblMNhnVin == null) {
			lblMNhnVin = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn");
			lblMNhnVin.setBounds(27, 28, 100, 14);
		}
		return lblMNhnVin;
	}
	private JTextField getTxtNhanVien_PC() {
		if (txtNhanVien_PC == null) {
			txtNhanVien_PC = new JTextField();
			txtNhanVien_PC.setBackground(Color.PINK);
			txtNhanVien_PC.setBounds(137, 25, 157, 20);
			txtNhanVien_PC.setColumns(10);
		}
		return txtNhanVien_PC;
	}
	private JLabel getLblMDn() {
		if (lblMDn == null) {
			lblMDn = new JLabel("M\u00E3 D\u1EF1 \u00C1n");
			lblMDn.setBounds(27, 69, 100, 14);
		}
		return lblMDn;
	}
	private JTextField getTxtDuAn_PC() {
		if (txtDuAn_PC == null) {
			txtDuAn_PC = new JTextField();
			txtDuAn_PC.setBackground(Color.PINK);
			txtDuAn_PC.setBounds(137, 66, 157, 20);
			txtDuAn_PC.setColumns(10);
		}
		return txtDuAn_PC;
	}
	private JLabel getLblMKNng() {
		if (lblMKNng == null) {
			lblMKNng = new JLabel("M\u00E3 K\u1EF9 N\u0103ng");
			lblMKNng.setBounds(27, 118, 100, 14);
		}
		return lblMKNng;
	}
	private JTextField getTxtKyNang_PC() {
		if (txtKyNang_PC == null) {
			txtKyNang_PC = new JTextField();
			txtKyNang_PC.setBackground(Color.PINK);
			txtKyNang_PC.setBounds(137, 115, 157, 20);
			txtKyNang_PC.setColumns(10);
		}
		return txtKyNang_PC;
	}
	private JButton getBtnThemPC() {
		if (btnThemPC == null) {
			btnThemPC = new JButton("Th\u00EAm");
			btnThemPC.setBackground(Color.PINK);
			btnThemPC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int nv = Integer.parseInt(txtNhanVien_PC.getText());
					String da = txtDuAn_PC.getText();
					String kn = txtKyNang_PC.getText();
					try {
						nhanVien.setMaNV(nv);
						duAn.setMaDuAn(da);
						kyNang.setMaKyNang(kn);
						phanCong = new PhanCong(nhanVien, duAn, kyNang);
						//them vao tbl
                        /*Object o[] = {nhanVien, duAn, kyNang};*/
						Object o[] = {nv, da, kn};
						tblModelPhanCong.addRow(o);
						//them vao csdl
						xlPhanCong.insert(phanCong);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			});
			btnThemPC.setBounds(304, 24, 89, 23);
		}
		return btnThemPC;
	}
	private JButton getBtnSuaPC() {
		if (btnSuaPC == null) {
			btnSuaPC = new JButton("S\u1EEDa");
			btnSuaPC.setBackground(Color.PINK);
			btnSuaPC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//xac dinh phan cong duoc chon de cap nhat
					String da = txtDuAn_PC.getText();
					String kn = txtKyNang_PC.getText();
					phanCong.getDuAn().setMaDuAn(da);
					phanCong.getKyNang().setMaKyNang(kn);
					/*duAn.setMaDuAn(da);
					kyNang.setMaKyNang(kn);*/
					//cap nhat tren tbl
				    /*tblModelPhanCong.setValueAt(nhanVien.getMaNV(), idTable, 0);*/
					tblModelPhanCong.setValueAt(da, idTable, 1);
					tblModelPhanCong.setValueAt(kn, idTable, 2);
					//cap nhat tren csdl
					xlPhanCong.update(phanCong);
					
				}
			});
			btnSuaPC.setBounds(304, 65, 89, 23);
		}
		return btnSuaPC;
	}
	private JButton getBtnXoaPC() {
		if (btnXoaPC == null) {
			btnXoaPC = new JButton("X\u00F3a");
			btnXoaPC.setBackground(Color.PINK);
			btnXoaPC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idTable = tblPhanCong.getSelectedRow();
					if(idTable>=0) {
						//xoa tren tbl
						tblModelPhanCong.removeRow(idTable);
						//xoa trong csdl
						xlPhanCong.delete(phanCong);
					}
				}
			});
			btnXoaPC.setBounds(304, 114, 89, 23);
		}
		return btnXoaPC;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm ", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 197, 437, 123);
			panel_1.setLayout(null);
			panel_1.add(getLblNhpThngTin());
			panel_1.add(getTxtTimKiemPC());
			panel_1.add(getBtnTmKiemPC());
		}
		return panel_1;
	}
	private JLabel getLblNhpThngTin() {
		if (lblNhpThngTin == null) {
			lblNhpThngTin = new JLabel("Nh\u1EADp th\u00F4ng tin li\u00EAn quan \u0111\u1EBFn d\u1EF1 \u00E1n");
			lblNhpThngTin.setBounds(128, 33, 265, 14);
		}
		return lblNhpThngTin;
	}
	private JTextField getTxtTimKiemPC() {
		if (txtTimKiemPC == null) {
			txtTimKiemPC = new JTextField();
			txtTimKiemPC.setBackground(Color.PINK);
			txtTimKiemPC.setBounds(131, 58, 160, 20);
			txtTimKiemPC.setColumns(10);
		}
		return txtTimKiemPC;
	}
	private JButton getBtnTmKiemPC() {
		if (btnTmKiemPC == null) {
			btnTmKiemPC = new JButton("T\u00ECm Ki\u1EBFm");
			btnTmKiemPC.setBackground(Color.PINK);
			btnTmKiemPC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//tim va hien tren tbl
					ArrayList<PhanCong> dsPhanCongTimKiem = xlPhanCong.search(txtTimKiemPC.getText());
					dsPhanCong = dsPhanCongTimKiem ;
					if(dsPhanCongTimKiem.size()==0){
						JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu liên quan");
						
					} else{
						//xoa data tren tbl
						tblModelPhanCong.setRowCount(0);
						//load data len tbl
						for(PhanCong pc : dsPhanCong){
                        Object o[] = {pc.getNhanVien().getMaNV(), pc.getDuAn().getMaDuAn(), pc.getKyNang().getMaKyNang()};
							tblModelPhanCong.addRow(o);
						}
					}
					
				}
			});
			btnTmKiemPC.setBounds(171, 89, 89, 23);
		}
		return btnTmKiemPC;
	}
}