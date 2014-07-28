package util;

import java.io.File;
import java.io.PrintWriter;

/**
 * Classe <i>LoggerUtil</i> - Servi�os de log de mensagens.
 * 
 * @author Cristiano S. Neves
 * @since 17/03/2007
 */
public abstract class LoggerUtil {
	private static final File f = new File(LoggerUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile().toString().replaceAll("%20", " "));

	public static final void logBooth(final String str) {
		System.out.println(str);
		log(str);
	}

	public static final void log(final String str) {
		try {
			final PrintWriter saida = getSaida();
			saida.println();
			saida.println(Util.formatoDataHoraMinutoSegundoAtual());
			saida.println();
			saida.println(str);
			saida.println();
			saida.close();
		} catch (final Exception e2) {
			e2.printStackTrace();
		}
	}

	public static final void log(final Exception e) {
		try {
			final PrintWriter saida = getSaida();
			saida.println();
			saida.println(Util.formatoDataHoraMinutoSegundoAtual());
			saida.println();
			e.printStackTrace(saida);
			saida.println();
			saida.close();
		} catch (final Exception e2) {
			e2.printStackTrace();
		}
	}

	private static final PrintWriter getSaida() throws Exception {
		return Util.getSaida(f.getParentFile().getParentFile().getAbsolutePath() + File.separator + "log_" + Util.formatoDataAtualNomeDeArquivo() + ".log", true);
	}

	public static final void logClean(final String str) {
		try {
			final PrintWriter saida = getSaida();
			saida.print(str);
			saida.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static final void logClean(final Exception e) {
		try {
			final PrintWriter saida = getSaida();
			e.printStackTrace(saida);
			saida.close();
		} catch (final Exception e2) {
			e2.printStackTrace();
		}
	}

	public static final void logCleanln(final Exception e) {
		try {
			final PrintWriter saida = getSaida();
			e.printStackTrace(saida);
			saida.println();
			saida.close();
		} catch (final Exception e2) {
			e2.printStackTrace();
		}
	}

	public static final void logCleanln(final String str) {
		try {
			final PrintWriter saida = getSaida();
			saida.println(str);
			saida.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}