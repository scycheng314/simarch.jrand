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
import it.uniroma2.info.sel.simlab.math.functions.densityFunctions.Truncated_ParetoDensityFunction;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

import it.uniroma2.sel.simlab.math.functions.cumulativeFunctions.ExponentialCumulativeFunction;
import it.uniroma2.sel.simlab.math.functions.densityFunctions.ExponentialDensityFunction;

/** Defines a numeric stream that presents pseudorandom properties with a Truncated Pareto 
 * distribution to represent the stream.
 *
 * @author  Sonia Forconi
 */

public class TruncatedParetoStream extends PseudoRandomGenerator {
	
	private double k; //scale parameter
	private double alfa; //shape parameter
	private double m; //truncated parameter
	
	/** Creates a new instance of TruncatedParetoStream */
    public TruncatedParetoStream(final NumericStream s, final double k, final double alfa, final double m) {
        super(new UniformStream(s, 0, 1));
       
        set_k(k);
        setAlfa(alfa);
        set_m(m);
        
        setCumulativeFunction();
        setDensityFunction();
    }

    protected void setCumulativeFunction() {
    	
    	cumulativeFunction = new Truncated_ParetoCumulativeFunction(k, alfa, m);
    	
    }
    
    protected void setDensityFunction() {
    	
    	densityFunction = new Truncated_ParetoDensityFunction(k, alfa, m);    	
    }
    
    private void set_k(final double k) {
        this.k = k;
    }
    
    private void setAlfa(final double alfa) {
        this.alfa = alfa;
    }
    
    private void set_m(final double m) {
        this.m = m;
    }
    
    public double get_k() {
        return k;
    }
    
    public double getAlfa() {
        return alfa;
    }
    
    public double get_m() {
        return m;
    }
    
    public Number getNext() {
       
    	Number n = super.getNext();
    	
    	//inverse of Truncated Pareto CDF
    	Double d = k / Math.pow((1 - (n.doubleValue() * (1 - Math.pow(k/m, alfa)))), 1/alfa);
    	
    	return d;//return random variable
    }
}

