package main.frames;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


import main.model.Aviao;

@SuppressWarnings("serial")
public class JFMain extends JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	
	private JButton btnAdd;
	private JButton btnScale;
	private JButton btnRemove;
	private JButton btnRotate;
	private JButton btnTranslate;
	private JButton btnDistPlanes;
	private JButton btnDistAirport;
	private JButton btnCollisionCourse;	
	
	private JScrollPane jScrollPane1;
	
	private JSeparator jSeparator1;
	
	private JLabel lblReport;
	private JLabel lblPlaneTable;
	
	private JPanel pnlLayout;
	private JPanel pnlRadar;
	
	private JScrollPane scpPlane;
	
	private JTable tblPlane;
	
	private DefaultTableModel defaultTableModel;
	
	private JTextArea txtReport;
	
	public List<Aviao> avioes;

	public JFMain() {
		initComponents();
		updateTable();
	}

	private void initComponents() {
		final java.awt.Color colorFirstButton = new java.awt.Color(230, 230, 230);
		final java.awt.Color colorSecondButton = new java.awt.Color(153, 230, 255);
		final java.awt.Color colorTables = new java.awt.Color(105,105,105);
		
		avioes = new ArrayList<>();
		
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();

		jLabel1.setText("Radar");
		jLabel2.setText("Transformation Functions");
		jLabel3.setText("Tracking Functions");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Plane radar");
		
		pnlLayout = new JPanel();
		pnlLayout.setPreferredSize(new java.awt.Dimension(900, 600));
		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("X");
		defaultTableModel.addColumn("Y");
		defaultTableModel.addColumn("R");
		defaultTableModel.addColumn("A");
		defaultTableModel.addColumn("V");
		defaultTableModel.addColumn("D");
				
		tblPlane = new JTable(defaultTableModel);
	
		scpPlane = new JScrollPane(tblPlane);
		
		btnAdd = new JButton();
		btnAdd.setText("Add");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setEnableBtnAdd(false);
				AdicionaAviao();
			}
		});

		btnRemove = new JButton();
		btnRemove.setText("Remove");
		btnRemove.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				RemoveAviao();
			}
		});

		lblPlaneTable = new JLabel();
		lblPlaneTable.setText("Plane table");
		
		lblReport = new JLabel();
		lblReport.setText("Report");

		pnlRadar = new JPanel();
		pnlRadar.setBackground(colorTables);
		pnlRadar.setPreferredSize(new java.awt.Dimension(400, 400));

		GroupLayout pnlRadarLayout = new GroupLayout(pnlRadar);
		pnlRadar.setLayout(pnlRadarLayout);
		pnlRadarLayout.setHorizontalGroup(pnlRadarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		pnlRadarLayout.setVerticalGroup(pnlRadarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));

		

		jSeparator1 = new JSeparator();
		jSeparator1.setOrientation(SwingConstants.VERTICAL);

		txtReport = new JTextArea();
		txtReport.setEditable(false);
		txtReport.setColumns(20);
		txtReport.setRows(5);
		txtReport.setFocusable(false);
		
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setViewportView(txtReport);		

		btnScale = new JButton();
		btnScale.setBackground(colorFirstButton);
		btnScale.setText("Scale");
		btnScale.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnScaleActionPerformed(evt);
			}
		});

		btnTranslate = new JButton();
		btnTranslate.setBackground(colorFirstButton);
		btnTranslate.setText("Translate");
		btnTranslate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnTranslateActionPerformed(evt);
			}
		});

		btnRotate = new JButton();
		btnRotate.setBackground(colorFirstButton);
		btnRotate.setText("Rotate");
		btnRotate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnRotateActionPerformed(evt);
			}
		});

		btnDistAirport = new JButton();
		btnDistAirport.setBackground(colorSecondButton);
		btnDistAirport.setText("Distance to Airport");
		btnDistAirport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnDistAirportActionPerformed(evt);
			}
		});

		btnDistPlanes = new JButton();
		btnDistPlanes.setBackground(colorSecondButton);
		btnDistPlanes.setText("Distance Airplanes");
		btnDistPlanes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnDistPlanesActionPerformed(evt);
			}
		});

		btnCollisionCourse = new JButton(); 
		btnCollisionCourse.setBackground(colorSecondButton);
		btnCollisionCourse.setText("Collision course");
		btnCollisionCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnCollisionCourseActionPerformed(evt);
			}
		});

		GroupLayout pnlLayoutLayout = new GroupLayout(pnlLayout);
		pnlLayout.setLayout(pnlLayoutLayout);
		pnlLayoutLayout.setHorizontalGroup(pnlLayoutLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlLayoutLayout.createSequentialGroup().addGroup(pnlLayoutLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(pnlLayoutLayout.createSequentialGroup().addGap(41, 41, 41)
								.addGroup(pnlLayoutLayout
										.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(pnlRadar, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jScrollPane1))
								.addGap(18, 18, 18))
						.addGroup(GroupLayout.Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(pnlLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(GroupLayout.Alignment.TRAILING,
												pnlLayoutLayout.createSequentialGroup().addComponent(jLabel1)
														.addGap(208, 208, 208))
										.addGroup(GroupLayout.Alignment.TRAILING,
												pnlLayoutLayout.createSequentialGroup().addComponent(lblReport)
														.addGap(195, 195, 195)))))
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
						.addGroup(pnlLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup()
												.addComponent(btnCollisionCourse, GroupLayout.PREFERRED_SIZE,
														150, GroupLayout.PREFERRED_SIZE)
												.addGap(133, 133, 133))
								.addGroup(GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup().addComponent(jLabel3).addGap(149, 149,
												149))))
				.addGroup(GroupLayout.Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pnlLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup().addComponent(jLabel2).addGap(144, 144,
												144))
								.addGroup(GroupLayout.Alignment.TRAILING,
										pnlLayoutLayout.createSequentialGroup().addGroup(pnlLayoutLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addGroup(pnlLayoutLayout.createSequentialGroup()
														.addComponent(btnDistAirport,
																GroupLayout.PREFERRED_SIZE, 150,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																LayoutStyle.ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnDistPlanes,
																GroupLayout.PREFERRED_SIZE, 150,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(pnlLayoutLayout.createSequentialGroup().addGap(124, 124, 124)
														.addComponent(lblPlaneTable))
												.addComponent(scpPlane, GroupLayout.PREFERRED_SIZE, 0,
														Short.MAX_VALUE)
												.addGroup(pnlLayoutLayout.createSequentialGroup()
														.addComponent(btnAdd, 
																	  GroupLayout.PREFERRED_SIZE, 
																	  98,
																	  GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																LayoutStyle.ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRemove,
																      GroupLayout.PREFERRED_SIZE, 
																      98,
																      GroupLayout.PREFERRED_SIZE))
												.addGroup(pnlLayoutLayout.createSequentialGroup()
														.addComponent(btnScale,
																GroupLayout.PREFERRED_SIZE, 98,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(btnTranslate,
																GroupLayout.PREFERRED_SIZE, 98,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(btnRotate,
																GroupLayout.PREFERRED_SIZE, 98,
																GroupLayout.PREFERRED_SIZE)))
												.addGap(46, 46, 46)))));
		pnlLayoutLayout.setVerticalGroup(pnlLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlLayoutLayout.createSequentialGroup().addContainerGap().addGroup(pnlLayoutLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jSeparator1)
						.addGroup(pnlLayoutLayout.createSequentialGroup()
								.addGroup(pnlLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblPlaneTable).addComponent(jLabel1))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(pnlLayoutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addComponent(pnlRadar, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8,
														Short.MAX_VALUE)
												.addComponent(lblReport)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 130,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addComponent(scpPlane, GroupLayout.PREFERRED_SIZE, 229,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(pnlLayoutLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(btnAdd).addComponent(btnRemove))
												.addGap(33, 33, 33).addComponent(jLabel2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(pnlLayoutLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(btnScale,
																GroupLayout.PREFERRED_SIZE, 48,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnTranslate,
																GroupLayout.PREFERRED_SIZE, 48,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnRotate,
																GroupLayout.PREFERRED_SIZE, 48,
																GroupLayout.PREFERRED_SIZE))
												.addGap(27, 27, 27).addComponent(jLabel3).addGap(18, 18, 18)
												.addGroup(pnlLayoutLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(btnDistPlanes,
																GroupLayout.PREFERRED_SIZE, 50,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnDistAirport,
																GroupLayout.PREFERRED_SIZE, 50,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnCollisionCourse, GroupLayout.PREFERRED_SIZE,
														50, GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE)))))
						.addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				pnlLayout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				pnlLayout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				GroupLayout.PREFERRED_SIZE));

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
       // pnlRadar.add(label);
        
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
	
	
	private void AdicionaAviao() {
		JFAdiconaAviao adicionaAvi = new JFAdiconaAviao(this);
		adicionaAvi.setVisible(true);
	}
	private void RemoveAviao() {
		System.out.println(avioes);
		avioes.remove(tblPlane.getSelectedRow());
		defaultTableModel.setRowCount(0);
		pnlRadar.removeAll();
		updateTable();
		System.out.println("___________");
		System.out.println(avioes);
		for (Aviao aviao : avioes) {
			addGrade(aviao);
		};
		
	};
	
	public void setEnableBtnAdd(boolean enable) {
		btnAdd.setEnabled(enable);
	}
	
	public void addGrade(Aviao aviao) {
		aviao.setCodigo(defaultTableModel.getRowCount() + 1);
		defaultTableModel.addRow(new Object[]{
												aviao.getCodigo(),
												aviao.getPontoX(),
												aviao.getPontoY(),
												aviao.getRaio(),
												aviao.getAngulo(),
												aviao.getVelocidade(),
												aviao.getDirecao(),
											  });
		addImagePanel(aviao);
	}
	
	public void addImagePanel(Aviao aviao) {
		try {
			URL url = getClass().getResource("../images/plane.png");
			BufferedImage img = ImageIO.read(url);
			
			img = addRotacion(img, - (aviao.getDirecao() - 45.0));
			
			int x = (int) (200 + aviao.getPontoX() - (42/2));
	        int y = (int) (200 - aviao.getPontoY()- (42/2));
	        
			JLabel label = new JLabel(new ImageIcon(img));
			label.setBounds(x, y, 42, 42);
			
			pnlRadar.add(label);
			pnlRadar.revalidate();
			pnlRadar.repaint();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	public BufferedImage addRotacion(BufferedImage img, double direcao) {
		direcao %= 360;
        if (direcao < 0) {
        	direcao+= 360;
        }

        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(direcao), img.getWidth() / 2.0, img.getHeight() / 2.0);

        double ytrans = 0;
        double xtrans = 0;
        if( direcao <= 90 ){
            xtrans = tx.transform(new Point2D.Double(0, img.getHeight()), null).getX();
            ytrans = tx.transform(new Point2D.Double(0.0, 0.0), null).getY();
        }
        else if( direcao <= 180 ){
            xtrans = tx.transform(new Point2D.Double(img.getWidth(), img.getHeight()), null).getX();
            ytrans = tx.transform(new Point2D.Double(0, img.getHeight()), null).getY();
        }
        else if( direcao <= 270 ){
            xtrans = tx.transform(new Point2D.Double(img.getWidth(), 0), null).getX();
            ytrans = tx.transform(new Point2D.Double(img.getWidth(), img.getHeight()), null).getY();
        }
        else{
            xtrans = tx.transform(new Point2D.Double(0, 0), null).getX();
            ytrans = tx.transform(new Point2D.Double(img.getWidth(), 0), null).getY();
        }

        AffineTransform translationTransform = new AffineTransform();
        translationTransform.translate(-xtrans, -ytrans);
        tx.preConcatenate(translationTransform);

        return new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR).filter(img, null);
		
	}
	
}

