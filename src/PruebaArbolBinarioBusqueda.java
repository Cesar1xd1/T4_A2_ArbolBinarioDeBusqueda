import java.util.Scanner;

interface Correcion{
	Scanner input = new Scanner(System.in);
	
	public static int validacion() {
		int r = 0;
		boolean e = false;
		do {
			try {
				r = input.nextInt();
			} catch (java.util.InputMismatchException h) {
				System.out.println("Ups... Solo numeros porfavor, intenta de nuevo:");
				input.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Solo numeros mayores a 0 por favor, intenta de nuevo:");
				e=true;
			}
		}while(e);
		return r;
	}
}




class Nodo{
	private int dato;
	private Nodo izquierdo;
	private Nodo Derecho;
	
	public Nodo(int dato) {
		this.dato = dato;
	}
	public Nodo(){}
	
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}
	public Nodo getDerecho() {
		return Derecho;
	}
	public void setDerecho(Nodo derecho) {
		Derecho = derecho;
	}
	
	public String toString() {
		return "Nodo [dato=" + dato + ", izquierdo=" + izquierdo + ", Derecho=" + Derecho + "]";
	}
	
	
	
}//Nodo

/*=====ARBOL======
 * 1) Crear 
 * 2) Agregar
 * 3) Eliminar (Dato)
 * 4) Mostar (Recorrido)
 * 
 */


class ArbolBinarioBusqueda{
	Nodo raiz;
	//1) Creacion (Listo en el contructor)
	public ArbolBinarioBusqueda() {
		CrearArbol();
	}
	public void CrearArbol() {
		raiz=null;
	}
	int zz = 0;
	//2) Agregar
	public void agregar(int dato) {
		Nodo nuevo = new Nodo(dato);
		zz = zz +1;
		if(raiz==null) {
			raiz = nuevo;
		}else {
			Nodo actual = raiz;
			Nodo padre ;
			
			while(actual!=null) {
				padre = actual;
				if(actual.getDato()<=dato) {
					actual = actual.getIzquierdo();
					if(actual==null) {
						padre.setIzquierdo(nuevo);
					}
				}else {
					actual = actual.getDerecho();
					if(actual==null) {
						padre.setDerecho(nuevo);
					}
				}
				
				
			}
	
		}//Else
		
	}//Agregar
	
	public void recorridoPreorden(Nodo nodoRaiz) {
		if(!(nodoRaiz==null)) {
			System.out.print(nodoRaiz.getDato() + " => ");
			recorridoPreorden(nodoRaiz.getIzquierdo());
			recorridoPreorden(nodoRaiz.getDerecho());
		}
		System.out.println();
	}
	
				//I-R-D  1-3-7-9-14-37
	public void recorridoEnorden(Nodo nodoRaiz) {
		
		if(!(nodoRaiz==null)) {
			recorridoEnorden(nodoRaiz.getIzquierdo());
			System.out.print(nodoRaiz.getDato() + " => ");
			recorridoEnorden(nodoRaiz.getDerecho());
			
			
		}
		
	}
	
public void buscar(Nodo nodoRaiz, int dato) {
		
		if(!(nodoRaiz==null)) {
			buscar(nodoRaiz.getIzquierdo(),dato);
			if(nodoRaiz.getDato()==dato) {
				
				System.out.println("El dato ha sido encontrado");
			}
			buscar(nodoRaiz.getDerecho(),dato);
		}
		
		
}
	
	
	int mayor;
	int menor;
	int z;
	public int menor(Nodo nodoRaiz,int x) {
		if(!(nodoRaiz==null)) {
			menor(nodoRaiz.getIzquierdo(),x);
			z = z+1;
			if(z == 1) {
				menor = nodoRaiz.getDato();
				
			}else {
				mayor = nodoRaiz.getDato();
				
			}
			menor(nodoRaiz.getDerecho(),x);
			
		}
		
		if(x==7)
			return mayor;
		if(x==6)
			return menor;
			
		return 0;
		}
		
	public void mayorMenor(Nodo nodoRaiz,int x) {
		System.out.println(menor(nodoRaiz, x));
		
	}
	
