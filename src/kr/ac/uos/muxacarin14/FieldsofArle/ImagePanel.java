package kr.ac.uos.muxacarin14.FieldsofArle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private BufferedImage img;
	private int x,y;
	private double ratio;
	
	@SuppressWarnings("unused")
	private ImagePanel(){} //can't create instance of ImagePanel without File.
	
	public ImagePanel(File f){
		try{
			img = ImageIO.read(f);
		} catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		this.x = img.getWidth(); this.y = img.getHeight();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (img == null) return;
		if (this.getHeight()*x < this.getWidth() *y)
			g.drawImage(img, 0, 0, this.getHeight() *x/y, this.getHeight(), this);
		else
			g.drawImage(img, 0, 0, this.getWidth(), this.getWidth() * y/x, this);
		ratio = (double)this.getWidth()/this.x;
	}
	
	public double getRatio(){
		return ratio;
	}
	
	/*
	@Override
	public Dimension getPreferredSize(){
		if(this.getHeight()*x < this.getWidth()*y)
			return new Dimension(this.getHeight()*x/y, this.getHeight());
		else
			return new Dimension(this.getWidth(), this.getWidth()*y/x);
	}
	*/ //maybe needed?

}