import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame implements MouseListener, KeyListener{
JPanel pnlBotones = new JPanel();
public Ventana() {

			//Atributos de la ventana
			this.setVisible(true);
			this.setSize(500,750);
			this.setLocation(200,200);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(true);
			this.setTitle("Click me");
			this.setMinimumSize(new Dimension(250,250));
			this.setMaximumSize(new Dimension(1000,750));
			this.setLocationRelativeTo(null);

			this.setLayout(null);
			addMouseListener(this);
			addKeyListener(this);
			this.IniciarComponentes();
		}

	//Metodo para los componentes
	public void IniciarComponentes() {

		this.botones();
	}
	
	public void botones() {
		
		//Primer panel
		pnlBotones.setSize(this.getWidth(), this.getHeight());
		pnlBotones.setBackground(Color.cyan);
		pnlBotones.setLayout(null);
		this.add(pnlBotones);
		
		 JButton btnClickMe = new JButton("Click me");
	        btnClickMe.setBounds(150, 600, 170, 50);
	        btnClickMe.setBackground(Color.decode("#DCCA8A"));
	        btnClickMe.setFont(new Font("Arial", Font.BOLD, 20));
	        pnlBotones.add(btnClickMe);
	        btnClickMe.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int x = (int) Math.floor(Math.random() * 450 + 1);
	                int y = (int) Math.floor(Math.random() * 650 + 1);
	                int w = (int) Math.floor(Math.random() * 120 + 1);
	                int h = (int) Math.floor(Math.random() * 120 + 1);
	                Random rand = new Random();
	                float r = rand.nextFloat();
	                float g = rand.nextFloat();
	                float b = rand.nextFloat();
	                JButton otroBtn = new JButton(r + "," + g + "," + b);
	                otroBtn.setBounds(x, y, w, h);
	                otroBtn.setBackground(new Color(r, g, b));
	               
	                otroBtn.addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                    	JButton yo = ((JButton) e.getSource());
							pnlBotones.remove(yo);
							
							getContentPane().repaint();
//	                        JOptionPane.showMessageDialog(null, r + "," + g + "," + b, "Codigo del color",
//	                                JOptionPane.ERROR_MESSAGE);
	                    }
	                });
	                
	                pnlBotones.add(otroBtn);
	                getContentPane().repaint();
	                getContentPane().revalidate();
	            }
	        });
	        btnClickMe.setFocusable(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		int w = (int) Math.floor(Math.random() * 120 + 1);
        int h = (int) Math.floor(Math.random() * 120 + 1);
         
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
         
        JButton otroBtn = new JButton(r + "," + g + "," + b);
        otroBtn.setBounds(x, y, w, h);
        otroBtn.setBackground(new Color(r, g, b));
         
        otroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, r + "," + g + "," + b, "Codigo del color",
                JOptionPane.ERROR_MESSAGE);
             }
        });
		pnlBotones.add(otroBtn);
		otroBtn.setFocusable(false);
		
		getContentPane().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		
		Color randomColor = new Color(r, g, b);
		pnlBotones.setBackground(randomColor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 8) {
			pnlBotones.removeAll();
			getContentPane().repaint();
		}
		if(e.getKeyCode() == 87) {
			Component[] elementos = pnlBotones.getComponents();
			for(int i = 0; i <elementos.length; i++) {
				if(elementos[i].getClass().toString().equals("class javax.swing.JButton")) {
					JButton btn = ((JButton) elementos[i]);
					
					btn.setSize(btn.getWidth() + 10, btn.getHeight() + 10);
					getContentPane().repaint();
					getContentPane().revalidate();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}