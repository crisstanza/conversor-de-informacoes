import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public abstract class AMain {

	/**
	 * L&ecirc; todos os arquivos do diret&oacute;rio de entrada, recursivamente, e retorna uma lista de objetos <code>File</code>.
	 * 
	 * @return Lista de objetos <code>File</code> com todos os arquivos de entrada.
	 */
	protected List<File> getArquivosEntrada() {
		List<File> arquivosEntrada = new ArrayList<File>();
		getArquivosEntrada(arquivosEntrada);
		return arquivosEntrada;
	}

	private final void getArquivosEntrada(final List<File> arquivosEntrada) {
		File d = new File("in");
		if (d.isDirectory())
			getarquivosEntrada(arquivosEntrada, d);
		else
			throw new IllegalArgumentException("Origem deve ser uma pasta: " + d.getAbsolutePath());
	}

	private final void getarquivosEntrada(final List<File> arquivosEntrada, final File d) {
		final File[] arqs = d.listFiles();
		for (int i = 0; i < arqs.length; i++) {
			if (arquivo(arqs[i])) {
				if (arquivoValido(arqs[i]))
					arquivosEntrada.add(arqs[i]);
			} else {
				getarquivosEntrada(arquivosEntrada, arqs[i]);
			}
		}
	}

	private final boolean arquivo(final File arquivo) {
		return arquivo.isFile();
	}

	private final boolean arquivoValido(final File arquivo) {
		return !arquivo.getName().startsWith(".");
	}

	protected final PrintWriter getSaida(final String nome) throws IOException {
		return Util.getSaida("out/" + nome);
	}

	protected final void println() {
		System.out.println();
	}

	protected final void println(final Object o) {
		System.out.println(o.toString());
	}

	protected final void print(final Object o) {
		System.out.print(o.toString());
	}

}