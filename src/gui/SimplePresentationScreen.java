package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(620, 265));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel lblLU = new JLabel("LU:");
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblGH = new JLabel("GitHub URL:");
		lblGH.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblImg = new JLabel("");
		try {
			URL url = new URL(studentData.getPathPhoto());
			Image img = ImageIO.read(url);
			lblImg.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		contentPane.add(lblImg, BorderLayout.EAST);
		
		JLabel lblFecha = new JLabel("Esta ventana fue generada el " + java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " a las: " + java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblFecha, BorderLayout.SOUTH);
		
		JTextField tFLU = new JTextField(String.valueOf(studentData.getId()));
		tFLU.setEditable(false);
		tFLU.setColumns(10);
		
		JTextField tFApellido = new JTextField(studentData.getLastName());
		tFApellido.setEditable(false);
		tFApellido.setColumns(10);
		
		JTextField tFNombre = new JTextField(studentData.getFirstName());
		tFNombre.setEditable(false);
		tFNombre.setColumns(10);
		
		JTextField tFMail = new JTextField(studentData.getMail());
		tFMail.setEditable(false);
		tFMail.setColumns(10);
		
		JTextField tFGH = new JTextField(studentData.getGithubURL());
		tFGH.setEditable(false);
		tFGH.setColumns(10);
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
				gl_tabInformation.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_tabInformation.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
							.addComponent(lblLU)
							.addComponent(lblGH)
							.addComponent(lblMail)
							.addComponent(lblApellido)
							.addComponent(lblNombre))
						.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING, false)
							.addComponent(tFGH)
							.addComponent(tFMail)
							.addComponent(tFNombre)
							.addComponent(tFApellido)
							.addComponent(tFLU, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_tabInformation.setVerticalGroup(
				gl_tabInformation.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_tabInformation.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
							.addComponent(tFLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblLU))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
							.addComponent(tFApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblApellido))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
							.addComponent(tFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNombre))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
							.addComponent(tFMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMail))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
							.addComponent(tFGH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblGH))
						.addContainerGap(18, Short.MAX_VALUE))
			);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);
	}
}
