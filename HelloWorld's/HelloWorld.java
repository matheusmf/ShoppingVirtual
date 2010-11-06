
public class HelloWorld {

	private String mensagem;
	public HelloWorld(){}
	public HelloWorld(String mensagem){
		this.mensagem=mensagem;
	}
	public String getMensagem(){
		return this.mensagem;
	}
	public void setMensagem(String mensagem){
		this.mensagem=mensagem;
	}
	public String toString(){
		return this.mensagem;
	}
	
	public static void main(String args[]){
	
			HelloWorld hw = new HelloWorld();
			hw.setMensagem("Hello World!");
			System.out.println(hw.getMensagem());	
			HelloWorld hw1 = new HelloWorld("Alo Mundo!");
			System.out.println(hw1);
	
	}

}
