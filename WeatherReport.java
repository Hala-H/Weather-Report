package CS120P1;

/** A weather report stores the temperature at a given date/time (TimeStamp) */
public class WeatherReport{
	protected Temperature    temperature;
	protected TimeStamp      time;


	/** Creates a weather report */
	public WeatherReport(Temperature temperature, TimeStamp time){
		this.temperature = temperature;
		this.time = time;
	} // end constructor WeatherReport

	/** Getter for the temperature */
	public Temperature getTemperature(){ return this.temperature; }

	/** Getter for the date/time */
	public TimeStamp   getTime(){ return this.time; }

	/* this will let us print a weather report nicely */
	@Override
	public String toString(){
		this.temperature.setScale(Scale.CELSIUS);
		String out = this.temperature.toString() + " on " + this.time.toString();
		return out;
	} // end method toString

} // end class WeatherReport
