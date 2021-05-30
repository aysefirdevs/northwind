package kodlamaio.northwind.core.utilities.results;


public class Result { //çıplak çünkü interface görevi görüyo aslında
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success=success;
	}
	
	public Result(boolean success,String message) {
		this(success); //tek parametreli const çağırdık kendini tekrarlama!!
		this.message=message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
