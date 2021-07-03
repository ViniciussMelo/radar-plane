package main.frames;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;



import main.Util.Calculo;
import main.components.PlaneTableModel;
import main.model.Aviao;
import main.model.InfoColisao;

@SuppressWarnings("serial")
public class JFMain extends JFrame {
	public PlaneTableModel planeTableModel = new PlaneTableModel();
	
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
		final java.awt.Color colorTables = new java.awt.Color(255,255,255);
		
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
				btnRemovePlaneActionPerformed(evt);
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
				btnScaleActionPerformed(evt);
			}
		});

		btnTranslate = new JButton();
		btnTranslate.setBackground(colorFirstButton);
		btnTranslate.setText("Translate");
		btnTranslate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTranslateActionPerformed(evt);
			}
		});

		btnRotate = new JButton();
		btnRotate.setBackground(colorFirstButton);
		btnRotate.setText("Rotate");
		btnRotate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRotateActionPerformed(evt);
			}
		});

		btnDistAirport = new JButton();
		btnDistAirport.setBackground(colorSecondButton);
		btnDistAirport.setText("Distance to Airport");
		btnDistAirport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				distanceAirport();
			}
		});

		btnDistPlanes = new JButton();
		btnDistPlanes.setBackground(colorSecondButton);
		btnDistPlanes.setText("Distance Airplanes");
		btnDistPlanes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				distancePlanes();
			}
		});

		btnCollisionCourse = new JButton(); 
		btnCollisionCourse.setBackground(colorSecondButton);
		btnCollisionCourse.setText("Collision course");
		btnCollisionCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tempColiton();
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

	public final void updateTable() {
		this.planeTableModel.update();
        this.tblPlane.setModel(this.planeTableModel);
        
        this.pnlRadar.removeAll();
        
        for (int i = 0; i < planeTableModel.getRowCount(); i++) {
            try {
                JLabel label = generatePlaneImage(planeTableModel.getPlane(i));
                pnlRadar.add(label);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
		startPlaneLayout();
		pnlRadar.revalidate();
        pnlRadar.repaint();
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
	
	
	private void AdicionaAviao() {
		JFAdiconaAviao adicionaAvi = new JFAdiconaAviao(this);
		adicionaAvi.setVisible(true);
	}
	
	private void btnRemovePlaneActionPerformed(java.awt.event.ActionEvent evt) {
		int linhaSelecionada = tblPlane.getSelectedRow();

        if (linhaSelecionada >= 0) {
            planeTableModel.removeAviao(linhaSelecionada);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "It is necessary to select an airplane!");
        }		
	};
	
	public void setEnableBtnAdd(boolean enable) {
		btnAdd.setEnabled(enable);
	}
	
	public void addGrade(Aviao aviao) throws IOException {
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
		generatePlaneImage(aviao);
	}
	
	
	
	
	
	private void btnScaleActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedLine = tblPlane.getSelectedRow();
		
		if(selectedLine < 0) {
			JOptionPane.showMessageDialog(null, "It is necessary to select an airplane!");
			return;
		}
		
		Aviao plane = planeTableModel.getPlane(selectedLine);
		
		JFScale scaleFrame = new JFScale(this, plane);
		scaleFrame.setVisible(true);
	}
	
	private JLabel generatePlaneImage(Aviao aviao) throws IOException {
		URL url = getClass().getResource("../images/plane.png");
        
        BufferedImage img = ImageIO.read(url);
        
        img = rotateImage(img, -1 * (aviao.getDirecao() - 45.0));
        
        Icon icon = new ImageIcon(img);
        JLabel label = new JLabel(icon);
        
        int x = (int) ((aviao.getPontoX() > 0) ? 200 + aviao.getPontoX() : 200 + aviao.getPontoX());
        int y = (int) ((aviao.getPontoY() > 0) ? 200 - aviao.getPontoY() : 200 - aviao.getPontoY());
        
        label.setBounds(x - (30/2), y - (30/2), 30, 30);
        
        return label;
	}
	
	public static BufferedImage rotateImage(BufferedImage imagem, double angle) {
		angle %= 360;
        if (angle < 0) angle += 360;

        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(angle), imagem.getWidth() / 2.0, imagem.getHeight() / 2.0);

        double ytrans = 0;
        double xtrans = 0;
        if( angle <= 90 ){
            xtrans = tx.transform(new Point2D.Double(0, imagem.getHeight()), null).getX();
            ytrans = tx.transform(new Point2D.Double(0.0, 0.0), null).getY();
        }
        else if( angle <= 180 ){
            xtrans = tx.transform(new Point2D.Double(imagem.getWidth(), imagem.getHeight()), null).getX();
            ytrans = tx.transform(new Point2D.Double(0, imagem.getHeight()), null).getY();
        }
        else if( angle <= 270 ){
            xtrans = tx.transform(new Point2D.Double(imagem.getWidth(), 0), null).getX();
            ytrans = tx.transform(new Point2D.Double(imagem.getWidth(), imagem.getHeight()), null).getY();
        }
        else{
            xtrans = tx.transform(new Point2D.Double(0, 0), null).getX();
            ytrans = tx.transform(new Point2D.Double(imagem.getWidth(), 0), null).getY();
        }

        AffineTransform translationTransform = new AffineTransform();
        translationTransform.translate(-xtrans, -ytrans);
        tx.preConcatenate(translationTransform);

        return new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR).filter(imagem, null);
	}

	private void btnTranslateActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedLine = tblPlane.getSelectedRow();

        if (selectedLine >= 0) {
            Aviao plane = planeTableModel.getPlane(selectedLine);
            
            JFTranslate frameTranslate = new JFTranslate(this, plane);
            frameTranslate.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "It is necessary to select an airplane!");
        }
	}
	
	private void btnRotateActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedLine = tblPlane.getSelectedRow();

        if (selectedLine >= 0) {
            Aviao plane = planeTableModel.getPlane(selectedLine);
            
            JFRotate frameTranslate = new JFRotate(this, plane);
            frameTranslate.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "It is necessary to select an airplane!");
        }
	}
	
	private void distanceAirport(){
		Double distancia = 0.0;
		txtReport.setText(null);
		try {
			distancia = Double.parseDouble(JOptionPane.showInputDialog("inform the minimum distance to the airport! (km)"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Enter valid value" + e);
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i=0; i < planeTableModel.getRowCount(); i++ ) {
			Aviao aviaoA = planeTableModel.getPlane(i);
			
			double distanciaCalc = Calculo.distancia(0,0,aviaoA.getPontoX(), aviaoA.getPontoY());
			
			if (distanciaCalc <= distancia) {
				stringBuilder.append("The airplane: " + aviaoA.getCodigo() + " is below the minimum distance from the airport!\n"); 
			}
					
		}
		if(stringBuilder.length() != 0) {
			txtReport.setText(stringBuilder.toString());
		}else {
			txtReport.setText("There is no plane below the minimum distance from the airport!");
		}
	}
	
	private void distancePlanes() {
		Double distancia = 0.0;
		StringBuilder stringBuilder = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		try {
			distancia = Double.parseDouble(JOptionPane.showInputDialog("inform the minimum distance between the aircraft! (km)"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Enter valid value" + e);
		}
			
		for (int i=0; i < planeTableModel.getRowCount(); i++ ) {
			Aviao aviaoA = planeTableModel.getPlane(i);
				
			for (int j=0; j < planeTableModel.getRowCount(); j++ ) {
				Aviao aviaoB = planeTableModel.getPlane(j);
				
				if(aviaoA.getCodigo() == aviaoB.getCodigo()) {
					continue;
				}
				
				Integer alreadyExistis = map.get(aviaoB.getCodigo());
				
				if(alreadyExistis != null) {
					continue;
				}
					
				double distanciaCalc = Calculo.distancia(aviaoA.getPontoX(), aviaoA.getPontoY(), aviaoB.getPontoX(), aviaoB.getPontoY());
					
				if (distanciaCalc <= distancia) {
					map.put(aviaoA.getCodigo(), aviaoB.getCodigo());
					stringBuilder.append("The airplane: " + aviaoA.getCodigo() +" is below the minimum distance from the plane " + aviaoB.getCodigo() + "\n");
				}		
			}		
		}
		
		if(stringBuilder.length() != 0) {
			txtReport.setText(stringBuilder.toString());
		}else {
			txtReport.setText("There is no plane below the minimum distance of another plane!");
		}		
	}
	
	private void tempColiton() {//GEN-FIRST:event_btnRotaColisaoActionPerformed
        if (planeTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "There are no planes on the radar");
            return;
        }
        
        double tempoMinimo;
        txtReport.setText(null);
        
        try {
            tempoMinimo = Double.parseDouble(JOptionPane.showInputDialog("Minimum distance to alert collision (Segundos):"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter valid value");
            return;
        }
        
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < planeTableModel.getRowCount(); i++) {
            Aviao aviaoA = planeTableModel.getPlane(i);
            
            for (int j = i; j < planeTableModel.getRowCount(); j++) {
                Aviao aviaoB = planeTableModel.getPlane(j);
                
                if (aviaoA.getCodigo() == aviaoB.getCodigo()) {
                    continue;
                }
                
                InfoColisao info = Calculo.calcularColisao(aviaoA, aviaoB);
                
                if (info.getDiferencaTempo() <= tempoMinimo) {
                	
                	stringBuilder.append("The airplane: " +aviaoA.getCodigo()  + " is on a collision course with the plane " + aviaoB.getCodigo() + "\n");
                    
                }
            }
        }
        if(stringBuilder.length() != 0) {
			txtReport.setText(stringBuilder.toString());
		}else {
			txtReport.setText("There is no plane on a collision course for the defined time!");
		}	       
    }
	
	
} 

