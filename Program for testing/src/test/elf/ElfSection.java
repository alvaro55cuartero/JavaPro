package test.elf;

import java.util.Arrays;

public class ElfSection {

	byte[] sectionHeader;
	byte[] sh_name;
	byte[] sh_type;
	byte[] sh_flags;
	byte[] sh_addr;
	byte[] sh_offset;
	byte[] sh_size;
	byte[] sh_link;
	byte[] sh_info;
	byte[] sh_addralign;
	byte[] sh_entsize;
	byte[] section;

	public ElfSection(byte[] section, long from, long to) {

		byte[] temp = copyOfRange(section, from, to);

		this.sectionHeader = temp;
		this.sh_name = Arrays.copyOfRange(temp, 0, 4);
		this.sh_type = Arrays.copyOfRange(temp, 4, 8);
		this.sh_flags = Arrays.copyOfRange(temp, 8, 16);
		this.sh_addr = Arrays.copyOfRange(temp, 16, 24);
		this.sh_offset = Arrays.copyOfRange(temp, 24, 32);
		this.sh_size = Arrays.copyOfRange(temp, 32, 40);
		this.sh_link = Arrays.copyOfRange(temp, 40, 48);
		this.sh_info = Arrays.copyOfRange(temp, 40, 48);
		this.sh_addralign = Arrays.copyOfRange(temp, 48, 56);
		this.sh_entsize = Arrays.copyOfRange(temp, 56, 64);

		long lsh_offset = Main.byteToInt(sh_offset);
		long lsh_size = Main.byteToInt(sh_size);

		this.section = copyOfRange(section, lsh_offset, lsh_offset + lsh_size);

	}

	public String toString() {
		return "sh_name: " + sh_name + "\n" + "sh_type: " + sh_type + "\n" + "sh_flags: " + sh_flags + "\n"
				+ "sh_addr: " + sh_addr + "\n" + "sh_offset: " + sh_size + "\n" + "sh_link: " + sh_link + "\n"
				+ "sh_info: " + sh_info + "\n" + "sh_addralign: " + sh_addralign + "\n" + "sh_entsize: " + sh_entsize
				+ "\n";
	}

	public static void name(String txt, long off) {

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
