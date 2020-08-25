package com.demo.hsl;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Java8����
import java.time.Clock;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClockNet extends JFrame implements Runnable, ChangeListener, ActionListener
{
	// �����ӱ��С�����ͱ���d�����������ṩ��ֵ���Լ����d
	int d = 150;
	// ����������,�������ṩ��ֵ�����Լ���������ӱ��С��d��ֵ
	JSlider eSlider;
	Thread timer; // �����ӱ���߳� timer
	int xClock, yClock;// �����ĵ�λ��
	JTextField textfield;
	int duration = 5;

	public void actionPerformed(ActionEvent e)
	{
		duration = Integer.parseInt(textfield.getText());
	}

	void start()
	{
		// ����ClockNet���̵߳ķ���
		if (timer == null)
		{
			timer = new Thread(this);
			timer.start();// �����߳�ʵ�� timer
		}
	}

	// ʵ�ֱ仯������ ChangeListener �ĳ��󷽷�
	public void stateChanged(ChangeEvent e)
	{
		/*
		 * ��������ӱ�ߴ��d��ֵ: �α������ƶ�������ֵ����d ֵ��С
		 */
		d = 300 - eSlider.getValue();
	}

	public void run()
	{
		// ʵ�ֽӿ�Runnable�ĳ��󷽷�
		while (timer != null)
		{
			try
			{
				Thread.sleep(150); // ��Ϣ150����
			}
			catch (InterruptedException e)
			{
			}
			repaint(); // ����paint����
		}
	}

	public static void main(String args[])
	{
		new ClockNet();// ����ClockNet��Ĺ��췽��
	}

	public ClockNet()
	{
		// ����ClockNet ��Ĺ��췽��
		super("��Դ�й������ʴ�");
		eSlider = new JSlider(SwingConstants.VERTICAL, 100, 200, 150);
		eSlider.addChangeListener(this);// Ϊ����ע��仯������
		add(eSlider, BorderLayout.EAST); // �����ŵ�����
		textfield = new JTextField(15);
		textfield.addActionListener(this);
		JPanel p = new JPanel();
		p.add(new JLabel("������઼��ֵ ( ��λ���룬TickDuration in seconds)"));
		p.add(textfield);
		p.add(new JLabel("��ʼֵ Initial��5 ��"));
		add(p, BorderLayout.SOUTH);
		add(new MyDraw(), BorderLayout.CENTER);// �����ŵ�����
		start();// ����start�������������߳�timer
		setVisible(true);// �������Ϊ�ɼ�
		setSize(650, 700);// ��ܿ�͸߷ֱ�����Ϊ 650 �� 700 ����
		/* Ϊ������Ͻǽ�����ťע�� */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/* �� ����� �Ŵ����С�� d �� */
	void enlarge(int[] x, int[] y, double d)
	{
		for (int i = 0; i < x.length; i++)
		{
			x[i] *= d;
			y[i] *= d;
		}
	}

	int instantAngle[] = { 64, 61, 56, 49, 40, 29, 16, 3, -8, -16, -23, -28, -31, -31, -31, -28, -23, -16, -8, 3, 16, 29, 40, 49, 56, 61, 64, 64 }; // �ڵļ�ʱ�Ƕ�����

	int index = 0;// �����±�,�仯��Χ[0,27], ѭ��ʹ��

	class MyDraw extends JPanel
	{
		// �ڲ���,��ʵ����Ϊ����ŵ�����
		public void paint(Graphics gScreen)
		{
			xClock = 250 * d / 150;// ʹ�������ĺ�������d����
			yClock = 200 * d / 150;// ʹ����������������d����
			String name1[] = { "��", "Դ", "��", "��" };
			String name[] = { "��", "Դ", "��", "��", "��", "��", "��", "��" };
			/* �ķ�֮һУ��ͼ���ڵ�һ���޵Ķ���ζ������� */
			int xCollege[] = { 15, 15, 20, 35, 35, 15, 5, 5, 15 };
			int yCollege[] = { -35, -20, -15, -15, -5, -5, -15, -35, -35 };
			/* ���� 0,3,6,9 ���־(�����ζ����)����λ������ */
			int x1[] = { 0, d / 15, 0, -d / 15, 0 };
			int y1[] = { (int) (-d * 1.13), -d, (int) (-d * 0.9), -d, (int) (-d * 1.13) };
			/* ���������ӵ��־(С���ζ����)����λ������ */
			int x[] = { 0, d / 30, 0, -d / 30, 0 };
			int y[] = { (int) (-d * 1.07), -d, (int) (-d * 0.9), -d, (int) (-d * 1.07) };

			Image buffer = createImage(650, 700); // ˫���漼����Ӱ��
			Graphics2D g = (Graphics2D) buffer.getGraphics();// ��ȡ�仭��
			g.setPaint(Color.white); // ��������Ϊ��ɫ
			g.fillRect(0, 0, 650, 700); // ����Ϳ�ɰ�ɫ
			g.translate(xClock, yClock); // ������ԭ��ƽ�Ƶ���������
			g.setColor(Color.green); // ��������Ϊ��ɫ
			g.setStroke(new BasicStroke((float) (7.0 * d / 150)));// ��������ϸ
			g.drawOval(-d, -d, 2 * d, 2 * d);// �������ܱ�Բ
			for (int i = 0; i < 12; i++)
			{
				// ����ӵ�λ��
				if (i % 3 == 0)
				{
					// 0,3,6,9��ı�־��Ϊ��ɫ�ϴ�����
					g.setColor(Color.red); // ��������Ϊ��ɫ
					g.fillPolygon(x1, y1, x1.length);// �������
				}
				else
				{
					// �����㻭Ϊ�ۻ�ɫ��С����
					g.setColor(Color.orange);// ��������Ϊ�ۻ�ɫ
					g.fillPolygon(x, y, x.length);// �������
				}
				g.rotate(Math.PI / 180 * 30);// �ӵ��־�ļ��Ϊ 30 ��
			}

			/* ��ʼ���� */
			if (index == instantAngle.length) index = 0; // ѭ��ʹ�ü�ʱ�Ƕȵ�����
			int degree = instantAngle[index++];// �Ӱڵļ�ʱ�Ƕ������ж�ȡ����

			g.rotate(Math.PI / 180 * degree);// ������˳ʱ����ת��Ӧ�Ļ���
			g.setColor(Color.red);
			g.setFont(new Font("����_GB2312", Font.BOLD, 25 * d / 150));
			for (int i = 0; i < name1.length; i++)
			{
				// д�ĸ������ַ���У��
				g.drawString(name1[i], 0, 200 * d / 150);
				g.rotate(-Math.PI / 180 * 8);// ÿ�������ַ�ռ8��
			}
			g.rotate(Math.PI / 180 * 16); // ��������������ߵĽǶ�,�Ի����ߺͰڴ�
			// ����ϵ������y������ƽ�ƣ� �����ĸ����޻�����Ϊ�ڴ���ͼ��
			g.translate(0, 250 * d / 150);
			g.setColor(Color.cyan);// �����ߵ���ɫ����Ϊ��ɫ
			g.setStroke(new BasicStroke((float) (4.0 * d / 150)));
			g.drawLine(0, 0, 0, -250 * d / 150);// ������
			/* ��ͼ�����ζ�����������ݣ����Ƶ�����xxx��yyy */
			int xxx[] = Arrays.copyOf(xCollege, xCollege.length);
			int yyy[] = Arrays.copyOf(yCollege, yCollege.length);
			enlarge(xxx, yyy, (double) d / 150); // ����ͼ��ĳߴ�
			g.setColor(Color.green); // ����ͼ�����ɫ
			for (int i = 0; i < 4; i++)
			{
				// �ֱ����ĸ������������,�����ͼ��
				g.fillPolygon(xxx, yyy, xxx.length);
				g.rotate(Math.PI / 2);
			}
			// ����ڴ�,����ϵ������y������ƽ��,�Ի�ԭ����ԭ��
			g.translate(0, -250 * d / 150);
			g.rotate(-Math.PI / 180 * (degree - 16));// ������ϵ��ԭ������λ��
			/* ������� */

			/* ��ʼ�������ϵ�ͼ�� */
			enlarge(xCollege, yCollege, 2.5 * d / 150);// ��������ͼ��ߴ�
			g.setColor(Color.magenta);// ��ͼ������Ϊ���ɫ
			// �Ա�������Ϊ����ԭ�㣬�ֱ����ĸ������������,�����ͼ��
			for (int i = 0; i < 4; i++)
			{
				g.fillPolygon(xCollege, yCollege, xCollege.length);
				g.rotate(Math.PI / 2);
			}

			/* ��ʼ�������ϵ����� */
			g.setColor(Color.black);
			g.setFont(new Font("����_GB2312", Font.BOLD, 20 * d / 150));
			g.rotate(Math.PI / 180 * 68); // ˳ʱ����ת����ϵ����дУ��
			for (int i = 0; i < name.length; i++)
			{
				g.drawString(name[i], 0, 110 * d / 150);// �ַ����ڰ��̵��°벿
				g.rotate(-Math.PI / 180 * 18);// ÿ���ַ�ռ18�ȵĿռ�
			}
			g.rotate(Math.PI / 180 * 76);// ˳ʱ����ת����ϵ,�Ի�ԭ����ϵ

			/* ��ʼ������ */
			LocalTime now = LocalTime.now();// �������ڵĵط�ʱ��
			/* �ֱ�������롢���롢ʱ����� 0 ��λ�õĻ����� */
			double s = Math.PI / 180 * 6 * now.getSecond();
			double m = Math.PI / 180 * 6 * now.getMinute();
			/* ʱ��λ�ã�Ӧ�������Ӷ�������ĸ���ֵ */
			double h = Math.PI / 180 * (30 * now.getHour()) + 30 * now.getMinute() / 60;

			/* ���� Clock.tick() ������ ����ö����� ��િ�� tickDuration ���ӱ� */
			Duration tickDuration = Duration.ofSeconds(duration);
			Clock clock = Clock.tick(Clock.systemUTC(), tickDuration);
			String ss = clock.instant().toString();
			int s_tick = Integer.parseInt(ss.substring(17, 19));
			// ��ʼ�� tick()�Ľ��
			double s_tick_rotate = Math.PI / 180 * 6 * s_tick;
			g.rotate(s_tick_rotate);
			g.fillRect(-8, -d - 8, 16, 16);
			// g.drawLine(0,0,0,-d);
			g.rotate(-s_tick_rotate);// �� tick()�Ľ������

			g.setColor(Color.blue);// ������ɫΪ��
			g.rotate(s); // ��ʼ�����룬������ϸ����ı���
			g.setStroke(new BasicStroke((float) (3.0 * d / 150)));
			g.drawLine(0, 0, 0, -140 * d / 150);
			g.rotate(-s);// ���������

			g.rotate(m);// ��ʼ�����룬���ǽϴ֡��϶̵ı���
			g.setStroke(new BasicStroke((float) (6.0 * d / 150)));
			g.drawLine(0, 0, 0, -90 * d / 150);
			g.rotate(-m);// ���������
			g.rotate(h);// ��ʼ��ʱ�룬������֡���̵ı���
			g.setStroke(new BasicStroke((float) (10.0 * d / 150)));
			g.drawLine(0, 0, 0, -45 * d / 150);
			g.rotate(-h);// ��ʱ�����
			/* ��������� */
			gScreen.drawImage(buffer, 0, 0, this);// �����ڴ��л��õ�Ӱ�񣬻���������
		} // ����paint ������
	}// �ڲ��� MyDraw ������
}// ������ ClockNet ������
