package CS120P1;

/**
 * A class to represent temperature (with a value and scale).
 *
 * CS 120
 * Spring 2019
 * Mid term Project 1
 */

public class Temperature{
	// define the attributes
	private double temp ;
	private Temperature tObject ;
	private Scale scale  = Scale.CELSIUS ;

	/** Initializes a temperature object with given value in Celsius
	 *  <p>
	 *  If the initial temperature is less than -273.15C then the temperature
	 *  object will be initialized with -273.15C.
	 *
	 * @param temp is the initial temperature in Celsius.
	 */
	// Temperature constructor that receives parameter temp
	public Temperature(double temp){
		if(this.scale==Scale.CELSIUS){ // if the scale is CELSIUS
			if (temp<-273.15) // if temp is less than -273.15
				temp = -273.15; // set temp to -273.15
			else
				this.temp = temp; // else set entered temperature as temp
		} // end if CELSIUS
		
		else if(this.scale==Scale.KELVIN){ // if the scale is KELVIN
			if (temp<0) // if temp is less than 0
				temp = 0; // set temp to 0
			else
				this.temp = temp;// else set entered temperature as temp
		} // end if KELVIN
		
		else if(this.scale==Scale.FAHRENHEIT){ // if the scale is FAHRENHEIT
			if (temp<-459.67) // if temp is less than -459.67
				temp = -459.67; // set temp to -459.67
			else
				this.temp = temp; // else set entered temperature as temp

		} // end if FAHRENHEIT

	} // end constructor 

	/** Initializes a temperature object with given value using the specified scale
	 * <p>
	 * If the temperature is lower than absolute zero, in the given scale,
	 * then set the temperature to absolute zero (in that scale).
	 * <p>
	 * Usage: new Temperature(12.3, Scale.KELVIN)
	 *
	 * @param temp is the initial temperature in the scale provided in
	 *        the second argument.
	 * @param scale is the scale of initial temperature and must be a constant
	 *        defined in the Scale enum type.
	 */
	// Temperature constructor that receives two parameters temp and scale
	public Temperature(double temp, Scale scale){

		if (scale==Scale.CELSIUS){ // if the scale is CELSIUS
			if (temp<-273.15){ // and temperature is less than absolute zero if that scale
				temp = -273.15; // temperature will equal the absolute zero
			}
			this.temp = temp; // set entered temperature as temp
			this.scale = Scale.CELSIUS; // set scale to CELSIUS
		} // end if
		
		else if (scale==Scale.FAHRENHEIT){ // if the scale is FAHRENHEIT
			if (temp<-459.67){ // and temperature is less than absolute zero if that scale
				temp = -459.67; // temperature will equal the absolute zero
			}
			this.temp = temp; // set entered temperature as temp
			this.scale = Scale.FAHRENHEIT; // set scale to FAHRENHEIT
		} // end if
		
		else if (scale==Scale.KELVIN){ // if the scale is KELVIN
			if (temp<0.00){ // and temperature is less than absolute zero if that scale
				temp = 0.00; // temperature will equal the absolute zero
			}
			this.temp = temp; // set entered temperature as temp
			this.scale = Scale.KELVIN; // set scale to KELVIN
		} // end if
		
	} // end constructor
	/** Initializes a new temperature object that is a copy of the
	 *  temperature object parameter.
	 *
	 * That is, it makes a new object that is a copy of the input object.
	 *
	 * @param temp is a non-null temperature object
	 */
	public Temperature(Temperature temp){
		this.tObject = temp;
	} // end constructor

	/** getter for the scale
	 * <p>
	 * The output of this getter method must always be the first letter of one
	 * of the names in the Scales enum class. It must be the upper case letter.
	 * <p>
	 * Example: t = new Temperature(12.3, Scale.KELVIN);
	 *          t.getScale() will then output 'K'
	 *
	 * @return the first letter (in upper case) of the string representation of the
	 *         current scale of this object.
	 */

	public char getScale(){ // getter for the scale
		char charofScale = 'C';

		switch (this.scale){ // switch between the scales

		case CELSIUS: // if scale is CELSIUS
			charofScale = 'C'; // charScale will be the first letter of that scale.
			break;

		case FAHRENHEIT: // if scale is FAHRENHEIT
			charofScale = 'F'; // charScale will be the first letter of that scale.
			break;

		case KELVIN: // if scale is KELVIN
			charofScale = 'K'; // charScale will be the first letter of that scale.
			break;

		default:
			charofScale = 'C' ;

		} // end switch

		return charofScale ;

	} // end method getScale

