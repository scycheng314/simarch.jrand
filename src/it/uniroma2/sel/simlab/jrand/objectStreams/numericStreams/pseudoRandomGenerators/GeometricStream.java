/*
 * 	Copyright (C) 2005-2011 Department of Enteprise Engineering, University of Rome "Tor Vergata"
 *                              ( http://www.dii.uniroma2.it )
 *
 *      This file is part of SimArch and was developed at the Software Engineering Laboratory
 *      ( http://www.sel.uniroma2.it )
 *
 *      SimArch is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      SimArch is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with SimArch.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.pseudoRandomGenerators;

import it.uniroma2.info.sel.simlab.jrand.objectStreams.numericStreams.pseudoRandomGenerators.PseudoRandomGenerator;
import it.uniroma2.info.sel.simlab.jrand.objectStreams.numericStreams.pseudoRandomGenerators.UniformStream;
import it.uniroma2.info.sel.simlab.math.functions.cumulativeFunctions.GeometricCumulativeFunction;
import it.uniroma2.info.sel.simlab.math.functions.cumulativeFunctions.Truncated_ParetoCumulativeFunction;
import it.uniroma2.info.sel.simlab.math.functions.cumulativeFunctions.WeibullCumulativeFunction;
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.GeometricDensityFunction;
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.Truncated_ParetoDensityFunction;
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.WeibullDensityFunction;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

import it.uniroma2.sel.simlab.math.functions.cumulativeFunctions.ExponentialCumulativeFunction;
import it.uniroma2.sel.simlab.math.functions.densityFunctions.ExponentialDensityFunction;

/** Defines a numeric stream that presents pseudorandom properties with a Geometric 
 * distribution to represent the stream.
 *
 * @author  Sonia Forconi
 */

public class GeometricStream extends PseudoRandomGenerator {

	private double p;
	
	/** Creates a new instance of GeometricaStream */
    public GeometricStream(final NumericStream s, final double p){
        super(new UniformStream(s, 0, 1));
       
        set_p(p);
	
        setCumulativeFunction();
        setDensityFunction();
}

    protected void setCumulativeFunction() {
    	cumulativeFunction = new GeometricCumulativeFunction(p);
    }
    
    protected void setDensityFunction() {
    	densityFunction = new GeometricDensityFunction(p);
    }
    
    private void set_p(final double p) {
        this.p = p;
    }
 
    public double get_p() {
        return p;
    }
    
    public Number getNext() {
        
    	Number n = super.getNext();
    	
    	//inverse of Geometric CDF
    	Double d =(Math.log(1-n.doubleValue())/(Math.log(1-p)));
    	return d;//return random variable
    }   
}