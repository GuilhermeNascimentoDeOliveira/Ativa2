package controller;



import  java.io.BufferedReader ;
import  java.io.IOException ;
import  java.io.InputStream ;
import  java.io.InputStreamReader ;

public  class  Killcontroller {

	public  void  initProcess ( processo de string  ) {
		tente {
			Tempo de execução . getRuntime() . exec(processo);
		} catch ( Exceção e) {
			Erro de cadeia = e . getMensagem();

			if (erro . contém( " 2 " )) {
				Sistema . erro . println( " Aplicação não encontrada " );
			}
			if (erro . contém( " 740 " )) {
				StringBuffer buffer =  new  StringBuffer ();
				buffer . append( " cmd/c " );
				buffer . anexar( "  " );
				buffer . anexar(processo);

				String cmdCred = buffer . para sequenciar();

				tente {
					Tempo de execução . getRuntime() . exec(cmdCred);
				} catch ( Exceção e1) {
					Sistema . erro . println( " Chamada de aplicação inválida " );
				}
			}
		}
	}

		public  void  killProcess ( processo de string  ) {
			String os =  System . getProperty( " os.nome " );
			String cmdNome =  " " ;
			String cmdPid =  " " ;
			if (os . contém( " Windows " )) {
				cmdNome =  " TASKKILL /IM " ;
				cmdPid =  " TASKKILL /PID " ;
			}
			if (os . contém( " Linux " )) {
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
			Processo p = Tempo de  execução . getRuntime() . exec(processo);
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
			Sistema . erro . println( " Chamada inválida " );
			e . printStackTrace();
			}
			}


}