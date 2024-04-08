package threadconcept;

class Student {
	private static  Student instance;
	private String name;

	private Student() {
	}

	public static Student getInstance() {
		if (instance == null) {
			instance = new Student();
		}
		return instance;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class ThreadTemp extends Thread {
	Student student =  Student.getInstance();

	public ThreadTemp(String newName) {
		student.setName(newName);
	}

	@Override
	public void  run() {
		while(true) {
			System.out.println("Thread " + Thread.currentThread().getId() + " changed name to " + student.getName());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Singleton {
	public static void main(String[] args) {
		
		ThreadTemp thread1 = new ThreadTemp("Raj");
		thread1.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ThreadTemp thread2 = new ThreadTemp("Harish");
		thread2.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ThreadTemp thread3 = new ThreadTemp("Ramesh");
		thread3.start();
	}
}