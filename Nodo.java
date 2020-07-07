public class Nodo
{
	Object valor;
	Nodo siguiente;

 	public Nodo(Object valor)
 	{
   		this.valor = valor;
   		this.siguiente = null;
 	}
 	public Object obtenerValor()
 	{
 		return valor;
 	}
 	public void enlazarSiguiente(Nodo nodo)
 	{
   		siguiente = nodo;
 	}
 	public Nodo obtenerSiguiente()
 	{
   		return siguiente;
 	}
}