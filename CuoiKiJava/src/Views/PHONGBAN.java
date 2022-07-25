package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controllers.XuLyNhaCungCap;
import Controllers.XuLyPhongBan;
import Controllers.XuLyPhongBan_NhaCungCap;
import Models.KyNang;
import Models.NhaCungCap;
import Models.PhongBan;
import Models.PhongBan_NhaCungCap;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class PHONGBAN extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tblPhongBan;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JTable tblPhongBan_NCC;
	private JLabel lblMaPBNcc;
	private JTextField txtMaNCC;
	private JLabel lblTenPBNcc;
	private JTextField txtTenNCC;
	private JLabel lblNgayLV;
	private JTextField txtDiaChi;
	
	//defalut table
	DefaultTableModel tblModelPhongBan = new DefaultTableModel();
	DefaultTableModel tblModelPhongBan_NCC = new DefaultTableModel();
	//cac bien de xu ly
		XuLyNhaCungCap xlNCC = new XuLyNhaCungCap();
		XuLyPhongBan xlPB = new XuLyPhongBan();
		XuLyPhongBan_NhaCungCap xlPB_NCC = new XuLyPhongBan_NhaCungCap();
		int idtable;
		PhongBan phongBan;
		PhongBan_NhaCungCap phongBan_NCC;
		NhaCungCap nhaCungCap = new NhaCungCap();
		KyNang kyNang = new KyNang();
	//list
		ArrayList<PhongBan> dspb = new ArrayList<PhongBan>();
		ArrayList<PhongBan_NhaCungCap> dspb_ncc = new ArrayList<PhongBan_NhaCungCap>();
		private JButton btnThemNCC;
		private JButton btnCapNhapNCC;
		private JButton btnXoaNCC;
		private JPanel panel_3;
		private JLabel lblPhongBan;
		private JLabel lblTenPhongBan;
		private JLabel lblSdt;
		private JLabel lblMaNcc;
		private JLabel lblMaKyNang;
		private JTextField txtMaPB;
		private JTextField txtTenPB;
		private JTextField txtSDTPB;
		private JTextField txtPB_NCC;
		private JTextField txtPB_KN;
		private JButton btnThemPB;
		private JButton btnCapnhatPB;
		private JButton btnXoaPB;
		
	//loadPB
	public void loadPB() {
		dspb = xlPB.findAll();
		for(PhongBan pb: dspb){
			Object o[] = {pb.getMaPhongBan(), pb.getTenPhongBan(), pb.getSDTPhongBan(), pb.getNcc().getMaNhaCungCap() ,pb.getKyNang().getMaKyNang()};
			tblModelPhongBan.addRow(o);
		}
	}
	//loadPB_NCC
	public void loadPB_NCC() {
		dspb_ncc = xlPB_NCC.findAll();
		for(PhongBan_NhaCungCap pb_ncc: dspb_ncc) {
Object o[] = {pb_ncc.getPhongBan().getMaPhongBan(), pb_ncc.getNhaCungCap().getMaNhaCungCap(), pb_ncc.getNgayLamViec()};
			tblModelPhongBan_NCC.addRow(o);
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PHONGBAN frame = new PHONGBAN();
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
	public PHONGBAN() {
		setTitle("QUẢN LÝ PHÒNG BAN");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 951, 676);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPanel_2());
		contentPane.add(getPanel_3_1());
		contentPane.add(getPanel_1());
		loadPB();
		loadPB_NCC();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(null, "Nha Cung Cap", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 377, 226);
			panel.setLayout(null);
			panel.add(getLblMaPBNcc());
			panel.add(getTxtMaNCC());
			panel.add(getLblTenPBNcc());
			panel.add(getTxtTenNCC());
			panel.add(getLblNgayLV());
			panel.add(getTxtDiaChi());
			panel.add(getBtnThemNCC());
			panel.add(getBtnCapNhapNCC());
			panel.add(getBtnXoaNCC());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(413, 271, 510, 366);
			panel_1.setBackground(Color.PINK);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh S\u00E1ch Ph\u00F2ng Ban", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setLayout(null);
			panel_1.add(getScrollPane());
		}
		return panel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				
			});
			scrollPane.setBounds(10, 21, 490, 334);
			scrollPane.setViewportView(getTblPhongBan());
		}
		return scrollPane;
	}
	private JTable getTblPhongBan() {
		if (tblPhongBan == null) {
			tblPhongBan = new JTable();
			tblPhongBan.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//xac dinh phong ban dang chon
					idtable = tblPhongBan.getSelectedRow();
					
					//hien thi thong tin len control
					if(idtable>=0){
						phongBan = dspb.get(idtable);
						txtMaPB.setText(phongBan.getMaPhongBan());
						txtTenPB.setText(phongBan.getTenPhongBan());
						txtSDTPB.setText(Integer.toString(phongBan.getSDTPhongBan()));
						txtPB_NCC.setText(phongBan.getNcc().getMaNhaCungCap());
						txtPB_KN.setText(phongBan.getKyNang().getMaKyNang());
						
					}
				}
});
			
			
			
			tblModelPhongBan.addColumn("Ma PB");
			tblModelPhongBan.addColumn("Ten PB");
			tblModelPhongBan.addColumn("SDT");
			tblModelPhongBan.addColumn("Ma NCC");
			tblModelPhongBan.addColumn("Ma KN");
			
			tblPhongBan.setModel(tblModelPhongBan);
		}
		return tblPhongBan;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.PINK);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ph\u00F2ng Ban- NCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(10, 271, 377, 366);
			panel_2.setLayout(null);
			panel_2.add(getScrollPane_1());
		}
		return panel_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 31, 357, 324);
			scrollPane_1.setViewportView(getTblPhongBan_NCC());
		}
		return scrollPane_1;
	}
	private JTable getTblPhongBan_NCC() {
		if (tblPhongBan_NCC == null) {
			tblPhongBan_NCC = new JTable();
			tblPhongBan_NCC.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//xac dinh dc pb_ncc dang chon
					idtable = tblPhongBan_NCC.getSelectedRow();
					//hien thi thong tin len tbl
					if(idtable>=0){
						phongBan_NCC = dspb_ncc.get(idtable);
						txtMaNCC.setText(phongBan_NCC.getPhongBan().getMaPhongBan());
						txtTenNCC.setText(phongBan_NCC.getNhaCungCap().getMaNhaCungCap());
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						txtDiaChi.setText(sdf.format(phongBan_NCC.getNgayLamViec()));
					}
				}
			});
			
		tblModelPhongBan_NCC.addColumn("Ma PB");
		tblModelPhongBan_NCC.addColumn("Ma NCC");
		tblModelPhongBan_NCC.addColumn("Ngay lam viec");
		
		tblPhongBan_NCC.setModel(tblModelPhongBan_NCC);
		}
		return tblPhongBan_NCC;
	}
	private JLabel getLblMaPBNcc() {
		if (lblMaPBNcc == null) {
			lblMaPBNcc = new JLabel("Mã phòng ban/ncc");
			lblMaPBNcc.setBackground(Color.WHITE);
			lblMaPBNcc.setBounds(10, 41, 144, 14);
		}
		return lblMaPBNcc;
	}
	private JTextField getTxtMaNCC() {
		if (txtMaNCC == null) {
			txtMaNCC = new JTextField();
			txtMaNCC.setBackground(Color.PINK);
			txtMaNCC.setBounds(164, 38, 187, 20);
			txtMaNCC.setColumns(10);
		}
		return txtMaNCC;
	}
	private JLabel getLblTenPBNcc() {
		if (lblTenPBNcc == null) {
			lblTenPBNcc = new JLabel("Tên phòng ban/ncc");
			lblTenPBNcc.setBounds(10, 85, 144, 14);
		}
		return lblTenPBNcc;
	}
	private JTextField getTxtTenNCC() {
		if (txtTenNCC == null) {
			txtTenNCC = new JTextField();
			txtTenNCC.setBackground(Color.PINK);
			txtTenNCC.setBounds(164, 82, 187, 20);
			txtTenNCC.setColumns(10);
		}
		return txtTenNCC;
	}
	private JLabel getLblNgayLV() {
		if (lblNgayLV == null) {
			lblNgayLV = new JLabel("Ngày làm việc");
			lblNgayLV.setBounds(10, 134, 144, 14);
		}
		return lblNgayLV;
	}
	private JTextField getTxtDiaChi() {
		if (txtDiaChi == null) {
txtDiaChi = new JTextField();
			txtDiaChi.setBackground(Color.PINK);
			txtDiaChi.setBounds(164, 131, 187, 20);
			txtDiaChi.setColumns(10);
		}
		return txtDiaChi;
	}
	private JButton getBtnThemNCC() {
		if (btnThemNCC == null) {
			btnThemNCC = new JButton("Thêm");
			btnThemNCC.setBackground(Color.PINK);
			btnThemNCC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mapb = txtMaNCC.getText();
					String mancc = txtTenNCC.getText();
					String strngaylv = txtDiaChi.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date ngaylv = sdf.parse(strngaylv);
						Object o[] = {mapb, mancc, ngaylv};
						tblModelPhongBan_NCC.addRow(o);
						
						
						//them vao csdl
						xlPB_NCC.insert(phongBan_NCC);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						
						e1.printStackTrace();
					}
				}
			});
			btnThemNCC.setBounds(10, 181, 89, 23);
		}
		return btnThemNCC;
	}
	private JButton getBtnCapNhapNCC() {
		if (btnCapNhapNCC == null) {
			btnCapNhapNCC = new JButton("Cập nhật");
			btnCapNhapNCC.setBackground(Color.PINK);
			btnCapNhapNCC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mapb = txtMaNCC.getText();
					String mancc = txtTenNCC.getText();
					String strngaylv = txtDiaChi.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date ngaylv = sdf.parse(strngaylv);
						
						//cap nhap vao ds phong ban dc chon
						phongBan_NCC.getPhongBan().setMaPhongBan(mapb);
						phongBan_NCC.getNhaCungCap().setMaNhaCungCap(mancc);
						phongBan_NCC.setNgayLamViec(ngaylv);
						//cap nhat tren jtbl
						tblModelPhongBan_NCC.setValueAt(mapb, idtable, 0);
						tblModelPhongBan_NCC.setValueAt(mancc, idtable, 1);
						tblModelPhongBan_NCC.setValueAt(ngaylv, idtable, 2);
						//cap nhat csdl
						xlPB_NCC.update(phongBan_NCC);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnCapNhapNCC.setBounds(136, 181, 89, 23);
		}
		return btnCapNhapNCC;
	}
	private JButton getBtnXoaNCC() {
		if (btnXoaNCC == null) {
			btnXoaNCC = new JButton("Xóa");
			btnXoaNCC.setBackground(Color.PINK);
			btnXoaNCC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//idtable = tblModelPhongBan_NCC.get
					idtable = tblPhongBan_NCC.getSelectedRow();
					
					if(idtable>=0){
						//xoa tren jtbl
						tblModelPhongBan_NCC.removeRow(idtable);
						//xoa trong danh sach pbncc dang chon
						phongBan.getPhongBan_NhaCungCapS().remove(idtable);
						//xoa trong csdl
						xlPB_NCC.delete(phongBan_NCC);
					}	
				}
			});
			btnXoaNCC.setBounds(262, 181, 89, 23);
		}
		return btnXoaNCC;
	}
	private JPanel getPanel_3_1() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ph\u00F2ng Ban", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_3.setBounds(413, 11, 510, 226);
			panel_3.setLayout(null);
			panel_3.add(getLblPhongBan());
			panel_3.add(getLblTenPhongBan());
			panel_3.add(getLblSdt());
			panel_3.add(getLblMaNcc());
			panel_3.add(getLblMaKyNang());
			panel_3.add(getTxtMaPB());
			panel_3.add(getTxtTenPB());
			panel_3.add(getTxtSDTPB());
			panel_3.add(getTxtPB_NCC());
			panel_3.add(getTxtPB_KN());
			panel_3.add(getBtnThemPB());
			panel_3.add(getBtnCapnhatPB());
			panel_3.add(getBtnXoaPB());
		}
		return panel_3;
	}
	private JLabel getLblPhongBan() {
		if (lblPhongBan == null) {
			lblPhongBan = new JLabel("Phòng Ban");
			lblPhongBan.setBounds(24, 24, 121, 14);
		}
		return lblPhongBan;
	}
	private JLabel getLblTenPhongBan() {
		if (lblTenPhongBan == null) {
			lblTenPhongBan = new JLabel("Tên phòng ban");
			lblTenPhongBan.setBounds(24, 59, 121, 14);
		}
		return lblTenPhongBan;
	}
	private JLabel getLblSdt() {
		if (lblSdt == null) {
			lblSdt = new JLabel("SĐT");
			lblSdt.setBounds(24, 97, 121, 14);
		}
		return lblSdt;
	}
	private JLabel getLblMaNcc() {
		if (lblMaNcc == null) {
			lblMaNcc = new JLabel("Mã NCC");
			lblMaNcc.setBounds(24, 143, 121, 14);
		}
		return lblMaNcc;
	}
	private JLabel getLblMaKyNang() {
		if (lblMaKyNang == null) {
			lblMaKyNang = new JLabel("Mã kỹ năng");
			lblMaKyNang.setBounds(24, 187, 121, 14);
		}
		return lblMaKyNang;
	}
	private JTextField getTxtMaPB() {
		if (txtMaPB == null) {
			txtMaPB = new JTextField();
			txtMaPB.setBackground(Color.PINK);
			txtMaPB.setBounds(155, 21, 166, 20);
			txtMaPB.setColumns(10);
		}
		return txtMaPB;
	}
	private JTextField getTxtTenPB() {
		if (txtTenPB == null) {
			txtTenPB = new JTextField();
			txtTenPB.setBackground(Color.PINK);
			txtTenPB.setBounds(155, 56, 166, 20);
			txtTenPB.setColumns(10);
		}
		return txtTenPB;
	}
	private JTextField getTxtSDTPB() {
		if (txtSDTPB == null) {
			txtSDTPB = new JTextField();
			txtSDTPB.setBackground(Color.PINK);
			txtSDTPB.setBounds(155, 94, 166, 20);
			txtSDTPB.setColumns(10);
		}
		return txtSDTPB;
	}
	private JTextField getTxtPB_NCC() {
		if (txtPB_NCC == null) {
			txtPB_NCC = new JTextField();
			txtPB_NCC.setBackground(Color.PINK);
			txtPB_NCC.setBounds(155, 140, 166, 20);
			txtPB_NCC.setColumns(10);
		}
		return txtPB_NCC;
	}
	private JTextField getTxtPB_KN() {
		if (txtPB_KN == null) {
			txtPB_KN = new JTextField();
			txtPB_KN.setBackground(Color.PINK);
			txtPB_KN.setBounds(155, 184, 166, 20);
			txtPB_KN.setColumns(10);
		}
		return txtPB_KN;
	}
	private JButton getBtnThemPB() {
		if (btnThemPB == null) {
			btnThemPB = new JButton("Thêm");
			btnThemPB.setBackground(Color.PINK);
			btnThemPB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ma = txtMaPB.getText();
String ten = txtTenPB.getText();
					int sdt = Integer.parseInt(txtSDTPB.getText());
					String mancc = txtPB_NCC.getText();
					String makn = txtPB_KN.getText();
					//
					nhaCungCap.setMaNhaCungCap(mancc);
					kyNang.setMaKyNang(makn);
					phongBan = new PhongBan(ma, ten, sdt, nhaCungCap, kyNang);
					//them vao tbl
					Object o[] = {ma, ten, sdt, mancc, makn};
					tblModelPhongBan.addRow(o);
					//them vao csdl
					xlPB.insert(phongBan);
				}
			});
			btnThemPB.setBounds(380, 20, 89, 23);
		}
		return btnThemPB;
	}
	private JButton getBtnCapnhatPB() {
		if (btnCapnhatPB == null) {
			btnCapnhatPB = new JButton("Cập nhật");
			btnCapnhatPB.setBackground(Color.PINK);
			btnCapnhatPB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//xac dinh PB dang chon de cap nhat
					
					String ten = txtTenPB.getText();
					int sdt = Integer.parseInt(txtSDTPB.getText());
					String mancc = txtPB_NCC.getText();
					String makn = txtPB_KN.getText();
					//cap nhat vao ds pb dang chon
					phongBan.setTenPhongBan(ten);
					phongBan.setSDTPhongBan(sdt);
					phongBan.getNcc().setMaNhaCungCap(mancc);
					phongBan.getKyNang().setMaKyNang(makn);
					//cap nhat tren tbl
					tblModelPhongBan.setValueAt(phongBan.getMaPhongBan(), idtable, 0);
					tblModelPhongBan.setValueAt(ten, idtable, 1);
					tblModelPhongBan.setValueAt(sdt, idtable, 2);
					tblModelPhongBan.setValueAt(mancc, idtable, 3);
					tblModelPhongBan.setValueAt(makn, idtable, 4);
					//cap nhat tren csdl
					xlPB.update(phongBan);
				}
			});
			btnCapnhatPB.setBounds(380, 93, 89, 23);
		}
		return btnCapnhatPB;
	}
	private JButton getBtnXoaPB() {
		if (btnXoaPB == null) {
			btnXoaPB = new JButton("Xóa");
			btnXoaPB.setBackground(Color.PINK);
			btnXoaPB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idtable = tblPhongBan.getSelectedRow();
					if(idtable>=0){
						//xoa tren tbl
						tblModelPhongBan.removeRow(idtable);
						//xoa trong csdl
						xlPB.delete(phongBan);
					}
					
					
					
				}
			});
			btnXoaPB.setBounds(380, 156, 89, 23);
		}
		return btnXoaPB;
	}
}