package main.frames;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JFMain extends javax.swing.JFrame {
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnScale;
	private javax.swing.JButton btnRemove;
	private javax.swing.JButton btnRotate;
	private javax.swing.JButton btnTranslate;
	private javax.swing.JButton btnDistPlanes;
	private javax.swing.JButton btnDistAirport;
	private javax.swing.JButton btnCollisionCourse;	
	
	private javax.swing.JScrollPane jScrollPane1;
	
	private javax.swing.JSeparator jSeparator1;
	
	private javax.swing.JLabel lblReport;
	private javax.swing.JLabel lblPlaneTable;
	
	private javax.swing.JPanel pnlLayout;
	private javax.swing.JPanel pnlRadar;
	
	private javax.swing.JScrollPane scpPlane;
	
	private javax.swing.JTable tblPlane;
	
	private javax.swing.JTextArea txtReport;

	public JFMain() {
		initComponents();
		updateTable();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		final java.awt.Color colorFirstButton = new java.awt.Color(230, 230, 230);
		final java.awt.Color colorSecondButton = new java.awt.Color(153, 230, 255);
		final java.awt.Color colorTables = new java.awt.Color(105,105,105);
		
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();

		jLabel1.setText("Radar");
		jLabel2.setText("Transformation Functions");
		jLabel3.setText("Tracking Functions");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Plane radar");
		
		pnlLayout = new javax.swing.JPanel();
		pnlLayout.setPreferredSize(new java.awt.Dimension(900, 600));
		
		tblPlane = new javax.swing.JTable();
		tblPlane.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "ID", "X", "Y", "R", "A", "V", "D" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class,
					java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		
		scpPlane = new javax.swing.JScrollPane();
		scpPlane.setViewportView(tblPlane);
		
		if (tblPlane.getColumnModel().getColumnCount() > 0) {
			tblPlane.getColumnModel().getColumn(0).setResizable(false);
			tblPlane.getColumnModel().getColumn(0).setPreferredWidth(30);
			tblPlane.getColumnModel().getColumn(1).setResizable(false);
			tblPlane.getColumnModel().getColumn(1).setPreferredWidth(30);
			tblPlane.getColumnModel().getColumn(2).setResizable(false);
			tblPlane.getColumnModel().getColumn(2).setPreferredWidth(30);
			tblPlane.getColumnModel().getColumn(3).setResizable(false);
			tblPlane.getColumnModel().getColumn(3).setPreferredWidth(30);
			tblPlane.getColumnModel().getColumn(4).setResizable(false);
			tblPlane.getColumnModel().getColumn(4).setPreferredWidth(30);
			tblPlane.getColumnModel().getColumn(5).setResizable(false);
			tblPlane.getColumnModel().getColumn(5).setPreferredWidth(30);
			tblPlane.getColumnModel().getColumn(6).setResizable(false);
			tblPlane.getColumnModel().getColumn(6).setPreferredWidth(30);
		}

		btnAdd = new javax.swing.JButton();
		btnAdd.setText("Add");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AdicionaAvio();
				btnAdd.setEnabled(false);
			}
		});

		btnRemove = new javax.swing.JButton();
		btnRemove.setText("Remove");
		btnRemove.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnRemoverActionPerformed(evt);
			}
		});

		lblPlaneTable = new javax.swing.JLabel();
		lblPlaneTable.setText("Plane table");
		
		lblReport = new javax.swing.JLabel();
		lblReport.setText("Report");

		pnlRadar = new javax.swing.JPanel();
		pnlRadar.setBackground(colorTables);
		pnlRadar.setPreferredSize(new java.awt.Dimension(400, 400));

		javax.swing.GroupLayout pnlRadarLayout = new javax.swing.GroupLayout(pnlRadar);
		pnlRadar.setLayout(pnlRadarLayout);
		pnlRadarLayout.setHorizontalGroup(pnlRadarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		pnlRadarLayout.setVerticalGroup(pnlRadarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));

		

		jSeparator1 = new javax.swing.JSeparator();
		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		txtReport = new javax.swing.JTextArea();
		txtReport.setEditable(false);
		txtReport.setColumns(20);
		txtReport.setRows(5);
		txtReport.setFocusable(false);
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setViewportView(txtReport);		

		btnScale = new javax.swing.JButton();
		btnScale.setBackground(colorFirstButton);
		btnScale.setText("Scale");
		btnScale.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnScaleActionPerformed(evt);
			}
		});

		btnTranslate = new javax.swing.JButton();
		btnTranslate.setBackground(colorFirstButton);
		btnTranslate.setText("Translate");
		btnTranslate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnTranslateActionPerformed(evt);
			}
		});

		btnRotate = new javax.swing.JButton();
		btnRotate.setBackground(colorFirstButton);
		btnRotate.setText("Rotate");
		btnRotate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnRotateActionPerformed(evt);
			}
		});

		btnDistAirport = new javax.swing.JButton();
		btnDistAirport.setBackground(colorSecondButton);
		btnDistAirport.setText("Distance to Airport");
		btnDistAirport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnDistAirportActionPerformed(evt);
			}
		});

		btnDistPlanes = new javax.swing.JButton();
		btnDistPlanes.setBackground(colorSecondButton);
		btnDistPlanes.setText("Distance Airplanes");
		btnDistPlanes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnDistPlanesActionPerformed(evt);
			}
		});

		btnCollisionCourse = new javax.swing.JButton(); 
		btnCollisionCourse.setBackground(colorSecondButton);
		btnCollisionCourse.setText("Collision course");
		btnCollisionCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnCollisionCourseActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlLayoutLayout = new javax.swing.GroupLayout(pnlLayout);
		pnlLayout.setLayout(pnlLayoutLayout);
		pnlLayoutLayout.setHorizontalGroup(pnlLayoutLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlLayoutLayout.createSequentialGroup().addGroup(pnlLayoutLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlLayoutLayout.createSequentialGroup().addGap(41, 41, 41)
								.addGroup(pnlLayoutLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(pnlRadar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jScrollPane1))
								.addGap(18, 18, 18))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												pnlLayoutLayout.createSequentialGroup().addComponent(jLabel1)
														.addGap(208, 208, 208))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												pnlLayoutLayout.createSequentialGroup().addComponent(lblReport)
														.addGap(195, 195, 195)))))
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
						.addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup()
												.addComponent(btnCollisionCourse, javax.swing.GroupLayout.PREFERRED_SIZE,
														150, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(133, 133, 133))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup().addComponent(jLabel3).addGap(149, 149,
												149))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup().addComponent(jLabel2).addGap(144, 144,
												144))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup().addGroup(pnlLayoutLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(pnlLayoutLayout.createSequentialGroup()
														.addComponent(btnDistAirport,
																javax.swing.GroupLayout.PREFERRED_SIZE, 150,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnDistPlanes,
																javax.swing.GroupLayout.PREFERRED_SIZE, 150,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(pnlLayoutLayout.createSequentialGroup().addGap(124, 124, 124)
														.addComponent(lblPlaneTable))
												.addComponent(scpPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
														Short.MAX_VALUE)
												.addGroup(pnlLayoutLayout.createSequentialGroup()
														.addComponent(btnAdd, 
																	  javax.swing.GroupLayout.PREFERRED_SIZE, 
																	  98,
																	  javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRemove,
																      javax.swing.GroupLayout.PREFERRED_SIZE, 
																      98,
																      javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(pnlLayoutLayout.createSequentialGroup()
														.addComponent(btnScale,
																javax.swing.GroupLayout.PREFERRED_SIZE, 98,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(btnTranslate,
																javax.swing.GroupLayout.PREFERRED_SIZE, 98,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(btnRotate,
																javax.swing.GroupLayout.PREFERRED_SIZE, 98,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(46, 46, 46)))));
		pnlLayoutLayout.setVerticalGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlLayoutLayout.createSequentialGroup().addContainerGap().addGroup(pnlLayoutLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1)
						.addGroup(pnlLayoutLayout.createSequentialGroup()
								.addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblPlaneTable).addComponent(jLabel1))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addComponent(pnlRadar, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8,
														Short.MAX_VALUE)
												.addComponent(lblReport)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addComponent(scpPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(pnlLayoutLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(btnAdd).addComponent(btnRemove))
												.addGap(33, 33, 33).addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(pnlLayoutLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(btnScale,
																javax.swing.GroupLayout.PREFERRED_SIZE, 48,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btnTranslate,
																javax.swing.GroupLayout.PREFERRED_SIZE, 48,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btnRotate,
																javax.swing.GroupLayout.PREFERRED_SIZE, 48,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(27, 27, 27).addComponent(jLabel3).addGap(18, 18, 18)
												.addGroup(pnlLayoutLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(btnDistPlanes,
																javax.swing.GroupLayout.PREFERRED_SIZE, 50,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btnDistAirport,
																javax.swing.GroupLayout.PREFERRED_SIZE, 50,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnCollisionCourse, javax.swing.GroupLayout.PREFERRED_SIZE,
														50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE)))))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnlLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnlLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
		setLocationRelativeTo(null);
	}

	private void updateTable() {
		startPlaneLayout();
	}
	
	private void startPlaneLayout() {
		URL url = getClass().getResource("../images/airport.png");        
        JLabel label = new JLabel(new ImageIcon(url));
        label.setBounds(201 - (30/2), 200 - (30/2), 30, 30);
        pnlRadar.add(label);
        
        // Horizontal lines
        JSeparator sep1 = new JSeparator();
        sep1.setBounds(0, 50, pnlRadar.getWidth(), 5);
        sep1.setVisible(true);
        pnlRadar.add(sep1);
        
        JSeparator sep2 = new JSeparator();
        sep2.setBounds(0, 100, pnlRadar.getWidth(), 5);
        sep2.setVisible(true);
        pnlRadar.add(sep2);
        
        JSeparator sep3 = new JSeparator();
        sep3.setBounds(0, 150, pnlRadar.getWidth(), 5);
        sep3.setVisible(true);
        pnlRadar.add(sep3);
        
        JSeparator sep4 = new JSeparator();
        sep4.setBounds(0, 200, pnlRadar.getWidth(), 5);
        sep4.setVisible(true);
        pnlRadar.add(sep4);
        
        JSeparator sep5 = new JSeparator();
        sep5.setBounds(0, 250, pnlRadar.getWidth(), 5);
        sep5.setVisible(true);
        pnlRadar.add(sep5);
        
        JSeparator sep6 = new JSeparator();
        sep6.setBounds(0, 300, pnlRadar.getWidth(), 5);
        sep6.setVisible(true);
        pnlRadar.add(sep6);
        
        JSeparator sep7 = new JSeparator();
        sep7.setBounds(0, 350, pnlRadar.getWidth(), 5);
        sep7.setVisible(true);
        pnlRadar.add(sep7);
        
        // Vertical lines
        JSeparator sep8 = new JSeparator();
        sep8.setOrientation(SwingConstants.VERTICAL);
        sep8.setBounds(50, 0, 5, pnlRadar.getHeight());
        sep8.setVisible(true);
        pnlRadar.add(sep8);
        
        JSeparator sep9 = new JSeparator();
        sep9.setOrientation(SwingConstants.VERTICAL);
        sep9.setBounds(100, 0, 5, pnlRadar.getHeight());
        sep9.setVisible(true);
        pnlRadar.add(sep9);
        
        JSeparator sep10 = new JSeparator();
        sep10.setOrientation(SwingConstants.VERTICAL);
        sep10.setBounds(150, 0, 5, pnlRadar.getHeight());
        sep10.setVisible(true);
        pnlRadar.add(sep10);
        
        JSeparator sep11 = new JSeparator();
        sep11.setOrientation(SwingConstants.VERTICAL);
        sep11.setBounds(200, 0, 5, pnlRadar.getHeight());
        sep11.setVisible(true);
        pnlRadar.add(sep11);
        
        JSeparator sep12 = new JSeparator();
        sep12.setOrientation(SwingConstants.VERTICAL);
        sep12.setBounds(250, 0, 5, pnlRadar.getHeight());
        sep12.setVisible(true);
        pnlRadar.add(sep12);
        
        JSeparator sep13 = new JSeparator();
        sep13.setOrientation(SwingConstants.VERTICAL);
        sep13.setBounds(300, 0, 5, pnlRadar.getHeight());
        sep13.setVisible(true);
        pnlRadar.add(sep13);
        
        JSeparator sep14 = new JSeparator();
        sep14.setOrientation(SwingConstants.VERTICAL);
        sep14.setBounds(350, 0, 5, pnlRadar.getHeight());
        sep14.setVisible(true);
        pnlRadar.add(sep14);
	}
	
	
	private void AdicionaAvio() {
		JFAdiconaAviao adicionaAvi = new JFAdiconaAviao();
		adicionaAvi.setVisible(true);
	}
	
	
}

