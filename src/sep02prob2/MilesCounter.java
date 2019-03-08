package sep02prob2;

import java.util.ArrayList;
import java.util.List;

public class MilesCounter {
	public static List<Vehicle> convertArray(Object[] vehicleArray) {
		List<Vehicle> listVehicle = new ArrayList<Vehicle>();
		for (Object o : vehicleArray) {
			listVehicle.add((Vehicle) o);
		}
		return listVehicle;
	}

	public static int computeTotalMiles(List<Vehicle> vehicleList) {
		int totalMile = 0;
		for (Vehicle v : vehicleList) {
			totalMile += v.getMilesUsedToday();
		}
		return totalMile;
	}
}
