import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class glowna_petl extends Canvas implements Runnable //Runnable clasa bedzie w¹tkiem
{
	public static final String Title ="Moje 2D";
	public static final int Width=800, Height=600;
	
	private boolean Running = false;
	private JFrame okno;
	
	public glowna_petl() 
	{
		setPreferredSize(new Dimension(Width, Height));// ustawiamy preferowane parametry okna z clasy canvas
		setMinimumSize(new Dimension(Width, Height));
		setMaximumSize(new Dimension(Width, Height));
		
		okno = new JFrame(Title);
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykanie apki po nacineciu X-a
		okno.add(this, new BorderLayout().CENTER);
		okno.pack();// pakujê elementy do okana
		
		okno.setLocationRelativeTo(null);//border mam ustawione na œrodek, muszê wy³¹czyæ  locationrelativa aby zosta³o zastosowane
		okno.setResizable(false);// przycisk maksymalny wy³¹czony
		okno.setVisible(true);
		
		
	}
	
	private void start()
	{
		if(Running) return;    // jezeli running jest na true przerywa progam  Jezeli nie wykonuje reszte kodu 
		Running = true;
		
		new Thread(this, Title +"Gra").start();// funkacja start wywo³uje funkcie run() Runnable musi miec funckje run()
	}
	

	
	private void stop()
	{
		if(!Running)return;
	Running=false;
		System.exit(0);// zamyka równiez w¹tek
	}
	
	public void run()     // funkcja w ktrej jest petla g³ówna
	{
		while(Running)
		{
			render();
			update();
		}
		stop();
	}
	
	private void update() 
	{
		
	}
	
	private void render()
	{
//	System.out.println("test");
	}
	public static void main(String[] args) {
		
		new glowna_petl().start();

	}

}
