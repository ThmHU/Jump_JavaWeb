package util;

import java.io.IOException;

import javax.validation.constraints.Max;

import org.junit.Test;

public class Adb {
	
	public Adb() {
		// TODO Auto-generated constructor stub
	}
	String cmd;
	@Test
	public void getScreencap(){
		
		try {
			cmd = "adb shell screencap -p /sdcard/1.png";
			Runtime.getRuntime().exec(cmd);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void pullScreencap(){
		cmd = "adb pull /sdcard/1.png" +Constants.IMG_POSITION;
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void jump(int distance){
		
	    int press_time = (int) (distance * Constants.PRESS_COEFFICIENT);
	    press_time = Math.max(press_time, 200); //设置 200 ms 是最小的按压时间
	    
	    cmd = "adb shell input swipe "+Constants.TOUCH_POSITION +press_time;
	    try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
