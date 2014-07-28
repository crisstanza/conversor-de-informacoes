package jcron;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.Locale;

import javax.swing.text.NumberFormatter;

public final class JCron {
	public static final int START = 1;
	public static final int STOP = 2;
	private int estado;
	private Date i;
	private Date f;

	public JCron() {
		set();
	}

	private final void set() {
		estado = STOP;
		i = new Date();
		f = i;
	}

	public final void start() {
		if (estado != START) {
			estado = START;
			i = new Date();
		}
	}

	public final void stop() {
		estado = STOP;
		f = new Date();
	}

	public final String stopRead() {
		stop();
		return read();
	}

	public final void reset() {
		set();
	}

	public final String read() {
		long restante = (estado == STOP ? f : new Date()).getTime() - i.getTime(); // numero de mili segundos

		final long horas = (long) (restante / (1000.0 * 60 * 60));
		restante %= 60 * 60 * 1000;

		final long minutos = (long) (restante / (1000.0 * 60));
		restante %= 1000 * 60;

		final double segundos = restante / (1000.0);

		try {
			return "[ " + horas + " hora" + Util.plural(horas) + " | " + minutos + " minuto" + Util.plural(minutos) + " | " + Util.formatoDecimal3(segundos) + " segundo" + Util.plural(segundos) + " ]";
		} catch (final Exception exc) {
			return "[ - ]";
		}
	}

	private static final class Util {
		private static final NumberFormatter nf = new NumberFormatter(new DecimalFormat("#,##0.000", new DecimalFormatSymbols(new Locale("pt", "BR"))));

		private static final String plural(final long n) {
			return n == 1 ? "" : "s";
		}

		private static final String plural(final double n) {
			return n == 1 ? "" : "s";
		}

		private static final String formatoDecimal3(final double n) throws Exception {
			return nf.valueToString(new Double(n));
		}
	}

}