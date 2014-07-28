import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jcron.JCron;
import util.Util;

public final class Main extends AMain {

	private static final int TAMANHO_LOTE = Integer.MAX_VALUE;

	public static final void main(final String[] args) throws IOException {
		new Main().go();
	}

	private final void go() throws IOException {

		final JCron cronometroParcial = new JCron(), cronometroTotal = new JCron();
		cronometroTotal.start();
		cronometroParcial.start();

		println();
		print("Lendo arquivos de entrada...");
		final List<File> arquivosEntrada = getArquivosEntrada();
		println(" ...arquivos de entrada lidos.");
		println(cronometroParcial.stopRead());
		println();

		cronometroParcial.start();
		println();
		print("Convertendo dados...");
		final List<Dado> dados = getDados(arquivosEntrada);
		println(" ...dados convertidos.");
		println(cronometroParcial.stopRead());
		println();

		// cronometroParcial.start();
		// println();
		// print("Randomizando dados...");
		// Collections.shuffle(dados);
		// println(" ...dados randomizados.");
		// println(cronometroParcial.stopRead());
		// println();

		cronometroParcial.start();
		println();
		print("Escrevendo dados...");
		escreveSaida(dados);
		cronometroParcial.stop();
		println(" ...dados escritos.");
		println(cronometroParcial.stopRead());
		println();

		println();
		println("Tempo total: " + cronometroTotal.stopRead());
		println();
		println();
	}

	private final void escreveSaida(final List<Dado> dados) throws IOException {
		PrintWriter escritor = getSaida("main-index.js");
		escritor.println("var MainIndex = {");
		escritor.println("	trabalhos: [");
		Dado dado;
		for (int i = 0; i < dados.size() && i < TAMANHO_LOTE; i++) {
			dado = dados.get(i);
			escritor.println("		{");
			escritor.println("			_a: '" + dado.areas + "', _b: " + dado.id + ",");
			escritor.println("			_d: '" + dado.titulo + "',");
			escritor.println("			_e: '" + dado.autor + "', _f: '" + dado.coautores + "'");
			escritor.println("		},");
		}
		escritor.println("	]");
		escritor.println("};");
		escritor.close();
	}

	private final List<Dado> getDados(final List<File> arquivosEntrada) throws IOException {
		final List<Dado> dados = new ArrayList<Dado>();
		File arquivo;
		for (int i = 0; i < arquivosEntrada.size(); i++) {
			arquivo = arquivosEntrada.get(i);
			dados.addAll(getDados(arquivo));
		}
		return dados;
	}

	private final List<Dado> getDados(final File arquivo) throws IOException {
		final List<Dado> dados = new ArrayList<Dado>();
		final BufferedReader leitor = Util.getLeitor(arquivo);
		for (String linha; (linha = leitor.readLine()) != null;) {
			if (isValid(linha)) {
				dados.add(getDado(linha));
			}
		}
		leitor.close();
		return dados;
	}

	private final boolean isValid(final String linha) {
		return !linha.startsWith("\"Areas\";\"ID\";");
	}

	private final Dado getDado(final String linha) {
		Dado dado = new Dado();
		final String[] parts = linha.trim().split(";");
		dado.areas = Util.trimQuotes(Util.fixJS(parts[0]));
		dado.id = Util.trimQuotes(Util.fixJS(parts[1]));
		// dado.quemSubmeteu = parts[2];
		dado.titulo = Util.trimQuotes(Util.fixJS(parts[3]));
		dado.autor = Util.trimQuotes(Util.fixJS(parts[4]));
		dado.coautores = Util.trimQuotes(Util.fixJS(parts[5]));
		// dado.status = parts[6];
		return dado;
	}

	private final class Dado {
		private String areas;
		private String id;
		// private String quemSubmeteu;
		private String titulo;
		private String autor;
		private String coautores;
		// private String status;
	}

}