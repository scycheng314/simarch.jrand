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

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;
import it.uniroma2.sel.simlab.math.functions.cumulativeFunctions.NormalCumulativeFunction;
import it.uniroma2.sel.simlab.math.functions.densityFunctions.NormalDensityFunction;

/** Defines a numeric stream that presents pseudorandom properties and this is
 * distributed normally
 *
 * @author  Daniele Gianni
 */
public final class NormalStream extends PseudoRandomGenerator {

    // the mu of the normal distribution
    private double mean;

    // the sigma of the normal distribution
    private double standardDeviation;

    // a parameters required for this type of transformation ????
    private double z;
    
    /** Creates a new instance of NormalStream */
    public NormalStream(final NumericStream s, final double m, final double d) {
        super(new UniformStream(s, 0, 1));
        
        setMean(m);
        setStandardDeviation(d);
        
        z = 0.0;
        
        setCumulativeFunction();
        setDensityFunction();        
    }
    
    public double getMean() {
        return mean;
    }
    
    public Number getNext() {
    	/* Polar Method by Both, Marsaglia ... Seminumerical Alghorithm vol 2 Knuth
         */
        
        double X2;

	if (z != 0.0) {
	    X2 = z;
	    z = 0.0;
	} else {
	    double S, v1, v2;
	    do {
                v1 = 2.0 * super.getNext().doubleValue() - 1.0;
		v2 = 2.0 * super.getNext().doubleValue() - 1.0;
		S = (v1 * v1) + (v2 * v2);
	    } while (S >= 1.0);

	    S = Math.sqrt((-2.0 * Math.log(S)) / S);
	    X2 = v1 * S;
	    z  = v2 * S;
	}

	return new Double(mean + X2 * standardDeviation);    
    }
    
    public double getStandardDeviation() {
        return standardDeviation;
    }
    
    protected void setCumulativeFunction() {
        cumulativeFunction = new NormalCumulativeFunction(mean, standardDeviation);
    }
    
    protected void setDensityFunction() {
        densityFunction = new NormalDensityFunction(mean, standardDeviation);
    }
    
    private void setMean(final double d) {
        mean = d;
    }
        
    private void setStandardDeviation(final double d) {
        standardDeviation = d;
    }
}
