
/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model{

	private  Direction direction = Direction.SOUTHEAST;
    private  int xloc = 0;
    private  int yloc = 0;
    private  int xIncr = 8;
    private  int yIncr = 2;
    
    public Model(int width, int height, int imgWidth, int imgHeight){
    	
    }
    
     Direction getDirect() {
    	return direction;
    }
    
     int getX() {
    	return xloc;
    }
    
     int getY() {
    	return yloc;
    }
    
     int getXIncr() {
    	return xIncr;
    }
    
     int getYIncr() {
    	return yIncr;
    }
    
    
    void updateLocationAndDirection(){
    	if(xloc > 360) {
    		if(direction == Direction.SOUTHEAST) { //SE
    			direction = Direction.SOUTHWEST; //SW
        		xIncr *=-1;
    		}else if(direction == Direction.NORTHEAST){ //NE
    			direction = Direction.NORTHWEST; //NW
        		xIncr *=-1;
    		}else { //E
    			direction = Direction.WEST; //W
        		xIncr *=-1;
    		}
    		xloc += xIncr;
    		yloc += yIncr;
    	}
    	if(xloc < -40){
    		if(direction == Direction.SOUTHWEST) { //SW
    			direction = Direction.SOUTHEAST; //SE
    		}else if(direction == Direction.NORTHWEST){ //NW
    			direction = Direction.NORTHEAST; //NE
    		}else { //E
    			direction = Direction.WEST; //W
    		}
    		xIncr *=-1;
    		xloc += xIncr;
    		yloc += yIncr;
    	}
    	if(yloc <-30){
    		if(direction == Direction.NORTH) { //N
    			direction = Direction.SOUTH; //S
    		}else if(direction == Direction.NORTHWEST){ //NW
    			direction = Direction.SOUTHWEST; //SW
    		}else { //NE
    			direction = Direction.SOUTHEAST; //SE
    		}
    		yIncr *=-1;
    		xloc += xIncr;
    		yloc += yIncr;
    	}
    	if(yloc > 150){
    		if(direction == Direction.SOUTHEAST) { //SE
    			direction = Direction.NORTHEAST; //NE
    		}else if(direction == Direction.SOUTHWEST){ //SE
    			direction = Direction.NORTHWEST; // NW
    		}else { //S
    			direction = Direction.NORTH; //N
    		}
    		yIncr *=-1;
    		xloc += xIncr;
    		yloc += yIncr;
    	}
    	else {
    		xloc += xIncr;
    		yloc += yIncr;
    	}
    }
	
	
	
}