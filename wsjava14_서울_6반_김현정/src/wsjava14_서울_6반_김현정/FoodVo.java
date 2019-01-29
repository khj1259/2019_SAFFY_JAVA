package wsjava14_서울_6반_김현정;

public class FoodVo {
	private String name;
	private String maker;
	private String material;
	
	public FoodVo() {
		// TODO Auto-generated constructor stub
	}

	public FoodVo(String name, String maker, String material) {
		super();
		this.name = name;
		this.maker = maker;
		this.material = material;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "FoodVo [name=" + name + ", maker=" + maker + ", material=" + material + "]";
	}
	

}