				//I-D-R => 1-3-9-37-14-7
	public void recorridoPostorden(Nodo nodoRaiz) {
		if(!(nodoRaiz==null)) {
			recorridoPostorden(nodoRaiz.getIzquierdo());
			recorridoPostorden(nodoRaiz.getDerecho());
			System.out.print(nodoRaiz.getDato() + " => ");
		}
		System.out.println();
	}
	
public boolean eliminarElemento(int dato) {
		
		if(!(raiz==null)) {
			
			Nodo anterior = raiz;
			Nodo aux = raiz;
			String ladoArbol ="";
			
			//proceso de busqueda-----------------------------------
			while(aux.getDato() != dato) {
				anterior = aux;
				if(dato<=aux.getDato()) { //izquierda
					aux = aux.getIzquierdo();
					ladoArbol = "IZQ";
				}else {//Derecha
					aux = aux.getDerecho();
					ladoArbol = "DER";
				}
				
				if(aux==null) {
					System.out.println("buscado y no encontrdo");
					return false;
				}
			}//while
			
			System.out.println("encontrado");

			
			//proceso de eliminacion  (se encontro el dato)---------------------
			
			//Escenario 1: El nodo a eliminar es HOJA
			if(aux.getIzquierdo()==null && aux.getDerecho()==null) { //verficar si es hoja
				if(aux==raiz)
					raiz = null;
				else if(ladoArbol.equals("IZQ"))
					anterior.setIzquierdo(null);
				else
					anterior.setDerecho(null);
			}else if(aux.getIzquierdo()==null) { //verificar si tiene un solo hijo a la IZQ
				if(aux==raiz)
					raiz = aux.getIzquierdo();
				else if(ladoArbol.equals("IZQ"))
					anterior.setIzquierdo(aux.getIzquierdo());
				else
					anterior.setDerecho(aux.getIzquierdo());
			}else if(aux.getDerecho()==null) { //verificar si tiene un solo hijo a la DER
				if(aux==raiz)
					raiz = aux.getDerecho();
				else if(ladoArbol.equals("IZQ"))
					anterior.setIzquierdo(aux.getDerecho());
				else
					anterior.setDerecho(aux.getDerecho());
			
			
			}else { // de lo contrario TIENE DOS HIJOS -----------------------------------
				
				//----------------------------------------------------------------
				Nodo reemplazo = reemplazar(aux);

				if(aux==raiz)
					raiz = reemplazo;
				else if(ladoArbol.equals("IZQ"))
					anterior.setIzquierdo(reemplazo);
				else
					anterior.setDerecho(reemplazo);
				
				reemplazo.setIzquierdo(aux.getIzquierdo());
			}
			return true;
				//----------------------------------------------------------------
			
		}else {
			System.out.println("Arbol vacio");
			return false;
		}
	}
	
	
	public Nodo reemplazar(Nodo nodo){
		Nodo reemplazarPadre = nodo;
		Nodo reemplazo = nodo;
		Nodo auxiliar = nodo.getDerecho();
		
		while(auxiliar != null){
			reemplazarPadre = reemplazo;
			reemplazo = auxiliar;
			auxiliar= auxiliar.getIzquierdo();
		}
		if(reemplazo!=nodo.getDerecho()){
			reemplazarPadre.setIzquierdo(reemplazo.getDerecho());
			reemplazo.setDerecho(nodo.getDerecho());
		}
		return reemplazo;		

	}//metodo reemplazar
	
	

}


public class PruebaArbolBinarioBusqueda {

	public static void main(String[] args) {
	ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();	
	
	int opcion = 0;
	int dato = 0;
	
	do {
		System.out.println("=================== MENU =====================");
		System.out.println("Digite 1 para Añadir un nodo al Arbol");
		System.out.println("Digite 2 para eliminar un nodo del arbol");
		System.out.println("Digite 3 para Mostrar el recorrido del Arbol en PREORDEN");
		System.out.println("Digite 4 para Mostrar el recorrido del Arbol en INORDEN");
		System.out.println("Digite 5 para Mostrar el recorrido del Arbol en POSTORDEN");
		System.out.println("Digite 6 para Mostara el dato MAYOR");//xd
		System.out.println("Digite 7 para Mostrar el dato MENOR");//xd
		System.out.println("Digite 8 Para buscar un Dato");//XD
		System.out.println("Digite 9 Para ***SALIR***");
		opcion = Correcion.validacion();
		
		switch (opcion) {
		case 1:	System.out.println("Ingrese el dato a añadir");
				dato = Correcion.validacion();
				abb.agregar(dato);break;
		case 2: System.out.println("Ingresa el dato a eliminar");
				dato = Correcion.validacion();
				abb.eliminarElemento(dato);break;
		case 3: abb.recorridoPreorden(abb.raiz);
				System.out.println();break;
		case 4: abb.recorridoEnorden(abb.raiz);
				System.out.println();break;
		case 5: abb.recorridoPostorden(abb.raiz);
				System.out.println();break;
		case 6: System.out.println("El Dato MAYOR es:");
				abb.menor(abb.raiz, 6);
				abb.mayorMenor(abb.raiz, 6);break;
		case 7: System.out.println("El Dato MENOR es: ");
				abb.menor(abb.raiz, 7);
				abb.mayorMenor(abb.raiz,7);break;
		case 8:
				System.out.println("Ingrese el dato a buscar");
				dato = Correcion.validacion();
				abb.buscar(abb.raiz, dato);break;
		case 9: System.out.println("Gracias por usar el programa!");break;
		}
	}while(opcion != 9);
	
	
	
	
	
		
	
	}

}
