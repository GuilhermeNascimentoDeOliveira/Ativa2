package controller;



import  java.io.BufferedReader ;
import  java.io.IOException ;
import  java.io.InputStream ;
import  java.io.InputStreamReader ;

public  class  Killcontroller {

	public  void  initProcess ( processo de string  ) {
		tente {
			Tempo de execu��o . getRuntime() . exec(processo);
		} catch ( Exce��o e) {
			Erro de cadeia = e . getMensagem();

			if (erro . cont�m( " 2 " )) {
				Sistema . erro . println( " Aplica��o n�o encontrada " );
			}
			if (erro . cont�m( " 740 " )) {
				StringBuffer buffer =  new  StringBuffer ();
				buffer . append( " cmd/c " );
				buffer . anexar( "  " );
				buffer . anexar(processo);

				String cmdCred = buffer . para sequenciar();

				tente {
					Tempo de execu��o . getRuntime() . exec(cmdCred);
				} catch ( Exce��o e1) {
					Sistema . erro . println( " Chamada de aplica��o inv�lida " );
				}
			}
		}
	}

		public  void  killProcess ( processo de string  ) {
			String os =  System . getProperty( " os.nome " );
			String cmdNome =  " " ;
			String cmdPid =  " " ;
			if (os . cont�m( " Windows " )) {
				cmdNome =  " TASKKILL /IM " ;
				cmdPid =  " TASKKILL /PID " ;
			}
			if (os . cont�m( " Linux " )) {
				cmdPid =  " matar -9 " ;
				cmdNome =  " pkill -f " ;
			}

			int pid =  0 ;
			StringBuffer buffer =  new  StringBuffer ();

			tente {
				pid =  inteiro . parseInt(processo);
				buffer . append(cmdPid);
				buffer . anexar( "  " );
				buffer . anexar(pid);
			} catch ( NumberFormatException e) {
				buffer . append(cmdNome);
				buffer . anexar( "  " );
				buffer . anexar(processo);
			}
			initProcess(buffer . toString());
		}

		public  String  os () {
			 sistema de retorno . getProperty( " os.pid " );
		}

		public  void  readProcess ( processo de string  ) {
			tente {
			Processo p = Tempo de  execu��o . getRuntime() . exec(processo);
			InputStream fluxo = p . getInputStream();
			leitor InputStreamReader =  new  InputStreamReader (fluxo);
			BufferedReader buffer =  new  BufferedReader (leitor);
			String linha = buffer . Leia a linha();
			while (linha !=  null ) {
			Sistema . fora . println(linha);
			linha = buffer . Leia a linha();
			}
			buffer . Fechar();
			leitor . Fechar();
			fluxo . Fechar();
			} catch ( IOException e) {
			Sistema . erro . println( " Chamada inv�lida " );
			e . printStackTrace();
			}
			}


}