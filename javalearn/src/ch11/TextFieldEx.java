package ch11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldEx extends JFrame {

	private JTextField tf;
	private JTextArea ta;
	private ScrollPane sp;    //��ũ�����ΰ� ���̽�ũ�������� �ִµ� ���̽�ũ�������� ������ ��ƸԾ ����
	
	public TextFieldEx() {
		setTitle("�ؽ�Ʈ ������, �ؽ�Ʈ �ڽ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		tf = new JTextField("", 20);

		// �ؽ�Ʈ�ʵ� ������
		tf.setFont(new Font("Arial", Font.BOLD, 30));
		tf.setPreferredSize(new Dimension(100, 50)); // �Է�â ���� ����

		sp = new ScrollPane();
		
		ta = new JTextArea("", 5, 20);
		ta.setBackground(Color.WHITE);
		
		ta.setEnabled(false);
		ta.setFont(new Font("Arial", Font.BOLD, 30));
		
		sp.add(ta);
		ta.setForeground(Color.BLACK);

		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String value = tf.getText();
					ta.append(value+"\n");
					tf.setText(""); //�Է��� �ʱ�ȭ
				}
			}
		});
		c.add(tf, BorderLayout.SOUTH);
		c.add(sp, BorderLayout.CENTER);

		setSize(400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextFieldEx();
	}

}