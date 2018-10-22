package test.elf;

import java.util.Arrays;

public class ElfSection {

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

	public ElfSection(byte[] section) {

		this.sh_name = Arrays.copyOfRange(section, 0, 3);
		this.sh_type = Arrays.copyOfRange(section, 4, 7);
		this.sh_flags = Arrays.copyOfRange(section, 8, 11);
		this.sh_addr = Arrays.copyOfRange(section, 12, 15);
		this.sh_offset = Arrays.copyOfRange(section, 16, 19);
		this.sh_size = Arrays.copyOfRange(section, 20, 23);
		this.sh_link = Arrays.copyOfRange(section, 24, 27);
		this.sh_info = Arrays.copyOfRange(section, 28, 31);
		this.sh_addralign = Arrays.copyOfRange(section, 32, 35);
		this.sh_entsize = Arrays.copyOfRange(section, 36, 39);
	}

	public String toString() {
		return "sh_name: " + sh_name + "\n" + "sh_type: " + sh_type + "\n" + "sh_flags: " + sh_flags + "\n"
				+ "sh_addr: " + sh_addr + "\n" + "sh_offset: " + sh_size + "\n" + "sh_link: " + sh_link + "\n"
				+ "sh_info: " + sh_info + "\n" + "sh_addralign: " + sh_addralign + "\n" + "sh_entsize: " + sh_entsize
				+ "\n";
	}

}
