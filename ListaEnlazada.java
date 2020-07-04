class ListaEnlazada{
	Nodo cabeza;
	int tamanio;
 public ListaEnlazada(){
 	cabeza = null;
 	tamanio = 0;
 }
 public Object obtener(int index){
 	int contador = 0;
 	Nodo aux = cabeza;
 	while(contador <index){
      aux = aux.obtenerSiguiente();
      contador++;
 	}
 	return aux.obtenerValor();
 }

 public void anadirP(Nodo objeto){
  if(cabeza == null) {
  	cabeza = new Nodo(objeto);
  }else{
  	Nodo aux = cabeza;
  	Nodo nuevo = new Nodo(objeto);
  	nuevo.obtenerSiguiente(objeto);
  	cabeza = nuevo;
  }
  tamanio++;
 }
 public int tamanio(){
 	return tamanio;
 }
 public boolean cabezaVacia(){
  return (cabeza == null)?true:false;
 }
}