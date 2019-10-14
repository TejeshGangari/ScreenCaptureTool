package basePackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

public class CaptureScreenTool extends JFrame {

	public static CaptureScreenTool frame;
	private JPanel contentPane;
	private JTextField moduleName;
	private JTextField testCaseName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frame = new CaptureScreenTool();
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
	public CaptureScreenTool() {
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		
		CaptureScreen cs = new CaptureScreen();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionText);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScreenCaptureTool = new JLabel("Screen Capture Tool");
		lblScreenCaptureTool.setBounds(2, 2, 430, 30);
		lblScreenCaptureTool.setForeground(Color.GREEN);
		lblScreenCaptureTool.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreenCaptureTool.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		lblScreenCaptureTool.setBackground(SystemColor.activeCaption);
		contentPane.add(lblScreenCaptureTool);
		
		moduleName = new JTextField();
		moduleName.setBounds(166, 72, 166, 35);
		contentPane.add(moduleName);
		moduleName.setColumns(10);
		
		JLabel lblModuleName = new JLabel("Module Name");
		lblModuleName.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblModuleName.setForeground(Color.GRAY);
		lblModuleName.setBounds(20, 72, 127, 35);
		contentPane.add(lblModuleName);
		
		JLabel lblTestCaseName = new JLabel("Test Case Name");
		lblTestCaseName.setForeground(Color.GRAY);
		lblTestCaseName.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblTestCaseName.setBounds(20, 149, 127, 35);
		contentPane.add(lblTestCaseName);
		
		testCaseName = new JTextField();
		testCaseName.setBounds(166, 149, 236, 35);
		contentPane.add(testCaseName);
		testCaseName.setColumns(10);
		
		JButton btnCapture = new JButton("Capture");
		btnCapture.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnCapture.setBounds(166, 215, 119, 35);
		contentPane.add(btnCapture);
		
		btnCapture.addActionListener(e -> cs.captureScreen(testCaseName.getText(), moduleName.getText(),frame));
	}
}
