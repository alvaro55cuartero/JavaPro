package test.elf;

import java.io.IOException;
import java.util.Arrays;

import tools.Lector;

public class Main {

	private byte[] e_ident;
	private short e_type;
	private short e_machine;
	private byte[] e_version;
	private byte[] e_entry;
	private byte[] e_phoff;
	private byte[] e_shoff; // bytes del inicio del documento a la tabla de encabezados de
							// secciones
	private byte[] e_flags;
	private byte[] e_ehsize;
	private byte[] e_phentsize;
	private byte[] e_phnum;
	private byte[] e_shentsize; // tamaño de las entradas de la tabla de encabezados de secciones
	private byte[] e_shnum; // numero de entradas en la tabla de encabezados de secciones
	private byte[] e_shstrndx;

	public static void main(String[] args) {
		try {
			elf(Lector.leerArchivoTexto("res/elf.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void elf(byte[] txt) {
		this.e_ident = Arrays.copyOfRange(txt, 0, 15);
		this.e_type = Arrays.copyOfRange(txt, 16, 17);
		this.e_machine = Arrays.copyOfRange(txt, 18, 19);
		this.e_version = Arrays.copyOfRange(txt, 20, 23);
		this.e_entry = Arrays.copyOfRange(txt, 24, 31);
		this.e_phoff = Arrays.copyOfRange(txt, 32, 39);
		this.e_shoff = Arrays.copyOfRange(txt, 40, 47);
		this.e_flags = Arrays.copyOfRange(txt, 48, 51);
		this.e_ehsize = Arrays.copyOfRange(txt, 52, 53);
		this.e_phentsize = Arrays.copyOfRange(txt, 54, 55);
		this.e_phnum = Arrays.copyOfRange(txt, 56, 57);
		this.e_shentsize = Arrays.copyOfRange(txt, 58, 59);
		this.e_shnum = Arrays.copyOfRange(txt, 60, 61);
		this.e_shstrndx = Arrays.copyOfRange(txt, 62, 63);

		for (int i = 0; i < e_phnum; i++) {

		}
	}

}
