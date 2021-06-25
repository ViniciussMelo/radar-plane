package model;

public class Aviao {
	private int codigo;
	private double positX;
	private double positY;
	private double raio;
	private double angulo;
	private double velocidade;
	private double direcao;

	public Aviao() {
		// TODO Auto-generated constructor stub
	}
	
	public Aviao(int codigo, double positX, double positY, double raio, double angulo, double velocidade,
			double direcao) {
		super();
		this.codigo = codigo;
		this.positX = positX;
		this.positY = positY;
		this.raio = raio;
		this.angulo = angulo;
		this.velocidade = velocidade;
		this.direcao = direcao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPositX() {
		return positX;
	}

	public void setPositX(double positX) {
		this.positX = positX;
	}

	public double getPositY() {
		return positY;
	}

	public void setPositY(double positY) {
		this.positY = positY;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public double getDirecao() {
		return direcao;
	}

	public void setDirecao(double direcao) {
		this.direcao = direcao;
	}

}
