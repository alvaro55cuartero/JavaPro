package test.elf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

	private static byte[] e_ident;
	private static byte[] e_type;
	private static byte[] e_machine;
	private static byte[] e_version;
	private static byte[] e_entry;
	private static byte[] e_phoff;
	private static byte[] e_shoff; // bytes del inicio del documento a la tabla de encabezados de
	// secciones
	private static byte[] e_flags;
	private static byte[] e_ehsize;
	private static byte[] e_phentsize;
	private static byte[] e_phnum;
	private static byte[] e_shentsize; // tamaño de las entradas de la tabla de encabezados de secciones
	private static byte[] e_shnum; // numero de entradas en la tabla de encabezados de secciones
	private static byte[] e_shstrndx;

	public static void main(String[] args) {
		try {
			elf(Files.readAllBytes(Paths.get("res/mkdir")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void elf(byte[] txt) {
		e_ident = Arrays.copyOfRange(txt, 0, 16);
		e_type = Arrays.copyOfRange(txt, 16, 18);
		e_machine = Arrays.copyOfRange(txt, 18, 20);
		e_version = Arrays.copyOfRange(txt, 20, 24);
		e_entry = Arrays.copyOfRange(txt, 24, 32);
		e_phoff = Arrays.copyOfRange(txt, 32, 40);
		e_shoff = Arrays.copyOfRange(txt, 40, 48);
		e_flags = Arrays.copyOfRange(txt, 48, 52);
		e_ehsize = Arrays.copyOfRange(txt, 52, 54);
		e_phentsize = Arrays.copyOfRange(txt, 54, 56);
		e_phnum = Arrays.copyOfRange(txt, 56, 58);
		e_shentsize = Arrays.copyOfRange(txt, 58, 60);
		e_shnum = Arrays.copyOfRange(txt, 60, 62);
		e_shstrndx = Arrays.copyOfRange(txt, 62, 64);
		System.out.println("Elf Header 00 00 00 00 -> " + byteToString(e_ehsize));

		int ie_phnum = (int) byteToInt(e_phnum);
		int ie_shnum = (int) byteToInt(e_shnum);
		long le_shoff = byteToInt(e_shoff);
		long le_shentsize = byteToInt(e_shentsize);

		ElfSection[] sections = new ElfSection[ie_shnum];
		byte[] programs = new byte[ie_phnum];
		for (int i = 0; i < ie_shnum; i++) {
			long tem = le_shoff + le_shentsize * i;
			sections[i] = new ElfSection(txt, tem, tem + le_shentsize);
			// System.out.println(sections[i].toString());

		}
		for (int i = 0; i < ie_shnum; i++) {
			// System.out.println(Arrays.toString(sections[i].section));
		}

		// System.out.println(new String(sections[28].section));

	}

	public static String byteToString(byte[] bytes) {
		String r = "";
		for (int i = bytes.length - 1; i > -1; i--) {

			if (bytes[i] == 0) {

			} else {
				r = r + " " + bytes[i];
			}

		}
		return r;

	}

	public static long byteToInt(byte[] bytes) {
		int val = 0;
		int temp = 0;
		if (bytes.length > 8)
			throw new RuntimeException("Too big to fit in int");
		for (int i = bytes.length - 1; i > -1; i--) {
			val = val << 8;
			temp = (bytes[i] & 0xFF);
			val = val | temp;
		}
		return val;
	}

	public static byte[] copyOfRange(byte[] original, long from, long to) {
		long newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		byte[] copy = new byte[(int) newLength];

		System.arraycopy(original, (int) from, copy, 0, (int) Math.min(original.length - from, newLength));
		return copy;
	}
}
