package test.elf;

import tools.Lector;

public class Main {
	enum header {
		e_ident, e_type, e_machine, e_versio, e_entry, e_phoff, e_shoff, e_flags, e_ehsize, e_phentsize, e_phnum, e_shentsize, e_shnum, e_shstrndx
	};

	public static void main(String[] args) {
		Lector.leerArchivoTexto();
	}

	public String[] getH(header h) {
		switch (h) {
		case e_ident:
			return null;
		case e_type:
			return null;
		case e_machine:
			return null;
		}
		return null;
	}
}
