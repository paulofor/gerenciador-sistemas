package br.com.gersis.loopback.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class TelaFront extends Model{

	private String nome;
	private String tipo;
	
	public String getNomeHifen() {
		return nome.replaceAll("([a-z])([A-Z])", "$1-$2").toLowerCase();
	}
	public String getComponent() {
		return this.nome + "Component";
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
