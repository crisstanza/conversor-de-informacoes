package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Util {

	public static final PrintWriter getSaida(String caminho) throws IOException {
		return getSaida(caminho, false);
	}

	public static final PrintWriter getSaida(final String caminho, boolean append) throws IOException {
		return new PrintWriter(new BufferedWriter(new FileWriter(caminho, append)));
	}

	public static final BufferedReader getLeitor(final File caminho) throws FileNotFoundException {
		return new BufferedReader(new InputStreamReader(new FileInputStream(caminho)));
	}

	public static final String formatoDataHoraMinutoSegundoAtual() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}

	public static final String formatoDataAtualNomeDeArquivo() {
		return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}

	public static final boolean naoVazio(final Object obj) {
		return obj != null && !obj.toString().equals("");
	}

	public static final String toTitleCase(final String str) {
		final StringBuffer sb = new StringBuffer();
		if (str != null) {
			final String[] palavras = str.split("\\s+");
			for (int i = 0; i < palavras.length; i++) {
				if (i == 0) {
					sb.append(toFirstUpperCaseAlways(palavras[i]));
					if (tamanho(palavras[i]) == 1)
						sb.append(".");
				} else {
					sb.append(toFirstUpperCase(palavras[i]));
				}
				if (i < palavras.length - 1)
					sb.append(" ");
			}
		}
		return sb.toString();
	}

	private static final String toFirstUpperCase(final String str) {
		return toFirstUpperCase(str, false);
	}

	private static final String toFirstUpperCase(final String str, final boolean ignorarTamanho1) {
		if (str == null)
			return "";
		else if (tamanho(str) == 1 && ignorarTamanho1)
			return str.toLowerCase();
		else if (tamanho(str) == 1 && isConsoante(str))
			return str.toUpperCase() + ".";
		else if (isRomano(str))
			return str.toUpperCase();
		else if (isFirstUpperCaseAlways(str))
			return toFirstUpperCaseAlways(str);
		else if (isSigla(str))
			return str.toUpperCase();
		else if (tamanho(str) < 3)
			return str.toLowerCase();
		else if (isRodovia(str))
			return to2FirstUpperCaseAlways(str);
		else if (isContemApostrofo(str))
			return toApostrofoUpperCaseAlways(str);
		else
			return toFirstUpperCaseAlways(str);
	}

	private static final String toApostrofoUpperCaseAlways(final String str) {
		if (str == null) {
			return "";
		} else {
			final Matcher m = Pattern.compile("(\\w*+)'(\\w*+)").matcher(str);
			final StringBuffer sb = new StringBuffer();
			if (m.find())
				for (int i = 1; i <= m.groupCount(); i++)
					sb.append(toFirstUpperCase(m.group(i), true) + (i < m.groupCount() ? "'" : ""));
			return sb.toString();
		}
	}

	private static final boolean isContemApostrofo(final String str) {
		if (str == null)
			return false;
		else
			return str.indexOf('\'') >= 0;
	}

	public static final String toFirstUpperCaseAlways(final String str) {
		if (isSigla(str))
			return to2FirstUpperCaseAlways(str);
		else if (isContemApostrofo(str))
			return toApostrofoUpperCaseAlways(str);
		else if (str != null && str.length() > 0)
			return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
		else
			return "";
	}

	private static final boolean isRomano(final String str) {
		if (str == null)
			return false;
		else
			return str.toLowerCase().equals("ii") || str.toLowerCase().equals("xv");
	}

	private static final boolean isFirstUpperCaseAlways(final String str) {
		if (str == null)
			return false;
		else
			return str.toLowerCase().equals("um");
	}

	private static final int tamanho(final String str) {
		if (str == null)
			return -1;
		else
			return str.length();
	}

	private static final String to2FirstUpperCaseAlways(final String str) {
		if (str == null)
			return "";
		else if (tamanho(str) < 2)
			return str.toUpperCase();
		else
			return str.substring(0, 2).toUpperCase() + str.substring(2).toLowerCase();
	}

	private static final boolean isRodovia(final String str) {
		if (str == null)
			return false;
		else
			return str.toUpperCase().startsWith("BR-") || str.toUpperCase().startsWith("RS-") || str.toUpperCase().startsWith("SC-");
	}

	private static final boolean isSigla(final String str) {
		if (str == null)
			return false;
		else
			return str.equalsIgnoreCase("BR") || str.equalsIgnoreCase("RS") || str.equalsIgnoreCase("SC") || (tamanho(str) == 2 && str.endsWith("."));
	}

	private static final boolean isConsoante(final String str) {
		if (str == null)
			return false;
		else
			return str.equalsIgnoreCase("b") || str.equalsIgnoreCase("c") || str.equalsIgnoreCase("�") || str.equalsIgnoreCase("d") || str.equalsIgnoreCase("f") || str.equalsIgnoreCase("g") || str.equalsIgnoreCase("h") || str.equalsIgnoreCase("j") || str.equalsIgnoreCase("k") || str.equalsIgnoreCase("l") || str.equalsIgnoreCase("m") || str.equalsIgnoreCase("n") || str.equalsIgnoreCase("p") || str.equalsIgnoreCase("q") || str.equalsIgnoreCase("r") || str.equalsIgnoreCase("s") || str.equalsIgnoreCase("t") || str.equalsIgnoreCase("v") || str.equalsIgnoreCase("w") || str.equalsIgnoreCase("x") || str.equalsIgnoreCase("y") || str.equalsIgnoreCase("z");
	}

	public static final String toTelefonePadrao(String str) {
		if (str.length() == 13)
			if (str.indexOf(' ') == 4)
				str = str.substring(0, 9) + "-" + str.substring(9);
		return str;
	}

	public static final String corrigeBDOracle(final String str) {
		if (str == null)
			return null;
		else
			return str.replaceAll("'", "''");
	}

	public static final String corrigeBDPostgreSQL(final String str) {
		if (str == null)
			return null;
		else
			return str.replaceAll("'", "\'");
	}

	public static final boolean contem(int[] array, int n) {
		for (int i = 0; i < array.length; i++)
			if (array[i] == n)
				return true;
		return false;
	}

	public static final String leftPad(final String str, char caractere, int tamanho) {
		final StringBuffer sb = new StringBuffer(str);
		while (sb.length() < tamanho)
			sb.insert(0, caractere);
		return sb.toString();
	}

	public static final String getCaractereHexa(final int decimal) {
		return "\\\\\\\\x" + leftPad(Integer.toHexString(decimal).toUpperCase(), '0', 2);
	}

	public static final String getCaractereUnicode(final int decimal) {
		return "\\u" + leftPad(Integer.toHexString(decimal).toUpperCase(), '0', 4);
	}

	public static final String esvazia(final String str) {
		if (str == null)
			return "";
		else if (str.trim().equalsIgnoreCase("sem nome"))
			return "";
		else if (str.trim().equalsIgnoreCase("sem informacao"))
			return "";
		else
			return str.trim();
	}

	public static final String formatoValorSeparador(final String valor, final String separador) {
		if (naoVazio(valor))
			return valor + separador;
		return "";
	}

	public static final String formatoValorSeparador(final String valor1, final String separador, final String valor2) {
		if (naoVazio(valor1) && naoVazio(valor2))
			return valor1 + separador + valor2;
		else if (naoVazio(valor1))
			return valor1;
		else if (naoVazio(valor2))
			return valor2 + "";
		return "";
	}

	public static final String formatoValorSeparador(final String valor1, final String separador1, final String valor2, final String separador2, final String valor3) {
		return formatoValorSeparador(formatoValorSeparador(valor1, separador1, valor2), separador2, valor3);
	}

	public static final String formatoValorSeparador(final String valor1, final String separador1, final String valor2, final String separador2, final String valor3, final String separador3, final String valor4) {
		return formatoValorSeparador(formatoValorSeparador(valor1, separador1, valor2, separador2, valor3), separador3, valor4);
	}

	public static final String formatoValorSeparador(final String valor1, final String separador1, final String valor2, final String separador2, final String valor3, final String separador3, final String valor4, final String separador4, final String valor5) {
		return formatoValorSeparador(formatoValorSeparador(valor1, separador1, valor2, separador2, valor3, separador3, valor4), separador4, valor5);
	}

	public static final String formatoValorSeparador(final String valor1, final String separador1, final String valor2, final String separador2, final String valor3, final String separador3, final String valor4, final String separador4, final String valor5, final String separador5, final String valor6) {
		return formatoValorSeparador(formatoValorSeparador(valor1, separador1, valor2, separador2, valor3, separador3, valor4, separador4, valor5), separador5, valor6);
	}

	public static final int parseInt(final String str, final int retornoErro) {
		try {
			return Integer.parseInt(str);
		} catch (final Exception exc) {
			return retornoErro;
		}
	}

	public static final String primeiraPalavra(String str) {
		if (str == null) {
			return "";
		} else {
			str = str.trim();
			final int i = str.indexOf(' ');
			if (i > 0)
				return str.substring(0, i);
			else
				return str;
		}
	}

	public static final String eliminaPrimeiraPalavra(String str) {
		if (str == null) {
			return "";
		} else {
			str = str.trim();
			final int i = str.indexOf(' ');
			if (i > 0 && i < str.length())
				return str.substring(i + 1).trim();
			else
				return str;
		}
	}

	public static final int ultimoNumero(String str) {
		if (str == null) {
			return -1;
		} else {
			str = str.trim();
			final int i = str.lastIndexOf(',');
			if (i > 0 && i < str.length())
				return Util.parseInt(str.substring(i + 1).trim(), -1);
			else
				return -1;
		}
	}

	public static final String eliminaUltimoNumero(String str) {
		if (str == null) {
			return "";
		} else {
			str = str.trim();
			final int i = str.lastIndexOf(',');
			if (i > 0)
				return str.substring(0, i);
			else
				return str;
		}
	}

	public static String trataAcentos(String str) {
		return str.replaceAll("\u00C0", "\\\\u00C0").replaceAll("\u00C1", "\\\\u00C1").replaceAll("\u00C2", "\\\\u00C2").replaceAll("\u00C3", "\\\\u00C3").replaceAll("\u00C4", "\\\\u00C4").replaceAll("\u00C5", "\\\\u00C5").replaceAll("\u00C6", "\\\\u00C6").replaceAll("\u00C7", "\\\\u00C7").replaceAll("\u00C8", "\\\\u00C8").replaceAll("\u00C9", "\\\\u00C9").replaceAll("\u00CA", "\\\\u00CA").replaceAll("\u00CB", "\\\\u00CB").replaceAll("\u00CC", "\\\\u00CC").replaceAll("\u00CD", "\\\\u00CD").replaceAll("\u00CE", "\\\\u00CE").replaceAll("\u00CF", "\\\\u00CF").replaceAll("\u00D0", "\\\\u00D0").replaceAll("\u00D1", "\\\\u00D1").replaceAll("\u00D2", "\\\\u00D2").replaceAll("\u00D3", "\\\\u00D3").replaceAll("\u00D4", "\\\\u00D4").replaceAll("\u00D5", "\\\\u00D5").replaceAll("\u00D6", "\\\\u00D6").replaceAll("\u00D8", "\\\\u00D8").replaceAll("\u00D9", "\\\\u00D9").replaceAll("\u00DA", "\\\\u00DA").replaceAll("\u00DB", "\\\\u00DB").replaceAll("\u00DC", "\\\\u00DC")
				.replaceAll("\u00DD", "\\\\u00DD").replaceAll("\u00DE", "\\\\u00DE").replaceAll("\u00DF", "\\\\u00DF").replaceAll("\u00E0", "\\\\u00E0").replaceAll("\u00E1", "\\\\u00E1").replaceAll("\u00E2", "\\\\u00E2").replaceAll("\u00E3", "\\\\u00E3").replaceAll("\u00E4", "\\\\u00E4").replaceAll("\u00E5", "\\\\u00E5").replaceAll("\u00E6", "\\\\u00E6").replaceAll("\u00E7", "\\\\u00E7").replaceAll("\u00E8", "\\\\u00E8").replaceAll("\u00E9", "\\\\u00E9").replaceAll("\u00EA", "\\\\u00EA").replaceAll("\u00EB", "\\\\u00EB").replaceAll("\u00EC", "\\\\u00EC").replaceAll("\u00ED", "\\\\u00ED").replaceAll("\u00EE", "\\\\u00EE").replaceAll("\u00EF", "\\\\u00EF").replaceAll("\u00F0", "\\\\u00F0").replaceAll("\u00F1", "\\\\u00F1").replaceAll("\u00F2", "\\\\u00F2").replaceAll("\u00F3", "\\\\u00F3").replaceAll("\u00F4", "\\\\u00F4").replaceAll("\u00F5", "\\\\u00F5").replaceAll("\u00F6", "\\\\u00F6").replaceAll("\u00F8", "\\\\u00F8").replaceAll("\u00F9", "\\\\u00F9")
				.replaceAll("\u00FA", "\\\\u00FA").replaceAll("\u00FB", "\\\\u00FB").replaceAll("\u00FC", "\\\\u00FC").replaceAll("\u00FD", "\\\\u00FD").replaceAll("\u00FE", "\\\\u00FE").replaceAll("\u00FF", "\\\\u00FF");
	}

	public static final String trataPontoFinal(final String str) {
		if (str == null)
			return "";
		else if (!str.endsWith(".") && !str.endsWith("?") && !str.endsWith("!"))
			return str + ".";
		else
			return str;
	}

	public static final Date parseDataBR(final String data) {
		try {
			final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			f.setLenient(false);
			return f.parse(data);
		} catch (final Exception exc) {
			return null;
		}
	}

	public static final String formatoDataBR(final Date data) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
	}

	public static final String formatoDataBR(final Date data, final String retornoErro) {
		try {
			return formatoDataBR(data);
		} catch (final Exception exc) {
			return retornoErro;
		}
	}

	public static final String corrigeXML(final String str) {
		if (str == null)
			return "";
		else
			return str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll("&amp;", "&").replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
	}

	public static final String trimQuotes(final String str) {
		if (str == null) {
			return null;
		}
		if (str.length() == 0) {
			return str;
		}
		final StringBuilder sb = new StringBuilder(str);
		if (str.charAt(str.length() - 1) == '"') {
			sb.deleteCharAt(str.length() - 1);
		}
		if (sb.length() > 0 && sb.charAt(0) == '"') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static final String fixJS(final String str) {
		return str.replaceAll("'", "\\\\'");
	}

	public static final String rightTrimComma(final String str) {
		if (str == null) {
			return null;
		}
		if (str.length() == 0) {
			return str;
		}
		final StringBuilder sb = new StringBuilder(str);
		if (str.charAt(str.length() - 1) == ';') {
			sb.deleteCharAt(str.length() - 1);
		}
		return sb.toString();
	}

}