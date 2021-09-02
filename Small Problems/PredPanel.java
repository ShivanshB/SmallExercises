
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class PredPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 800;
	static final int GRID_LENGTH = 20;
	static final int UNIT_SIZE = SCREEN_WIDTH/GRID_LENGTH;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	static final int DELAY = 250;
	static int NUM_PREDATORS = 20;
	static int NUM_PREY = 64;
	static final int PREDATOR_LIFE = 32;
	static final int PREY_LIFE = 32;
	ArrayList<Integer> predX = new ArrayList<>();
	ArrayList<Integer> predY = new ArrayList<>();
	ArrayList<Integer> predCurrLife = new ArrayList<>();
	ArrayList<Integer> preyX = new ArrayList<>();
	ArrayList<Integer> preyY = new ArrayList<>();
	ArrayList<Integer> preyCurrLife = new ArrayList<>();
	boolean running = false;
	boolean gridFull = false;
	Timer timer;
	Random random;
	
	
	PredPanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		startGame();
	}
	
	public void startGame() {
		setPositions();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (running) {
			//draw grid
			for (int i = 0; i < GRID_LENGTH; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			
			//draw predators
			g.setColor(Color.red);
			for (int i = 0; i < NUM_PREDATORS; i++) {
				g.fillOval(predX.get(i), predY.get(i), UNIT_SIZE, UNIT_SIZE);
			}
			
			//draw prey
			g.setColor(Color.green);
			for (int i = 0; i < NUM_PREY; i++) {
				g.fillOval(preyX.get(i)+UNIT_SIZE/4, preyY.get(i)+UNIT_SIZE/4, UNIT_SIZE/2, UNIT_SIZE/2);
			}
			
			//show number of prey and predators
			g.setColor(Color.white);
			g.setFont(new Font("Courier New", Font.BOLD, 30));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Predators: " + NUM_PREDATORS, (SCREEN_WIDTH - metrics.stringWidth("Predators: "+NUM_PREDATORS))/2, g.getFont().getSize());
			g.drawString("Prey: " + NUM_PREY, (SCREEN_WIDTH - metrics.stringWidth("Prey: "+NUM_PREY))/2, 2*g.getFont().getSize());
		}
	}
	
	public void setPositions() {
		for (int i = 0; i < NUM_PREDATORS; i++) {
			predX.add(random.nextInt((int)GRID_LENGTH)*UNIT_SIZE);
			predY.add(random.nextInt((int)GRID_LENGTH)*UNIT_SIZE);
			predCurrLife.add(0);
			
			//make sure predators don't spawn on the same square
			for (int j = 0; j < i; j++) {
				if (predX.get(i) == predX.get(j) && predY.get(i) == predY.get(j)) {
					i--;
					predX.remove(predX.size() - 1);
					predY.remove(predY.size() - 1);
					predCurrLife.remove(predCurrLife.size() - 1);
					break;
				}
			}
		}
		
		for (int i = 0; i < NUM_PREY; i++) {
			preyX.add(random.nextInt((int)GRID_LENGTH)*UNIT_SIZE);
			preyY.add(random.nextInt((int)GRID_LENGTH)*UNIT_SIZE);
			preyCurrLife.add(0);
			
			//make sure prey don't spawn on the same square
			for (int j = 0; j < i; j++) {
				if (preyX.get(i) == preyX.get(j) && preyY.get(i) == preyY.get(j)) {
					i--;
					preyX.remove(preyX.size() - 1);
					preyY.remove(preyY.size() - 1);
					preyCurrLife.remove(preyCurrLife.size() - 1);
					break;
				}
			}
		}
		
	}
	
	public void move() {
		int dx[] = {0, 0, 1, -1};
		int dy[] = {1, -1, 0, 0};
		
		for (int i = 0; i < NUM_PREY; i++) {
			int dir = random.nextInt(4);
			int newX = preyX.get(i) + (dx[dir]*UNIT_SIZE);
			int newY = preyY.get(i) + (dy[dir]*UNIT_SIZE);
			
			//if it goes off the screen, enter from the opposite side
			if (newX < 0) newX = SCREEN_WIDTH - UNIT_SIZE;
			if (newX >= SCREEN_WIDTH) newX = 0;
			if (newY < 0) newY = SCREEN_HEIGHT - UNIT_SIZE;
			if (newY >= SCREEN_HEIGHT) newY = 0;
			
			//if prey reaches same square as another prey, ignore the move
			for (int j = 0; j < NUM_PREY; j++) {
				if (newX == preyX.get(j) && newY == preyY.get(j)) {
					continue;
				}
			}
			
			preyX.set(i, newX);
			preyY.set(i, newY);
			preyCurrLife.set(i, preyCurrLife.get(i) + 1);
		}
		
		for (int i = 0; i < NUM_PREDATORS; i++) {
			int dir = random.nextInt(4);
			int newX = predX.get(i) + (dx[dir]*UNIT_SIZE);
			int newY = predY.get(i) + (dy[dir]*UNIT_SIZE);
			
			if (newX < 0) newX = SCREEN_WIDTH - UNIT_SIZE;
			if (newX >= SCREEN_WIDTH) newX = 0;
			if (newY < 0) newY = SCREEN_HEIGHT - UNIT_SIZE;
			if (newY >= SCREEN_HEIGHT) newY = 0;
			
			
			for (int j = 0; j < NUM_PREDATORS; j++) {
				if (newX == predX.get(j) && newY == predY.get(j)) {
					continue;
				}
			}
			
			predX.set(i, newX);
			predY.set(i, newY);
			predCurrLife.set(i, predCurrLife.get(i) + 1);
		}
	}
	
	public void checkCollision() {
		for (int i = 0; i < NUM_PREDATORS; i++) {
			for (int j = 0; j < NUM_PREY; j++) {
				if (predX.get(i)/UNIT_SIZE == preyX.get(j)/UNIT_SIZE && predY.get(i)/UNIT_SIZE == preyY.get(j)/UNIT_SIZE) {
					//remove prey if eaten
					NUM_PREY--;
					preyX.remove(j);
					preyY.remove(j);
					preyCurrLife.remove(j);
					
					//reset the predator life counter
					predCurrLife.set(i, 0);
				}
			}
		}
	}
	
	public void reproduceAndDie() {
		int dx[] = {0, 0, 1, -1};
		int dy[] = {1, -1, 0, 0};
		
		//reproduce after PREY_LIFE moves alive
		if (!gridFull) {
			for (int i = 0; i < NUM_PREY; i++) {
				if (preyCurrLife.get(i) >= PREY_LIFE) {
					preyCurrLife.set(i, 0);
					NUM_PREY++;
					int dir = random.nextInt(4);
					int newX = preyX.get(i) + (dx[dir]*UNIT_SIZE);
					int newY = preyY.get(i) + (dy[dir]*UNIT_SIZE);
					preyX.add(newX);
					preyY.add(newY);
					preyCurrLife.add(0);
				}
			}
		}
		
		//predators die after PREDATOR_LIFE moves without eating
		for (int i = 0; i < NUM_PREDATORS; i++) {
			if (predCurrLife.get(i) >= PREDATOR_LIFE) {
				NUM_PREDATORS--;
				predX.remove(i);
				predY.remove(i);
				predCurrLife.remove(i);
			}
		}
	}
	
	//timer - redraw the grid
	@Override
	public void actionPerformed(ActionEvent e) {
		if (running) {
			checkCollision();
			reproduceAndDie();
			move();
			if (NUM_PREY > GRID_LENGTH*GRID_LENGTH) {
				gridFull = true;
			} else {
				gridFull = false;
			}
			System.out.println("Predators: " + NUM_PREDATORS + "   Prey: "+ NUM_PREY);
		}
		repaint();
	}
}
