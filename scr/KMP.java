
public class KMP {
	
	public void getKMP(String padrao, String texto) {
		int M = padrao.length();
		int N = texto.length();

		// criar lps[] que irá manter o mais longo
		// valores de sufixo de prefixo para padrão
		int lps[] = new int[M];
		int j = 0; // index for pat[]

		// Pré-processar o padrão (calcular lps[]
		// array)
		//computeLPSArray(padrao, M, lps);
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] é sempre 0

		// o loop calcula lps[i] para i = 1 a M-1
		while (i < M) {
			if (padrao.charAt(i) == padrao.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				// Isso é complicado. Considere o exemplo.
				// AAACAAAA e i = 7. A ideia é semelhante
				// para a etapa de pesquisa.
				if (len != 0) {
					len = lps[len - 1];

					// Além disso, observe que não incrementamos
					// i aqui
				} else // se (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
		

		int total = 0;
		i = 0; // índice para txt[]
		while ((N - i) >= (M - j)) {
			total = total + 1;
			if (padrao.charAt(j) == texto.charAt(i)) {
				j++;
				i++;

			}
			if (j == M) {
				System.out.println("Padrão encontrado no índice: " + (i - j));
				j = lps[j - 1];
				// total = total +1;
				System.out.println("Total de Comparações: " + total);

			}

			// incompatibilidade após j correspondências
			else if (i < N && padrao.charAt(j) != texto.charAt(i)) {
				// Não corresponda aos caracteres lps[0..lps[j-1]],
				// eles vão combinar de qualquer maneira

				if (j != 0) {
					j = lps[j - 1];

				} else {
					i = i + 1;
				}
			}
		}

	}
	
}
