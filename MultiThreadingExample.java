package com.test.MultiThreadingExample;

class Chef extends Thread {
	private String dish;
	private int cookingTime;

	public Chef(String dish, int cookingTime) {
		this.dish = dish;
		this.cookingTime = cookingTime;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is preparing " + dish);
		try {
			Thread.sleep(cookingTime); // Simulating cooking time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(dish + " is ready! ✅");
	}
}

public class RestaurantKitchen {
	public static void main(String[] args) {
		System.out.println("🛎️ Restaurant Kitchen is open!");

		// Creating chef threads
		Chef chef1 = new Chef("Pizza 🍕", 5000);
		Chef chef2 = new Chef("Pasta 🍝", 3000);
		Chef chef3 = new Chef("Salad 🥗", 2000);

		// Starting threads (chefs start cooking)
		chef1.start();
		chef2.start();
		chef3.start();

		System.out.println("All chefs are cooking... ⏳");
	}
}
