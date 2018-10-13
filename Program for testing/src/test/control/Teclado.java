package test.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	public String t = "";

	public Tecla tA = new Tecla();
	public Tecla tB = new Tecla();
	public Tecla tC = new Tecla();
	public Tecla tD = new Tecla();
	public Tecla tE = new Tecla();
	public Tecla tF = new Tecla();
	public Tecla tG = new Tecla();
	public Tecla tH = new Tecla();
	public Tecla tI = new Tecla();
	public Tecla tJ = new Tecla();
	public Tecla tK = new Tecla();
	public Tecla tL = new Tecla();
	public Tecla tM = new Tecla();
	public Tecla tN = new Tecla();
	public Tecla tO = new Tecla();
	public Tecla tP = new Tecla();
	public Tecla tQ = new Tecla();
	public Tecla tR = new Tecla();
	public Tecla tS = new Tecla();
	public Tecla tT = new Tecla();
	public Tecla tU = new Tecla();
	public Tecla tV = new Tecla();
	public Tecla tW = new Tecla();
	public Tecla tX = new Tecla();
	public Tecla tY = new Tecla();
	public Tecla tZ = new Tecla();
	public Tecla t0 = new Tecla();
	public Tecla t1 = new Tecla();
	public Tecla t2 = new Tecla();
	public Tecla t3 = new Tecla();
	public Tecla t4 = new Tecla();
	public Tecla t5 = new Tecla();
	public Tecla t6 = new Tecla();
	public Tecla t7 = new Tecla();
	public Tecla t8 = new Tecla();
	public Tecla t9 = new Tecla();
	public Tecla tdot = new Tecla();
	public Tecla tcoma = new Tecla();
	public Tecla tsemicolon = new Tecla();
	public Tecla backSpace = new Tecla();
	public Tecla tEnter = new Tecla();
	public Tecla tEsc = new Tecla();
	public Tecla tSpace = new Tecla();
	public Tecla tMas = new Tecla();
	public Tecla tMenos = new Tecla();

	public boolean shift = false;

	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			tA.teclaPulsada();
			if(shift) {
				t = "A";
			}else {
				t = "a";
			}
			break;
		case KeyEvent.VK_B:
			tB.teclaPulsada();
			if(shift) {
				t = "B";
			}else {
				t = "b";
			}
			break;
		case KeyEvent.VK_C:
			tC.teclaPulsada();
			if(shift) {
				t = "C";
			}else {
				t = "c";
			}
			break;
		case KeyEvent.VK_D:
			tD.teclaPulsada();
			if(shift) {
				t = "D";
			}else {
				t = "d";
			}
			break;
		case KeyEvent.VK_E:
			tE.teclaPulsada();
			if(shift) {
				t = "E";
			}else {
				t = "e";
			}
			break;
		case KeyEvent.VK_F:
			tF.teclaPulsada();
			if(shift) {
				t = "F";
			}else {
				t = "f";
			}
			break;
		case KeyEvent.VK_G:
			tG.teclaPulsada();
			if(shift) {
				t = "G";
			}else {
				t = "g";
			}
			break;
		case KeyEvent.VK_H:
			tH.teclaPulsada();
			if(shift) {
				t = "H";
			}else {
				t = "h";
			}
			break;
		case KeyEvent.VK_I:
			tI.teclaPulsada();
			if(shift) {
				t = "I";
			}else {
				t = "i";
			}
			break;
		case KeyEvent.VK_J:
			tJ.teclaPulsada();
			if(shift) {
				t = "J";
			}else {
				t = "j";
			}
			break;
		case KeyEvent.VK_K:
			tK.teclaPulsada();
			if(shift) {
				t = "K";
			}else {
				t = "k";
			}
			break;
		case KeyEvent.VK_L:
			tL.teclaPulsada();
			if(shift) {
				t = "L";
			}else {
				t = "l";
			}
			break;
		case KeyEvent.VK_M:
			tM.teclaPulsada();
			if(shift) {
				t = "M";
			}else {
				t = "m";
			}
			break;
		case KeyEvent.VK_N:
			tN.teclaPulsada();
			if(shift) {
				t = "N";
			}else {
				t = "n";
			}
			break;
		case KeyEvent.VK_O:
			tO.teclaPulsada();
			if(shift) {
				t = "O";
			}else {
				t = "o";
			}
			break;
		case KeyEvent.VK_P:
			tP.teclaPulsada();
			if(shift) {
				t = "P";
			}else {
				t = "p";
			}
			break;
		case KeyEvent.VK_Q:
			tQ.teclaPulsada();
			if(shift) {
				t = "Q";
			}else {
				t = "q";
			}
			break;
		case KeyEvent.VK_R:
			tR.teclaPulsada();
			if(shift) {
				t = "R";
			}else {
				t = "r";
			}
			break;
		case KeyEvent.VK_S:
			tS.teclaPulsada();
			if(shift) {
				t = "S";
			}else {
				t = "s";
			}
			break;
		case KeyEvent.VK_T:
			tT.teclaPulsada();
			if(shift) {
				t = "T";
			}else {
				t = "t";
			}
			break;
		case KeyEvent.VK_U:
			tU.teclaPulsada();
			if(shift) {
				t = "U";
			}else {
				t = "u";
			}
			break;
		case KeyEvent.VK_V:
			tV.teclaPulsada();
			if(shift) {
				t = "V";
			}else {
				t = "v";
			}
			break;
		case KeyEvent.VK_W:
			tW.teclaPulsada();
			if(shift) {
				t = "W";
			}else {
				t = "w";
			}
			break;
		case KeyEvent.VK_X:
			tX.teclaPulsada();
			if(shift) {
				t = "X";
			}else {
				t = "x";
			}
			break;
		case KeyEvent.VK_Y:
			tY.teclaPulsada();
			if(shift) {
				t = "Y";
			}else {
				t = "y";
			}
			break;
		case KeyEvent.VK_Z:
			tZ.teclaPulsada();
			if(shift) {
				t = "Z";
			}else {
				t = "z";
			}
			break;
		case KeyEvent.VK_0:
			t0.teclaPulsada();
			if(shift) {
				t = "=";
			}else {
				t = "0";
			}
			break;
		case KeyEvent.VK_1:
			t1.teclaPulsada();
			t = "1";
			break;
		case KeyEvent.VK_2:
			t2.teclaPulsada();
			t = "2";
			break;
		case KeyEvent.VK_3:
			t3.teclaPulsada();
			t = "3";
			break;
		case KeyEvent.VK_4:
			t4.teclaPulsada();
			t = "4";
			break;
		case KeyEvent.VK_5:
			t5.teclaPulsada();
			t = "5";
			break;
		case KeyEvent.VK_6:
			t6.teclaPulsada();
			t = "6";
			break;
		case KeyEvent.VK_7:
			t7.teclaPulsada();
			t = "7";
			break;
		case KeyEvent.VK_8:
			t8.teclaPulsada();
			t = "8";
			break;
		case KeyEvent.VK_9:
			t9.teclaPulsada();
			t = "9";
			break;
		case KeyEvent.VK_PERIOD:
			tcoma.teclaPulsada();
			t = ".";
			break;
		case KeyEvent.VK_COMMA:
			tdot.teclaPulsada();
			t = ",";
			break;
		case KeyEvent.VK_SHIFT:
			shift = true;
			break;
		case KeyEvent.VK_BACK_SPACE:
			backSpace.teclaPulsada();
			break;
		case KeyEvent.VK_ENTER:
			tEnter.teclaPulsada();
			break;
		case KeyEvent.VK_ESCAPE:
			tEsc.teclaPulsada();
			break;
		case KeyEvent.VK_SPACE:
			tSpace.teclaPulsada();
			t = " ";
			break;
		case KeyEvent.VK_CLOSE_BRACKET:
			tMas.teclaPulsada();
			t = "+";
			break;
		case KeyEvent.VK_SLASH:
			tMenos.teclaPulsada();
			t = "-";
			break;
			
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			tA.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_B:
			tB.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_C:
			tC.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_D:
			tD.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_E:
			tE.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_F:
			tF.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_G:
			tG.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_H:
			tH.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_I:
			tI.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_J:
			tJ.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_K:
			tK.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_L:
			tL.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_M:
			tM.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_N:
			tN.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_O:
			tO.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_P:
			tP.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_Q:
			tQ.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_R:
			tR.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_S:
			tS.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_T:
			tT.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_U:
			tU.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_V:
			tV.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_W:
			tW.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_X:
			tX.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_Y:
			tY.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_Z:
			tZ.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_0:
			t0.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_1:
			t1.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_2:
			t2.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_3:
			t3.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_4:
			t4.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_5:
			t5.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_6:
			t6.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_7:
			t7.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_8:
			t8.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_9:
			t9.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_PERIOD:
			tdot.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_COMMA:
			tcoma.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_SHIFT:
			shift = false;
			break;
		case KeyEvent.VK_BACK_SPACE:
			backSpace.teclaLiberada();
			break;
		case KeyEvent.VK_ENTER:
			tEnter.teclaLiberada();
			break;
		case KeyEvent.VK_ESCAPE:
			tEsc.teclaLiberada();
			break;
		case KeyEvent.VK_SPACE:
			tSpace.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_CLOSE_BRACKET:
			tMas.teclaLiberada();
			t = "";
			break;
		case KeyEvent.VK_SLASH:
			tMenos.teclaLiberada();
			t = "";
			break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void clear() {
		t = "";
	}
}