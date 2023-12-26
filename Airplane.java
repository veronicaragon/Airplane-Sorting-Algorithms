class Airplane {
	private int id;
	String Airplane;
	private int capacity;

	/*
	 * 24-hour format without a
	 * colon, 8:00 am is 800, 5:30 pm
	 * is 1730
	 */
	private int startTime;
	private int endTime;

	Airplane(int i, int s, int e) {
		id = i;
		startTime = s;
		endTime = e;
	}

	Airplane(int i, String model, int c, int s, int e) {
		id = i;
		Airplane = model;
		capacity = c;
		startTime = s;
		endTime = e;
	}

	private int getOperatingLength() {
		return endTime - startTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int c) {
		capacity = c;
	}

	public int getDuration() {
        return endTime - startTime;
    }

	public int compareTo(Airplane obj) {
		int myDuration = this.getOperatingLength();
		int anotherDuration = obj.getOperatingLength();

		if (myDuration > anotherDuration)
			return 1;
		else if (myDuration < anotherDuration)
			return -1;
		else
			return 0;
	}

	public String toString() {
		return "ID: " + id +
				"\tModel: " + Airplane +
				"\tCapacity: " + capacity +
				"\tDeparture: " + startTime +
				"\tArrival: " + endTime +
				"\tDur: " + getOperatingLength();
	}

}