package util;

public abstract class AbreviaturasUtil {
	public static final String[][] ABREVIATURAS_NOMES = new String[][] { new String[] { "ab", "abade" }, new String[] { "abs", "abadessa" }, new String[] { "adva", "advogada" }, new String[] { "advo", "advogado" }, new String[] { "alm", "almirante" }, new String[] { "arc", "arcebispo" }, new String[] { "arq", "arquiteto" }, new String[] { "arqa", "arquiteta" }, new String[] { "av", "aviador" }, new String[] { "bpo", "bispo" }, new String[] { "br", "barao" }, new String[] { "bra", "baronesa" }, new String[] { "brg", "brigadeiro" }, new String[] { "bta", "beata" }, new String[] { "bto", "beato" }, new String[] { "cad", "cadete" }, new String[] { "calh", "cavalheiro" }, new String[] { "cap", "capitao" }, new String[] { "card", "cardeal" }, new String[] { "cb", "cabo" }, new String[] { "cd", "conde" }, new String[] { "cda", "condessa" }, new String[] { "cdor", "comendador" }, new String[] { "cdor", "comr" }, new String[] { "cel", "coronel" }, new String[] { "cinet", "cineasta" },
			new String[] { "cmisa", "comissaria" }, new String[] { "cmiso", "comissario" }, new String[] { "cmte", "comandante" }, new String[] { "cnsa", "conselheira" }, new String[] { "cnso", "conselheiro" }, new String[] { "con", "conego" }, new String[] { "d", "dom" }, new String[] { "da.", "dona" }, new String[] { "del", "delegado" }, new String[] { "dent", "dentista" }, new String[] { "dep", "deputado" }, new String[] { "depa", "deputada" }, new String[] { "des", "desembargador" }, new String[] { "dq", "duque" }, new String[] { "dqa", "duquesa" }, new String[] { "dr", "doutor" }, new String[] { "dra", "doutora" }, new String[] { "emb", "embaixador" }, new String[] { "embz", "embaixatriz" }, new String[] { "eng", "engenheiro" }, new String[] { "enga", "engenheira" }, new String[] { "fr", "frei" }, new String[] { "gal", "general" }, new String[] { "gen", "general" }, new String[] { "gov", "governador" }, new String[] { "imp", "imperador" }, new String[] { "impz", "imperatriz" },
			new String[] { "inf", "infante" }, new String[] { "jorn", "jornalista" }, new String[] { "maj", "major" }, new String[] { "mal", "marechal" }, new String[] { "me", "madre" }, new String[] { "min", "ministro" }, new String[] { "mme", "madame" }, new String[] { "mns", "monsenhor" }, new String[] { "mq", "marques" }, new String[] { "mqa", "marquesa" }, new String[] { "mte", "mestre" }, new String[] { "mto", "maestro" }, new String[] { "pe", "padre" }, new String[] { "prca", "princesa" }, new String[] { "prce", "principe" }, new String[] { "prce", "princ" }, new String[] { "pref", "prefeito" }, new String[] { "prefa", "prefeita" }, new String[] { "pres", "presidente" }, new String[] { "presb", "presbitero" }, new String[] { "prf", "professor" }, new String[] { "prof", "professor" }, new String[] { "prfa", "professora" }, new String[] { "prq", "parque" }, new String[] { "pst", "pastor" }, new String[] { "reg", "regente" }, new String[] { "rev", "reverendo" },
			new String[] { "rpt", "reporter" }, new String[] { "s", "sao" }, new String[] { "sd", "soldado" }, new String[] { "sen", "senador" }, new String[] { "sgt", "sargento" }, new String[] { "srg", "sargento" }, new String[] { "sta", "santa" }, new String[] { "sto", "santo" }, new String[] { "ten", "tenente" }, new String[] { "ten-cel", "ten-cel." }, // nao desabreviado por ser muito longo
			new String[] { "ver", "vereador" }, new String[] { "vera", "vereadora" }, new String[] { "vet", "veterinaria" }, new String[] { "vet", "veterinario" }, new String[] { "vig", "vigario" }, new String[] { "vsc", "visconde" }, new String[] { "vsca", "viscondessa" }, new String[] { "a", "a" }, new String[] { "b", "b" }, new String[] { "c", "c" }, new String[] { "d", "d" }, new String[] { "e", "e" }, new String[] { "f", "f" }, new String[] { "g", "g" }, new String[] { "h", "h" }, new String[] { "i", "i" }, new String[] { "j", "j" }, new String[] { "k", "k" }, new String[] { "l", "l" }, new String[] { "m", "m" }, new String[] { "n", "n" }, new String[] { "o", "o" }, new String[] { "p", "p" }, new String[] { "q", "q" }, new String[] { "r", "r" }, new String[] { "t", "s" }, new String[] { "u", "t" }, new String[] { "u", "u" }, new String[] { "v", "v" }, new String[] { "w", "w" }, new String[] { "x", "x" }, new String[] { "y", "y" }, new String[] { "z", "z" }, };
	public static final String[][] ABREVIATURAS_LOGRADOUROS = new String[][] { new String[] { "av", "avenida" }, new String[] { "ac", "acesso" }, new String[] { "al", "alameda" }, new String[] { "bc", "beco" }, new String[] { "calc", "calcada" }, new String[] { "esc", "escada" }, new String[] { "estr", "estrada" }, new String[] { "estrad", "estrada" }, new String[] { "lg", "largo" },
	/**/new String[] { "lrg", "lrg" }, new String[] { "pca", "praca" }, new String[] { "p\u00E7a", "praca" }, new String[] { "pte", "ponte" }, new String[] { "r", "rua" }, new String[] { "rtn", "retorno" }, new String[] { "rtt", "rotatoria" }, new String[] { "rod", "rodovia" }, new String[] { "rot", "rot" }, // PENDENTE !!!
			new String[] { "srv", "servidao" }, new String[] { "spc", "spc" }, // PENDENTE !!!
			new String[] { "st", "setor" }, new String[] { "trav", "travessa" }, new String[] { "tv", "travessa" }, new String[] { "vd", "viaduto" }, new String[] { "ve", "viela" }, new String[] { "vl", "viela" }, new String[] { "q", "q" }, };
	public final static String[][] CARACTERES_ESPECIAIS_XML = new String[][] { new String[] { "\"", "&quot;" }, new String[] { "&", "&amp;" }, new String[] { "<", "&lt;" }, new String[] { ">", "&gt;" }, };

