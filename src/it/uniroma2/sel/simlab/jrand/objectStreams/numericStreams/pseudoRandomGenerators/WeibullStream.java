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
import it.uniroma2.info.sel.simlab.math.functions.cumulativeFunctions.Truncated_ParetoCumulativeFunction;
import it.uniroma2.info.sel.simlab.math.functions.cumulativeFunctions.WeibullCumulativeFunction;
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.Truncated_ParetoDensityFunction;
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.WeibullDensityFunction;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

import it.uniroma2.sel.simlab.math.functions.cumulativeFunctions.ExponentialCumulativeFunction;
import it.uniroma2.sel.simlab.math.functions.densityFunctions.ExponentialDensityFunction;

/** Defines a numeric stream that presents pseudorandom properties with a Weibull 
 * distribution to represent the stream.
 *
 * @author  Sonia Forconi
 */

public final class WeibullStream extends PseudoRandomGenerator {
	
	private double alfa; //scale parameter 
	private double gamma; //shape parameter
	
	/** Creates a new instance of WeibullStream */
    public WeibullStream(final NumericStream s, final double alfa, final double gamma) {
        super(new UniformStream(s, 0, 1));
       
        setAlfa(alfa); 
        setGamma(gamma); 
        
        setCumulativeFunction();
        setDensityFunction();
    }

    protected void setCumulativeFunction() {
    	cumulativeFunction = new WeibullCumulativeFunction(alfa,gamma);
    }
    
    protected void setDensityFunction() {
    	densityFunction = new WeibullDensityFunction(alfa, gamma);
    }
    
    private void setAlfa(final double alfa) {
        this.alfa = alfa;
    }
    
    private void setGamma(final double gamma) {
        this.gamma = gamma;
    }
    
    public double getAlfa() {
        return alfa;
    }
    
    public double getGamma() {
        return gamma;
    }
    
    public Number getNext() {
    	Number n = super.getNext();
    	return alfa * Math.pow(-1*Math.log(n.doubleValue()), (1/gamma));//return random variable
    }
}
