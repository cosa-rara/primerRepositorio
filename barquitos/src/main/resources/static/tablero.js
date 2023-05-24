/**
 * 
 */
let isSeleccionBarco=false;
let numeroCasillas=0;//longitud del barco seleccionado
let numeroPosicion=0; // un contador de elementos del array posiciones
let posiciones = [];//array con las posiciones de un barco
const matrizPosiciones = []; // matriz de arrays  posiciones de barco
let numeroBarco=0
let nombreBarcoSeleccionado = "";
let contador = 0;//contador para tipos de barco con mas de una unidad
const coleccionCasillas = document.getElementsByName("casillasJugador"); //casillas del jugador para que la IA elija a cual disparar
var listaCasillas=[100];

//esto copia la coleccion de casillas al array listaCasillas
function rellenarArrayCasillas(){
	for(var i=0; i<coleccionCasillas.length; i++ ){
	listaCasillas[i]=coleccionCasillas[i];
	}
}
let primerDisparoEnemigo=true;
let aciertosEnemigos=[];
let listaAciertos=[];

//para hacer la resursividad de casillas permitidas en la colocacion
let casillaAnterior=null;
let listaLetras = new Array("a","b","c","d","e","f","g","h","i","j");
let direccionBarco;
let primeraCasilla=null;

//para el fin de partida
let victoria;




function grabarCasilla(e){
	document.getElementById(e.id).style.backgroundColor="grey";
	 		posiciones[numeroPosicion]=e.id;
	 		numeroPosicion++;
}

function registrarPosicionBarco(nombreBarcoSeleccionado){	
			//si hay mas de un barco de ese tipo ( esto hay que modificarlo cuando haya otros tipos de barco)
	if(document.getElementsByClassName(nombreBarcoSeleccionado).length>1){
		document.getElementsByClassName(nombreBarcoSeleccionado)[contador].setAttribute("value",posiciones);
		contador++;
				
				//si solo hay un barco de ese tipo
	}else if (document.getElementsByClassName(nombreBarcoSeleccionado).length=1){
		document.getElementById(nombreBarcoSeleccionado).setAttribute("value",posiciones);
	}
}

function resetVariables(){
	matrizPosiciones[numeroBarco]=posiciones;
	numeroBarco++;
	isSeleccionBarco=false;
	numeroCasillas=0;
	numeroPosicion=0;
	posiciones=[];
	document.getElementById("overlay").style.display = "none";
	casillaAnterior=null;
	primeraCasilla=null;
	direccionBarco=null;
	if(contador==2){contador=0;}
}

function clickCasilla(e){

	let coordenadas = e.getAttribute("id");
	let letra=coordenadas.substring(0,1);
	let numero=Number(coordenadas.substring(1)); 
	
	//primero comprobamos si es casilla ya esta seleccionada
	if (posiciones.includes(coordenadas)) {
		alert("esa ya esta cogida");
	} else {

		if (isSeleccionBarco) {

			//hay ya una direccion ?( hay dos casillas?)
			if (direccionBarco == null) {

				//es la primera casilla?
				if (casillaAnterior == null) {
					grabarCasilla(e);
					casillaAnterior = document.getElementById(e.id);
					primeraCasilla = document.getElementById(e.id);

				}//no es la primera casilla
				else {
					let coordenadasAnteriores = casillaAnterior.getAttribute("id");
					let letraAnterior = coordenadasAnteriores.substring(0, 1);
					let numeroAnterior = Number(coordenadasAnteriores.substring(1));

					if (letra == letraAnterior) {
						if (numero == 1 + numeroAnterior || numero == numeroAnterior - 1) {
							grabarCasilla(e);
							casillaAnterior = document.getElementById(e.id);
							direccionBarco = "vertical";
						}
					}

					if (numero == numeroAnterior) {
						let indiceLetra = listaLetras.indexOf(letra);
						let indiceLetraAnterior = listaLetras.indexOf(letraAnterior);
						if (indiceLetra == indiceLetraAnterior + 1 || indiceLetra == indiceLetraAnterior - 1) {
							grabarCasilla(e);
							casillaAnterior = document.getElementById(e.id);
							direccionBarco = "horizontal";
						}
					}

				}

				//si ya hay una direccion definida
			} else {
				//coordenadas de la primera casilla que se seleccionó
				let primerasCoordenadas = primeraCasilla.getAttribute("id");
				let primeraLetra = primerasCoordenadas.substring(0, 1);
				let primerNumero = Number(primerasCoordenadas.substring(1));

				let coordenadasAnteriores = casillaAnterior.getAttribute("id");
				let letraAnterior = coordenadasAnteriores.substring(0, 1);
				let numeroAnterior = Number(coordenadasAnteriores.substring(1));


				if (direccionBarco == "horizontal") {
					if (numero == numeroAnterior) {

						let indiceLetra = listaLetras.indexOf(letra);
						let indiceLetraAnterior = listaLetras.indexOf(letraAnterior);
						let indicePrimeraLetra = listaLetras.indexOf(primeraLetra);

						if (indiceLetra == indicePrimeraLetra + 1 ||
							indiceLetra == indicePrimeraLetra - 1 ||
							indiceLetra == indiceLetraAnterior + 1 ||
							indiceLetra == indiceLetraAnterior - 1) {

							grabarCasilla(e);
							if (indiceLetra == indicePrimeraLetra + 1 || indiceLetra == indicePrimeraLetra - 1) {
								primeraCasilla = document.getElementById(casillaAnterior.id);
							}
							casillaAnterior = document.getElementById(e.id);
						}
					}

				} else if (direccionBarco == "vertical") {
					if (letra == letraAnterior) {
						if (numero == numeroAnterior + 1 || numero == numeroAnterior - 1 || numero == primerNumero + 1 || numero == primerNumero - 1) {

							grabarCasilla(e);
							if (numero == primerNumero + 1 || numero == primerNumero - 1) {
								primeraCasilla = document.getElementById(casillaAnterior.id);
							}
							casillaAnterior = document.getElementById(e.id);
						}
					}

				}

			}

			if (numeroPosicion == numeroCasillas) {

				registrarPosicionBarco(nombreBarcoSeleccionado);
				resetVariables();
			}
		}

	}
    
    
}