	/** getter for the temperature
	 *
	 * @return the temperature of the object using the current scale
	 */
	public double getTemp(){

		return this.temp ;
	} // end method getTemp
	/** setter for scale
	 *
	 * @param scale is the new scale of the temperature and must be
	 *        a constant from the Scale enum type. The next time you
	 *        call getTemp(), the temperature will be output in this scale.
	 * @return a reference to this object.
	 */
	public Temperature setScale(Scale scale){
		// converting between temperatures

		// For CELSIUS conversions
		if (scale==Scale.CELSIUS){	// When scale to convert to is CELSIUS 
			if (this.scale== Scale.CELSIUS){ // if scale of input is CELSIUS
				this.scale = Scale.CELSIUS; // scale is CELSIUS
			}
			else if (this.scale==Scale.FAHRENHEIT){ // if scale of input is FAHRENHEIT
				this.scale = Scale.CELSIUS; // scale is CELSIUS
				this.temp = (this.temp-32)*(5.0/9.0); //convert temp from F to C using the formula
			}
			else if (this.scale==Scale.KELVIN){ // if scale of input is KELVIN
				this.scale = Scale.CELSIUS; // scale is CELSIUS
				this.temp = this.temp - 273.15; //convert temp from k to C using the formula
			}
			if (this.temp < -273.15){ // if the temp is less than -273.15
				this.temp = -273.15; // set it to -273.15
			}
		} // end if scale = CELSIUS

		// For FAHRENHEIT conversions
		else if (scale==Scale.FAHRENHEIT){ // When scale to convert to is FAHRENHEIT
			if (this.scale==Scale.FAHRENHEIT){ // if scale of input is FAHRENHEIT
				this.scale = Scale.FAHRENHEIT; // set scale to FAHRENHEIT
			}
			else if (this.scale==Scale.KELVIN){ // if scale of input is KELVIN
				this.scale = Scale.FAHRENHEIT; //  set scale to FAHRENHEIT
				this.temp = (this.temp*(9.0/5.0))-459.67;  //convert temp from K to F using the formula
			}
			else if (this.scale== Scale.CELSIUS){ // if scale of input is CELSIUS
				this.scale = Scale.FAHRENHEIT; //  set scale to FAHRENHEIT
				this.temp = (this.temp*(9.0/5.0)) +32; //convert temp from K to C using the formula
			}	
			if (this.temp < -459.15){ // if the temperature is less than -459.15 (F absolute zero)
				this.temp = -459.15;// set it to -459.15
			}

		} // end if scale = FAHRENHEIT 

		// For KELVIN conversions
		if (scale==Scale.KELVIN){ // When scale to convert to is KELVIN
			if (this.scale== Scale.CELSIUS){ // if scale of input is CELSIUS
				this.scale = Scale.KELVIN; //  set scale to KELVIN
				this.temp = this.temp + 273.15; //convert temp from C to K using the formula
			}  
			else if (this.scale==Scale.FAHRENHEIT){ // if scale of input is FAHRENHEIT
				this.scale = Scale.KELVIN; //  set scale to KELVIN
				this.temp = (this.temp+459.67)*(5.0/9.0); //convert temp from F to K using the formula
			} 
			else if (scale==Scale.KELVIN){ // if scale of input is KELVIN
				if (this.scale.equals(Scale.KELVIN)){ //  set scale to KELVIN
					this.scale = Scale.KELVIN; 
				} 
				if (this.temp < 0) { // if the temp is less than 0
					this.temp = 0; // set it to 0
				}
			} 
		} // end if scale = KELVIN
		return this;  // do NOT change this return statement.
	} // end method setScale
	/** setter for temperature
	 *
	 * @param temp is the new temperature (in the object's current scale)
	 * @return a reference to this object.
	 */
	public Temperature setTemp(double temp){

		if (this.scale==Scale.CELSIUS){ // if scale is CELSIUS 
			if (temp<-273.15){ // if temp is less than -273.15
				temp = -273.15; // set temp to -273.15
			}
			this.temp=temp; // set entered temp as temp
		} // end if CELSIUS
		
		else if (this.scale==Scale.FAHRENHEIT){ // if scale is FAHRENHEIT
			if (temp<-459.67){ // if temp is less than -459.67
				temp = -459.67; // set temp to -459.67
			}
			this.temp =temp; // set entered temp as temp
		} // end else if FAHRENHEIT

		else if (this.scale==Scale.KELVIN){ // if scale is KELVIN
			if (temp<0){ // if temp is less than 0
				temp = 0; // set temp to 0
			}
			this.temp = temp; // set entered temp as temp

		} // end else if KELVIN
		
		return this;  // do NOT change this return statement.
		
	} // end method setTemp

