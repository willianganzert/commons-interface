package br.com.cdweb.processos;

import java.util.List;

public abstract class Fila<T> {
	private String tipoFila;
	private List<T> listaFilaMemoria = null;
	private T item = null;
	
	public Fila(String tipoFila) {
		this.tipoFila = tipoFila;
		carregaListaFilaMemoria();
		System.out.println(String.format("Iniciado fila[%s] - Lista size[%d]",this.tipoFila,listaFilaMemoria.size()));
	}

	protected abstract List<T> carregarLista();	
	
	protected abstract boolean encaminhar(T item);

	private void carregaListaFilaMemoria(){
		List<T> listaCarregada = carregarLista();
		if(listaFilaMemoria == null){
			listaFilaMemoria = listaCarregada;
		}
		else{
			listaFilaMemoria.addAll(listaCarregada);
		}
	}
	protected T proximo(){
		if(listaFilaMemoria.size() > 0){
			item = listaFilaMemoria.get(0);		
		}
		else {
			carregaListaFilaMemoria();
			if(listaFilaMemoria.size() > 0){
				item = proximo();
			}
		}		
		return item;
	}
	
	public boolean processar() {
		boolean sucesso = true;
		while (proximo()!= null) {
			if(encaminhar(item)){
				SUCESSO!
			}
			else{
				ERRO!
			}
			
		}
		return sucesso;
	}
}