function marcarCasillaAgua(e){
    document.getElementById(e.id).style.backgroundColor='rgba(78, 118, 198, 0)';
}

function marcarCasillaTocado(e){
    document.getElementById(e.id).style.backgroundColor='#911';
}

function funcionColocar(nombre, longitud){
	isSeleccionBarco =true;
	numeroCasillas =longitud;
	nombreBarcoSeleccionado = nombre;
}

function colorearTableroBarcos(e){
	let casilla = document.getElementById(e.id);

	alert(casilla.getAttribute("data-ocupacion"));
	
}
function colorearBarcos(e){
	let casilla = document.getElementById(e.id);
	let ocupacion = casilla.getAttribute("data-ocupacion")
	
	if(ocupacion=="true"){
			document.getElementById(e.id).style.backgroundColor="grey";

	}
}
function disparar(e){
	let casilla = document.getElementById(e.id);
	let ocupacion = casilla.getAttribute("data-ocupacion");
	
	if(ocupacion=="true"){
		casilla.style.backgroundColor='red';
		casilla.style.backgroundImage="url('https://iconos8.es/icon/QV5JEtrTP6nH/fire')"
		listaAciertos.push(casilla);
	}
	else{casilla.style.backgroundColor='rgba(78, 118, 198, 0)';}
	comprobarVictoria();
	setTimeout(disparoEnemigo,1000);
	
}

function efectosSeleccionBarco(){
	document.getElementById("overlay").style.display = "block";
	//esto es lo que hace que se vea el overlay al clickar un barco
	
}

function colorearDisparoEnemigo(casillaObjetivo){
	
	if(casillaObjetivo.getAttribute("data-ocupacion")=="true"){
		casillaObjetivo.style.backgroundColor='red';
		aciertosEnemigos.push(casillaObjetivo);
		alert(aciertosEnemigos.length);
		
	}else{
			casillaObjetivo.style.backgroundColor='green';
	}
}

function disparoEnemigo(){
	
	if(primerDisparoEnemigo){
		//si es el primer disparo enemigo se crea el array de casillas a las que disparar.
		rellenarArrayCasillas();
		primerDisparoEnemigo=false;
	}

	let random = Math.floor(Math.random() * 100);
	let casillaObjetivo = listaCasillas[random];
	
	colorearDisparoEnemigo(casillaObjetivo);

	listaCasillas.splice(20,1);
	comprobarVictoriaEnemiga();
}

function efectosFinPartida(){
	document.getElementById("overlayFinPartida").style.display = "block";
	document.getElementById("botonSalir").style.display = "block";
}

function comprobarVictoria(){
	if (listaAciertos.length==document.getElementsByClassName("casillaOcupadatrue").length){
		victoria="jugador";
		document.getElementById("overlayFinPartida").innerHTML = "Has Ganado !";
		efectosFinPartida();
		
	}
}
function comprobarVictoriaEnemiga(){
	if (aciertosEnemigos.length==document.getElementsByClassName("casillaOcupadatrue").length){
		victoria="enemigo";
		document.getElementById("overlayFinPartida").innerHTML = "Has perdido !";
		efectosFinPartida()
		
		
	}
}

function grabarPartida(){
	if(victoria=="jugador"){
		let form = document.getElementById("formularioFinPartida");
		form.resultado.value="victoria";
		form.submit();
	}
	if(victoria=="enemigo"){
		let form = document.getElementById("formularioFinPartida");
		form.resultado.value="derrota";
		form.submit();
	}
}








