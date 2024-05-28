package designPatternFacade;

public class ShopKeeper {

	  private MobileShop apple;  
	    private MobileShop samsung;  
	    private MobileShop nokia;  
	      
	    public ShopKeeper(){  
	        apple= new Apple();  
	        samsung=new Samsung();  
	        nokia=new Nokia();  
	    }  
	    public void appleSale(){  
	    	apple.modelNo();  
	    	apple.price();  
	    }  
	        public void samsungSale(){  
	        samsung.modelNo();  
	        samsung.price();  
	    }  
	   public void nokiaSale(){  
		   nokia.modelNo();  
		   nokia.price();  
	        }  
}
