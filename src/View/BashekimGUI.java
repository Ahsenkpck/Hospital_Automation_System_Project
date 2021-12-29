package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.*;
import Helper.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class BashekimGUI extends JFrame {

	static Bashekim bashekim=new Bashekim();
	Clinic clinic = new Clinic();
	private JPanel w_pane;
	private JTextField fld_dName;
	private JTextField fld_dTcno;
	private JPasswordField fld_dPass;
	private JTextField fld_doctorID;
	private JTable table_doctor;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;
	private JTextField fld_clinicName;
	private JTable table_Clinic;
	private JTextField fld_ClinicName;
	private DefaultTableModel clinicModel = null;
	private Object[] clinicData = null;
	private JPopupMenu clinicMenu;
	private JTable table_worker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BashekimGUI frame = new BashekimGUI(bashekim);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public BashekimGUI(Bashekim bashekim) throws SQLException {
		
		   //Doctor Model
				doctorModel = new DefaultTableModel();
				Object[] colDoctorName = new Object[4];
				colDoctorName[0] = "ID";
				colDoctorName[1] = "Ad Soyad";
				colDoctorName[2] = "TC No";
				colDoctorName[3] = "Þifre";
				doctorModel.setColumnIdentifiers(colDoctorName);
				doctorData = new Object[4];
				for (int i = 0; i < bashekim.getDoctorList().size(); i++) {
					doctorData[0] = bashekim.getDoctorList().get(i).getId();
					doctorData[1] = bashekim.getDoctorList().get(i).getName();
					doctorData[2] = bashekim.getDoctorList().get(i).getTcno();
					doctorData[3] = bashekim.getDoctorList().get(i).getPassword();

					doctorModel.addRow(doctorData);
				}
				
				// Clinic Model
				clinicModel = new DefaultTableModel();
				Object[] colClinic = new Object[2];
				colClinic[0] = "ID";
				colClinic[1] = "Poliklinik Adý";
				clinicModel.setColumnIdentifiers(colClinic);
				clinicData = new Object[2];
				for (int i = 0; i < clinic.getList().size(); i++) {
					clinicData[0] = clinic.getList().get(i).getId();
					clinicData[1] = clinic.getList().get(i).getName();
					clinicModel.addRow(clinicData);
				}
		
				DefaultTableModel workerModel=new DefaultTableModel();
				Object[] colWorker=new Object[2];
				colWorker[0]="ID";
				colWorker[1]="Ad Soyad";
				workerModel.setColumnIdentifiers(colWorker);
				Object[] workerData=new Object[2];
				
		
		setTitle("Hastane Y\u00F6netim Sistemi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoþgeldiniz, Sayýn "+ bashekim.getName());
		lblNewLabel.setBounds(10, 23, 339, 26);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login=new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(601, 28, 108, 23);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		w_pane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 89, 714, 361);
		w_pane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Doktor Yönetimi", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setBounds(549, 11, 139, 23);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1);
		
		fld_dName = new JTextField();
		fld_dName.setBounds(549, 32, 139, 29);
		fld_dName.setColumns(10);
		panel_1.add(fld_dName);
		
		JLabel lblNewLabel_1_1 = new JLabel("T.C No");
		lblNewLabel_1_1.setBounds(549, 72, 139, 23);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1);
		
		fld_dTcno = new JTextField();
		fld_dTcno.setBounds(549, 93, 139, 29);
		fld_dTcno.setColumns(10);
		panel_1.add(fld_dTcno);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u015Eifre");
		lblNewLabel_1_1_1.setBounds(549, 133, 139, 23);
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1);
		
		fld_dPass = new JPasswordField();
		fld_dPass.setBounds(549, 153, 139, 29);
		panel_1.add(fld_dPass);
		
		JButton btn_addDoctor = new JButton("Ekle");
		btn_addDoctor.setBounds(549, 201, 139, 23);
		
		btn_addDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_dName.getText().length() == 0 || fld_dPass.getText().length() == 0
						|| fld_dTcno.getText().length() == 0) {
					Helper.showMessage("fill");

				} else {
					try {
						boolean control = bashekim.addDoctor(fld_dTcno.getText(), fld_dPass.getText(),
								fld_dName.getText());
						if (control) {
							Helper.showMessage("success");
							fld_dName.setText(null);
							fld_dTcno.setText(null);
							fld_dPass.setText(null);
							updateDoctorModel();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}
			}
		});
		panel_1.add(btn_addDoctor);
		
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Kullan\u0131c\u0131 ID");
		lblNewLabel_1_2.setBounds(559, 232, 129, 23);
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_2);
		
		fld_doctorID = new JTextField();
		fld_doctorID.setBounds(549, 255, 139, 20);
		fld_doctorID.setColumns(10);
		panel_1.add(fld_doctorID);
		
		JButton btn_delDoctor = new JButton("Sil");
		btn_delDoctor.setBounds(549, 286, 139, 23);
		btn_delDoctor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (fld_doctorID.getText().length() == 0) {
					Helper.showMessage("Lütfen geçerli bir doktor seçiniz!");
				} else {
					if (Helper.confirm("sure")) {
						int selectID = Integer.parseInt(fld_doctorID.getText());

						try {
							boolean control = bashekim.deleteDoctor(selectID);
							if (control) {
								Helper.showMessage("success");
								fld_doctorID.setText(null);
								updateDoctorModel();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		panel_1.add(btn_delDoctor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 304, 529, -291);
		panel_1.add(scrollPane);
		
		JScrollPane w_scrollDoctor = new JScrollPane();
		w_scrollDoctor.setBounds(10, 11, 529, 311);
		panel_1.add(w_scrollDoctor);
		
		table_doctor = new JTable(doctorModel);
		w_scrollDoctor.setViewportView(table_doctor);
		
		table_doctor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					fld_doctorID.setText(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString());
				} catch (Exception ex) {

				}
			}

		});

		table_doctor.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer
							.parseInt(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString());
					String selectName = table_doctor.getValueAt(table_doctor.getSelectedRow(), 1).toString();
					String selectTcNo = table_doctor.getValueAt(table_doctor.getSelectedRow(), 2).toString();
					String selectPass = table_doctor.getValueAt(table_doctor.getSelectedRow(), 3).toString();

					try {
						boolean control = bashekim.updateDoctor(selectID, selectTcNo, selectPass, selectName);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		
		
		JPanel w_clinic = new JPanel();
		w_clinic.setBackground(Color.WHITE);
		tabbedPane.addTab("Poliklinikler", null, w_clinic, null);
		w_clinic.setLayout(null);
		
		JScrollPane w_scrollClinic = new JScrollPane();
		w_scrollClinic.setBounds(10, 11, 307, 311);
		w_clinic.add(w_scrollClinic);
		
		
		clinicMenu =new JPopupMenu();
		JMenuItem updateMenu =new JMenuItem("Güncelle");
		JMenuItem deleteMenu =new JMenuItem("Sil");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);
		
		updateMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selId=Integer.parseInt(table_Clinic.getValueAt(table_Clinic.getSelectedRow(),0).toString());
				Clinic selectClinic=clinic.getFetch(selId);
				UpdateClinicGUI updateGUI =new UpdateClinicGUI(selectClinic);
				updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateGUI.setVisible(true);
				updateGUI.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						try {
							updateClinicModel();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
			}
			
			
		});
		
		deleteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(Helper.confirm("sure")) {
				int selId=Integer.parseInt(table_Clinic.getValueAt(table_Clinic.getSelectedRow(),0).toString());
				try {
					if(clinic.deleteClinic(selId)) {
						Helper.showMessage("success");
						updateClinicModel();
					}else {
						Helper.showMessage("error");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			}
		});
		
		
		table_Clinic = new JTable(clinicModel);
		table_Clinic.setComponentPopupMenu(clinicMenu);
		table_Clinic.addMouseListener(new MouseAdapter() {
			
			 @Override
			public void mousePressed(MouseEvent e) {
			Point point= e.getPoint();
			int selectedRow=table_Clinic.rowAtPoint(point);
			table_Clinic.setRowSelectionInterval(selectedRow,selectedRow);
		
			}
		});
		w_scrollClinic.setViewportView(table_Clinic);
		
		JLabel lblNewLabel_1_3 = new JLabel("Poliklinik Ad\u0131");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(327, 6, 139, 23);
		w_clinic.add(lblNewLabel_1_3);
		
		fld_ClinicName = new JTextField();
		fld_ClinicName.setColumns(10);
		fld_ClinicName.setBounds(327, 36, 139, 29);
		w_clinic.add(fld_ClinicName);
		
		JButton btn_addClinic = new JButton("Ekle");
		btn_addClinic.setBounds(327, 76, 139, 29);
		w_clinic.add(btn_addClinic);
		btn_addClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_ClinicName.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {
					try {
						if (clinic.addClinic(fld_ClinicName.getText())) {
							Helper.showMessage("success");
							fld_ClinicName.setText(null);
							updateClinicModel();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	
		
		JScrollPane w_scrollWorker = new JScrollPane();
		w_scrollWorker.setBounds(476, 11, 223, 311);
		w_clinic.add(w_scrollWorker);
		
		table_worker = new JTable();
		w_scrollWorker.setViewportView(table_worker);
		
		JComboBox select_doctor = new JComboBox();
		for(int i=0;i<bashekim.getDoctorList().size();i++) {
			select_doctor.addItem(new Item(bashekim.getDoctorList().get(i).getId(),bashekim.getDoctorList().get(i).getName()));
		}
		select_doctor.addActionListener(e->{
			JComboBox c=(JComboBox) e.getSource();
			Item item=(Item)c.getSelectedItem();
			System.out.println(item.getKey()+":"+item.getValue());
		});
		select_doctor.setBounds(327, 240, 139, 29);
		w_clinic.add(select_doctor);
		
		JButton btn_addWorker = new JButton("Ekle");
		btn_addWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow=table_Clinic.getSelectedRow();
				if(selRow >= 0) {
					String selClinic=table_Clinic.getModel().getValueAt(selRow,0).toString();
					int selClinicID=Integer.parseInt(selClinic);
					Item doctorItem=(Item) select_doctor.getSelectedItem();
					try {
						boolean control= bashekim.addWorker(doctorItem.getKey(),selClinicID);
						if(control) {
							Helper.showMessage("success");
							DefaultTableModel clearModel=(DefaultTableModel) table_worker.getModel();
							clearModel.setRowCount(0);
							
							for(int i=0;i< bashekim.getClinicDoctorList(selClinicID).size();i++) {
								workerData[0]=bashekim.getClinicDoctorList(selClinicID).get(i).getId();
								workerData[1]=bashekim.getClinicDoctorList(selClinicID).get(i).getName();
								workerModel.addRow(workerData);
								
							}
							table_worker.setModel(workerModel);
						}else {
							Helper.showMessage("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					Helper.showMessage("Lütfen bir poliklinik seçiniz!");
				}
				
			}
		});
		btn_addWorker.setBounds(327, 280, 139, 29);
		w_clinic.add(btn_addWorker);
		
		JButton btn_workerSelect = new JButton("Se\u00E7");
		btn_workerSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow=table_Clinic.getSelectedRow();
				if(selRow >=0) {
					String selClinic=table_Clinic.getModel().getValueAt(selRow,0).toString();
					int selClinicID=Integer.parseInt(selClinic);
					DefaultTableModel clearModel=(DefaultTableModel) table_worker.getModel();
					clearModel.setRowCount(0);
					
					try {
						for(int i=0;i< bashekim.getClinicDoctorList(selClinicID).size();i++) {
							workerData[0]=bashekim.getClinicDoctorList(selClinicID).get(i).getId();
							workerData[1]=bashekim.getClinicDoctorList(selClinicID).get(i).getName();
							workerModel.addRow(workerData);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table_worker.setModel(workerModel);
				}else {
					Helper.showMessage("Lütfen bir poliklinik seçiniz!");
				}
				
				
			}
		});
		btn_workerSelect.setBounds(327, 166, 139, 29);
		w_clinic.add(btn_workerSelect);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Poliklinik Ad\u0131");
		lblNewLabel_1_3_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(327, 138, 139, 23);
		w_clinic.add(lblNewLabel_1_3_1);
		
		
		
	}
	
	public void updateDoctorModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_doctor.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < bashekim.getDoctorList().size(); i++) {
			doctorData[0] = bashekim.getDoctorList().get(i).getId();
			doctorData[1] = bashekim.getDoctorList().get(i).getName();
			doctorData[2] = bashekim.getDoctorList().get(i).getTcno();
			doctorData[3] = bashekim.getDoctorList().get(i).getPassword();

			doctorModel.addRow(doctorData);
		}
	}
	
	public void updateClinicModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_Clinic.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < clinic.getList().size(); i++) {
			clinicData[0] = clinic.getList().get(i).getId();
			clinicData[1] = clinic.getList().get(i).getName();
			clinicModel.addRow(clinicData);
		}
	}
}
