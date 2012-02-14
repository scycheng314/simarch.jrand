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
import it.uniroma2.info.sel.simlab.math.functions.cumulativeFunctions.LogNormalCumulativeFunction;
import it.uniroma2.info.sel.simlab.math.functions.cumulativeFunctions.Truncated_ParetoCumulativeFunction;
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.LogNormalDensityFunction;
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.Truncated_ParetoDensityFunction;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

import it.uniroma2.sel.simlab.math.functions.cumulativeFunctions.ExponentialCumulativeFunction;
import it.uniroma2.sel.simlab.math.functions.densityFunctions.ExponentialDensityFunction;

/** Defines a numeric stream that presents pseudorandom properties with a Truncated Pareto 
 * distribution to represent the stream.
 *
 * @author  Sonia Forconi
 */

public class LogNormalStream extends PseudoRandomGenerator {

	private double psi;//mean
	private double sigma;//standard deviation
	
	
	/** Creates a new instance of LogNormalStream */
    public LogNormalStream(final NumericStream s, final double psi, final double sigma) {
        super(new UniformStream(s, 0, 1));
        
        set_psi(psi);
        set_sigma(sigma);
        
        setCumulativeFunction();
        setDensityFunction();
    }
	
    protected void setCumulativeFunction() {
    	cumulativeFunction = new LogNormalCumulativeFunction(psi, sigma);
    }
    
    protected void setDensityFunction() {
    	densityFunction = new LogNormalDensityFunction(psi, sigma);
    }
    
    private void set_psi(final double psi) {
        this.psi = psi;
    }
    
    private void set_sigma(final double sigma) {
        this.sigma = sigma;
    }
    
    public double get_psi() {
        return psi;
    }
    
    public double get_sigma() {
        return sigma;
    }
    
    public Number getNext() {
    	
    	Number n = super.getNext();
	
		//Normal Distribution
    	double normal_dist = 0.0;
    	double var_rand;
    	for(int i=0; i<12; i++){
    		var_rand = n.intValue();//random variable
    		normal_dist = normal_dist + var_rand;
    		var_rand=0.0;
    	}
    	normal_dist = normal_dist - 6;
    	  
    	//inverse of lognormal ditribution 
    	Double d = (psi * Math.exp(sigma * normal_dist)); 
    	return d;
    }
}