	/** setter for temperature
	 *
	 * @param temp is the new temperature
	 * @param scale is the scale of the new temperature. It must be
	 *        a constant from the Scale enum type.
	 * @return a reference to this object.
	 */
	// method setTemp with two parameters of type double temp and type Scale scale
	public Temperature setTemp(double temp, Scale scale){ 

		if (scale==Scale.CELSIUS){ // if scale is CELSIUS 
			if (temp < -273.15){ // if temp is less than -273.15
				temp = -273.15; // set temp to -273.15
			}
			this.temp=temp; // set entered temp as temp
			this.scale = Scale.CELSIUS; // set  scale as CELSIUS
		} // end if scale is CELSIUS

		else if (scale==Scale.FAHRENHEIT){ // if scale is FAHRENHEIT 
			if (temp<-459.67){ // if temp is less than -459.67
				temp = -459.67; // set temp to -459.67
			}
			this.temp =temp; // set entered temp as temp
			this.scale = Scale.FAHRENHEIT; // set scale as FAHRENHEIT
		} // end if scale is FAHRENHEIT

		else if (scale==Scale.KELVIN){ // if scale is KELVIN 
			if (temp<0){ // if temp is less than 0
				temp = 0; // set temp to 0
			}
			this.temp = temp; // set entered temp as temp
			this.scale = Scale.KELVIN; // set scale as KELVIN
		} // end if scale is KELVIN
		return this;  // do NOT change this return statement.
	} // end method setTemp

	/** setter for temperature
	 *
	 * @param temp is the new temperature.
	 * @param scale is a string representing one of the three scales.
	 * @return a reference to this object.
	 */
	public Temperature setTemp(double temp, String scale){

		char first_letter = scale.charAt(0) ; // reads the first letter of scale

		if (first_letter=='c' || first_letter == 'C'){ // if the first letter read is c or C

			if (temp < -273.15){ // if the temperature is less than -273.15
				temp = -273.15; // set temp to -273.15
			}
			this.temp=temp; // set entered temperature to temp
			this.scale = Scale.CELSIUS; // set scale to CELSIUS
		} // end if c

		else if (first_letter=='f' || first_letter == 'F'){ // if the first letter read is f or F
			if (temp < -459.67){ // if the temperature is less than -459.67
				temp = -459.67; // set temp to -459.67
			}
			this.temp =temp; // set entered temperature to temp
			this.scale = Scale.FAHRENHEIT; // set scale to FAHRENHEIT
		} // end if f

		if (first_letter=='k' || first_letter == 'K'){ // if the first letter read is k or K
			if (temp < 0){ // if the temperature is less than 0
				temp = 0; // set temp to 0
			}
			this.temp = temp; // set entered temperature to temp
			this.scale = Scale.KELVIN; // set scale to KELVIN
		} // end if k
		return this;  // do NOT change this return statement.
	} // end method setTemp

	/* ------------------------------------------------- */
	/* ------------------------------------------------- */
	/* do not change anything below this                 */
	/* ------------------------------------------------- */
	/* ------------------------------------------------- */

	/** String representation of a temperature object    */
	@Override
	public String toString(){
		String temperature = Double.toString(this.getTemp());
		String scale = Character.toString(this.getScale());
		return temperature + scale;
	} // end method toString

	public static void main(String[] args){
		Temperature t = new Temperature(10.1);
		System.out.println(t.getScale()); // outputs the char 'C'
		System.out.println(t); // outputs 10.1C
		t.setScale(Scale.FAHRENHEIT);
		System.out.println(t); // outputs 50.18F
		System.out.println(t.getScale()); // outputs the char 'F'
		t.setTemp(12.25, "Kel"); // ***
		System.out.println(t); // outputs 12.25K

	} // end method main

} // end class Temperature
