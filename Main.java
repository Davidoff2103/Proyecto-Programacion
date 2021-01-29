package minijuegos;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	//*********************************************************************************************
	//** Nombre de la funci�n: main
	//** Explicaci�n de lo que hace la funci�n: Muestra la pantalla principal del m�dulo de juegos.
	//** Par�metros de entrada: String[] args.
	//** Par�metros de salida: -
	//*********************************************************************************************
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int eleccion = 0;								//variable para guardar la elecci�n del usuario.
	do {System.out.println("     ///////////////     \n/////////////////////////");	
		System.out.println("//  M�dulo de juegos.  //");
		System.out.println("//  1. Jugar.          //");
		System.out.println("//  2. Informaci�n.    //");
		System.out.println("//  3. Autores.        //");
		System.out.println("//  4. Versi�n.        //");
		System.out.println("//  0. Salir.          //\n/////////////////////////\n     ///////////////");
		eleccion = reader.nextInt();
		if(eleccion<0 || eleccion>4) {
			System.err.println("Por favor, introduce un n�mero v�lido.");
		}
	}while(eleccion<0 || eleccion>4);		//control de errores.
		if(eleccion == 1) {		//if que lleva a una secci�n o a otra seg�n el n�mero introducido por el usuario.
			jugar();	
		}else if(eleccion == 2) {
			informacion();	
		}else if(eleccion == 3) {
			autores();
		}else if(eleccion == 4) {
			version();	
		}else {
			salir();
		}
	}
	
	//********************************************************************************************************
	//** Nombre de la funci�n: informacion
	//** Explicaci�n de lo que hace la funci�n: Permite elegir de qu� juego se quieren leer las instrucciones.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//********************************************************************************************************
	public static void informacion () throws InterruptedException {
		Scanner reader = new Scanner (System.in);
		System.out.println("\n                Instrucciones");
		libro();
		int instrucciones = 0;		//variable para elegir de qu� juego se quieren leer las instrucciones.
		do {
			System.out.println("\n�De qu� juego quieres ver las instrucciones?\n1. OCA\n2. EL PISTOLERO\n3. LUCHA\n\n0. Volver atr�s");
			instrucciones = reader.nextInt();
			if(instrucciones < 0 || instrucciones > 3) {
				System.err.println("Por favor, introduce un n�mero de juego v�lido.");
			}
		}while(instrucciones < 0 || instrucciones > 3);		//control de errores.
		if(instrucciones == 1) {		//if que lleva a unas instrucciones o a otras seg�n el n�mero introducido por el usuario.
			instruccionesOca();
		}
		else if(instrucciones == 2) {
			instruccionesPistolero();
		}
		else if (instrucciones == 3){
			instruccionesLucha();
		}
		else {
			System.out.println("\n\n\n\n");
			main(null);
		}
	}
	
	//******************************************************************************************
	//** Nombre de la funci�n: libro
	//** Explicaci�n de lo que hace la funci�n: Muestra un libro en la secci�n de instrucciones.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//******************************************************************************************
	public static void libro () {
		System.out.println("      __...--~~~~~-._   _.-~~~~~--...__\r\n" + 
				"    //               `V'               \\\\ \r\n" + 
				"   //                 |                 \\\\ \r\n" + 
				"  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ \r\n" + 
				" //__.....----~~~~._\\ | /_.~~~~----.....__\\\\\r\n" + 
				"====================\\\\|//====================\r\n" + 
				"                    `---`");
	}
	
	//****************************************************************************************
	//** Nombre de la funci�n: instruccionesOca
	//** Explicaci�n de lo que hace la funci�n: Explica el funcionamiento del juego de la Oca.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//****************************************************************************************
	public static void instruccionesOca () throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int volver = 0;		//variable para volver atr�s.
		System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("//  Se trata del tradicional juego de mesa conocido como 'La Oca'.                                                                                                  //\n"+		//se muestran las instrucciones del juego de la Oca.
							"//  Ofrece la opci�n de dos jugadores y la de jugar contra la IA.                                                                                                   //\n" +
							"//  El juego consiste en ir avanzando en el tablero por turnos hasta llegar al final.                                                                               //\n" +
							"//  Hay varias casillas con diferentes tipos de consecuencias, y son las que se exponen a continuaci�n:                                                             //\n" +
							"//	-	2: casilla de Oca. Se salta a la siguiente casilla con el mismo s�mbolo y se vuelve a tirar.                                                        //\n" +
							"//	-	B: casilla de Puente (bridge en ingl�s). Se salta a la otra casilla con el mismo s�mbolo (en ambos sentidos) y se vuelve a tirar.                   //\n" +
							"//	-	P: casilla de Posada. Al caer en esta casilla, se pierde un turno.                                                                                  //\n" +
							"//	-	D: casilla de Dados. Se salta a la otra casilla con el mismo s�mbolo (en ambos sentidos) y se vuelve a tirar.                                       //\n" +
							"//	-	W: casilla de Pozo (water well en ingl�s). Al caer en esta casilla, se pierden dos turnos.                                                          //\n" +
							"//	-	L: casilla de Laberinto. Al caer en esta casilla, se retrocede a la casilla 30.                                                                     //\n" +
							"//	-	C: casilla de C�rcel. Al caer en esta casilla, se pierden dos turnos.                                                                               //\n" +
							"//	-	S: casilla de Calavera (skull en ingl�s). Al caer en esta casilla, se retrocede a la primera casilla y se vuelve a empezar.                         //\n" +
							"//	-	O: casilla libre. Las casillas representadas con una O est�n libres y, por lo tanto, no sucede nada al caer en ellas.                               //\n" +
							"//                                                                                                                                                                  //\n"+
							"//  El ganador ser� el primero en llegar al final del tablero, y lo tendr� que conseguir entrando exacto.                                                           //");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\nEscribe 0 para volver atr�s y cualquier n�mero para volver a la pantalla principal.\n");
		volver = reader.nextInt();
		if(volver == 0) {		//si se escribe 0, se vuelve al men� de instrucciones.
			informacion();
		}
		else {		//si se escribe cualquier otro n�mero, se vuelve a la pantalla principal.
			System.out.println("\n\n\n\n");
			main(null);
		}
	}
	
	//********************************************************************************************
	//** Nombre de la funci�n: instruccionesPistolero
	//** Explicaci�n de lo que hace la funci�n: Explica el funcionamiento del juego del pistolero.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//********************************************************************************************
	public static void instruccionesPistolero () throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int volver = 0;		//variable para volver atr�s.
		System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("//  El juego del pistolero es apto para jugar contra otro jugador o contra la IA, y es lo primero que te hace escoger. Despu�s empezar� el juego.                   //\n"+		//se muestran las instrucciones del juego de la Oca.
							"//  Cuando empieza, los dos jugadores empiezan con 5 vidas y 0 balas. En el primer turno solo se pueden marcar las opciones de recargar o cubrirse,                 //\n" +
							"//  ya que al no tener balas no se puede disparar. Una vez se haya recargado, si disparas con menos de 3 balas se le restar� 1 de vida al oponente,                 //\n" +
							"//  en cambio, si disparas con 3 o m�s balas, si el oponente no se cubre, se le restar� 3 de vida, a eso se le llama usar la metralleta.                            //\n" +
							"//  Si el oponente se cubre y le disparas sin la metralleta no se le restara vida, pero si se le ataca con metralleta y se cubre se le restara 1 de vida.           //\n" +
							"//  Para ganar, deber�s quitarle las 5 vidas al contrincante y evitar que te las quiten a ti.                                                                       //\n" +
							"//                                                                                                                                                                  //\n"+
							"//  Es importante que los dos jugadores sean honestos y no miren cuando el rival haga su elecci�n en cada turno.                                                    //\n"+
							"//  Finalmente, si acaba la ronda y los dos jugadores a�n tienen vidas, se repetir� de nuevo con los datos actualizados y as� consecutivamente                      //\n" +
							"//  hasta que uno de los dos o los dos jugadores se queden sin vidas.                                                                                               //");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\nEscribe 0 para volver atr�s y cualquier n�mero para volver a la pantalla principal.\n");
		volver = reader.nextInt();
		if(volver == 0) {		//si se escribe 0, se vuelve al men� de instrucciones.
			informacion();
		}
		else {		//si se escribe cualquier otro n�mero, se vuelve a la pantalla principal.
			System.out.println("\n\n\n\n");
			main(null);
		}
	}
	
	//***************************************************************************************
	//** Nombre de la funci�n: instruccionesLucha
	//** Explicaci�n de lo que hace la funci�n: Explica el funcionamiento del juego de lucha.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//***************************************************************************************
	public static void instruccionesLucha () throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int volver = 0;		//variable para volver atr�s.
		System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("//  El juego de lucha es bastante sencillo, los jugadores deben elegir un combatiente entre los 5 que hay.                                                          //\n"+
							"//  Una vez escogidos, se mostraran las habilidades (ataque, escudo, velocidad y salud) de cada uno de los combatientes.                                            //\n"+
							"//  hay que mirar esas habilidades atentamente puesto que no se van a mostrar m�s a lo largo de la partida,                                                         //\n"+
							"//  y los jugadores deber�n elegir su estrategia seg�n como se va desarrollando la partida.                                                                         //\n"+
							"//  Una vez mostradas las habilidades en el inicio, se pedir� a los dos jugadores que indiquen cu�l es su decisi�n (atacar o defender).                             //\n"+
							"//  Aqu� es donde entran en juego las habilidades, si un jugador elige atacar y el otro defender, el defensor se ver� �recompensado�                                //\n"+
							"//  usando su escudo que evitar� que le reste el da�o directamente a su vida. En el caso de que los dos jugadores indiquen que quieren atacar,                      //\n"+
							"//  el atacante ser� el jugador que tenga m�s velocidad y el enemigo se defender� �nicamente con su vida.                                                           //\n"+
							"//  Por �ltimo, en el caso que los dos jugadores decidan defenderse, ninguno recibir� ni provocar� ning�n da�o.                                                     //\n"+
							"//                                                                                                                                                                  //\n"+
							"//  Es importante que los dos jugadores sean honestos y no miren cuando el rival haga su elecci�n en cada turno.                                                    //\n"+
							"//  Una vez finalizada la ronda, si ning�n combatiente ha muerto, se pasar� a la siguiente ronda, en caso contrario, el combatiente vencedor se proclamar� ganador. //");
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\nEscribe 0 para volver atr�s y cualquier n�mero para volver a la pantalla principal.\n");
		volver = reader.nextInt();
		if(volver == 0) {		//si se escribe 0, se vuelve al men� de instrucciones.
			informacion();
		}
		else {		//si se escribe cualquier otro n�mero, se vuelve a la pantalla principal.
			System.out.println("\n\n\n\n");
			main(null);
		}
	}
	
	//************************************************************************************
	//** Nombre de la funci�n: jugar
	//** Explicaci�n de lo que hace la funci�n: Men� de selecci�n de juega.
	//** Par�metros de entrada: -
	//** Par�metros de salida: Variables de juego y vs.
	//************************************************************************************
	public static void jugar () throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int juego = 0;		//variable para la elecci�n del juego.
		System.out.println("\n�A qu� juego quieres jugar?\n1. OCA"+dibujoOca()+"\n\n2. EL PISTOLERO"+dibujoPistolero()+"\n3. LUCHA"+dibujoLucha());
		do {
			juego = reader.nextInt();
			if(juego<1 || juego>3) {
				System.err.println("Por favor, introduce un n�mero v�lido.");
			}
		}while(juego<1 || juego>3);		//control de errores.
		seleccionRival(juego);		//se llama a la siguiente funci�n pasando el juego elegido.
	}
	
	//************************************************************************************
	//** Nombre de la funci�n: seleccionRival
	//** Explicaci�n de lo que hace la funci�n: Men� de selecci�n de rival.
	//** Par�metros de entrada: Variables juego y vs.
	//** Par�metros de salida: Variables juego y vs.
	//************************************************************************************
	public static void seleccionRival (int juego) throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int vs = 0;		//variable para la elecci�n del rival.
		do {
			System.out.println("\n�Contra qui�n quieres jugar?");
			System.out.println("1- Contra otro jugador.\n2- Contra la IA.");
			vs = reader.nextInt();
			if(vs != 1 && vs !=2) {
				System.err.println("Por favor, introduce un n�mero v�lido.");
			}
		}while(vs != 1 && vs !=2);		//control de errores.
		if(juego==1) {		//if que lleva a un juego o a otro pasando el rival elegido.
				oca(vs);
		}
		else if (juego==2) {
				pistolero(vs);			
		}
		else {
				pelea(vs);			
		}
	}
	
	//***********************************************************************************************************
	//** Nombre de la funci�n: dibujoOca
	//** Explicaci�n de lo que hace la funci�n: Muestra el dibujo de la Oca en la pantalla de selecci�n de juego.
	//** Par�metros de entrada: -
	//** Par�metros de salida: String oca.
	//***********************************************************************************************************
	public static String dibujoOca () {
		String oca = " ";
		oca =   "\n" +
				"      _ __/\\\r\n" + 
				"  /\\_\\      \\\r\n" + 
				" |           \\\r\n" + 
				" |             \\           ___\r\n" + 
				"  \\             \\        /  _ \\\r\n" + 
				" _|              \\      {  ( \\^)\r\n" + 
				" \\                \\     \\  \\  \\|\r\n" + 
				"  \\                \\     \\  \\\r\n" + 
				"  --                \\ ____)  \\\r\n" + 
				" \\                            \\\r\n" + 
				"  |                           )\r\n" + 
				"___\\_________________________/____________\r\n" + 
				"   ..........................             ~~~~\r\n" + 
				"  ............................\r\n" + 
				"  .............................\r\n" + 
				" ...............................\r\n" + 
				"...............................\r\n" + 
				"..............................";
		return oca;
	}
	
	//***************************************************************************************************************
	//** Nombre de la funci�n: dibujoPistolero
	//** Explicaci�n de lo que hace la funci�n: Muestra el dibujo del Pistolero en la pantalla de selecci�n de juego.
	//** Par�metros de entrada: -
	//** Par�metros de salida: String pistolero.
	//***************************************************************************************************************
	public static String dibujoPistolero () {
		String pistolero = " ";
		pistolero =   "\n" +
				"  (                                 _\r\n" + 
				"   )                               /=>\r\n" + 
				"  (  +____________________/\\/\\___ / /|\r\n" + 
				"   .''._____________'._____      / /|/\\\r\n" + 
				"  : () :              :\\ ----\\|    \\ )\r\n" + 
				"   '..'______________.'0|----|      \\\r\n" + 
				"                    0_0/____/        \\\r\n" + 
				"                        |----    /----\\\r\n" + 
				"                       || -\\\\ --|      \\\r\n" + 
				"                       ||   || ||\\      \\\r\n" + 
				"                        \\\\____// '|      \\\r\n" + 
				"Bang! Bang!                     .'/       |\r\n" + 
				"                               .:/        |\r\n" + 
				"                               :/_________|\r\n";
		return pistolero;
	}
	
	//*************************************************************************************************************
	//** Nombre de la funci�n: dibujoLucha
	//** Explicaci�n de lo que hace la funci�n: Muestra el dibujo de la Lucha en la pantalla de selecci�n de juego.
	//** Par�metros de entrada: -
	//** Par�metros de salida: String lucha.
	//*************************************************************************************************************
	public static String dibujoLucha () {
		String lucha = " ";
		lucha =   "\n" +
				"   |\\                     /)\r\n" + 
				" /\\_\\\\__               (_//\r\n" + 
				"|   `>\\-`     _._       //`)\r\n" + 
				" \\ /` \\\\  _.-`:::`-._  //\r\n" + 
				"  `    \\|`    :::    `|/\r\n" + 
				"        |     :::     |\r\n" + 
				"        |.....:::.....|\r\n" + 
				"        |:::::::::::::|\r\n" + 
				"        |     :::     |\r\n" + 
				"        \\     :::     /\r\n" + 
				"         \\    :::    /\r\n" + 
				"          `-. ::: .-'\r\n" + 
				"           //`:::`\\\\\r\n" + 
				"          //   '   \\\\\r\n" + 
				"         |/         \\\\";
		return lucha;
	}
	
	//*******************************************************************************************************************************
	//** Nombre de la funci�n: autores
	//** Explicaci�n de lo que hace la funci�n: Muestra los autores del m�dulo de minijuegos y permite volver a la pantalla anterior.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//*******************************************************************************************************************************	
	public static void autores () throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int volver = 0;		//variable para volver atr�s.
		mano();
		System.out.println("\nM�dulo de juegos hecho por: David Blanco, Sergi Pifarr� y Daniel Romero.");
		do{
			System.out.println("0. Volver");
			volver = reader.nextInt();
			if(volver != 0) {
				System.err.println("Por favor, introduce un n�mero v�lido.");
			}
		}while(volver != 0);		//control de errores.
		main(null);
	}
	
	//************************************************************************************
	//** Nombre de la funci�n: mano
	//** Explicaci�n de lo que hace la funci�n: Muestra una mano en la secci�n de autores.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//************************************************************************************	
	public static void mano () {
		System.out.println("                                                      .\r\n" + 
				"                                                    .' \\\r\n" + 
				"                                                  .'    .\r\n" + 
				"                                                .'  ...'.`\r\n" + 
				"                                       ___.-. .'  ...'.'\r\n" + 
				"                                 _.---'   `..'  ...'.'\r\n" + 
				"                          __.---'         .'  ...'.'\r\n" + 
				"                      .--'              .'  ...'.'.\r\n" + 
				"                     /`               .'  ...'.'   `.\r\n" + 
				"                    /               .'  ...'.'       `.\r\n" + 
				"                   /              .'  ...'.'           `-.\r\n" + 
				"                  /             .'  ...'.'                `.\r\n" + 
				"                 /       ` _.-.'  ...'                      `-._____.-'\r\n" + 
				"                /        /  .'  ...'\r\n" + 
				"               /`       / .'. ...'\r\n" + 
				"              /        /.'  .`.'   \\\r\n" + 
				"             /        .'  ...'  |   \\ /\r\n" + 
				"            /\\      .'  ...'     \\   |\r\n" + 
				"           / /    .'  ...' /      \\  |\r\n" + 
				"          /_/   .'  ...'  /  |    |  |'\r\n" + 
				"          `._..' .-------.__________.'\r\n" + 
				"            .' .'----\r\n" + 
				"          .'   |     |      |\r\n" + 
				"        .'  ....     |    |\r\n" + 
				"      .'  ...'| \\ __.'     |                                        ___\r\n" + 
				"     / \\...'   \\_`------------------._____                  ___.---'\r\n" + 
				"    /  .-'            |    | \\__/         `--.__        _.-'\r\n" + 
				"   /.-'                \\__/                     `------'\r\n" + 
				"  '");
	}
	
	//******************************************************************************************************************************
	//** Nombre de la funci�n: version
	//** Explicaci�n de lo que hace la funci�n: Muestra la versi�n del m�dulo de minijuegos y permite volver a la pantalla anterior.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//******************************************************************************************************************************	
	public static void version () throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		int volver = 0;		//variable para volver atr�s.
		versionDibujo();
		System.out.println("\nVersi�n del m�dulo de juegos: v.1.0");
		do{
			System.out.println("0. Volver");
			volver = reader.nextInt();
			if(volver != 0) {
				System.err.println("Por favor, introduce un n�mero v�lido.");
			}
		}while(volver != 0);		//control de errores.
		System.out.println("\n\n\n\n");
		main(null);
	}
	
	//***************************************************************************************
	//** Nombre de la funci�n: versionDibujo
	//** Explicaci�n de lo que hace la funci�n: Muestra un joystick en la secci�n de versi�n.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//***************************************************************************************
	public static void versionDibujo () {
		System.out.println("                ___\r\n" + 
				"              ,\"---\".\r\n" + 
				"              :     ;\r\n" + 
				"               `-.-'\r\n" + 
				"                | |\r\n" + 
				"                | |\r\n" + 
				"                | |\r\n" + 
				"             _.-\\_/-._\r\n" + 
				"          _ / |     | \\ _\r\n" + 
				"         / /   `---'   \\ \\\r\n" + 
				"        /  `-----------'  \\\r\n" + 
				"       /,-\"\"-.       ,-\"\"-.\\\r\n" + 
				"      ( i-..-i       i-..-i )\r\n" + 
				"      |`|    |-------|    |'|\r\n" + 
				"      \\ `-..-'  ,=.  `-..-'/\r\n" + 
				"       `--------|=|-------'\r\n" + 
				"                | |\r\n" + 
				"                \\ \\\r\n" + 
				"                 ) )    \r\n" + 
				"                / /\r\n" + 
				"               ( (");
	}
	
	//************************************************************************************
	//** Nombre de la funci�n: salir
	//** Explicaci�n de lo que hace la funci�n: Finaliza el programa.
	//** Par�metros de entrada: -
	//** Par�metros de salida: -
	//************************************************************************************		
	public static void salir () {
		System.out.println("   _____                 _ _                \r\n" + 
				"  / ____|               | | |               \r\n" + 
				" | |  __  ___   ___   __| | |__  _   _  ___ \r\n" + 
				" | | |_ |/ _ \\ / _ \\ / _` | '_ \\| | | |/ _ \\\r\n" + 
				" | |__| | (_) | (_) | (_| | |_) | |_| |  __/\r\n" + 
				"  \\_____|\\___/ \\___/ \\__,_|_.__/ \\__, |\\___|\r\n" + 
				"                                  __/ |     \r\n" + 
				"                                 |___/      ");
		System.out.println("\nGracias por jugar con nosotros. �Vuelve pronto!");
	}
	
	//*************************************************************************************************************************************
	//** Nombre de la funci�n: oca
	//** Explicaci�n de lo que hace la funci�n: Genera los tableros y todas las variables del juego de la Oca.
	//** Par�metros de entrada: Variables vs.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//*************************************************************************************************************************************
	public static void oca (int vs) throws InterruptedException {
		//se crean los arrays de char del tablero base y de los tableros de los jugadores.
		char[] tablero = {'2','O','O','O','2','B','O','O','2','O','O','B','O','2','O','O','O','2','P','O','O','O','2','O','O','D','2','O','O','O','W','2','O','O','O','2','O','O','O','O','2','L','O','O','2','O','O','O','O','2','O','O','D','2','O','C','O','S','2','O','O','O','2'};
		char[] tableroJ1 = {'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'};
		char[] tableroJ2 = {'Y','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'};
		int J1 = 0;		//variables para controlar la posici�n de cada jugador.
		int J2 = 0;
		int pTJ1 = 0;	//variables para controlar las p�rdidas de turno.
		int pTJ2 = 0;
		int tirada1 = 0;	//variable para guardar cada tirada.
		int tirada2 = 0;
		Thread.sleep(100);
		System.err.println("\n\n/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		Thread.sleep(100);
		for (int i = 0; i < tablero.length; i++) {		//bucle for que muestra el tablero base.		
			System.out.print(tablero[i]+"| ");
		} Thread.sleep(100);
		System.err.println("\n/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		Thread.sleep(100);
		System.out.println();
		for (int i = 0; i < tableroJ1.length; i++) {		//bucle for que muestra el tablero del jugador 1.
			System.out.print(tableroJ1[i]+"| ");
		}
		System.out.println("\n");
		for (int i = 0; i < tableroJ2.length; i++) {		//bucle for que muestra el tablero del jugador 2 / IA.
			System.out.print(tableroJ2[i]+"| ");
		} tiradaOcaJ1(vs, tablero, tableroJ1, tableroJ2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: tiradaOcaJ1
	//** Explicaci�n de lo que hace la funci�n: Hace los procesos necesarios para la tirada del jugador 1.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void tiradaOcaJ1(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException {
		Random aleatorio = new Random();
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		Thread.sleep(2000);
		System.out.println("\n\n\n\n\n\n\n\nJugador 1, haz 'Enter' para tirar el dado:");
		Thread.sleep(100);
		System.err.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		Thread.sleep(100);
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i]+"| ");
		}
		Thread.sleep(100);
		System.err.println("\n/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		Thread.sleep(100);
		for (int i = 0; i < t1.length; i++) {		//bucle for que muestra el tablero del jugador 1.
			System.out.print(t1[i]+"| ");
		}
		reader.nextLine();
		tirada1 = aleatorio.nextInt(6)+1;		//tirada aleatoria del jugador 1.
		System.out.println("\nHa salido un "+tirada1);
		t1[J1]='O';		//se pone una O en la posici�n anterior.
		comprobacionesTiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);		//se pasa a comprobar si la ficha debe rebotar.
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesTiradaOcaJ1
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 1 tiene que rebotar al llegar al final del tablero.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void comprobacionesTiradaOcaJ1(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException {
		if((J1+tirada1)<62 || (J1+tirada1)==62) {		//se comprueba si la nueva posici�n es el final del tablero o si est� dentro de los m�rgenes.
			J1=J1+tirada1;
			t1[J1]='X';
		}
		else if((J1+tirada1)>62 && (62-((J1+tirada1)-62))<=62) {		//si se sale de los m�rgenes, se actualiza la posici�n para que rebote.
			J1=62-((J1+tirada1)-62);
			t1[J1]='X';
		}
		Thread.sleep(1000);
		for (int i = 0; i < t1.length; i++) {		//bucle for que muestra el tablero del jugador 1.	
			System.out.print(t1[i]+"| ");
		}
		comprobacionesOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);		//se pasa a comprobar la casilla.
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: tiradaOcaJ2
	//** Explicaci�n de lo que hace la funci�n: Hace los procesos necesarios para la tirada del jugador 2.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void tiradaOcaJ2(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException {
		Random aleatorio = new Random();
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		Thread.sleep(2000);
		if(vs==1) {
			System.out.println("\n\n\n\n\n\n\n\nJugador 2, haz 'Enter' para tirar el dado:");
		}else {
			System.out.println("\n\n\n\n\n\n\n\nIA, tira el dado:");
		}Thread.sleep(100);
		System.err.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		Thread.sleep(100);
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i]+"| ");
		}Thread.sleep(100);
		System.err.println("\n/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		Thread.sleep(100);
		for (int i = 0; i < t2.length; i++) {
			System.out.print(t2[i]+"| ");
		}
		if(vs==1) {
			reader.nextLine();
		}else {
			System.out.println();
		}
		tirada2 = aleatorio.nextInt(6)+1;		//tirada aleatoria del jugador 2 / IA.
		System.out.println("\nHa salido un "+tirada2);
		t2[J2]='O';		//se pone una O en la posici�n anterior.
		comprobacionesTiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);		//se pasa a comprobar si la ficha debe rebotar.
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesTiradaOcaJ2
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 2 tiene que rebotar al llegar al final del tablero.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void comprobacionesTiradaOcaJ2(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException {
		if((J2+tirada2)<62 || (J2+tirada2)==62) {		//se comprueba si la nueva posici�n es el final del tablero o si est� dentro de los m�rgenes.
			J2=J2+tirada2;
			t2[J2]='Y';
		}
		else if((J2+tirada2)>62 && (62-((J2+tirada2)-62))<=62) {		//si se sale de los m�rgenes, se actualiza la posici�n para que rebote.
			J2=62-((J2+tirada2)-62);
			t2[J2]='Y';
		}
		Thread.sleep(1000);
		for (int i = 0; i < t2.length; i++) {		//bucle for que muestra el tablero del jugador 2 / IA.
			System.out.print(t2[i]+"| ");
		}
		comprobacionesOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);		//se pasa a comprobar la casilla.
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesOcaJ1
	//** Explicaci�n de lo que hace la funci�n: Comprueba si en la casilla que ha ca�do el jugador 1 hay una oca o si es el final del tablero.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//****************************************************************************************************************************************
	public static void comprobacionesOcaJ1(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if(J1 == 62) {		//si ha llegado al final exacto, finaliza la partida.
			System.out.println("\n\nFIN DE LA PARTIDA. HA GANADO EL JUGADOR 1");
			victoria();	//se llama a la funci�n que muestra la copa.
		}
		else if(t[J1] == '2') {		//si se ha ca�do en una casilla de oca.
			boolean fin = false;	//se crea un boolean para controlar el fin del bucle que busca la siguiente oca.
			for(int i = J1+1; fin == false; i++) {	//bucle que busca la siguiente oca y lleva al jugador 1 a ella.
				if(t[i] == '2') {
					t1[J1] = 'O';
					J1 = i;
					t1[i] = 'X';
					fin = true;
				}
			}Thread.sleep(2000);
			System.out.println("\n\n�De oca a oca y tiro porque me toca!");
			for(int i=0; i<t1.length;i++) {		//bucle for que muestra el tablero del jugador 1.
				System.out.print(t1[i]+"| ");
			}
			if(J1 == 62) {		//si se ha ca�do en la �ltima oca, gana el jugador 1.
				Thread.sleep(1000);
				System.out.println("\n\nFIN DE LA PARTIDA. GANA EL JUGADOR 1");
				victoria();
			}else {		//si no, simplemente vuelve a tirar.
				tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}
		}else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ1Puente(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ1Puente
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 1 ha ca�do en un puente.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void comprobacionesJ1Puente(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J1] == 'B') {		//si ha ca�do en una casilla de puente, va al otro y vuelve a tirar.
			if(J1 == 5) {
				t1[J1] = 'O';
				J1 = 11;
				t1[J1] = 'X';
			}
			else {
				t1[J1] = 'O';
				J1 = 5;
				t1[J1] = 'X';
			}
			Thread.sleep(2000);
			System.out.println("\n\nDe puente a puente y tiro porque me lleva la corriente.");
			for(int i = 0; i < t1.length; i++) {		//bucle for que muestra el tablero del jugador 1.
				System.out.print(t1[i]+"| ");
			}
			tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ1Dado(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ1Dado
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 1 ha ca�do en un dado.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void comprobacionesJ1Dado(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J1] == 'D') {		//si ha ca�do en una casilla de dado, va al otro y vuelve a tirar.
			if(J1 == 25) {
					t1[J1] = 'O';
					J1 = 52;
					t1[J1] = 'X';
			}
			else {
				t1[J1] = 'O';
				J1 = 25;
				t1[J1] = 'X';
			}
			Thread.sleep(2000);
			System.out.println("\n\nDe dado a dado y tiro porque me ha tocado.");

			for(int i = 0; i < t1.length; i++) {		//bucle for que muestra el tablero del jugador 1.
				System.out.print(t1[i]+"| ");
			}
			tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ1Carcel(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ1Carcel
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 1 ha ca�do en la c�rcel o si el jugador 2 est� en ella.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void comprobacionesJ1Carcel(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J1] == 'C' || (t[J2] == 'C' && pTJ2 <= 2 && pTJ1 == 0)) {		//si ha ca�do en la c�rcel o el rival est� en la c�rcel.
			if(t[J1] == 'C') {
				Thread.sleep(2000);
				System.err.println("\n\n�Has ca�do en la c�rcel! Pierdes dos turnos.\n");
				pTJ1 = 2;
				if(pTJ2 == 1) {
					System.out.println("\n\nLa penalizaci�n se reduce a un turno porque tu rival tambi�n tiene que perder uno.");
					pTJ2 = 0;
					pTJ1 = 1;
				}else if(pTJ2 == 2) {
					System.out.println("\n\nQueda sin efecto porque tu rival tambi�n tiene que perder dos turnos.");
					pTJ2 = 0;
					pTJ1 = 0;
				}
				tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}else if (t[J2] == 'C' && pTJ2 <= 2 && pTJ1 == 0){
				if(pTJ2 <= 2 && pTJ2 != 0) {
					Thread.sleep(2000);
					System.out.println("\n\nTu rival est� en la c�rcel. Vuelve a tirar.");
					pTJ2--;
					tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}else if (pTJ2 == 0){
					tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);

				}
			}
		}else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ1Pozo(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}	
	}
	
	//*****************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ1Pozo
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 1 ha ca�do en el pozo o si el jugador 2 se encuentra en ella.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//*****************************************************************************************************************************************
	public static void comprobacionesJ1Pozo(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J1] == 'W' || (t[J2] == 'W' && pTJ2 <= 2 && pTJ1 == 0)) {		//si ha ca�do en el pozo o el rival est� en el pozo.
			Thread.sleep(2000);
			if(t[J1] == 'W') {
				System.err.println("\n\n�Has ca�do al pozo! Pierdes dos turnos.");
				pTJ1 = 2;
				if(pTJ2 == 1) {
					System.out.println("\n\nLa penalizaci�n se reduce a un turno porque tu rival tambi�n tiene que perder uno.");
					pTJ2 = 0;
					pTJ1 = 1;
				}else if(pTJ2 == 2) {
					System.out.println("\n\nQueda sin efecto porque tu rival tambi�n tiene que perder dos turnos.");
					pTJ2 = 0;
					pTJ1 = 0;
				}
				tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}else if (t[J2] == 'W' && pTJ2 <= 2 && pTJ1 == 0){
				if(pTJ2 <= 2 && pTJ2 != 0) {
					System.out.println("\n\nTu rival est� en el pozo. Vuelves a tirar.");
					pTJ2--;
					tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}else if(pTJ2 == 0){
					tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}
			}
		}else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ1Posada(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//*******************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ1Posada
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 1 ha ca�do en la posada o si el jugador 2 se encuentra en ella.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//*******************************************************************************************************************************************
	public static void comprobacionesJ1Posada(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J1] == 'P' || (t[J2] == 'P' && pTJ2 == 1 && pTJ1 == 0)) {		//si ha ca�do a la posada o el rival est� en la posada.
			Thread.sleep(2000);
			if(t[J1] == 'P') {
				System.err.println("\n\nHas ca�do en la posada. Te quedas descansando y pierdes un turno.");
				pTJ1 = 1;
				if(pTJ2 == 1) {
					System.out.println("\n\nQueda sin efecto porque tu rival tambi�n tiene que perder un turno.");
					pTJ2 = 0;
					pTJ1 = 0;
				}
				else if(pTJ2 == 2) {
					System.out.println("\n\nQueda sin efecto porque tu rival tiene que perder dos turnos, y �l ahora solo perder� uno.");
					pTJ2 = 1;
					tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}
				tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}
			else if (t[J2] == 'P' && pTJ2 == 1 && pTJ1 == 0){
				System.out.println("\n\nTu rival est� descansando en la posada. Vuelves a tirar.");
				pTJ2 = 0;
				tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ1Finales(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//**********************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ1Finales
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 1 ha ca�do en el laberinto, en la calavera o en una casilla vac�a.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**********************************************************************************************************************************************
	public static void comprobacionesJ1Finales(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J1] == 'L') {		//si ha ca�do en el laberinto.
			Thread.sleep(2000);
			System.err.println("\n\nHas ca�do en el laberinto, retrocedes a la casilla 30.\n");
			t1[J1]= 'O';
			J1=29;
			t1[J1] = 'X';
			for(int i=0; i<t1.length; i++) {		//bucle for que muestra el tablero del jugador 1.
				System.out.print(t1[i]+"| ");
			}
			tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else if (t[J1] == 'S') {		//si ha ca�do en la calavera.
			Thread.sleep(2000);
			System.err.println("\n\n�Has ca�do en la calavera! Vuelves a empezar.\n");
			t1[J1] = 'O';
			J1=0;
			t1[J1] = 'X';
			for(int i=0; i<t1.length; i++) {
				System.out.print(t1[i]+"| ");
			}
			tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//************************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesOcaJ2
	//** Explicaci�n de lo que hace la funci�n: Comprueba si en la casilla que ha ca�do el jugador 2 o la IA hay una oca o si es el final del tablero.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//************************************************************************************************************************************************
	public static void comprobacionesOcaJ2(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if(J2 == 62) {		//si ha llegado al final exacto, finaliza la partida.
			Thread.sleep(1000);
			System.out.println("\n\nFIN DE LA PARTIDA. HA GANADO EL JUGADOR 2");
			victoria();
		}
		else if(t[J2] == '2') {		//si se ha ca�do en una casilla de oca.
			boolean fin = false;	//se crea un boolean para controlar el fin del bucle que busca la siguiente oca.
			for(int i = J2+1; fin == false; i++) {
				if(t[i] == '2') {
					t2[J2] = 'O';
					J2 = i;
					t2[i] = 'Y';
					fin = true;
				}
			}Thread.sleep(2000);
			System.out.println("\n\n�De oca a oca y tiro porque me toca!");
			for(int i=0; i<t2.length;i++) {	//bucle que busca la siguiente oca y lleva al jugador 2 / IA a ella.
				System.out.print(t2[i]+"| ");
			}
			if(J2 == 62) { Thread.sleep(1000);	//si se ha ca�do en la �ltima oca, gana el jugador 2 / IA.
				if(vs == 1) {
					System.out.println("\n\nFIN DE LA PARTIDA. GANA EL JUGADOR 2");
					victoria();
				}else {
					System.out.println("\n\nFIN DE LA PARTIDA. GANA LA IA");
					victoria();
				}
			}else {		//si no, simplemente vuelve a tirar.
				tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}
		}else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ2Puente(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ2Puente
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 2 o la IA ha ca�do en un puente.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void comprobacionesJ2Puente(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J2] == 'B') {		//si ha ca�do en una casilla de puente, va al otro y vuelve a tirar.
			if(J2 == 5) {
				t2[J2] = 'O';
				J2 = 11;
				t2[J2] = 'Y';
			}
			else {
				t2[J2] = 'O';
				J2 = 5;
				t2[J2] = 'Y';
			}
			Thread.sleep(2000);
			System.out.println("\n\nDe puente a puente y tiro porque me lleva la corriente..");

			for(int i = 0; i < t2.length; i++) {		//bucle for que muestra el tablero del jugador 2 / IA.
				System.out.print(t2[i]+"| ");
			}
			tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ2Dado(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//**************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ2Dado
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 2 o la IA ha ca�do en un dado.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//**************************************************************************************************************************************
	public static void comprobacionesJ2Dado(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J2] == 'D') {		//si ha ca�do en una casilla de dado, va al otro y vuelve a tirar.
			if(J2 == 25) {
					t2[J2] = 'O';
					J2 = 52;
					t2[J2] = 'Y';
			}
			else {
				t2[J2] = 'O';
				J2 = 25;
				t2[J2] = 'Y';
			}
			Thread.sleep(2000);
			System.out.println("\n\nDe dado a dado y tiro porque me ha tocado.");

			for(int i = 0; i < t2.length; i++) {		//bucle for que muestra el tablero del jugador 2 / IA.
				System.out.print(t2[i]+"| ");
			}
			tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ2Carcel(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//*******************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ2Carcel
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 2 o la IA ha ca�do en la c�rcel o si el jugador 1 est� en ella.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//*******************************************************************************************************************************************
	public static void comprobacionesJ2Carcel(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J2] == 'C' || (t[J1] == 'C' && pTJ1 <= 2 && pTJ2 == 0)) {		//si ha ca�do en la c�rcel o el rival est� en la c�rcel.
			if(t[J2] == 'C') {
				Thread.sleep(2000);
				System.err.println("\n\n�Has ca�do en la c�rcel! Pierdes dos turnos.\n");
				pTJ2 = 2;
				if(pTJ1 == 1) {
					System.out.println("\n\nLa penalizaci�n se reduce a un turno porque tu rival tambi�n tiene que perder uno.");
					pTJ1 = 0;
					pTJ2 = 1;
				}else if(pTJ1 == 2) {
					System.out.println("\n\nQueda sin efecto porque tu rival tambi�n tiene que perder dos turnos.");
					pTJ2 = 0;
					pTJ1 = 0;
				}
				tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}else if (t[J1] == 'C' && pTJ1 <= 2 && pTJ2 == 0){
				if(pTJ1 <= 2 && pTJ1 != 0) {
					Thread.sleep(2000);
					System.out.println("\n\nTu rival est� en la c�rcel. Vuelve a tirar.");
					pTJ1--;
					tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}else if (pTJ1 == 0){
					tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}
			}	
		}else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ2Pozo(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//*************************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ2Pozo
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 2 o la IA ha ca�do en el pozo o si el jugador 1 se encuentra en ella.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//*************************************************************************************************************************************************
	public static void comprobacionesJ2Pozo(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J2] == 'W' || (t[J1] == 'W' && pTJ1 <= 2 && pTJ2 == 0)) {		//si ha ca�do en el pozo o el rival est� en el pozo.
			Thread.sleep(2000);
			if(t[J2] == 'W') {
				System.err.println("\n\n�Has ca�do al pozo! Pierdes dos turnos.");
				pTJ2 = 2;
				if(pTJ1 == 1) {
					System.out.println("\n\nLa penalizaci�n se reduce a un turno porque tu rival tambi�n tiene que perder uno.");
					pTJ1 = 0;
					pTJ2 = 1;
				}else if(pTJ1 == 2) {
					System.out.println("\n\nQueda sin efecto porque tu rival tambi�n tiene que perder dos turnos.");
					pTJ2 = 0;
					pTJ1 = 0;
				}
				tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}else if (t[J1] == 'W' && pTJ1 <= 2 && pTJ2 == 0){
				if(pTJ1 <= 2 && pTJ1 != 0) {
					System.out.println("\n\nTu rival est� en el pozo. Vuelve a tirar.");
					pTJ1--;
					tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}else if (pTJ1 == 0) {
					tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}
			}
		}else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ2Posada(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//***************************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ2Posada
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 2 o la IA ha ca�do en la posada o si el jugador 1 se encuentra en ella.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//***************************************************************************************************************************************************
	public static void comprobacionesJ2Posada(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J2] == 'P' || (t[J1] == 'P' && pTJ1 == 1 && pTJ2 == 0)) {		//si ha ca�do a la posada o el rival est� en la posada.
			Thread.sleep(2000);
			if(t[J2] == 'P') {
				System.err.println("\n\nHas ca�do en la posada. Te quedas descansando y pierdes un turno.");
				pTJ2 = 1;
				if(pTJ1 == 1) {
					System.out.println("\n\nQueda sin efecto porque tu rival tambi�n tiene que perder un turno.");
					pTJ1 = 0;
					pTJ2 = 0;
				}
				else if(pTJ1 == 2) {
					System.out.println("\n\nQueda sin efecto porque tu rival tiene que perder dos turnos, y �l ahora solo perder� uno.");
					pTJ1 = 1;
					tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
				}		
				tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}
			else if (t[J1] == 'P' && pTJ1 == 1 && pTJ2 == 0){
				System.out.println("\n\nTu rival est� descansando en la posada. Vuelves a tirar.");
				pTJ1 = 0;
				tiradaOcaJ2(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
			}
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			comprobacionesJ2Finales(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//******************************************************************************************************************************************************
	//** Nombre de la funci�n: comprobacionesJ2Finales
	//** Explicaci�n de lo que hace la funci�n: Comprueba si la ficha del jugador 2 o la IA ha ca�do en el laberinto, en la calavera o en una casilla vac�a.
	//** Par�metros de entrada: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//** Par�metros de salida: Variables vs, Arrays de char tablero, tableroJ1, tableroJ2 y variables J1, J2, pTJ1, pTJ2, tirada1, tirada2.
	//******************************************************************************************************************************************************
	public static void comprobacionesJ2Finales(int vs, char[] t, char[] t1, char[] t2, int J1, int J2, int pTJ1, int pTJ2, int tirada1, int tirada2) throws InterruptedException{
		if (t[J2] == 'L') {		//si ha ca�do en el laberinto.
			Thread.sleep(2000);
			System.err.println("\n\nHas ca�do en el laberinto, retrocedes a la casilla 30.\n");
			t2[J2] = 'O';
			J2 = 29;
			t2[J2] = 'Y';
			for(int i = 0; i < t2.length; i++) {		//bucle for que muestra el tablero del jugador 2 / IA.
				System.out.print(t2[i]+"| ");
			}
			tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else if (t[J2] == 'S') {		//si ha ca�do en la calavera.
			Thread.sleep(2000);
			System.err.println("\n\n�Has ca�do en la calavera! Vuelves a empezar.\n");
			t2[J2] = 'O';
			J2 = 0;
			t2 [J2] = 'Y';
			for(int i = 0; i < t2.length; i++) {
				System.out.print(t2[i]+"| ");
			}
			tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
		else {		//si no cumple nada de esto, pasa a las siguientes comprobaciones.
			tiradaOcaJ1(vs, t, t1, t2, J1, J2, pTJ1, pTJ2, tirada1, tirada2);
		}
	}
	
	//**************************************************************************************************************
	//** Nombre de la funci�n: pistolero
	//** Explicaci�n de lo que hace la funci�n: Esta funcion inicializa las variables que necesitare en el programa,
	//** y te muestra lo que tienes que hacer para jugar y si quieres jugar 
	//** contra la IA o contra otro jugador.
	//** Par�metros de entrada:-
	//** Par�metros de salida:Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//**************************************************************************************************************
	public static void pistolero(int vs) throws InterruptedException {
		Scanner reader	= new Scanner(System.in); //se crea el scanner para introducir contra quien se quiere jugar.
		int municion1=0;//todas estas variables son las que se van modificando segun el paso de funciones
		int municion2=0;
		int vida1=5;
		int vida2=5;
		int el1=0;
		int el2=0;
		int ia=0;
			
		turnoJ1(municion1, municion2, vida1, vida2, el1, el2, ia , vs);
		//se llama a la funcion turnoJ1 para empezar las rondas
	}
	
	//************************************************************************************************************
	//** Nombre de la funci�n: turnoJ1
	//** Explicaci�n de lo que hace la funci�n: Esta funcion le pide al jugador 1 que escoja lo que quiere hacer
	//** y controla que los valores no sean erroneos.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de Salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//************************************************************************************************************
	public static void turnoJ1(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		Scanner reader	= new Scanner(System.in);//se crea el scanner
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");//aqui se muestra lo que se debe introducir
		System.out.println("/Para recargar introduze 0.                                                           /");// para hacer segun que cosa
		System.out.println("/Para disparar introduze 1.                                                           /");
		System.out.println("/Para usar el escudo introduze 2.                                                     /");
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////\n");
		Thread.sleep(100);
		System.err.println("-----------------------------------------------------------------------------------------------------------");
		Thread.sleep(100);
		System.out.println("Jugador 1, elije lo que quieres hacer:");
		el1=reader.nextInt();//se pide por pantalla lo que quiere hacer el jugador 1
		while (el1<0 || el1>2) {
			System.err.println("El valor no es v�lido, introduce de nuevo:");
			el1=reader.nextInt();
		}//varios controles de errores para comprovar si los valores son validos o no
		while(el1==1 && municion1==0) {
			System.err.println("No se puede disparar sin munici�n, recarga primero:");
			el1=reader.nextInt();
		}
		if(vs == 1) {
			//se llama a la funcion turnoJ2
			turnoJ2(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
		}
		else {
			//se llama a la funcion IA
			IA(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
		}
	}
	
	//*****************************************************************************************
	//** Nombre de la funci�n: IA
	//** Explicaci�n de lo que hace la funci�n: Esta funcion le otorga a la variable ia un 
	//** valor random entre el 0 i el 2 minetras pasan los turnos
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*****************************************************************************************
	public static void IA(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		Random ale=new Random();//se crea un random
		
		ia=ale.nextInt(3);//se le da a la variable ia un valor random entre el 0 i el 2
		
		//se llama a la funcion turnoJ2
		turnoJ2(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
	}	

	//**********************************************************************************************************
	//** Nombre de la funci�n: turnoJ2
	//** Explicaci�n de lo que hace la funci�n: Esta funcion le pide al jugador 2 que escoja lo que quiere hacer
	//** y controla que los valores no sean erroneos. Depende del vs
	//** que se escoja se hara random o se hara manualmente por el jugador 2.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//**********************************************************************************************************
	public static void turnoJ2(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		Scanner reader	= new Scanner(System.in);
		Random ale=new Random();//se introducen un random i un scanner por si se juga vs ia o vs j2
		if(vs==2) {//si el vs es 2 se pide que la ia escoja
			el2=ia;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nIA, elije lo que quieres hacer:");
		}
		if(vs==1) {//si el vs es 1 se muestra y pide por pantalla lo que el jugador 2 quere hacer
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nJugador 2, elije lo que quieres hacer:");
			el2=reader.nextInt();
		}
		while (el2<0 || el2>2) {		//se introducen controles de error para comprovar si los valores son validos
			System.err.println("El valor no es v�lido, introduce de nuevo:");
			if(vs==1) {
			el2=reader.nextInt();
			}
		}
		while(el2==1 && municion2==0) {
			if(vs==1) {
				System.err.println("No se puede disparar sin munici�n, recarga primero:");
				el2=reader.nextInt();
			}
			else {
				el2=0;	
			}
		}
		if(vs==2) {//se muestra lo que la ia ha elegido
			System.out.println("La IA ha introducido " + el2);
		}
			comparacion(municion1, municion2, vida1, vida2, el1, el2, ia , vs);		//se llama a la funcion comparacion
	}
	
	//*******************************************************************************************
	//** Nombre de la funci�n: comparacion
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando los dos 
	//** jugadores recargan
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*******************************************************************************************
	public static void comparacion(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (el1==0 && el2==0) {
			municion1=municion1+1;	
			municion2=municion2+1;
			
			System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
			if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
				vida1=0;
			}	
			if(vida2<0) {
				vida2=0;
			}//se muestra la situacion de cada jugador
			System.out.println("El jugador 1 recarga. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				
			if(vs==1) {
			System.out.println("El jugador 2 recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
			}
			else{
				System.out.println("La IA recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
			}
			
			System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
			//si lo anterior se cumple se llama directamente a la fucion ganador sin pasar por todas las demas.
			ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
		}
		
		else {//si no se cumple lo anterior se llama a la funcion comparaciona
			comparaciona(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
	}
	
	//*************************************************************************************************
	//** Nombre de la funci�n: comparaciona
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** dispara con tres de municion o mas i el jugador 2 recarga.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparaciona(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (el1==1) {
			if(municion1>=3 && el2==0) {
				vida2=vida2-3;
				municion1=municion1-3;
				municion2=municion2+1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("�El jugador 1 usa la metralleta!. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("El jugador 2 recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("La IA recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacionb
			else {
				comparacionb(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}
		else {
			comparacionb(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}

	//*************************************************************************************************
	//** Nombre de la funci�n: comparacionb
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** dispara con tres de municion o mas i el jugador 2 dispara con
	//** menos de tres de municion.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacionb(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el1==1) {
			if(municion1>=3 && municion2<3 && el2==1) {
				vida2=vida2-3;
				vida1=vida1-1;
				municion1=municion1-3;
				municion2=municion2-1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("�El jugador 1 usa la metralleta!. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("�El jugador 2 dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("�La IA dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacionc
			else {
				comparacionc(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}else {
			comparacionc(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}

	//*************************************************************************************************
	//** Nombre de la funci�n: comparacionc
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** dispara con tres de municion o mas i el jugador 2 se cubre
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacionc(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el1==1) {
			if(municion1>=3 && el2==2) {
				municion1=municion1-3;
				vida2=vida2-1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("�El jugador 1 usa la metralleta!. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("El jugador 2 se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("La IA se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparaciond
			else {
				comparaciond(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}
		else {
			comparaciond(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}
	
	//*************************************************************************************************
	//** Nombre de la funci�n: comparaciond
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** dispara con tres de municion o mas i el jugador 2 dispara 
	//** tambien con tres o mas de municion.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparaciond(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el1==1) {
			if(municion1>=3 && municion2 >=3 && el2==1) {
				vida2=vida2-3;
				vida1=vida1-3;
				municion1=municion1-3;
				municion2=municion2-3;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("�El jugador 1 usa la metralleta!. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("�El jugador 2 usa la metralleta!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("�La IA usa la metralleta!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no se llama a comparacion1
			else {
				comparacion1(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}else {
			comparacion1(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}
	
	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion1
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** dispara con menos de tres de municion y el jugador 2 
	//** recarga.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion1(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (el1==1) {
			if(municion1>0 && el2==0) {
				vida2=vida2-1;
				municion1=municion1-1;
				municion2=municion2+1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("El jugador 1 dispara!. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("El jugador 2 recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("La IA recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparadion2
			else {
				comparacion2(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}else {
			comparacion2(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}


	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion2
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** dispara con menos de tres de municion i el jugador 2 dispara
	//** tambien con menos de tres de municion.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion2(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el1==1) {
			if(municion1>0 && el2==1) {
				vida2=vida2-1;
				vida1=vida1-1;
				municion1=municion1-1;
				municion2=municion2-1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
					}	
				if(vida2<0) {
					vida2=0;
					}//se muestra la situacion de cada jugador
				System.out.println("El jugador 1 dispara!. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("El jugador 2 dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
					}
				else{
					System.out.println("La IA dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llamara a la funcion ganador y si no a la comparacion3
			else {
				comparacion3(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}else {
			comparacion3(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}

	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion3
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** dispara con menos de tres de municion i el jugador 2 
	//** se cubre.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion3(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el1==1) {
			if(municion1>0 && el2==2 && municion1<3) {
				municion1=municion1-1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("El jugador 1 dispara!. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("El jugador 2 se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("La IA se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacionx
			else {
				comparacionx(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}
		else {
			comparacionx(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}

	//*************************************************************************************************
	//** Nombre de la funci�n: comparacionx
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 2
	//** dispara con tres de municion o mas i el jugador 1
	//** recarga.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacionx(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (el2==1) {
			if(municion2>=3 && el1==0) {
				municion2=municion2-3;
				vida1=vida1-3;
				municion1=municion1+1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("El jugador 1 recarga. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");
				if(vs==1) {
					System.out.println("�El jugador 2 usa la metralleta!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("�La IA usa la metralleta!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}	
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparaciony
			else {
				comparaciony(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}	
		}
		else {
			comparaciony(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}

	//*************************************************************************************************
	//** Nombre de la funci�n: comparaciony
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 2
	//** dispara con tres de municion o mas i el jugador 1
	//** se cubre.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparaciony(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (el2==1) {
			if(municion2>=3 && el1==2) {
				municion2=municion2-3;
				vida1=vida1-1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("El jugador 1 se cubre. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");
				if(vs==1) {
					System.out.println("�El jugador 2 usa la metralleta!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("�La IA usa la metralleta!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);	
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacion4
			else {
				comparacion4(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}
		else {
			comparacion4(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}
	
	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion4
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 2
	//** dispara con menos de tres de municion i el jugador 1 recarga.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion4(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (el2==1) {
			if(municion2>0 && el1==0) {
				vida1=vida1-1;
				municion2=municion2-1;
				municion1=municion1+1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada situacion
				System.out.println("El jugador 1 recarga. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");
				if(vs==1) {
					System.out.println("El jugador 2 dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("La IA dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacion6
			else {
				comparacion6(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}
		else {
			comparacion6(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}
	
	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion6
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 2
	//** dispara con menos de tres de municion i el jugador 1 se cubre.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion6(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (el2==1) {
			if(municion2>0 && el1==2) {
				municion2=municion2-1;
				System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugadir
				System.out.println("El jugador 1 se cubre. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");
				if(vs==1) {
					System.out.println("El jugador 2 dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("La IA dispara!. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
				ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);		
			}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacion7
			else {
				comparacion7(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
			}
		}
		else {
			comparacion7(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}
		
	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion7
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** se cubre i el jugador 2 tambie se cubre.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion7(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el1==2 && el2==2) { 
			System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
			if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
				vida1=0;
			}	
			if(vida2<0) {
				vida2=0;
			}//se muestra la situacion de cada jugador
			System.out.println("El jugador 1 se cubre. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
			if(vs==1) {
				System.out.println("El jugador 2 se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
			}
			else{
				System.out.println("La IA se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
			}
			System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
			ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
		}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacion8
		else {
			comparacion8(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}
	
	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion8
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 1
	//** se cubre i el jugador 2 recarga.
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion8(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el1==2 && el2==0) {
			municion2=municion2+1;
			System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
			if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
				vida1=0;
			}	
			if(vida2<0) {
				vida2=0;
			}//se muestra la situacion de cada jugador
			System.out.println("El jugador 1 se cubre. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
			if(vs==1) {
				System.out.println("El jugador 2 recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
			}
			else{
				System.out.println("La IA recarga. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
			}
			System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");
			ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);	
		}//si se cumple lo anterior se llama a la funcion ganador y si no a la comparacion9
		else {
		comparacion9(municion1, municion2, vida1, vida2, el1, el2, ia , vs);	
		}
	}
	
	//*************************************************************************************************
	//** Nombre de la funci�n: comparacion9
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba lo que pasa cuando el jugador 2
	//** se cubre i el jugador 1 recarga
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//*************************************************************************************************
	public static void comparacion9(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if(el2==2 && el1==0) {
			municion1=municion1+1;
			System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////");
				if(vida1<0) {//si la vida1 o 2 es menor a 0 se mostrara igualmente un 0
					vida1=0;
				}	
				if(vida2<0) {
					vida2=0;
				}//se muestra la situacion de cada jugador
				System.out.println("El jugador 1 recarga. Le quedan "+ vida1+" vidas y "+ municion1+ " balas");	
				if(vs==1) {
					System.out.println("El jugador 2 se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
				else{
					System.out.println("La IA se cubre. Le quedan "+ vida2+ " vidas y "+ municion2+" balas");
				}
			System.out.println("//////////////////////////////////////////////////////////////////////////////\n\n");	
		}
		//llama a ganador directamente ya que es la ultima
		ganador(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
	}
	
	//**********************************************************************************************************
	//** Nombre de la funci�n: ganador
	//** Explicaci�n de lo que hace la funci�n: Esta funcion comprueba quin ha ganado segun las vidas que tienen
	//** Par�metros de entrada: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//** Par�metros de salida: Variables municion1, municion2, vida1, vida2, el1, el2, ia, vs
	//**********************************************************************************************************
	public static void ganador(int municion1,int municion2,int vida1,int vida2,int el1,int el2, int ia, int vs) throws InterruptedException {
		if (vida1<=0 || vida2<=0) {//si la vida es igual o menor a 0 se muestra quien gana con las comparaciones
			System.out.println("///////////////////");
			System.out.println("   FIN DEL JUEGO");
			if(vida1==vida2){
				System.out.println("��EMPATE!!");
				System.out.println("///////////////////");
				finJuego();
			}
			else if (vida2<=0) {
				System.out.println("��JUGADOR 1 GANA!!");
				System.out.println("///////////////////");
				victoria();
			}
			else if(vida1<=0) {
				System.out.println("��JUGADOR2 GANA!!");
				System.out.println("///////////////////");
				victoria();
			}
		}
	//si ninguna de las vidas es menor o igual a 0 se llama a turnoJ1 para continuar las rondas
		else if(vida1!=0 && vida2!=0) {
			turnoJ1(municion1, municion2, vida1, vida2, el1, el2, ia, vs);
		}
	}
				
	//*********************************************************************************************
	//** Nombre de la funci�n: pelea
	//** Explicaci�n de lo que hace la funci�n: muestra por consola los dibujos de los personajes.
	//** Par�metros de entrada: Variable vs.
	//** Par�metros de salida: Variable vs.
	//*********************************************************************************************
	public static void pelea(int vs) throws InterruptedException {
		//Printa el nombre de los combatientes y debajo muestra su imagen		
		System.out.println("1. Manolo\n");
		personajeManolo();
		System.out.println("\n2. Jacobo\n");
		personajeJacobo();
		System.out.println("\n3. George\n");
		personajeGeorge();
		System.out.println("\n4. Toni\n");
		personajeToni();
		System.out.println("\n5. Tere\n");
		personajeTere();
		//Llamada a la funcion de eleccion para el jugador 1
		jugador1(vs);
	}
	
	//*********************************************************************************************
	//** Nombre de la funci�n: jugador1
	//** Explicaci�n de lo que hace la funci�n: da a elegir al jugador 1 el combatiente que desea.
	//** Par�metros de entrada: Variable vs.
	//** Par�metros de salida: Variables combatiente1, combatiente2, vs.
	//*********************************************************************************************
	public static void jugador1(int vs) throws InterruptedException {
		Scanner reader = new Scanner(System.in);
		
		int combatiente1 = 0;
		int combatiente2 = 0;
		
		//Pedimos que el jugador 1 introduzca el combatiente
		System.out.println("JUGADOR 1: Elige el combatiente que desees");
		combatiente1 = reader.nextInt();
		//Control de errores
		while (combatiente1 <= 0 || combatiente1 > 5) {
			System.err.println("Introduce un valor correcto");
			System.out.println("Vuelve a elegir el combatiente que desees");
			combatiente1 = reader.nextInt();
		}
		
		//Llamada a la funcion de eleccion para el jugador 2
		jugador2(combatiente1, combatiente2, vs);
	}
	
	//********************************************************************************************************************************************
	//** Nombre de la funci�n: jugador2
	//** Explicaci�n de lo que hace la funci�n: da a elegir al jugador 2 el combatiente que desea, en caso de ser contra la IA se hace aleatorio.
	//** Par�metros de entrada: Variables comb1, comb2, vs.
	//** Par�metros de salida: Variables vs, comb1, comb2.
	//********************************************************************************************************************************************
	public static void jugador2(int comb1, int comb2, int vs) throws InterruptedException {
		Scanner reader = new Scanner(System.in);
		Random aleatorio = new Random ();
		
		//Pedimos que el jugador 2 introduzca el combatiente, en caso que se haya elegido jugar contra la IA se hace aleatorio
		if(vs == 1) {
			do {
				System.out.println("JUGADOR 2: Elige el combatiente que desees");
				comb2 = reader.nextInt();
				//Control de errores
				while (comb2 <= 0 || comb2 > 5) {
					System.err.println("Introduce un valor correcto");
					System.out.println("Vuelve a elegir el combatiente que desees");
					comb2 = reader.nextInt();
				}
				if(comb2 == comb1) {
					System.err.println("No puedes elegir el mismo combatiente que el Jugador 1.");
				}
			}while(comb2 == comb1);
			System.out.println("El jugador 1 ha elegido el combatiente "+comb1+" y el jugador 2 ha elegido el combatiente "+comb2+".");
		}else {
			do {
				System.out.println("IA: Elige el combatiente que desees");
				comb2 = aleatorio.nextInt(5)+1;
			}while (comb2 == comb1);
			System.out.println("El jugador 1 ha elegido el combatiente "+comb1+" y la IA ha elegido el combatiente "+comb2+".");
		}		
		//Llamada a la funcion que muestra las caracteristicas de los dos combatientes elegidos.
		creacionCaracteristicas(vs, comb1, comb2);
	}
	
	//************************************************************************************************************************************************************
	//** Nombre de la funci�n: creacionCaracteristicas
	//** Explicaci�n de lo que hace la funci�n: crea los valores de las habilidades que tiene el personaje escogido (en algunos casos es aleatorio)
	//** Par�metros de entrada: Variables vs, combatiente1, combatiente2.
	//** Par�metros de salida: Variables ataque1, escudo1, salud1, velocidad1, ataque2, escudo2, salud2, velocidad2, vida1, vida2, i, vs.
	//************************************************************************************************************************************************************
	public static void creacionCaracteristicas(int vs, int combatiente1, int combatiente2) throws InterruptedException {
		Random aleatorio = new Random ();
		
		//Damos valores a las variables, algunos son aleatorios para dar juego, que no siempre sean los mismos.
		int ataque1 = aleatorio.nextInt(76)+15;
		int escudo1 = aleatorio.nextInt(41)+20;
		int salud1 = 100;
		int velocidad1 = aleatorio.nextInt(36)+20;
		int ataque2 = aleatorio.nextInt(76)+15;
		int escudo2 = aleatorio.nextInt(41)+20;
		int salud2 = 100;
		int velocidad2 = aleatorio.nextInt(36)+20;
		int vida1 = 0;
		int vida2 = 0;
		int i = 0;
		
		//Control para que el ataque que se haga no sea menor que el escudo ya que daria un da�o negativo (imposible).
		do {
			ataque1 = aleatorio.nextInt(76)+15;
			ataque2 = aleatorio.nextInt(76)+15;
		}while(ataque1 < escudo2 || ataque2 < escudo1);
		
		//Llamada a la funci�n que muestra las caracter�sticas de los combatientes.
		caracteristicas(vs, combatiente1, combatiente2, ataque1, escudo1, salud1, velocidad1, ataque2, escudo2, salud2, velocidad2, vida1, vida2, i);
	}
	
	//************************************************************************************************************************************************************
	//** Nombre de la funci�n: caracteristicas
	//** Explicaci�n de lo que hace la funci�n: muestra por consola los valores de las habilidades que tiene el personaje escogido (en algunos casos es aleatorio)
	//** Par�metros de entrada: Variables vs, combatiente1, combatiente2, ataque1, escudo1, salud1, velocidad1, ataque2, escudo2, salud2, velocidad2, vida1, vida2, i.
	//** Par�metros de salida: Variables ataque1, escudo1, salud1, velocidad1, ataque2, escudo2, salud2, velocidad2, vida1, vida2, i, vs.
	//************************************************************************************************************************************************************
	public static void caracteristicas (int vs, int combatiente1, int combatiente2, int ataque1, int escudo1, int salud1, int velocidad1, int ataque2, int escudo2, int salud2, int velocidad2, int vida1, int vida2, int i) throws InterruptedException {
		//Muestra las caracteristicas de los dos combatientes
		System.out.println("\n\nCaracteristicas COMBATIENTE "+combatiente1+":");
		System.out.println("Ataque: "+ataque1);
		System.out.println("Escudo: "+escudo1);
		System.out.println("Salud: "+salud1);
		System.out.println("Velocidad: "+velocidad1);
		
		System.out.println("\n\nCaracteristicas COMBATIENTE "+combatiente2+":");
		System.out.println("Ataque: "+ataque2);
		System.out.println("Escudo: "+escudo2);
		System.out.println("Salud: "+salud2);
		System.out.println("Velocidad: "+velocidad2);
	
		//Llamada a la funci�n que da inicio a la partida, y muestra los turnos de los jugadores
		turnos(ataque1, escudo1, salud1, velocidad1, ataque2, escudo2, salud2, velocidad2, vida1, vida2, i, vs);	
	}
	
	//*********************************************************************************************************************************
	//** Nombre de la funci�n: turnos
	//** Explicaci�n de lo que hace la funci�n: muestra por consola el inicio de la ronda
	//** Par�metros de entrada: Variables a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables eleccion1, eleccion2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//*********************************************************************************************************************************
	public static void turnos(int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int vida1, int vida2, int i, int vs) throws InterruptedException {

		int eleccion1 = 0;
		int eleccion2 = 0;
		int ataque = 0;
		
		System.out.println("\n\n\nEntrando en la zona de batalla...\n\n\n");
		
		i++;
		System.out.println("Ronda "+i);
		
		//Llamada al turno del jugador 1 para saber que quiere hacer, atacar o defender.
		turno1(eleccion1, eleccion2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		
	}
	
	//*********************************************************************************************************************************
	//** Nombre de la funci�n: turno1
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que debe hacer el jugador 1 para atacar o defender, la eleccion.
	//** Par�metros de entrada: Variable eleccion1.
	//** Par�metros de salida: -
	//*********************************************************************************************************************************
	public static void turno1(int eleccion1, int eleccion2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException {
		Scanner reader = new Scanner(System.in);
		
		//Muestra por consola la eleccion que debe hacer el jugador
		System.out.println("\nTurno JUGADOR 1\n");
		System.out.println("Introduce 1 si quieres ATACAR");
		System.out.println("Introduce 2 si quieres DEFENDER");
		eleccion1 = reader.nextInt();
		//Control de errores
		while (eleccion1 <= 0 || eleccion1 > 2) {
			System.err.println("Introduce un valor correcto:");
			eleccion1 = reader.nextInt();
		}
		//Llamada al turno del jugador 2 para saber que quiere hacer, atacar o defender.
		turno2(eleccion1, eleccion2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
	}
	
	//******************************************************************************************************************************************************************
	//** Nombre de la funci�n: turno2
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que debe hacer el jugador 2 para atacar o defender, la eleccion (en el caso de la IA es aleatorio)
	//** Par�metros de entrada: Variable eleccion2, vs.
	//** Par�metros de salida: -
	//******************************************************************************************************************************************************************
	public static void turno2(int eleccion1, int eleccion2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException {
		Scanner reader = new Scanner(System.in);
		Random aleatorio = new Random ();
		
		//Muestra por consola la eleccion que debe hacer el jugador
		if(vs == 1) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nTurno JUGADOR 2\n");
			System.out.println("Introduce 1 si quieres ATACAR");
			System.out.println("Introduce 2 si quieres DEFENDER");
		}
		else {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nTurno IA\n");
		}
		//En caso de jugar contra la IA es un valor aleatorio entre esos 2
		if(vs == 1) {
			eleccion2 = reader.nextInt();
		}
		else {
			eleccion2 = aleatorio.nextInt(2)+1;		
		}
		//Control de errores
		while (eleccion2 <= 0 || eleccion2 > 2) {
			System.err.println("Introduce un valor correcto:");
			eleccion2  = reader.nextInt();
		}
		decisiones(eleccion1, eleccion2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: decisiones
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables eleccion1, eleccion2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables eleccion1, eleccion2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//****************************************************************************************************************************************
	public static void decisiones(int eleccion1, int eleccion2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException {

		//Una vez terminadas las elecciones, se printa lo que han elegido los dos.
		if (eleccion1 == 1) {
			System.out.println("\nJugador 1 elige:\n  ATACAR.");
		}
		else {
			System.out.println("\nJugador 1 elige:\n  DEFENDER.");
		}
		
		if (eleccion2 == 1) {
			System.out.println("\nJugador 2 elige:\n  ATACAR.");
		}
		else {
			System.out.println("\nJugador 2 elige:\n  DEFENDER.");
		}
		
		//Llamada a la funcion que muestra lo que pasa en el campo de batalla para el jugador 1, segun las elecciones y las caracteristicas de los combatientes.
		jugador1(eleccion1, eleccion2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
	}
	
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador1
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//****************************************************************************************************************************************
	public static void jugador1(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException {
		
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (el1 == 1 && el2 == 1 && v1 > v2) {
			System.out.println("\n\nEl primero en atacar es el JUGADOR 1 debido a su mayor velocidad.");
			System.out.println("Ataca con "+a1+".");
			//Calculo del da�o que le resta a la salud del combatiente y la vida total que hay que restar al total de la salud
			ataque = a1;
			vida2 = s2 - ataque;
			if (vida2 <= 0) {
				vida2 = 0;
			}
			if(vs == 1) {
				System.out.println("JUGADOR 2 no resiste con su escudo porque decide atacar, asi que pierde "+ataque+" de vida.");
			}
			else {
				System.out.println("La IA no resiste con su escudo porque decide atacar, asi que pierde "+ataque+" de vida.");
			}
			System.out.println("Le queda "+vida2+" de vida");
			//Actualizamos el valor de la salud del combatiente
			s2 = vida2;
			//Llamada a la funcion que muestra lo que pasa en el campo de batalla para el jugador 2, segun las elecciones y las caracteristicas de los combatientes.
			jugador2(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
		//En caso de no cumplir se siguen comprobando en la siguiente funcion
		else {
			jugador1_1(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
	}
	

	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador1_1
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//****************************************************************************************************************************************
	public static void jugador1_1(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException{
		
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (el2 == 2 && el1 == 2 && v1 > v2) {
			System.out.println("Los dos eligen defender, as� que nadie recibe ni hace da�o.");
			vida1 = s1;
			vida2 = s2;
			//Llamada a la funcion que muestra lo que pasa en el campo de batalla para el jugador 2, segun las elecciones y las caracteristicas de los combatientes.
			jugador2(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
		//En caso de no cumplir se siguen comprobando en la siguiente funcion
		else {
			jugador1_2(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador1_2
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//****************************************************************************************************************************************
	public static void jugador1_2(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException{
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (el1 == 1 && el2 == 2 && v1 != v2) {
			System.out.println("\n\nEl que ataca es el JUGADOR 1 ya que JUGADOR 2 ha elegido defenderse.");
			System.out.println("Ataca con "+a1+".");
			if(vs == 1) {
				System.out.println("JUGADOR 2 se defiende con su escudo de "+e2+".");
			}else {
				System.out.println("La IA se defiende con su escudo de "+e2+".");
			}
			//Calculo del da�o que le resta a la salud del combatiente y la vida total que hay que restar al total de la salud
			ataque = a1 - e2;
			vida2 = s2 - ataque;
			if (vida2 <= 0) {
				vida2 = 0;
			}
			if(vs == 1) {
				System.out.println("JUGADOR 2 resiste con su escudo, aun as� pierde "+ataque+" de vida.");
			}else {
				System.out.println("La IA resiste con su escudo, aun as� pierde "+ataque+" de vida.");
			}
			System.out.println("Le queda "+vida2+" de vida");
			//Actualizamos el valor de la salud del combatiente
			s2 = vida2;
			//Llamada a la funcion que muestra lo que pasa en el campo de batalla para el jugador 2, segun las elecciones y las caracteristicas de los combatientes.
			jugador2(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}else {		//En caso de no cumplir se siguen comprobando en la siguiente funcion
			jugador1_3(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador1_3
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs
	//****************************************************************************************************************************************
	public static void jugador1_3(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException{
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (v1 == v2 && a1 > a2) {
			System.out.println("Los combatientes tienen la misma velocidad, as� que el primero en atacar es el JUGADOR 1 porque tiene m�s ataque.");
			System.out.println("Ataca con "+a1+".");
			if(vs == 1) {
				System.out.println("JUGADOR 2 se defiende con su escudo de "+e2+".");
			}else {
				System.out.println("La IA se defiende con su escudo de "+e2+".");
			}
			//Calculo del da�o que le resta a la salud del combatiente y la vida total que hay que restar al total de la salud
			ataque = a1 - e2;
			vida2 = s2 - ataque;
			if (vida2 <= 0) {
				vida2 = 0;
			}
			if(vs == 1) {
				System.out.println("JUGADOR 2 resiste con su escudo, aun as� pierde "+ataque+" de vida.");
			}else {
				System.out.println("La IA resiste con su escudo, aun as� pierde "+ataque+" de vida.");
			}
			System.out.println("Le queda "+vida2+" de vida.");
		}else {
			vida2 = s2;
		}
		s2 = vida2;		//Actualizamos el valor de la salud del combatiente
		//Llamada a la funcion que muestra lo que pasa en el campo de batalla para el jugador 2, segun las elecciones y las caracteristicas de los combatientes.
		jugador2(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador2
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs
	//****************************************************************************************************************************************
	public static void jugador2(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException {
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (el1 == 1 && el2 == 1 && v2 > v1) {
			if(vs == 1) {
				System.out.println("\n\nEl primero en atacar es el JUGADOR 2 debido a su mayor velocidad.");

			}
			else {
				System.out.println("\n\nEl primero en atacar es la IA debido a su mayor velocidad.");
			}
			System.out.println("Ataca con "+a2);
			//Calculo del da�o que le resta a la salud del combatiente y la vida total que hay que restar al total de la salud
			ataque = a2;
			vida1 = s1 - ataque;
			if (vida1 <= 0) {
				vida1 = 0;
			}
			System.out.println("JUGADOR 1 no resiste con su escudo porque decide atacar, as� que pierde "+ataque+" de vida.");
			System.out.println("Le queda "+vida1+" de vida.");
			//Actualizamos el valor de la salud del combatiente
			s1 = vida1;
			//Llamada a la funcion que muestra si hay o no un ganador
			ganador(a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs);
		}
		//En caso de no cumplir se siguen comprobando en la siguiente funcion
		else {
			jugador2_1(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador2_1
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs
	//****************************************************************************************************************************************
	public static void jugador2_1(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException{
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (el2 == 2 && el1 == 2 && v2 > v1) {
			System.out.println("Los dos eligen defender, as� que nadie recibe ni hace da�o.");
			vida1 = s1;
			vida2 = s2;
			//Llamada a la funcion que muestra si hay o no un ganador
			ganador(a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs);
		}
		//En caso de no cumplir se siguen comprobando en la siguiente funcion
		else {
			jugador2_2(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador2_2
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs
	//****************************************************************************************************************************************
	public static void jugador2_2(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException{
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (el1 == 2 && el2 == 1 && v1 != v2) {
			if(vs == 1) {
				System.out.println("\n\nEl que ataca es el JUGADOR 2 ya que JUGADOR 1 ha elegido defenderse.");

			}
			else {
				System.out.println("\n\nEl que ataca es la IA ya que JUGADOR 1 ha elegido defenderse.");
			}
			System.out.println("Ataca con "+a2+".");
			System.out.println("JUGADOR 1 se defiende con su escudo de "+e1+".");
			//Calculo del da�o que le resta a la salud del combatiente y la vida total que hay que restar al total de la salud
			ataque = a2 - e1;
			vida1 = s1 - ataque;
			if (vida1 <= 0) {
				vida1 = 0;
			}
			System.out.println("JUGADOR 1 resiste con su escudo, aun as� pierde "+ataque+" de vida.");
			System.out.println("Le queda "+vida1+" de vida.");
			//Actualizamos el valor de la salud del combatiente
			s1 = vida1;
			//Llamada a la funcion que muestra si hay o no un ganador
			ganador(a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs);
		}
		//En caso de no cumplir se siguen comprobando en la siguiente funcion
		else {
			jugador2_3(el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs);
		}
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: jugador2_3
	//** Explicaci�n de lo que hace la funci�n: muestra por consola lo que sucede en el campo de batalla segun la eleccion de los 2 jugadores.
	//** Par�metros de entrada: Variables el1, el2, a1, e1, s1, v1, a2, e2, s2, v2, ataque, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs.
	//****************************************************************************************************************************************
	public static void jugador2_3(int el1, int el2, int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int ataque, int vida1, int vida2, int i, int vs) throws InterruptedException{
		//Si la eleccion y las caracteristicas del combatiente se cumplen se ejecuta lo siguiente
		if (v1 == v2 && a2 > a1) {
			if(vs == 1) {
				System.out.println("Los combatientes tienen la misma velocidad, as� que el primero en atacar es el JUGADOR 2 porque tiene m�s ataque.");
			}
			else {
				System.out.println("Los combatientes tienen la misma velocidad, as� que el primero en atacar es la IA porque tiene m�s ataque.");
			}
			System.out.println("Ataca con "+a2);
			System.out.println("JUGADOR 1 se defiende con su escudo de "+e1);
			//Calculo del da�o que le resta a la salud del combatiente y la vida total que hay que restar al total de la salud
			ataque = a2 - e1;
			vida1 = s1 - ataque;
			if (vida1 <= 0) {
				vida1 = 0;
			}
			System.out.println("JUGADOR 1 resiste con su escudo, aun asi pierde "+ataque+" de vida");
			System.out.println("Le queda "+vida1+" de vida");	
		}
		else {
			vida1 = s1;
		}
		//Actualizamos el valor de la salud del combatiente
		s1 = vida1;
		//Llamada a la funcion que muestra si hay o no un ganador
		ganador(a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs);
	}
	
	//****************************************************************************************************************************************
	//** Nombre de la funci�n: ganador
	//** Explicaci�n de lo que hace la funci�n: comprueba si se ha terminado el juego, en caso contrario, vuelve a la funcion turnos del inicio
	//** Par�metros de entrada: Variables a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs.
	//** Par�metros de salida: Variables a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs.
	//****************************************************************************************************************************************
	public static void ganador(int a1, int e1, int s1, int v1, int a2, int e2, int s2, int v2, int vida1, int vida2, int i, int vs) throws InterruptedException {
		//Si la vida de algun combatiente es 0, el juego termina
		if (vida1 == 0 || vida2 == 0 ) {
			
			if (vida1 == 0) {
				if (vs == 1) {
					System.out.println("\n\n�El JUGADOR 2 ha ganado la batalla! �Derrotando al JUGADOR 1 por completo!");
				}
				else {
					System.out.println("\n\n�La IA ha ganado la batalla! �Derrotando al JUGADOR 1 por completo!");
				}
				victoria();
			}
			else {
				if (vs == 1) {
					System.out.println("\n\n�El JUGADOR 1 ha ganado la batalla! �Derrotando al JUGADOR 2 por completo!");
				}
				else {
					System.out.println("\n\n�El JUGADOR 1 ha ganado la batalla! �Derrotando a la IA por completo!");
				}
				victoria();
			}
		}
		//En caso contrario se vuelve a ejecutar la funcion turnos que inicia la siguiente ronda
		else {
			
			turnos(a1, e1, s1, v1, a2, e2, s2, v2, vida1, vida2, i, vs);
		}
	}
	
	//************************************************************************************
	//** Nombre de la funci�n: victoria
	//** Explicaci�n de lo que hace la funci�n: Muestra una Copa cuando hay ganador en cualquiera de los juegos.
	//** Par�metros de entrada: Variable vs.
	//** Par�metros de salida: Variable vs.
	//************************************************************************************	
	public static void victoria () throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("              .-=========-.\r\n" + 
				"              \\'-=======-'/\r\n" + 
				"              _|   .=.   |_\r\n" + 
				"             ((|  {{1}}  |))\r\n" + 
				"              \\|   /|\\   |/\r\n" + 
				"               \\__ '`' __/\r\n" + 
				"                 _`) (`_\r\n" + 
				"               _/_______\\_\r\n" + 
				"              /___________\\");
		finJuego();
	}
	
	//************************************************************************************************************************************************
	//** Nombre de la funci�n: finJuego
	//** Explicaci�n de lo que hace la funci�n: Pregunta si se quiere volver a jugar y, en caso afirmativo, lleva a la pantalla de selecci�n de juego.
	//** Par�metros de entrada: Variable vs.
	//** Par�metros de salida: -
	//************************************************************************************************************************************************
	public static void finJuego () throws InterruptedException {
		Scanner reader = new Scanner (System.in);		//esc�ner para leer variables introducidas por el usuario.
		char repetir = ' ';
		do {
			System.out.println("\n�Volver a jugar? (S/N)");
			repetir = reader.nextLine().charAt(0);
			if(repetir!='S' && repetir!='s' && repetir!='N' && repetir!='n') {
				System.err.println("Por favor, introduce un car�cter v�lido.");
			}
		}while(repetir!='S' && repetir!='s' && repetir!='N' && repetir!='n');		//control de errores.
		System.out.println("\n\n");
		if(repetir=='S'||repetir=='s') {
			jugar();
		}
		else {
			main(null);
		}
	}	
	
	public static void personajeManolo() {
		System.out.println("       .-\"\"-.\r\n" + 
				"      /-.{}  \\\r\n" + 
				"      | _\\__.|\r\n" + 
				"      \\/^)^ \\/\r\n" + 
				"       \\ =  /\r\n" + 
				"  .---./`--`\\.--._\r\n" + 
				" /     `;--'`     \\\r\n" + 
				";        /`       ;\r\n" + 
				"|       |*        |\r\n" + 
				"/   |   |     |    \\\r\n" + 
				"|    \\  |*    /    |\r\n" + 
				"\\_   |\\_|____/|  __/\r\n" + 
				"  \\__//======\\\\__/\r\n" + 
				"  / //_      _\\\\ \\\r\n" + 
				"  -'  |`\"\"\"\"`|  `-\r\n" + 
				"      |  L   |\r\n" + 
				"      >_ || _<\r\n" + 
				"      |  ||  |\r\n" + 
				"      |  ||  |\r\n" + 
				"     /   ||   \\\r\n" + 
				"    /    /,    \\\r\n" + 
				"     `|\"|`\"|\"|\"`\r\n" + 
				"     /  )  /  )\r\n" + 
				"    /__/  /__/");
	}
	
	public static void personajeJacobo () {
		System.out.println("      ////\\\\\\\\\r\n" + 
				"      |      |\r\n" + 
				"     @  O  O  @\r\n" + 
				"      |  ~   |         \\__\r\n" + 
				"       \\ -- /          |\\ |\r\n" + 
				"     ___|  |___        | \\|\r\n" + 
				"    /          \\      /|__|\r\n" + 
				"   /            \\    / /\r\n" + 
				"  /  /| .  . |\\  \\  / /\r\n" + 
				" /  / |      | \\  \\/ /\r\n" + 
				"<  <  |      |  \\   /\r\n" + 
				" \\  \\ |  .   |   \\_/\r\n" + 
				"  \\  \\|______|\r\n" + 
				"    \\_|______|\r\n" + 
				"      |      |\r\n" + 
				"      |  |   |\r\n" + 
				"      |  |   |\r\n" + 
				"      |__|___|\r\n" + 
				"      |  |  |\r\n" + 
				"      (  (  |\r\n" + 
				"      |  |  |\r\n" + 
				"      |  |  |\r\n" + 
				"   ___|__|  |\r\n" + 
				"  (___(_____|");
	}
	public static void personajeGeorge() {
		System.out.println("                 ,#####,\r\n" + 
				"                 #_   _#\r\n" + 
				"                 |a` `a|\r\n" + 
				"                 |  u  |\r\n" + 
				"                 \\  =  /\r\n" + 
				"                 |\\___/|\r\n" + 
				"        ___ ____/:     :\\____ ___\r\n" + 
				"      .'   `.-===-\\   /-===-.`   '.\r\n" + 
				"     /      .-\"\"\"\"\"-.-\"\"\"\"\"-.      \\\r\n" + 
				"    /'             =:=             '\\\r\n" + 
				"  .'  ' .:    o   -=:=-   o    :. '  `.\r\n" + 
				"  (.'   /'. '-.....-'-.....-' .'\\   '.)\r\n" + 
				"  /' ._/   \".     --:--     .\"   \\_. '\\\r\n" + 
				" |  .'|      \".  ---:---  .\"      |'.  |\r\n" + 
				" |  : |       |  ---:---  |       | :  |\r\n" + 
				"  \\ : |       |_____._____|       | : /\r\n" + 
				"  /   (       |----|------|       )   \\\r\n" + 
				" /... .|      |    |      |      |. ...\\\r\n" + 
				"|::::/''     /     |       \\     ''\\::::|\r\n" + 
				"'\"\"\"\"       /'    .L_      `\\       \"\"\"\"'\r\n" + 
				"           /'-.,__/` `\\__..-'\\\r\n" + 
				"          ;      /     \\      ;\r\n" + 
				"          :     /       \\     |\r\n" + 
				"          |    /         \\.   |\r\n" + 
				"          |`../           |  ,/\r\n" + 
				"          ( _ )           |  _)\r\n" + 
				"          |   |           |   |\r\n" + 
				"          |___|           \\___|\r\n" + 
				"          :===|            |==|\r\n" + 
				"           \\  /            |__|\r\n" + 
				"           /\\/\\           /\"\"\"`8.__\r\n" + 
				"           |oo|           \\__.//___)\r\n" + 
				"           |==|\r\n" + 
				"           \\__/");
	}
	public static void personajeToni() {
		System.out.println("                 ___,\r\n" + 
				"              __)____)__\r\n" + 
				"                -)- )))\r\n" + 
				"        ,       \\=_/ \\__\r\n" + 
				"     __/).          )_/=\\\r\n" + 
				"    /6)   \\      __((_\\_/\\\r\n" + 
				"   /   __/ \\    /_/-\\o____)\r\n" + 
				"  / ,_/|    \\   \\/  ))\\\\\\\\\\\r\n" + 
				"  \\_)o_'     _.-'  ,/:_/_\\\\    ___\r\n" + 
				"       '---`' \\>__/   /\\\\---.,/_  \\\r\n" + 
				"       (      /  /  /\\\\        \\)  \\\r\n" + 
				"       |        ('  \\\\\\        (   /\r\n" + 
				"  _____/         )__\\\\ /       /\\ (\r\n" + 
				" / _______/,_____| |_,(       /  ) )\r\n" + 
				"/ (_     \\  |   _/ o)  \\     /_  |/\r\n" + 
				"\\_ /     ( '| (___/     `.__  /  '\r\n" + 
				"          \\ |        / _/ / _/\r\n" + 
				"           \\(       / /  / /\r\n" + 
				"            )\\     / (  ( <\r\n" + 
				"         ,./_(,, ,/_|    \\_/,,._");
	}
	public static void personajeTere() {
		System.out.println(".            .--.\r\n" + 
				"\\\\          //\\\\ \\\r\n" + 
				".\\\\        ///_\\\\\\\\\r\n" + 
				":/>`      /(| `|'\\\\\\\r\n" + 
				" Y/\\      )))\\_-_/((\\\r\n" + 
				"  \\ \\    ./'_/ \" \\_`\\)\r\n" + 
				"   \\ \\.-\" ._ \\   /   \\\r\n" + 
				"    \\ _.-\" (_ \\Y/ _) |\r\n" + 
				"     \"      )\" | \"\"/||\r\n" + 
				"         .-'  .'  / ||\r\n" + 
				"        /    `   /  ||\r\n" + 
				"       |    __  :   ||_\r\n" + 
				"       |   / \\   \\ '|\\`\r\n" + 
				"       |  |   \\   \\\r\n" + 
				"       |  |    `.  \\\r\n" + 
				"       |  |      \\  \\\r\n" + 
				"       |  |       \\  \\\r\n" + 
				"       |  |        \\  \\\r\n" + 
				"       |  |         \\  \\\r\n" + 
				"       /__\\          |__\\\r\n" + 
				"       /.|            |.\\_\r\n" + 
				"      `-''            ``--'");
	}
	
}


