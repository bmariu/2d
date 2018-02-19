import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

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
			update();
			render();
		}
		stop();
	}
	
	private void update() 
	{
		
	}
	
	private void render()
	{
		BufferStrategy bs  = getBufferStrategy();    //tworzyê strategie bufora i pobieram j¹ do nowo  utowrzoneogo obiektu
		if(bs == null)    //warunek sprawdza czy bufor jest utworzony 
		{
			createBufferStrategy(3);//jezeli nie ma bufora tworzy, podana wartoœæ okresla ile buffer jest tworzone,  1 bedzie migotanie 2 dzia³¹ p³ynie ale m¹g¹ byc równiez migotania 
		return;
		}
		Graphics g = bs.getDrawGraphics();     //class odpowiedzallna za rysowanie na naszym canvas
		g.setColor(Color.black);
		g.fillRect(0, 0, Width+10, Height+10);
		g.dispose();//musimy zamknoæ obietk clasy graphics
		bs.show();// wyswietlamy na rysowany element 
		
		
//	System.out.println("test");
	}
	public static void main(String[] args) {
		
		new glowna_petl().start();

	}

}