	public static final String desconverteCaractereEspecialXML(String str) {
		String[] abreviatura;
		for (int i = 0; i < CARACTERES_ESPECIAIS_XML.length; i++) {
			abreviatura = CARACTERES_ESPECIAIS_XML[i];
			str = str.replaceAll(abreviatura[1], abreviatura[0]);
		}
		return str;
	}

	public static final String converteCaractereEspecialXML(String str) {
		str = desconverteCaractereEspecialXML(str);
		String[] abreviatura;
		for (int i = 0; i < CARACTERES_ESPECIAIS_XML.length; i++) {
			abreviatura = CARACTERES_ESPECIAIS_XML[i];
			str = str.replaceAll(abreviatura[0], abreviatura[1]);
		}
		return str;
	}

	public static final String desabreviaNome(final String str) {
		return desabreviaFrase(str, ABREVIATURAS_NOMES);
	}

	public static final String desabreviaLogradouro(final String str) {
		return desabreviaFrase(str, ABREVIATURAS_LOGRADOUROS);
	}

	public static final String abreviaNome(final String str) {
		return abreviaFrase(str, ABREVIATURAS_NOMES);
	}

	public static final String abreviaLogradouro(final String str) {
		return abreviaFrase(str, ABREVIATURAS_LOGRADOUROS);
	}

	private static final String desabreviaFrase(final String str, final String[][] abreviaturas) {
		final String[] palavras = str.split(" ");
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < palavras.length; i++)
			sb.append(desabreviaPalavra(palavras[i], i < palavras.length - 1 ? palavras[i + 1] : "", abreviaturas) + (i < palavras.length - 1 ? " " : ""));
		return sb.toString();
	}

	private static final String abreviaFrase(final String str, final String[][] abreviaturas) {
		final String[] palavras = str.split(" ");
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < palavras.length; i++)
			sb.append(abreviaPalavra(palavras[i], i < palavras.length - 1 ? palavras[i + 1] : "", abreviaturas) + (i < palavras.length - 1 ? " " : ""));
		return sb.toString();
	}

	private static final String abreviaPalavra(final String str, final String proxima, final String[][] abreviaturas) {
		if (!isRodovia(proxima)) {
			String[] abreviatura;
			for (int i = 0; i < abreviaturas.length; i++) {
				abreviatura = abreviaturas[i];
				if (str.equalsIgnoreCase(abreviatura[1]))
					return abreviatura[0] + ".";
			}
		}
		return str;
	}

	private static final String desabreviaPalavra(final String str, final String proxima, final String[][] abreviaturas) {
		if (!isRodovia(proxima)) {
			String[] abreviatura;
			for (int i = 0; i < abreviaturas.length; i++) {
				abreviatura = abreviaturas[i];
				if (str.equalsIgnoreCase(abreviatura[0]) || str.equalsIgnoreCase(abreviatura[0] + "."))
					return abreviatura[1];
			}
		}
		return str;
	}

	private static final boolean isRodovia(final String str) {
		if (str == null)
			return false;
		else
			return str.toLowerCase().startsWith("cento") || str.toLowerCase().startsWith("duzentos") || str.toLowerCase().startsWith("trezentos");
	}

}